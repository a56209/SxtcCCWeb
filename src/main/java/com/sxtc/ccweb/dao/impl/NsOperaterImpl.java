package com.sxtc.ccweb.dao.impl;

import com.sxtc.ccweb.base.CCSqlDaoSupport;
import com.sxtc.ccweb.dao.NsOperaterDao;
import com.sxtc.ccweb.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/8/27.
 */
@Repository("nsOperaterDao")
public class NsOperaterImpl extends CCSqlDaoSupport implements NsOperaterDao {

    public List<User> findAllUsers() {
        SqlSession session = getSqlSession();
        List<User> listdta = session.selectList("findAllUsers");
        return listdta;
    }

    public User findUserById(Integer userId) {
        SqlSession session = getSqlSession();
        return session.selectOne("findUserById", userId);
    }

    public int addUser(User user) {
        SqlSession session = getSqlSession();
        return session.insert("addNewUser", user);
    }

    public int updateUser(User user) {
        SqlSession session = getSqlSession();
        return session.update("updateUser", user);
    }

//    @Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
    public int delUser(Integer userId) {
        SqlSession session = getSqlSession();
        return session.delete("delUser", userId);
    }

}
