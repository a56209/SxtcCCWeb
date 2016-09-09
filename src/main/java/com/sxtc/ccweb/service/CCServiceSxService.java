package com.sxtc.ccweb.service;

import com.sxtc.ccweb.model.CCServiceSx;

/**
 * Created by Administrator on 2016/9/9.
 */
public interface CCServiceSxService {
    Integer addCCService(CCServiceSx ccServiceSx);

    /**
     * 更新录音相关信息
     *
     * @param ccServiceSx
     * @return 更新执行影响条数
     */
    Integer updateCCServiceVocInfo(CCServiceSx ccServiceSx);

    /**
     * 更新补充话务完成后信息
     *
     * @param ccServiceSx
     * @return 更新执行影响条数
     */
    Integer updateCCServiceEndInfo(CCServiceSx ccServiceSx);
}
