package com.sxtc.ccweb.service.impl;

import com.sxtc.ccweb.dao.NsOperaterDao;
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
    NsOperaterDao nsOperaterDao;

    public List<User> findUsers() {
        return nsOperaterDao.findAllUsers();
    }
}
