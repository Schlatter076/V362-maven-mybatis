package org.loyer.dao.utils;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import org.loyer.beans.V362;

public class DataTools {
  
  /**
   * 创建JTable方法
   * 
   * @return
   */
  private static JTable getTestTable() {
    Vector<Object> rowNum = null, colNum = null;
    // 创建列对象
    colNum = new Vector<>();
    colNum.add("");
    colNum.add("序号");
    colNum.add("测试项目");
    colNum.add("上限");
    colNum.add("下限");
    colNum.add("测试值");
    colNum.add("单位");
    colNum.add("测试结果");
    colNum.add("备注");

    // 创建行对象
    rowNum = new Vector<>();
    List<V362> tableList = ImplUtils.getV362Impl().getAll();
    for (V362 rd : tableList) {
      Vector<String> vt = new Vector<>();
      vt.add("");
      vt.add(rd.getNumber());
      vt.add(rd.getItem());
      vt.add(rd.getUpper());
      vt.add(rd.getLower());
      vt.add(rd.getValue());
      vt.add(rd.getUnit());
      vt.add(rd.getResult());

      rowNum.add(vt);
    }

    DefaultTableModel model = new DefaultTableModel(rowNum, colNum) {
      private static final long serialVersionUID = 1L;

      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    JTable table = new JTable(model);
    return table;
  }

  /**
   * 提供设置JTable方法
   * 
   * @param tableName
   * @return
   */
  public static JTable completedTable() {

    JTable table = getTestTable();
    DefaultTableCellRenderer r = new DefaultTableCellRenderer(); // 设置
    r.setHorizontalAlignment(JLabel.CENTER); // 单元格内容居中
    // table.setOpaque(false); //设置表透明
    JTableHeader jTableHeader = table.getTableHeader(); // 获取表头
    // 设置表头名称字体样式
    jTableHeader.setFont(new Font("宋体", Font.PLAIN, 14));
    // 设置表头名称字体颜色
    jTableHeader.setForeground(Color.BLACK);
    jTableHeader.setDefaultRenderer(r);

    // 表头不可拖动
    jTableHeader.setReorderingAllowed(false);
    // 列大小不可改变
    jTableHeader.setResizingAllowed(false);

    // 设置列宽
    TableColumn colNull = table.getColumnModel().getColumn(0);
    TableColumn colTestitem = table.getColumnModel().getColumn(2);
    TableColumn colMaxvalue = table.getColumnModel().getColumn(3);
    TableColumn colMinvalue = table.getColumnModel().getColumn(4);
    TableColumn colTestvalue = table.getColumnModel().getColumn(5);
    TableColumn colTestResult = table.getColumnModel().getColumn(7);
    colNull.setPreferredWidth(20);
    colTestitem.setPreferredWidth(150);
    colMaxvalue.setPreferredWidth(120);
    colMinvalue.setPreferredWidth(120);
    colTestvalue.setPreferredWidth(120);
    colTestResult.setPreferredWidth(120);

    // table.setEnabled(false); // 内容不可编辑

    table.setDefaultRenderer(Object.class, r); // 居中显示

    table.setRowHeight(30); // 设置行高
    // 增加一行空白行
    // AbstractTableModel tableModel = (AbstractTableModel) table.getModel();
    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
    tableModel.addRow(new Object[] { "*", "", "", "", "", "", "", "", "", "", "", "", "" });
    table.setGridColor(new Color(245, 245, 245)); // 设置网格颜色
    table.setForeground(Color.BLACK); // 设置文字颜色
    table.setBackground(new Color(245, 245, 245));
    table.setFont(new Font("宋体", Font.PLAIN, 13));
    //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 关闭表格列自动调整

    return table;
  }

}
