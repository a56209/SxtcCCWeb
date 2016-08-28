package com.sxtc.ccweb.redis.dao.impl;

import com.sxtc.ccweb.model.AgentStatusInfo;
import com.sxtc.ccweb.redis.dao.AgentStatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/8/28.
 */
@Repository("agentStatusDao")
public class AgentStatusDaoImpl implements AgentStatusDao {

    @Autowired
    private RedisTemplate<String, AgentStatusInfo> redisTemplate;

    public void saveAgentStatus(AgentStatusInfo agentStatusInfo) {
        ValueOperations<String, AgentStatusInfo> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(agentStatusInfo.getAgentId().toString(), agentStatusInfo);
    }

    public AgentStatusInfo readAgentStatus(String agentId) {
        ValueOperations<String, AgentStatusInfo> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(agentId);
    }

    public void deleteAgentStatus(String agentId) {
        ValueOperations<String, AgentStatusInfo> valueOperations = redisTemplate.opsForValue();
        RedisOperations<String, AgentStatusInfo> redisOperations = valueOperations.getOperations();
        redisOperations.delete(agentId);
    }
}
