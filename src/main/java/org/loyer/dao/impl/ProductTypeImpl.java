package org.loyer.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.loyer.beans.ProductType;
import org.loyer.dao.IProductType;
import org.loyer.dao.utils.SessionUtils;

public class ProductTypeImpl implements IProductType {
  
  private SqlSessionFactory sessionFactory;

  @Override
  public List<ProductType> getAll() {
    List<ProductType> list = null;
    SqlSession session = null;
    try {
      sessionFactory = SessionUtils.getFactory();
      session = sessionFactory.openSession();
      list = session.selectList("selectAllProductType");
      session.commit();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(session != null)
      session.close();
    }
    return list;
  }

  @Override
  public ProductType getByNum(int num) {
    ProductType pt = null;
    SqlSession session = null;
    try {
      sessionFactory = SessionUtils.getFactory();
      session = sessionFactory.openSession();
      pt = session.selectOne("selectProductTypeByNum", num);
      session.commit();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(session != null)
      session.close();
    }
    return pt;
  }

}
