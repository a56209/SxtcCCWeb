package com.sxtc.ccweb.service.impl;

import com.sxtc.ccweb.dao.impl.CCServiceSxDaoImpl;
import com.sxtc.ccweb.model.CCServiceSx;
import com.sxtc.ccweb.service.CCServiceSxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/9.
 */
@Service
public class CCServiceSxServiceImpl implements CCServiceSxService {

    @Autowired
    private CCServiceSxDaoImpl ccServiceSxDao;

    public Integer addCCService(CCServiceSx ccServiceSx) {
        System.out.println(ccServiceSx.getServiceId());
        int ret = ccServiceSxDao.addCCServiceSx(ccServiceSx);
        System.out.println(ret);
        System.out.println("最新的SERVICE_ID：" + ccServiceSx.getServiceId());
        return ccServiceSx.getServiceId();
    }
}
