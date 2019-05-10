package org.loyer.dao.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtils {
  
  private static SqlSessionFactory sessionFactory;
  
  private SessionUtils() {} //不允许创建本类对象
  
  public static SqlSessionFactory getFactory() throws IOException {
    if(sessionFactory == null) {
      String resource = "mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      return sessionFactory;
    }
    else {
      return sessionFactory;
    }
  }

}
