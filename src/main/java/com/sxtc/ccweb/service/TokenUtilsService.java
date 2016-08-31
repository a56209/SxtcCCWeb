package com.sxtc.ccweb.service;

import com.sxtc.ccweb.model.User;

/**
 * Created by Administrator on 2016/8/31.
 */
public interface TokenUtilsService {

    User tokenSign(String token);
}
