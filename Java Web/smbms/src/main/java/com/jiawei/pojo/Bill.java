package com.jiawei.pojo;


import java.math.BigDecimal;

public class Bill {

  private Integer id;
  private String billCode;
  private String productName;
  private String productDesc;
  private String productUnit;
  private BigDecimal productCount;
  private BigDecimal totalPrice;
  private Integer isPayment;
  private Integer createdBy;
  private java.sql.Timestamp creationDate;
  private Integer modifyBy;
  private java.sql.Timestamp modifyDate;
  private Integer providerld;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getBillCode() {
    return billCode;
  }

  public void setBillCode(String billCode) {
    this.billCode = billCode;
  }


  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }


  public String getProductDesc() {
    return productDesc;
  }

  public void setProductDesc(String productDesc) {
    this.productDesc = productDesc;
  }


  public String getProductUnit() {
    return productUnit;
  }

  public void setProductUnit(String productUnit) {
    this.productUnit = productUnit;
  }


  public BigDecimal getProductCount() {
    return productCount;
  }

  public void setProductCount(BigDecimal productCount) {
    this.productCount = productCount;
  }


  public BigDecimal getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(BigDecimal totalPrice) {
    this.totalPrice = totalPrice;
  }


  public Integer getIsPayment() {
    return isPayment;
  }

  public void setIsPayment(Integer isPayment) {
    this.isPayment = isPayment;
  }


  public Integer getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Integer createdBy) {
    this.createdBy = createdBy;
  }


  public java.sql.Timestamp getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(java.sql.Timestamp creationDate) {
    this.creationDate = creationDate;
  }


  public Integer getModifyBy() {
    return modifyBy;
  }

  public void setModifyBy(Integer modifyBy) {
    this.modifyBy = modifyBy;
  }


  public java.sql.Timestamp getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(java.sql.Timestamp modifyDate) {
    this.modifyDate = modifyDate;
  }


  public Integer getProviderld() {
    return providerld;
  }

  public void setProviderld(Integer providerld) {
    this.providerld = providerld;
  }

  @Override
  public String toString() {
    return "Bill{" +
            "id=" + id +
            ", billCode='" + billCode + '\'' +
            ", productName='" + productName + '\'' +
            ", productDesc='" + productDesc + '\'' +
            ", productUnit='" + productUnit + '\'' +
            ", productCount=" + productCount +
            ", totalPrice=" + totalPrice +
            ", isPayment=" + isPayment +
            ", createdBy=" + createdBy +
            ", creationDate=" + creationDate +
            ", modifyBy=" + modifyBy +
            ", modifyDate=" + modifyDate +
            ", providerld=" + providerld +
            '}';
  }
}
