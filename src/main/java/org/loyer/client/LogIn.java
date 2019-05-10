package org.loyer.client;

import java.awt.EventQueue;
import java.util.List;

import org.jfree.ui.RefineryUtilities;
import org.loyer.beans.ProductType;
import org.loyer.dao.impl.ProductTypeImpl;

import loyer.gui.LogInFrame;

public class LogIn extends LogInFrame {

  private List<ProductType> list;
  
  public LogIn() {
    list = new ProductTypeImpl().getAll();
    textField.setText(list.get(0).getName());  //设置默认机种
    frame.pack();
    RefineryUtilities.centerFrameOnScreen(frame); 
  }
  @Override
  public void logInEvent() {
    if(!isDataView) {
      if(textField.getText().equals(list.get(0).getName())) {
        isDataView = true;
        frame.dispose();
        DataView.getDataView("v362", list.get(0).getName());
      }
    }
  }
  @Override
  public void chooseEvent() {
    textField.setText(list.get(typeCount % list.size()).getName());
    typeCount++;
  }
  
  public static void logIn() {
    EventQueue.invokeLater(new Runnable() {
      
      @Override
      public void run() {
        LogIn win = new LogIn();
        win.frame.setVisible(true);
      }
    });
  }//*/
  
}
