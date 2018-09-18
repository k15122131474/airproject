package com.sfa.model;

import javax.persistence.*;

@Table(name = "t_attenchment")
public class TAttenchment {
    @Id
    @Column(name = "t_attid")
    private Integer tAttid;

    @Column(name = "t_id")
    private String tId;

    @Column(name = "t_attname")
    private String tAttname;

    @Column(name = "t_type")
    private String tType;

    @Column(name = "t_atturl")
    private String tAtturl;

    /**
     * @return t_attid
     */
    public Integer gettAttid() {
        return tAttid;
    }

    /**
     * @param tAttid
     */
    public void settAttid(Integer tAttid) {
        this.tAttid = tAttid;
    }

    /**
     * @return t_id
     */
    public String gettId() {
        return tId;
    }

    /**
     * @param tId
     */
    public void settId(String tId) {
        this.tId = tId;
    }

    /**
     * @return t_attname
     */
    public String gettAttname() {
        return tAttname;
    }

    /**
     * @param tAttname
     */
    public void settAttname(String tAttname) {
        this.tAttname = tAttname;
    }

    /**
     * @return t_type
     */
    public String gettType() {
        return tType;
    }

    /**
     * @param tType
     */
    public void settType(String tType) {
        this.tType = tType;
    }

    /**
     * @return t_atturl
     */
    public String gettAtturl() {
        return tAtturl;
    }

    /**
     * @param tAtturl
     */
    public void settAtturl(String tAtturl) {
        this.tAtturl = tAtturl;
    }
}