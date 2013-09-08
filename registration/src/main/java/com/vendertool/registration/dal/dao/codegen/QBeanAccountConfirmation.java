package com.vendertool.registration.dal.dao.codegen;

import javax.annotation.Generated;

/**
 * QBeanAccountConfirmation is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class QBeanAccountConfirmation {

    private Long accountConfirmationId;

    private Long accountId;

    private Short confirmationCode;

    private java.sql.Timestamp confirmationDate;

    private java.sql.Timestamp createdDate;

    private java.sql.Timestamp expiryDate;

    private Byte lastModifiedApp;

    private java.sql.Timestamp lastModifiedDate;

    private Byte numberOfAttempts;

    private String sessionId;

    public Long getAccountConfirmationId() {
        return accountConfirmationId;
    }

    public void setAccountConfirmationId(Long accountConfirmationId) {
        this.accountConfirmationId = accountConfirmationId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Short getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(Short confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public java.sql.Timestamp getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(java.sql.Timestamp confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public java.sql.Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(java.sql.Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public java.sql.Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(java.sql.Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Byte getLastModifiedApp() {
        return lastModifiedApp;
    }

    public void setLastModifiedApp(Byte lastModifiedApp) {
        this.lastModifiedApp = lastModifiedApp;
    }

    public java.sql.Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(java.sql.Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Byte getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfAttempts(Byte numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}

