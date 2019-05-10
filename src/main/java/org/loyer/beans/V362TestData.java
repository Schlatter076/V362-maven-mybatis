package org.loyer.beans;

import java.math.BigInteger;

public class V362TestData {

  private BigInteger id;
  private String product_num;
  private String num;
  private String items;
  private String upper;
  private String lower;
  private String value;
  private String unit;
  private String result;
  private String times;
  private String date;
  private String remark;

  public V362TestData() {
    super();
  }

  public V362TestData(String number, String xuhao, String items, String upper, String lower, String testValue,
      String unit, String result, String times, String date, String remark) {
    super();
    this.product_num = number;
    this.num = xuhao;
    this.items = items;
    this.upper = upper;
    this.lower = lower;
    this.value = testValue;
    this.unit = unit;
    this.result = result;
    this.times = times;
    this.date = date;
    this.remark = remark;
  }

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public String getNumber() {
    return product_num;
  }

  public void setNumber(String number) {
    this.product_num = number;
  }

  public String getXuhao() {
    return num;
  }

  public void setXuhao(String xuhao) {
    this.num = xuhao;
  }

  public String getItems() {
    return items;
  }

  public void setItems(String items) {
    this.items = items;
  }

  public String getUpper() {
    return upper;
  }

  public void setUpper(String upper) {
    this.upper = upper;
  }

  public String getLower() {
    return lower;
  }

  public void setLower(String lower) {
    this.lower = lower;
  }

  public String getTestValue() {
    return value;
  }

  public void setTestValue(String testValue) {
    this.value = testValue;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getTimes() {
    return times;
  }

  public void setTimes(String times) {
    this.times = times;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  @Override
  public String toString() {
    return "V362TestData [id=" + id + ", number=" + product_num + ", xuhao=" + num + ", items=" + items + ", upper="
        + upper + ", lower=" + lower + ", testValue=" + value + ", unit=" + unit + ", result=" + result + ", times="
        + times + ", date=" + date + ", remark=" + remark + "]";
  }

}
