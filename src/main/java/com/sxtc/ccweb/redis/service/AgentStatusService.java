package com.sxtc.ccweb.redis.service;

import com.sxtc.ccweb.model.AgentStatusInfo;

/**
 * Created by Administrator on 2016/8/28.
 */
public interface AgentStatusService {

    void saveStatus(AgentStatusInfo agentStatusInfo);

    AgentStatusInfo getAgentDetailInfo(String agentId);

    void deleteAgentInfo(String agentId);

}
