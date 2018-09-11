package com.sfa.model;

import javax.persistence.*;

@Table(name = "t_test_info")
public class TTestInfo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TEST_STATE")
    private String testState;

    @Column(name = "TEST_NAME")
    private String testName;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return TEST_STATE
     */
    public String getTestState() {
        return testState;
    }

    /**
     * @param testState
     */
    public void setTestState(String testState) {
        this.testState = testState;
    }

    /**
     * @return TEST_NAME
     */
    public String getTestName() {
        return testName;
    }

    /**
     * @param testName
     */
    public void setTestName(String testName) {
        this.testName = testName;
    }
}