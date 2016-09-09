package com.sxtc.ccweb.dao.impl;

import com.sxtc.ccweb.base.CCSqlDaoSupport;
import com.sxtc.ccweb.dao.CCServiceSxDao;
import com.sxtc.ccweb.model.CCServiceSx;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
@Repository("ccServiceSxDao")
public class CCServiceSxDaoImpl extends CCSqlDaoSupport implements CCServiceSxDao {

    /**
     * 增加话务记录
     *
     * @param ccServiceSx
     * @return
     */
    public int addCCServiceSx(CCServiceSx ccServiceSx) {
        SqlSession session = getSqlSession();
        int ret = session.insert("addNewServiceSx", ccServiceSx);
        return ret;
    }

    /**
     * 根据记录值更新话务数据
     *
     * @param ccServiceSx
     * @return
     */
    public int updateCCServiceSx(CCServiceSx ccServiceSx) {
        SqlSession session = getSqlSession();
        int ret = session.update("updateServiceSx", ccServiceSx);
        return ret;
    }

    /**
     * 根据编号查找话务记录
     *
     * @param serviceId
     * @return
     */
    public CCServiceSx findCCServiceSxById(Integer serviceId) {
        return null;
    }

    /**
     * 根据筛选条件查找话务记录
     *
     * @param ccServiceSx
     * @return
     */
    public List<CCServiceSx> findCCServiceSxByData(CCServiceSx ccServiceSx) {
        return null;
    }
}
