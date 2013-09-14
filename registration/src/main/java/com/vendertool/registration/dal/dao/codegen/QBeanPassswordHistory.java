package com.vendertool.registration.dal.dao.codegen;

import javax.annotation.Generated;

/**
 * QBeanPassswordHistory is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class QBeanPassswordHistory {

    private Long accountId;

    private java.sql.Timestamp createdDate;

    private java.sql.Timestamp lastModifiedDate;

    private Long passswordHistoryId;

    private String password;

    private String salat;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public java.sql.Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(java.sql.Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public java.sql.Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(java.sql.Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getPassswordHistoryId() {
        return passswordHistoryId;
    }

    public void setPassswordHistoryId(Long passswordHistoryId) {
        this.passswordHistoryId = passswordHistoryId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalat() {
        return salat;
    }

    public void setSalat(String salat) {
        this.salat = salat;
    }

}

