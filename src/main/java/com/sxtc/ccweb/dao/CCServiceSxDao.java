package com.sxtc.ccweb.dao;

import com.sxtc.ccweb.model.CCServiceSx;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
public interface CCServiceSxDao {

    /**
     * 增加话务记录
     *
     * @param ccServiceSx
     * @return
     */
    int addCCServiceSx(CCServiceSx ccServiceSx);

    /**
     * 根据记录值更新话务数据
     *
     * @param ccServiceSx
     * @return
     */
    int updateCCServiceSx(CCServiceSx ccServiceSx);

    /**
     * 根据编号查找话务记录
     *
     * @param serviceId
     * @return
     */
    CCServiceSx findCCServiceSxById(Integer serviceId);

    /**
     * 根据筛选条件查找话务记录
     *
     * @param ccServiceSx
     * @return
     */
    List<CCServiceSx> findCCServiceSxByData(CCServiceSx ccServiceSx);
}
