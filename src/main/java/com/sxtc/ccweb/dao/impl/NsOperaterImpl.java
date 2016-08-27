package com.sxtc.ccweb.dao.impl;

import com.sxtc.ccweb.dao.NsOperaterDao;
import com.sxtc.ccweb.model.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * Created by Administrator on 2016/8/27.
 */
public class NsOperaterImpl extends SqlSessionDaoSupport implements NsOperaterDao {

    public List<User> findAllUsers() {
        SqlSession session = getSqlSession();
        List<User> listdta = session.selectList("findAllUsers");
        return listdta;
    }

}
