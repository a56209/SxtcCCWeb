package com.sxtc.ccweb.redis.service.impl;

import com.sxtc.ccweb.model.AgentStatusInfo;
import com.sxtc.ccweb.redis.dao.AgentStatusDao;
import com.sxtc.ccweb.redis.dao.impl.AgentStatusDaoImpl;
import com.sxtc.ccweb.redis.service.AgentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/8/28.
 */
@Service
public class AgentStatusServiceImpl implements AgentStatusService {

    @Autowired
    private AgentStatusDaoImpl agentStatusDao;

    public void saveStatus(AgentStatusInfo agentStatusInfo) {
        agentStatusDao.saveAgentStatus(agentStatusInfo);
    }

    public AgentStatusInfo getAgentDetailInfo(String agentId) {
        return agentStatusDao.readAgentStatus(agentId);
    }

    public void deleteAgentInfo(String agentId) {
        agentStatusDao.deleteAgentStatus(agentId);
    }
}
