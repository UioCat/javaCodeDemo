package com.hanxun.demo.handle;

import com.hanxun.demo.common.BackEnum;
import com.hanxun.demo.common.BackMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * @author uio
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public BackMessage<String> handle(MethodArgumentNotValidException e) {
        String defaultMessage = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        return new BackMessage<>(BackEnum.PARAM_ERROR.getCode(), defaultMessage);
    }
}