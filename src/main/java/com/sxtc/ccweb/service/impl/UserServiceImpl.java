package com.sxtc.ccweb.service.impl;

import com.sxtc.ccweb.dao.impl.NsOperaterImpl;
import com.sxtc.ccweb.model.User;
import com.sxtc.ccweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/8/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private NsOperaterImpl nsOperaterDao;

    public List<User> findUsers() {
        return nsOperaterDao.findAllUsers();
    }

    public User findUserById(Integer userId) {
        return nsOperaterDao.findUserById(userId);
    }

    public void addUserInfo(User user) {
        nsOperaterDao.addUser(user);
    }

    public void updateUserInfo(User user) {
        nsOperaterDao.updateUser(user);
    }

    public void deleteUserInfo(Integer userId) {
        nsOperaterDao.delUser(userId);
    }
}
