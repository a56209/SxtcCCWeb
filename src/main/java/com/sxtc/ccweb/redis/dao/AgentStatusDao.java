package com.sxtc.ccweb.redis.dao;

import com.sxtc.ccweb.model.AgentStatusInfo;

/**
 * Created by Administrator on 2016/8/28.
 */
public interface AgentStatusDao {

    void saveAgentStatus(AgentStatusInfo agentStatusInfo);

    AgentStatusInfo readAgentStatus(String agentId);

    void deleteAgentStatus(String agentId);
}
