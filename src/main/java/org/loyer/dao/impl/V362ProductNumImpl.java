package org.loyer.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.loyer.beans.V362ProductNum;
import org.loyer.dao.IV362ProductNum;
import org.loyer.dao.utils.SessionUtils;

public class V362ProductNumImpl implements IV362ProductNum {

  private SqlSessionFactory sessionFactory;
  
  @Override
  public void insert(V362ProductNum num) {
    SqlSession session = null;
    try {
      sessionFactory = SessionUtils.getFactory();
      session = sessionFactory.openSession();
      session.insert("v362-insertProductNum", num);
      session.commit();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(session != null)
      session.close();
    }
  }

  @Override
  public List<V362ProductNum> selectNum(String num) {
    SqlSession session = null;
    List<V362ProductNum> num2 = null;
    try {
      sessionFactory = SessionUtils.getFactory();
      session = sessionFactory.openSession();
      num2 = session.selectList("v362-selectByNum", num);
      session.commit();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(session != null)
      session.close();
    }
    return num2;
  }

}
