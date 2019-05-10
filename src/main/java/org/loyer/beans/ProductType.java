package org.loyer.beans;

public class ProductType {

  private int num;
  private String product_name;

  public ProductType() {
    super();
  }

  public ProductType(int num, String name) {
    super();
    this.num = num;
    this.product_name = name;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public String getName() {
    return product_name;
  }

  public void setName(String name) {
    this.product_name = name;
  }

  @Override
  public String toString() {
    return "ProductType [num=" + num + ", name=" + product_name + "]";
  }

}
