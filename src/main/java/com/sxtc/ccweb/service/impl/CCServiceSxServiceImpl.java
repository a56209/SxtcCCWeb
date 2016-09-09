package com.sxtc.ccweb.service.impl;

import com.sxtc.ccweb.dao.impl.CCServiceSxDaoImpl;
import com.sxtc.ccweb.model.CCServiceSx;
import com.sxtc.ccweb.service.CCServiceSxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    /**
     * 更新录音相关信息
     *
     * @param ccServiceSx
     * @return 更新执行影响条数
     */
    public Integer updateCCServiceVocInfo(CCServiceSx ccServiceSx) {
        //防止无良奸商知道字段后，瞎改
        CCServiceSx mccServiceSx = new CCServiceSx();
        mccServiceSx.setServiceId(ccServiceSx.getServiceId());
        mccServiceSx.setRecVoFile(ccServiceSx.getRecVoFile());

        int ret = ccServiceSxDao.updateCCServiceSx(mccServiceSx);
        return ret;
    }

    /**
     * 更新补充话务完成后信息
     *
     * @param ccServiceSx
     * @return 更新执行影响条数
     */
    public Integer updateCCServiceEndInfo(CCServiceSx ccServiceSx) {
        //防止无良奸商知道字段后，瞎改
        CCServiceSx mccServiceSx = new CCServiceSx();
        mccServiceSx.setServiceId(ccServiceSx.getServiceId());
        mccServiceSx.setRecStopTime(new Date());

        int ret = ccServiceSxDao.updateCCServiceSx(mccServiceSx);
        return ret;
    }
}
