package com.sfa.model;

import javax.persistence.*;

@Table(name = "t_company")
public class TCompany {
    @Id
    @Column(name = "t_com_id")
    private Integer tComId;

    @Column(name = "t_com_pid")
    private String tComPid;

    @Column(name = "t_com_name")
    private String tComName;

    @Column(name = "t_org_code")
    private String tOrgCode;

    @Column(name = "t_address")
    private String tAddress;

    @Column(name = "t_zhuceriqi")
    private String tZhuceriqi;

    @Column(name = "t_zhuciziben")
    private String tZhuciziben;

    @Column(name = "t_faren")
    private String tFaren;

    /**
     * @return t_com_id
     */
    public Integer gettComId() {
        return tComId;
    }

    /**
     * @param tComId
     */
    public void settComId(Integer tComId) {
        this.tComId = tComId;
    }

    /**
     * @return t_com_pid
     */
    public String gettComPid() {
        return tComPid;
    }

    /**
     * @param tComPid
     */
    public void settComPid(String tComPid) {
        this.tComPid = tComPid;
    }

    /**
     * @return t_com_name
     */
    public String gettComName() {
        return tComName;
    }

    /**
     * @param tComName
     */
    public void settComName(String tComName) {
        this.tComName = tComName;
    }

    /**
     * @return t_org_code
     */
    public String gettOrgCode() {
        return tOrgCode;
    }

    /**
     * @param tOrgCode
     */
    public void settOrgCode(String tOrgCode) {
        this.tOrgCode = tOrgCode;
    }

    /**
     * @return t_address
     */
    public String gettAddress() {
        return tAddress;
    }

    /**
     * @param tAddress
     */
    public void settAddress(String tAddress) {
        this.tAddress = tAddress;
    }

    /**
     * @return t_zhuceriqi
     */
    public String gettZhuceriqi() {
        return tZhuceriqi;
    }

    /**
     * @param tZhuceriqi
     */
    public void settZhuceriqi(String tZhuceriqi) {
        this.tZhuceriqi = tZhuceriqi;
    }

    /**
     * @return t_zhuciziben
     */
    public String gettZhuciziben() {
        return tZhuciziben;
    }

    /**
     * @param tZhuciziben
     */
    public void settZhuciziben(String tZhuciziben) {
        this.tZhuciziben = tZhuciziben;
    }

    /**
     * @return t_faren
     */
    public String gettFaren() {
        return tFaren;
    }

    /**
     * @param tFaren
     */
    public void settFaren(String tFaren) {
        this.tFaren = tFaren;
    }
}