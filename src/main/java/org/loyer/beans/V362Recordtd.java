package org.loyer.beans;

public class V362Recordtd {

  private String recordname;
  private String recordsum;
  private String recordok;
  private String recordng;
  private String recordts;
  private String recordtime;

  public V362Recordtd() {
    super();
  }

  public V362Recordtd(String name, String sum, String ok, String ng, String times, String date) {
    super();
    this.recordname = name;
    this.recordsum = sum;
    this.recordok = ok;
    this.recordng = ng;
    this.recordts = times;
    this.recordtime = date;
  }

  public String getName() {
    return recordname;
  }

  public void setName(String name) {
    this.recordname = name;
  }

  public String getSum() {
    return recordsum;
  }

  public void setSum(String sum) {
    this.recordsum = sum;
  }

  public String getOk() {
    return recordok;
  }

  public void setOk(String ok) {
    this.recordok = ok;
  }

  public String getNg() {
    return recordng;
  }

  public void setNg(String ng) {
    this.recordng = ng;
  }

  public String getTimes() {
    return recordts;
  }

  public void setTimes(String times) {
    this.recordts = times;
  }

  public String getDate() {
    return recordtime;
  }

  public void setDate(String date) {
    this.recordtime = date;
  }

  @Override
  public String toString() {
    return "V362Recordtd [name=" + recordname + ", sum=" + recordsum + ", ok=" + recordok + ", ng=" + recordng + ", times=" + recordts + ", date="
        + recordtime + "]";
  }

}
