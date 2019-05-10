package org.loyer.dao;

import java.math.BigInteger;
import java.util.List;

import org.loyer.beans.V362TestData;

public interface IV362TestData {
  
  List<V362TestData> getAllByDate(String date);
  String getItemNumById(BigInteger id);
  String getProductNumById(BigInteger id);
  List<BigInteger> getIdsBydate(String date);
  V362TestData getTestDataById(BigInteger id);
  void insert(V362TestData data);
}
