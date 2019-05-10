package org.loyer.dao;

import java.util.List;

import org.loyer.beans.V362Recordtd;

public interface IV362Recordtd {
  List<V362Recordtd> getAll();
  V362Recordtd getByDate(String date);
  void insert(V362Recordtd data);
  void update(V362Recordtd data);
}
