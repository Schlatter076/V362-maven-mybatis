package org.loyer.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.loyer.beans.V362Recordtd;
import org.loyer.dao.IV362Recordtd;
import org.loyer.dao.utils.SessionUtils;

public class V362RecordtdImpl implements IV362Recordtd {
  
  private SqlSessionFactory sessionFactory;

  @Override
  public List<V362Recordtd> getAll() {
    SqlSession session = null;
    List<V362Recordtd> v = null;
    try {
      sessionFactory = SessionUtils.getFactory();
      session = sessionFactory.openSession();
      v = session.selectList("v362-selectAllRecordtd");
      session.commit();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(session != null)
      session.close();
    }
    return v;
  }

  @Override
  public V362Recordtd getByDate(String date) {
    SqlSession session = null;
    V362Recordtd v = null;
    try {
      sessionFactory = SessionUtils.getFactory();
      session = sessionFactory.openSession();
      v = session.selectOne("v362-selectRecordtdByDate", date);
      session.commit();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(session != null)
      session.close();
    }
    return v;
  }

  @Override
  public void insert(V362Recordtd data) {
    SqlSession session = null;
    try {
      sessionFactory = SessionUtils.getFactory();
      session = sessionFactory.openSession();
      session.insert("v362-insertRecordtd", data);
      session.commit();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(session != null)
      session.close();
    }
  }

  @Override
  public void update(V362Recordtd data) {
    SqlSession session = null;
    try {
      sessionFactory = SessionUtils.getFactory();
      session = sessionFactory.openSession();
      session.update("v362-updateRecordtd", data);
      session.commit();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(session != null)
      session.close();
    }
  }
}
