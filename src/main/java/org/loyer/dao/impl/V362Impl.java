package org.loyer.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.loyer.beans.V362;
import org.loyer.dao.IV362;
import org.loyer.dao.utils.SessionUtils;

public class V362Impl implements IV362 {
  
  private SqlSessionFactory sessionFactory;

  @Override
  public List<V362> getAll() {
    SqlSession session = null;
    List<V362> l = null;
    try {
      sessionFactory = SessionUtils.getFactory();
      session = sessionFactory.openSession();
      l = session.selectList("v362");
      session.commit();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(session != null)
      session.close();
    }
    return l;
  }

}
