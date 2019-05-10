package org.loyer.test;

import java.math.BigInteger;
import java.util.List;

import org.junit.Test;
import org.loyer.beans.ProductType;
import org.loyer.beans.User;
import org.loyer.beans.V362;
import org.loyer.beans.V362ProductNum;
import org.loyer.beans.V362Recordtd;
import org.loyer.beans.V362TestData;
import org.loyer.dao.impl.ProductTypeImpl;
import org.loyer.dao.impl.UserImpl;
import org.loyer.dao.impl.V362Impl;
import org.loyer.dao.impl.V362ProductNumImpl;
import org.loyer.dao.impl.V362RecordtdImpl;
import org.loyer.dao.impl.V362TestDataImpl;
import org.loyer.dao.utils.ImplUtils;

public class MyTest {
  
  @Test
  public void test01() {
    V362Impl v362Impl = new V362Impl();
    List<V362> list = v362Impl.getAll();
    for (V362 v362 : list) {
      System.out.println(v362);
    }
  }
  @Test
  public void test02() {
    ProductTypeImpl impl = new ProductTypeImpl();
    List<ProductType> list = impl.getAll();
    for (ProductType productType : list) {
      System.out.println(productType);
    }
  }
  @Test
  public void test03() {
    UserImpl impl = new UserImpl();
    User u = impl.getUserById(1);
    System.out.println(u);
  }
  @Test
  public void test04() {
    V362ProductNumImpl impl = new V362ProductNumImpl();
    V362ProductNum num = new V362ProductNum("你好");
    impl.insert(num);
    List<V362ProductNum> list = impl.selectNum("你好");
    for (V362ProductNum v362ProductNum : list) {
      System.out.println(v362ProductNum);
    }
  }
  @Test
  public void test05() {
    V362RecordtdImpl impl = new V362RecordtdImpl();
    List<V362Recordtd> list = impl.getAll();
    for (V362Recordtd v362Recordtd : list) {
      System.out.println(v362Recordtd);
    }
    System.out.println(impl.getByDate("2019-05-08"));
    //impl.update(new V362Recordtd("v362", "250", "249", "1", "25.8", "2019-05-09"));
  }
  @Test
  public void test06() {
    V362TestDataImpl impl = new V362TestDataImpl();
//    for(int i = 0; i < 9; i++) {
//      impl.insert(new V362TestData("789456", (1 + i) + "", "cdvd", "52.3", "45.2", "50.3", "V", "PASS", "13:42", "2019-05-09", ""));
//    }
    List<V362TestData> list = impl.getAllByDate("2019-05-09");
    for (V362TestData v362TestData : list) {
      System.out.println(v362TestData);
    }
    List<BigInteger> ids = impl.getIdsBydate("2019-05-09");
    for (BigInteger bigInteger : ids) {
      System.out.println("ID::" + bigInteger);
      System.out.println("ID" + bigInteger + "对应的数据::" + impl.getTestDataById(bigInteger));
      System.out.println("产品编号::" + impl.getProductNumById(bigInteger));
      System.out.println("步骤名::" + impl.getItemNumById(bigInteger));
    }
    
  }
  @Test
  public void test07() {
    ImplUtils.outExcl("2019-05-09");
  }

}















