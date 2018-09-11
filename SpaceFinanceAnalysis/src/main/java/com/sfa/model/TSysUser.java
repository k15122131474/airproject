package com.sfa.model;

import javax.persistence.*;

@Table(name = "t_sys_user")
public class TSysUser {
    @Id
    @Column(name = "t_user_id")
    private String tUserId;

    @Column(name = "t_user_name")
    private String tUserName;

    @Column(name = "t_user_pwd")
    private String tUserPwd;

    @Column(name = "t_role")
    private String tRole;

    @Column(name = "t_status")
    private String tStatus;

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
     * @return t_user_name
     */
    public String gettUserName() {
        return tUserName;
    }

    /**
     * @param tUserName
     */
    public void settUserName(String tUserName) {
        this.tUserName = tUserName;
    }

    /**
     * @return t_user_pwd
     */
    public String gettUserPwd() {
        return tUserPwd;
    }

    /**
     * @param tUserPwd
     */
    public void settUserPwd(String tUserPwd) {
        this.tUserPwd = tUserPwd;
    }

    /**
     * @return t_role
     */
    public String gettRole() {
        return tRole;
    }

    /**
     * @param tRole
     */
    public void settRole(String tRole) {
        this.tRole = tRole;
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