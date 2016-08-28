package com.sxtc.ccweb.dao.impl;

import com.sxtc.ccweb.base.CCSqlDaoSupport;
import com.sxtc.ccweb.dao.NsOperaterDao;
import com.sxtc.ccweb.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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

}
