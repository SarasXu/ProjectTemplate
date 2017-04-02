package com.saras.template.mapper;

import com.saras.template.entity.User;

public interface UserMapper {
    /**
     *
     * @mbggenerated 2017-04-02 12:17:02
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2017-04-02 12:17:02
     */
    int insert(User record);

    /**
     *
     * @mbggenerated 2017-04-02 12:17:02
     */
    int insertSelective(User record);

    /**
     *
     * @mbggenerated 2017-04-02 12:17:02
     */
    User selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2017-04-02 12:17:02
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *
     * @mbggenerated 2017-04-02 12:17:02
     */
    int updateByPrimaryKey(User record);
}