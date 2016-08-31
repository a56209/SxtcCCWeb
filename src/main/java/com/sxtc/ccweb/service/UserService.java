package com.sxtc.ccweb.service;

import com.sxtc.ccweb.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/8/27.
 */
public interface UserService {

    List<User> findUsers();

    User findUserById(Integer userId);

    void addUserInfo(User user);

    void updateUserInfo(User user) throws Exception;

    void deleteUserInfo(Integer userId);
}
