package com.sxtc.ccweb.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/9.
 */
@XmlRootElement
public class CCServiceSx implements Serializable {

    private static final long serialVersionUID = 9180852870995335058L;

    /**
     * 编号，由CC_SRV_LIST_SEQ产生
     */
    private Integer serviceId;

    /**
     *呼叫编号，由排队机程序产生
     */
    private Integer callId;

    /**
     * 来电号码（呼出时为对方号码）
     */
    private String callerId;

    /**
     * 1简单记录（内容为空）0为详细记录
     */
    private Integer simpleRec;

    /**
     * 呼叫方向 0呼入 1呼出 2其他
     */
    private Integer callDir;

    /**
     * 客户编号，参考用电系统Cusotmers表
     */
    private Integer customerId;

    /**
     * 客户名称
     */
    private String custName;

    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 受理人工号
     */
    private String agentId;

    /**
     * 登记时间
     */
    private Date registerTime;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 录音文件（华为排队机）
     */
    private String recVoFile;

    /**
     * 是否已经确认分类
     */
    private Integer confirmType;

    /**
     * 当前服务评价结果 0未评议 1非常满意 2不满意3满意4基本满意
     */
    private Integer serviceResult;

    /**
     * 当前服务评价时间
     */
    private Date serviceResultTime;

    /**
     * 是否需要回访（0不需要1需要）
     */
    private Integer needFB;

    /**
     * 密级（0到5级）
     */
    private Integer secretRank;

    /**
     * 客户挂机录音结束时间
     */
    private Date recStopTime;

    /**
     * 华为排队机呼叫编号
     */
    private String hwCallId;

    /**
     * 华为排队机通话释放原因代码     1281为坐席主动挂机
     */
    private Integer releaseCause;

    /**
     *  回访编号
     */
    private String visitId;

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getCallId() {
        return callId;
    }

    public void setCallId(Integer callId) {
        this.callId = callId;
    }

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }

    public Integer getSimpleRec() {
        return simpleRec;
    }

    public void setSimpleRec(Integer simpleRec) {
        this.simpleRec = simpleRec;
    }

    public Integer getCallDir() {
        return callDir;
    }

    public void setCallDir(Integer callDir) {
        this.callDir = callDir;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRecVoFile() {
        return recVoFile;
    }

    public void setRecVoFile(String recVoFile) {
        this.recVoFile = recVoFile;
    }

    public Integer getConfirmType() {
        return confirmType;
    }

    public void setConfirmType(Integer confirmType) {
        this.confirmType = confirmType;
    }

    public Integer getServiceResult() {
        return serviceResult;
    }

    public void setServiceResult(Integer serviceResult) {
        this.serviceResult = serviceResult;
    }

    public Date getServiceResultTime() {
        return serviceResultTime;
    }

    public void setServiceResultTime(Date serviceResultTime) {
        this.serviceResultTime = serviceResultTime;
    }

    public Integer getNeedFB() {
        return needFB;
    }

    public void setNeedFB(Integer needFB) {
        this.needFB = needFB;
    }

    public Integer getSecretRank() {
        return secretRank;
    }

    public void setSecretRank(Integer secretRank) {
        this.secretRank = secretRank;
    }

    public Date getRecStopTime() {
        return recStopTime;
    }

    public void setRecStopTime(Date recStopTime) {
        this.recStopTime = recStopTime;
    }

    public String getHwCallId() {
        return hwCallId;
    }

    public void setHwCallId(String hwCallId) {
        this.hwCallId = hwCallId;
    }

    public Integer getReleaseCause() {
        return releaseCause;
    }

    public void setReleaseCause(Integer releaseCause) {
        this.releaseCause = releaseCause;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }
}
