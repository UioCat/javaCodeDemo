package com.hanxun.demo.handle;

import com.hanxun.demo.common.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

/**
 * @author han xun
 * @date 2021-10-08 14:42
 * @description
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BackMessage<Void> handle(Exception e) {

        if (e instanceof CustomException) {
            CustomException customException = (CustomException) e;
            log.warn("自定义异常捕获:{}", customException.getMessage());
            return new BackMessage<Void>(customException.getErrorCode(), customException.getMessage());
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            log.warn("捕捉浏览器错误请求异常");
            return new BackMessage<Void>(BackEnum.REQUEST_METHOD_ERROR);
        } else if (e instanceof MissingServletRequestParameterException) {
            log.warn("捕捉错误参数请求异常");
            return new BackMessage<Void>(BackEnum.PARAM_ERROR);
        } else if (e instanceof HttpMessageNotReadableException) {
            log.warn("捕捉错误JSON请求有数据异常");
            return new BackMessage<Void>(BackEnum.DATA_ERROR);
        } else if (e instanceof DuplicateKeyException) {
            log.warn("主键重复添加");
            return new BackMessage<Void>(BackEnum.REPETITION);
        } else if (e instanceof HttpMediaTypeNotSupportedException) {
            log.warn("数据类型错误,json<->form-urlencoded");
            return new BackMessage<Void>(BackEnum.MEDIA_TYPE_ERROR);
        } else {
            log.error("系统异常", e);
            return new BackMessage<Void>(BackEnum.UNKNOWN_ERROR);
        }
    }
}