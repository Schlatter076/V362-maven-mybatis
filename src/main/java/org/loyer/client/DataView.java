package org.loyer.client;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.Timer;

import org.loyer.beans.User;
import org.loyer.beans.V362ProductNum;
import org.loyer.beans.V362Recordtd;
import org.loyer.beans.V362TestData;
import org.loyer.commands.Commands;
import org.loyer.dao.utils.DataTools;
import org.loyer.dao.utils.ImplUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import loyer.gui.LoyerFrame;
import loyer.serial.SerialPortTools;

public class DataView extends LoyerFrame {

  /** 测试数据表 */
  private JTable table;
  /** 测试数据表渲染类 */
  private MyTableCellRenderrer tableCell;
  /** 数据库表名 */
  private String tableName;
  /** 产品型号 */
  private String productType;
  /** 测试数据显示面板滚动条 */
  private JScrollBar scrollBar;
  /** 管理员用户 */
  private static User admin;

  private boolean com1HasData = false;
  private byte[] com1Bytes = new byte[11];
  private boolean isFinished = false;
  
  private int stepCounter = 0;
  
  /** 20ms定时器 */
  private Timer timer1;
  /** 10ms定时器 */
  private Timer timer2;
  /** 格式化时间值 */
  private SimpleDateFormat sdf;
  
  private static final Logger logger = LoggerFactory.getLogger(DataView.class);

  static {
    // 加载用户数据
    admin = ImplUtils.getUserImpl().getUserById(1);
    // 获取串口列表
  }

  public DataView(String tableName, String productType) {
    this.tableName = tableName;
    this.productType = productType;
    initialize();
  }

  private void initialize() {
    PRODUCT_NAME = productType;
    productField.setText(PRODUCT_NAME);
    table = DataTools.completedTable();
    dataPanel.setViewportView(table);
    dataPanel.doLayout();
    scrollBar = dataPanel.getVerticalScrollBar();
    persistScroll.setViewportView(new JLabel(new ImageIcon(JLabel.class.getResource("/pic/frame.jpg"))));
    scanField.setEditable(false);
    timer1 = new Timer(20, new Timer1Listener());
    timer2 = new Timer(10, new Timer2Listener());
    sdf = new SimpleDateFormat("HH:mm:ss");
  }

  /**
   * 调用测试页面的方法
   */
  public static void getDataView(String tableName, String productType) {
    EventQueue.invokeLater(new Runnable() {

      @Override
      public void run() {
        DataView win = new DataView(tableName, productType);
        win.frame.setVisible(true);
        win.setTableCellRenderer();
        win.initLoad();
      }
    });
  }

  /**
   * table渲染色，测试结果为"PASS"则设为绿色，"NG"为红色
   */
  public void setTableCellRenderer() {
    if (tableCell == null) {
      tableCell = new MyTableCellRenderrer();
      table.getColumnModel().getColumn(7).setCellRenderer(tableCell);
    } else
      table.getColumnModel().getColumn(7).setCellRenderer(tableCell);
  }

  public boolean isEquals(byte hex, String data) {
    return String.format("%02x", hex).equals(data);
  }

  /**
   * 初始化表格
   */
  public void initTable() {
    for (int i = 1; i < table.getRowCount() - 1; i++) {
      table.setValueAt("?", i, 5); // 清空测试值
      table.setValueAt("?", i, 7); // 清空测试结果
    }
  }
  /**
   * 获取测试数据，插入到数据库
   * 
   * @param row
   *          行数
   * @param remark
   *          备注
   */
  public void record(int row, String remark) {
    String[] datas = new String[10];
    datas[0] = scanField.getText(); // 获取产品编号
    for (int i = 1; i <= 7; i++) {
      datas[i] = table.getValueAt(row, i).toString();
    }
    datas[8] = sdf.format(new Date());
    datas[9] = LocalDate.now().toString();
    V362TestData vtd = new V362TestData(datas[0], datas[1], datas[2], datas[3], datas[4], 
        datas[5], datas[6], datas[7], datas[8], datas[9], remark);
    ImplUtils.getV362TestDataImpl().insert(vtd);
    logger.info("成功记录一条数据::" + vtd.toString());
  }

  /**
   * 获取对应单元格的数值
   * 
   * @param row
   * @param col
   */
  public double getDoubleValue(int row, int col) {
    return Double.parseDouble(table.getValueAt(row, col).toString());
  }

  /**
   * 设置测试值
   * 
   * @param row
   * @param val
   */
  public void setTestValue(int row, double val) {
    table.setValueAt(val, row, 5);
    autoSetResultStatu(row, val);
  }

  /**
   * 自动判定结果
   * 
   * @param row
   *          行数，从0开始
   */
  public void autoSetResultStatu(int row, double val) {
    if (scrollBar != null) {
      scrollBar.setValue(scrollBar.getMaximum() * row / table.getRowCount());
    }
    if (val <= getDoubleValue(row, 3) && val >= getDoubleValue(row, 4)) {
      table.setValueAt("PASS", row, 7);

    } else {
      table.setValueAt("NG", row, 7);
      setResultNG();
    }
  }

  /*
   * 自动记录测试数据
   */
  public void autoRecord() {
    String[] rdData = new String[6];
    rdData[0] = tableName;
    rdData[1] = totalField.getText();
    rdData[2] = okField.getText();
    rdData[3] = ngField.getText();
    rdData[4] = timeField.getText();
    rdData[5] = LocalDate.now().toString();
    if (ImplUtils.getV362RecordtdImpl().getByDate(rdData[5]) == null) {
      ImplUtils.getV362RecordtdImpl().insert(new V362Recordtd(rdData[0], rdData[1], rdData[2], rdData[3], rdData[4], rdData[5]));
    } else {
      ImplUtils.getV362RecordtdImpl().update(new V362Recordtd(rdData[0], rdData[1], rdData[2], rdData[3], rdData[4], rdData[5]));
    }
  }

  /**
   * 设置测试结果NG
   */
  public void setResultNG() {
    statuField.setText("NG");
    ngCount++;
    totalCount = okCount + ngCount;
    ngField.setText(ngCount + "");
    totalField.setText(totalCount + "");
    setPieChart(okCount, ngCount);
    autoRecord();
    SerialPortTools.writeBytes(COM[0], Commands.NG);
    scanField.requestFocusInWindow();
  }

  /**
   * 全部测试结果OK
   */
  public void allPass() {
    if (isFinished) {
      
      stepCounter = 0;

      for (int i = 1; i < table.getRowCount() - 1; i++) {
        if (!table.getValueAt(i, 7).equals("PASS")) {
          setResultNG();
          return;
        }
      }
      SerialPortTools.writeBytes(COM[0], Commands.FINISHED);
      statuField.setText("PASS");
      okCount++;
      totalCount = okCount + ngCount;
      okField.setText(okCount + "");
      totalField.setText(totalCount + "");
      setPieChart(okCount, ngCount);
      ImplUtils.getV362ProductNumImpl().insert(new V362ProductNum(scanField.getText())); // 添加良品编号，防止重复测试
      autoRecord();
      scanField.requestFocusInWindow();
    }
  }

  /**
   * 初始化饼图和测试数据
   */
  public void initCountAndPieChart() {
    V362Recordtd rd = ImplUtils.getV362RecordtdImpl().getByDate(LocalDate.now().toString());
    if (rd != null) {
      okCount = Integer.parseInt(rd.getOk());
      ngCount = Integer.parseInt(rd.getNg());
      totalCount = Integer.parseInt(rd.getSum());
      timeCount = 0;
    } else {
      okCount = 0;
      ngCount = 0;
      totalCount = 0;
      timeCount = 0;
    }
    // scanField.setText(System.currentTimeMillis() + "");
    okField.setText(okCount + "");
    ngField.setText(ngCount + "");
    totalField.setText(totalCount + "");
    timeField.setText(timeCount + "");
    setPieChart(okCount, ngCount);
  }

  /**
   * 载入
   */
  public void initLoad() {
    initCountAndPieChart();
    initTable();
    initCOM(0);
    initCOM(1);
    initMultimeter();
    timer1.start();
    timer2.start();
    scanField.requestFocusInWindow();
  }
  /**
   * 初始化万用表
   */
  public void initMultimeter() {
    SerialPortTools.writeString(COM[1], "UTF-8", "*RST");
    SerialPortTools.writeString(COM[1], "UTF-8", "cmdset rigol");
    SerialPortTools.writeString(COM[1], "UTF-8", ":FUNCtion:CLEAR");
    SerialPortTools.writeString(COM[1], "UTF-8", ":function:voltage:DC");
    SerialPortTools.writeString(COM[1], "UTF-8", ":measure:voltage:DC?");
    SerialPortTools.writeString(COM[1], "UTF-8", ":calculate:function none");
  }
  /**
   * 系统复位
   */
  public void mcu_reset() {
    statuField.setText("系统复位");
    scanField.setText("");
    stepCounter = 0;
    initMultimeter();
    scanField.requestFocusInWindow();
    // initTable();
  }

  @Override
  public boolean pwdIsPassed(String command) {
    return false;
  }

  @Override
  public void usartMethod() {
    if (statuField.getText().equals("测试中...")) {
      JOptionPane.showMessageDialog(null, "测试进行中，不可操作！");
      scanField.requestFocusInWindow();
      return;
    }
    JPasswordField pf = new JPasswordField();
    pf.setFont(new Font("宋体", Font.PLAIN, 17));
    pf.setEchoChar('*');
    JOptionPane.showMessageDialog(null, pf, "请输入管理员密码：", JOptionPane.PLAIN_MESSAGE);
    char[] pwd = pf.getPassword();
    if (pwd.length == 6) {
      if (String.valueOf(pwd).equals(admin.getPwd())) {
        closeAllPorts();
        UsartTools.getUsartTools();
        scanField.requestFocusInWindow();
      } else {
        JOptionPane.showMessageDialog(null, "密码错误！");
        scanField.requestFocusInWindow();
      }
    } else {
      JOptionPane.showMessageDialog(null, "密码长度为6位！");
      scanField.requestFocusInWindow();
    }
  }

  @Override
  public void resultView() {
    if (statuField.getText().equals("测试中...")) {
      JOptionPane.showMessageDialog(null, "测试进行中，不可操作！");
      scanField.requestFocusInWindow();
      return;
    }
    scanField.requestFocusInWindow();
  }

  @Override
  public void reportView() {
    if (statuField.getText().equals("测试中...")) {
      JOptionPane.showMessageDialog(null, "测试进行中，不可操作！");
      scanField.requestFocusInWindow();
      return;
    } else {
      ReportView.getReportView();
      scanField.requestFocusInWindow();
    }
  }

  @Override
  public void nayinMethod() {
  }

  @Override
  public void COM1DataArrived() {
    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    byte[] data = SerialPortTools.readBytes(COM[0]);
    if (!com1HasData) {
      for (int i = 0; i < com1Bytes.length; i++) {
        if (isEquals(com1Bytes[i], "f3") && isEquals(com1Bytes[i + 1], "f4") && isEquals(com1Bytes[i + 10], "0a")) {
          System.arraycopy(data, i, com1Bytes, 0, 11);
          com1HasData = true; // 成功正确接收到下位机发回的数据
          break;
        }
      }
    }
  }

  @Override
  public void COM2DataArrived() {
    String val = SerialPortTools.readString(COM[1], "UTF-8");
    if(stepCounter == 5 || stepCounter == 9) {
      setTestValue(stepCounter, Double.parseDouble(new BigDecimal(val).toPlainString().substring(0, 6)));
      if(stepCounter == 9) {
        isFinished = true;
      }
    }
    else if(stepCounter > 5 && stepCounter < 9) {
      setTestValue(stepCounter, Double.parseDouble(new BigDecimal(val).toPlainString().substring(0, 6)) * 1000);
    }
  }

  @Override
  public void COM3DataArrived() {
  }

  @Override
  public void COM4DataArrived() {
  }

  @Override
  public void COM5DataArrived() {
  }

  @Override
  public void COM6DataArrived() {
  }

  @Override
  public void COM7DataArrived() {
  }

  @Override
  public void close() {
    int tem = JOptionPane.showConfirmDialog(null, "确认退出系统?", "询问", JOptionPane.YES_NO_OPTION);
    if (tem == JOptionPane.YES_OPTION) {
      frame.setVisible(false);
      MyLineChart.saveAsJPEG();
      ImplUtils.outExcl(LocalDate.now().toString());
      ImplUtils.outCompExcl(LocalDate.now().toString());
      System.exit(0);
    }
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  class Timer1Listener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      if (statuField.getText().equals("测试中...")) {
        timeCount += 20;
        timeField.setText(calculate(timeCount));
        progressValue++;
        if (progressValue == 100) {
          progressValue = 0;
        }
        progressBar.setValue(progressValue);
      } else {
        progressValue = 0;
        progressBar.setValue(progressValue);
        timeCount = 0;
      }
      //============================================
      if (isFinished) {
        allPass();
        isFinished = false;
        scanField.setText(""); // 清除产品编号，留待下次扫描
        scanField.requestFocusInWindow();
      }
    }
  }
  
//=============================================================
 class Timer2Listener implements ActionListener {
   @Override
   public void actionPerformed(ActionEvent e) {
     if (com1HasData) {
       if(isEquals(com1Bytes[9], "20")) { //下位机开始
         statuField.setText("测试中");
         scanField.setText(System.currentTimeMillis() + "");
         SerialPortTools.writeBytes(COM[0], Commands.START);
         com1HasData = false;
       }
       else if(isEquals(com1Bytes[9], "30")) { //下位机复位
         mcu_reset();
         com1HasData = false;
       }
       else if(isEquals(com1Bytes[9], "01")) { //步数发送回来
         stepCounter = com1Bytes[2];
         if(isEquals(com1Bytes[3], "10")) { //绝缘测试
           if(isEquals(com1Bytes[4], "10")) { //绝缘测试PASS
             table.setValueAt("ok", stepCounter, 5);
             table.setValueAt("PASS", stepCounter, 7);
           }
           else { //绝缘测试fail
             table.setValueAt("fail", stepCounter, 5);
             table.setValueAt("NG", stepCounter, 7);
             setResultNG();
           }
         }
         else if(isEquals(com1Bytes[3], "11")) { //电压降测试
           SerialPortTools.writeString(COM[1], "UTF-8", ":measure:voltage:DC?");
         }
         
       }
       
     }
   }
 }

}
