package org.loyer.dao.impl;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.loyer.beans.User;
import org.loyer.dao.IUser;
import org.loyer.dao.utils.SessionUtils;

public class UserImpl implements IUser {
  
  private SqlSessionFactory sessionFactory;

  @Override
  public User getUserById(Integer id) {
    SqlSession session = null;
    User u = null;
    try {
      sessionFactory = SessionUtils.getFactory();
      session = sessionFactory.openSession();
      u = session.selectOne("getUserById", id);
      session.commit();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if(session != null)
      session.close();
    }
    return u;
  }

}
