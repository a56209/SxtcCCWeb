package com.sxtc.ccweb.dao;

import com.sxtc.ccweb.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/8/27.
 */

public interface NsOperaterDao {

    public List<User> findAllUsers();
}
