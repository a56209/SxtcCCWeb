package com.sxtc.ccweb.base;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

/**
 * Created by Administrator on 2016/8/31.
 */
@Provider
public class AuthorizationFilterFeature implements DynamicFeature {

    public void configure(ResourceInfo resourceInfo, FeatureContext featureContext) {

    }
}
