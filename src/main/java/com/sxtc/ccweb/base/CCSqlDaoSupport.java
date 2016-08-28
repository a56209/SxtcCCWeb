package com.sxtc.ccweb.base;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/8/28.
 */
public class CCSqlDaoSupport extends SqlSessionDaoSupport {

    @Resource
    public void  setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
