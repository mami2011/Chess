package com.vendertool.listing.dal.dao.codegen;

import javax.annotation.Generated;

/**
 * QBeanListingVariation is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class QBeanListingVariation {

    private String condition;

    private java.sql.Timestamp createdDate;

    private Byte lastModifiedApp;

    private java.sql.Timestamp lastModifiedDate;

    private Long listingId;

    private Long listingVariationId;

    private java.math.BigDecimal price;

    private Long productVariationId;

    private Integer quantity;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public java.sql.Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(java.sql.Timestamp createdDate) {
        this.createdDate = createdDate;
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

    public Long getListingId() {
        return listingId;
    }

    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }

    public Long getListingVariationId() {
        return listingVariationId;
    }

    public void setListingVariationId(Long listingVariationId) {
        this.listingVariationId = listingVariationId;
    }

    public java.math.BigDecimal getPrice() {
        return price;
    }

    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }

    public Long getProductVariationId() {
        return productVariationId;
    }

    public void setProductVariationId(Long productVariationId) {
        this.productVariationId = productVariationId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}

