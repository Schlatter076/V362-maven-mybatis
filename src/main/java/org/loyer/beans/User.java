package org.loyer.beans;

public class User {

  private Integer id;
  private String user_name;
  private String password;

  public User() {
    super();
  }

  public User(Integer id, String name, String pwd) {
    super();
    this.id = id;
    this.user_name = name;
    this.password = pwd;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return user_name;
  }

  public void setName(String name) {
    this.user_name = name;
  }

  public String getPwd() {
    return password;
  }

  public void setPwd(String pwd) {
    this.password = pwd;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + user_name + ", pwd=" + password + "]";
  }

}
