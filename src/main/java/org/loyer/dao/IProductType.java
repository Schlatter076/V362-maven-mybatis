package org.loyer.dao;

import java.util.List;

import org.loyer.beans.ProductType;

public interface IProductType {
  
  List<ProductType> getAll();
  ProductType getByNum(int num);

}
