package com.sfa.model;

import javax.persistence.*;

@Table(name = "t_dic_code")
public class TDicCode {
    @Id
    @Column(name = "t_dic_id")
    private String tDicId;

    @Column(name = "t_dic_code")
    private String tDicCode;

    @Column(name = "t_name")
    private String tName;

    @Column(name = "t_type")
    private String tType;

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
     * @return t_dic_code
     */
    public String gettDicCode() {
        return tDicCode;
    }

    /**
     * @param tDicCode
     */
    public void settDicCode(String tDicCode) {
        this.tDicCode = tDicCode;
    }

    /**
     * @return t_name
     */
    public String gettName() {
        return tName;
    }

    /**
     * @param tName
     */
    public void settName(String tName) {
        this.tName = tName;
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
}