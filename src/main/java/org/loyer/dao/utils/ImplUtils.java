package org.loyer.dao.utils;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import javax.swing.JOptionPane;

import org.loyer.beans.V362TestData;
import org.loyer.dao.impl.ProductTypeImpl;
import org.loyer.dao.impl.UserImpl;
import org.loyer.dao.impl.V362Impl;
import org.loyer.dao.impl.V362ProductNumImpl;
import org.loyer.dao.impl.V362RecordtdImpl;
import org.loyer.dao.impl.V362TestDataImpl;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ImplUtils {
  
  private static ProductTypeImpl productTypeImpl;
  private static UserImpl userImpl;
  private static V362Impl v362Impl;
  private static V362ProductNumImpl v362ProductNumImpl;
  private static V362RecordtdImpl v362RecordtdImpl;
  private static V362TestDataImpl v362TestDataImpl;
  
  private ImplUtils() {} //不允许其他类创建本类实例
  
  public static ProductTypeImpl getProductTypeImpl() {
    if(productTypeImpl == null) {
      productTypeImpl = new ProductTypeImpl();
    }
    return productTypeImpl;
  }
  public static UserImpl getUserImpl() {
    if(userImpl == null) {
      userImpl = new UserImpl();
    }
    return userImpl;
  }
  public static V362Impl getV362Impl() {
    if(v362Impl == null) {
      v362Impl = new V362Impl();
    }
    return v362Impl;
  }
  public static V362ProductNumImpl getV362ProductNumImpl() {
    if(v362ProductNumImpl == null) {
      v362ProductNumImpl = new V362ProductNumImpl();
    }
    return v362ProductNumImpl;
  }
  public static V362RecordtdImpl getV362RecordtdImpl() {
    if(v362RecordtdImpl == null) {
      v362RecordtdImpl = new V362RecordtdImpl();
    }
    return v362RecordtdImpl;
  }
  public static V362TestDataImpl getV362TestDataImpl() {
    if(v362TestDataImpl == null) {
      v362TestDataImpl = new V362TestDataImpl();
    }
    return v362TestDataImpl;
  }
  /**
   * 将测试数据记录导出到本地
   */
  public static void outExcl(String date) {
    WritableWorkbook wwb = null;
    try {
      String path = "excl/";
      File pathFile = new File(path);
      if(!pathFile.isDirectory()) {
        pathFile.mkdirs();
      }
      //创建可写入的Excel工作簿
      String fileName = "v362测试数据" + date + ".xls";
      File file = new File(pathFile, fileName);
      if(!file.exists()) {
        file.createNewFile();
      }
      //以fileName为文件名来创建一个Workbook
      wwb = Workbook.createWorkbook(file);
      
      //创建工作表
      WritableSheet ws = wwb.createSheet("测试数据表", 0);
      
      //查询数据库中所有的数据
      List<V362TestData> list = getV362TestDataImpl().getAllByDate(date);
      
      //要插入到的excl表格的行号，默认从0开始
      Label label1 = new Label(0, 0, "产品编号");
      Label label2 = new Label(1, 0, "测试步骤");
      Label label3 = new Label(2, 0, "测试内容");
      Label label4 = new Label(3, 0, "上限值");
      Label label5 = new Label(4, 0, "下限值");
      Label label6 = new Label(5, 0, "实测值");
      Label label7 = new Label(6, 0, "单位");
      Label label8 = new Label(7, 0, "结果判定");
      Label label9 = new Label(8, 0, "修改时间");
      Label label10 = new Label(9, 0, "日期");
      Label label11 = new Label(10, 0, "备注");
      ws.addCell(label1);
      ws.addCell(label2);
      ws.addCell(label3);
      ws.addCell(label4);
      ws.addCell(label5);
      ws.addCell(label6);
      ws.addCell(label7);
      ws.addCell(label8);
      ws.addCell(label9);
      ws.addCell(label10);
      ws.addCell(label11);
      for(int i = 0; i < list.size(); i++) {
        Label label1_ = new Label(0, i+1, list.get(i).getNumber());
        Label label2_ = new Label(1, i+1, list.get(i).getXuhao());
        Label label3_ = new Label(2, i+1, list.get(i).getItems());
        Label label4_ = new Label(3, i+1, list.get(i).getUpper());
        Label label5_ = new Label(4, i+1, list.get(i).getLower());
        Label label6_ = new Label(5, i+1, list.get(i).getTestValue());
        Label label7_ = new Label(6, i+1, list.get(i).getUnit());
        Label label8_ = new Label(7, i+1, list.get(i).getResult());
        Label label9_ = new Label(8, i+1, list.get(i).getTimes());
        Label label10_ = new Label(9, i+1, list.get(i).getDate());
        Label label11_ = new Label(10, i+1, list.get(i).getRemark());
        
        ws.addCell(label1_);
        ws.addCell(label2_);
        ws.addCell(label3_);
        ws.addCell(label4_);
        ws.addCell(label5_);
        ws.addCell(label6_);
        ws.addCell(label7_);
        ws.addCell(label8_); 
        ws.addCell(label9_);
        ws.addCell(label10_);
        ws.addCell(label11_); 
        
      }
      //写进文档
      wwb.write();
      
    } catch(Exception e) {
      JOptionPane.showMessageDialog(null, "excl写入失败:" + e.getLocalizedMessage());
    } finally {
      //关闭Excel工作簿对象
      try {
        wwb.close();
      } catch (WriteException | IOException e) {
        JOptionPane.showMessageDialog(null, "excl导出失败:" + e.getLocalizedMessage());
      }
    }
  }
  /**
   * 将测试数据对比导出到本地
   */
  public static void outCompExcl(String date) {
    WritableWorkbook wwb = null;
    try {
      String path = "excl/";
      File pathFile = new File(path);
      if (!pathFile.isDirectory()) {
        pathFile.mkdirs();
      }
      // 创建可写入的Excel工作簿
      String fileName = "v362数据比对" + date + ".xls";
      File file = new File(pathFile, fileName);
      if (!file.exists()) {
        file.createNewFile();
      }
      // 以fileName为文件名来创建一个Workbook
      wwb = Workbook.createWorkbook(file);

      // 创建工作表
      WritableSheet ws = wwb.createSheet("测试数据表", 0);

      List<BigInteger> ids = getV362TestDataImpl().getIdsBydate(date);

      // 要插入到的excl表格的行号，默认从0开始
      Label label1 = new Label(0, 0, "产品编号");
      Label label2 = new Label(1, 0, "Left_PIN1-PIN2绝缘");
      Label label3 = new Label(2, 0, "Left_PIN2-PIN3绝缘");
      Label label4 = new Label(3, 0, "Right_PIN1-PIN2绝缘");
      Label label5 = new Label(4, 0, "Right_PIN2-PIN3绝缘");
      Label label6 = new Label(5, 0, "产品负载电压");
      Label label7 = new Label(6, 0, "PIN1电压降");
      Label label8 = new Label(7, 0, "PIN2电压降");
      Label label9 = new Label(8, 0, "PIN3电压降");
      Label label10 = new Label(9, 0, "产品断电");

      Label label11 = new Label(10, 0, "修改时间");
      Label label12 = new Label(11, 0, "日期");
      ws.addCell(label1);
      ws.addCell(label2);
      ws.addCell(label3);
      ws.addCell(label4);
      ws.addCell(label5);
      ws.addCell(label6);
      ws.addCell(label7);
      ws.addCell(label8);
      ws.addCell(label9);
      ws.addCell(label10);
      ws.addCell(label11);
      ws.addCell(label12);

      int count = 0;
      for(BigInteger id : ids) {
        
        String item = getV362TestDataImpl().getItemNumById(id);
        V362TestData td = getV362TestDataImpl().getTestDataById(id);
        
        int key = Integer.parseInt(item);
        switch (key) {
        case 1:
          ws.addCell(new Label(0, ++count, td.getNumber()));
          ws.addCell(new Label(1, count, td.getTestValue()));
          ws.addCell(new Label(10, count, td.getTimes()));
          ws.addCell(new Label(11, count, td.getDate()));
          break;
        case 2:
          ws.addCell(new Label(2, count, td.getTestValue()));
          break;
        case 3:
          ws.addCell(new Label(3, count, td.getTestValue()));
          break;
        case 4:
          ws.addCell(new Label(4, count, td.getTestValue()));
          break;
        case 5:
          ws.addCell(new Label(5, count, td.getTestValue()));
          break;
        case 6:
          ws.addCell(new Label(6, count, td.getTestValue()));
          break;
        case 7:
          ws.addCell(new Label(7, count, td.getTestValue()));
          break;
        case 8:
          ws.addCell(new Label(8, count, td.getTestValue()));
          break;
        case 9:
          ws.addCell(new Label(9, count, td.getTestValue()));
          break;
        case 10:
          ws.addCell(new Label(10, count, td.getTestValue()));
          break;
        default:
          break;
        }
      }
      // 写进文档
      wwb.write();

    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(null, "excl写入失败:" + e.getLocalizedMessage());
    } finally {
      // 关闭Excel工作簿对象
      try {
        wwb.close();
      } catch (WriteException | IOException e) {
        JOptionPane.showMessageDialog(null, "excl导出失败:" + e.getLocalizedMessage());
      }
    }
  }
  
}
