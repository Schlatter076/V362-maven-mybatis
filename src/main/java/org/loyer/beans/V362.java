package org.loyer.beans;

public class V362 {

  private String number;
  private String item;
  private String upper;
  private String lower;
  private String value;
  private String unit;
  private String result;

  public V362() {
    super();
  }

  public V362(String number, String item, String upper, String lower, String value, String unit, String result) {
    super();
    this.number = number;
    this.item = item;
    this.upper = upper;
    this.lower = lower;
    this.value = value;
    this.unit = unit;
    this.result = result;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
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

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
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

  @Override
  public String toString() {
    return "V362 [number=" + number + ", item=" + item + ", upper=" + upper + ", lower=" + lower + ", value=" + value
        + ", unit=" + unit + ", result=" + result + "]";
  }

}
