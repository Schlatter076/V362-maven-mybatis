package org.loyer.dao;

import java.util.List;

import org.loyer.beans.V362ProductNum;

public interface IV362ProductNum {
  void insert(V362ProductNum num);
  List<V362ProductNum> selectNum(String num);
}
