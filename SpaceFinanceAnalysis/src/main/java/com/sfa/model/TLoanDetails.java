package com.sfa.model;

import javax.persistence.*;

@Table(name = "t_loan_details")
public class TLoanDetails {
    @Id
    @Column(name = "t_loan_id")
    private String tLoanId;

    @Column(name = "t_loanout_comid")
    private String tLoanoutComid;

    @Column(name = "t_loanin_comid")
    private String tLoaninComid;

    @Column(name = "t_loan_pre_time")
    private String tLoanPreTime;

    @Column(name = "t_loan_start_time")
    private String tLoanStartTime;

    @Column(name = "t_loan_num")
    private String tLoanNum;

    @Column(name = "t_loan_end_time")
    private String tLoanEndTime;

    @Column(name = "t_warn_days")
    private String tWarnDays;

    @Column(name = "t_weiyue_num")
    private String tWeiyueNum;

    @Column(name = "t_lixi")
    private String tLixi;

    @Column(name = "t_changhuan_total")
    private String tChanghuanTotal;

    @Column(name = "t_status")
    private String tStatus;

    /**
     * @return t_loan_id
     */
    public String gettLoanId() {
        return tLoanId;
    }

    /**
     * @param tLoanId
     */
    public void settLoanId(String tLoanId) {
        this.tLoanId = tLoanId;
    }

    /**
     * @return t_loanout_comid
     */
    public String gettLoanoutComid() {
        return tLoanoutComid;
    }

    /**
     * @param tLoanoutComid
     */
    public void settLoanoutComid(String tLoanoutComid) {
        this.tLoanoutComid = tLoanoutComid;
    }

    /**
     * @return t_loanin_comid
     */
    public String gettLoaninComid() {
        return tLoaninComid;
    }

    /**
     * @param tLoaninComid
     */
    public void settLoaninComid(String tLoaninComid) {
        this.tLoaninComid = tLoaninComid;
    }

    /**
     * @return t_loan_pre_time
     */
    public String gettLoanPreTime() {
        return tLoanPreTime;
    }

    /**
     * @param tLoanPreTime
     */
    public void settLoanPreTime(String tLoanPreTime) {
        this.tLoanPreTime = tLoanPreTime;
    }

    /**
     * @return t_loan_start_time
     */
    public String gettLoanStartTime() {
        return tLoanStartTime;
    }

    /**
     * @param tLoanStartTime
     */
    public void settLoanStartTime(String tLoanStartTime) {
        this.tLoanStartTime = tLoanStartTime;
    }

    /**
     * @return t_loan_num
     */
    public String gettLoanNum() {
        return tLoanNum;
    }

    /**
     * @param tLoanNum
     */
    public void settLoanNum(String tLoanNum) {
        this.tLoanNum = tLoanNum;
    }

    /**
     * @return t_loan_end_time
     */
    public String gettLoanEndTime() {
        return tLoanEndTime;
    }

    /**
     * @param tLoanEndTime
     */
    public void settLoanEndTime(String tLoanEndTime) {
        this.tLoanEndTime = tLoanEndTime;
    }

    /**
     * @return t_warn_days
     */
    public String gettWarnDays() {
        return tWarnDays;
    }

    /**
     * @param tWarnDays
     */
    public void settWarnDays(String tWarnDays) {
        this.tWarnDays = tWarnDays;
    }

    /**
     * @return t_weiyue_num
     */
    public String gettWeiyueNum() {
        return tWeiyueNum;
    }

    /**
     * @param tWeiyueNum
     */
    public void settWeiyueNum(String tWeiyueNum) {
        this.tWeiyueNum = tWeiyueNum;
    }

    /**
     * @return t_lixi
     */
    public String gettLixi() {
        return tLixi;
    }

    /**
     * @param tLixi
     */
    public void settLixi(String tLixi) {
        this.tLixi = tLixi;
    }

    /**
     * @return t_changhuan_total
     */
    public String gettChanghuanTotal() {
        return tChanghuanTotal;
    }

    /**
     * @param tChanghuanTotal
     */
    public void settChanghuanTotal(String tChanghuanTotal) {
        this.tChanghuanTotal = tChanghuanTotal;
    }

    /**
     * @return t_status
     */
    public String gettStatus() {
        return tStatus;
    }

    /**
     * @param tStatus
     */
    public void settStatus(String tStatus) {
        this.tStatus = tStatus;
    }
}