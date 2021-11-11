package com.hanxun.demo.manager;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hanxun.demo.dao.UserDOMapper;
import com.hanxun.demo.entity.UserDO;
import com.hanxun.demo.entity.UserDOExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author han xun      
 * Date 2021-11-10 14:20   
 * Description  
 */
@Component
public class UserDOManager {

    @Autowired
    private UserDOMapper userDOMapper;

    /**
     * 根据主键查询数据
     * @param id
     * @return
     */
    public UserDO getUserDoById(Long id) {
        return userDOMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据telephone查找数据吧
     * @param telephone
     * @return
     */
    public UserDO getUserDo(String telephone) {
        UserDOExample example = new UserDOExample();
        UserDOExample.Criteria criteria = example.createCriteria();
        criteria.andTelephoneEqualTo(telephone);
        return userDOMapper.selectByExample(example).stream().findFirst().orElse(null);
    }

    /**
     * 插入数据或更新数据
     */
    public void insertOrUpdate(UserDO userDO) {
        if (userDO.getId() == null) {
            userDOMapper.insert(userDO);
        } else {
            UserDOExample example = new UserDOExample();
            UserDOExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(userDO.getId());
            userDOMapper.updateByExample(userDO, example);
        }
    }

    public Page<UserDO> queryByPage(Integer pageNum, Integer pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(
            () -> userDOMapper.selectByExample(null));
    }

}
