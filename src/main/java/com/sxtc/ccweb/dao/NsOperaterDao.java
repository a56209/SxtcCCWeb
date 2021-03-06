package com.sxtc.ccweb.dao;

import com.sxtc.ccweb.model.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.BinaryClient;

import java.util.List;

/**
 * Created by Administrator on 2016/8/27.
 */

public interface NsOperaterDao {

    List<User> findAllUsers();

    User findUserById(Integer userId);

    List<User> findUserByUserData(User user);

    int addUser(User user);

    int updateUser(User user);

    int delUser(Integer userId);


//    @Select(" SELECT OP_ID,OP_NAME,OP_PSW FROM NS_OPERATOR_INFO ")
//    @Results({
//            @Result(id = true,column = "OP_ID",property = "userId"),
//            @Result(column = "OP_NAME",property = "userName"),
//            @Result(column = "OP_PSW",property = "userPwd")
//    })
//    public List<User> getUsers();
}
