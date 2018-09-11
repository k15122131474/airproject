package com.sfa.model;

import javax.persistence.*;

@Table(name = "t_person")
public class TPerson {
    @Id
    @Column(name = "t_preson_id")
    private String tPresonId;

    @Column(name = "t_user_id")
    private String tUserId;

    @Column(name = "t_com_id")
    private String tComId;

    @Column(name = "t_dic_id")
    private String tDicId;

    @Column(name = "t_gender")
    private String tGender;

    @Column(name = "t_mobile")
    private String tMobile;

    @Column(name = "t_email")
    private String tEmail;

    @Column(name = "t_cname")
    private String tCname;

    /**
     * @return t_preson_id
     */
    public String gettPresonId() {
        return tPresonId;
    }

    /**
     * @param tPresonId
     */
    public void settPresonId(String tPresonId) {
        this.tPresonId = tPresonId;
    }

    /**
     * @return t_user_id
     */
    public String gettUserId() {
        return tUserId;
    }

    /**
     * @param tUserId
     */
    public void settUserId(String tUserId) {
        this.tUserId = tUserId;
    }

    /**
     * @return t_com_id
     */
    public String gettComId() {
        return tComId;
    }

    /**
     * @param tComId
     */
    public void settComId(String tComId) {
        this.tComId = tComId;
    }

    /**
     * @return t_dic_id
     */
    public String gettDicId() {
        return tDicId;
    }

    /**
     * @param tDicId
     */
    public void settDicId(String tDicId) {
        this.tDicId = tDicId;
    }

    /**
     * @return t_gender
     */
    public String gettGender() {
        return tGender;
    }

    /**
     * @param tGender
     */
    public void settGender(String tGender) {
        this.tGender = tGender;
    }

    /**
     * @return t_mobile
     */
    public String gettMobile() {
        return tMobile;
    }

    /**
     * @param tMobile
     */
    public void settMobile(String tMobile) {
        this.tMobile = tMobile;
    }

    /**
     * @return t_email
     */
    public String gettEmail() {
        return tEmail;
    }

    /**
     * @param tEmail
     */
    public void settEmail(String tEmail) {
        this.tEmail = tEmail;
    }

    /**
     * @return t_cname
     */
    public String gettCname() {
        return tCname;
    }

    /**
     * @param tCname
     */
    public void settCname(String tCname) {
        this.tCname = tCname;
    }
}