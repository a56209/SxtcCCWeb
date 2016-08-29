package com.sxtc.ccweb.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/8/28.
 */
public class AgentStatusInfo implements Serializable {


    private static final long serialVersionUID = -6856091664478230511L;
    /**
     * 坐席编号
     */
    private Integer agentId;

    /**
     * 坐席状态值
     */
    private Integer agentStatus;

    /**
     * 坐席状态内容
     */
    private String statusInfo;

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getAgentStatus() {
        return agentStatus;
    }

    public void setAgentStatus(Integer agentStatus) {
        this.agentStatus = agentStatus;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public AgentStatusInfo(Integer agentId, Integer agentStatus, String statusInfo) {
        this.agentId = agentId;
        this.agentStatus = agentStatus;
        this.statusInfo = statusInfo;
    }

    @Override
    public String toString() {
        return "AgentStatusInfo{" +
                "agentId=" + agentId +
                ", agentStatus=" + agentStatus +
                ", statusInfo='" + statusInfo + '\'' +
                '}';
    }
}
