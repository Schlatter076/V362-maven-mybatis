package org.loyer.dao.impl;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.loyer.beans.V362TestData;
import org.loyer.dao.IV362TestData;
import org.loyer.dao.utils.SessionUtils;

public class V362TestDataImpl implements IV362TestData {

  private SqlSessionFactory sessionFactory;
  
  @Override
  public List<V362TestData> getAllByDate(String date) {
    SqlSession session = null;
    List<V362TestData> l = null;
    try {
      sessionFactory = SessionUtils.getFactory();
      session = sessionFactory.openSession();
      l = session.selectList("v362-selectOneDayTestDatas", date);
      session.commit();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(session != null)
      session.close();
    }
    return l;
  }

  @Override
  public String getItemNumById(BigInteger id) {
    SqlSession session = null;
    String s = "";
    try {
      sessionFactory = SessionUtils.getFactory();
      session = sessionFactory.openSession();
      s = session.selectOne("v362-getItemNumById", id);
      session.commit();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(session != null)
      session.close();
    }
    return s;
  }

  @Override
  public String getProductNumById(BigInteger id) {
    SqlSession session = null;
    String s = "";
    try {
      sessionFactory = SessionUtils.getFactory();
      session = sessionFactory.openSession();
      s = session.selectOne("v362-getProductNumById", id);
      session.commit();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(session != null)
      session.close();
    }
    return s;
  }

  @Override
  public List<BigInteger> getIdsBydate(String date) {
    SqlSession session = null;
    List<BigInteger> l = null;
    try {
      sessionFactory = SessionUtils.getFactory();
      session = sessionFactory.openSession();
      l = session.selectList("v362-getIdsBydate", date);
      session.commit();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(session != null)
      session.close();
    }
    return l;
  }

  @Override
  public V362TestData getTestDataById(BigInteger id) {
    SqlSession session = null;
    V362TestData d = null;
    try {
      sessionFactory = SessionUtils.getFactory();
      session = sessionFactory.openSession();
      d = session.selectOne("v362-getTestDataById", id);
      session.commit();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(session != null)
      session.close();
    }
    return d;
  }

  @Override
  public void insert(V362TestData data) {
    SqlSession session = null;
    try {
      sessionFactory = SessionUtils.getFactory();
      session = sessionFactory.openSession();
      session.insert("v362-insertTestData", data);
      session.commit();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(session != null)
      session.close();
    }
  }

}
