package com.SinbinZhou.JavaLab.Demo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Vector;

/**
 * @ClassName: MyJTable
 * @UserName: SinBin
 * @date: 2023-07-07 13:06
 * @Description:
 */
public class MyJTable extends JTable {
    MyCellRender myCellRender = new MyCellRender();
    JScrollPane jScrollPane = new JScrollPane(this);

    public MyJTable() {
        Vector<Vector<Object>> data = new Vector<>();
        Vector<Object> d1 = new Vector<>();
        d1.addElement(1);
        d1.addElement("周新斌");
        d1.addElement("软工212");
        d1.addElement("01");
        d1.addElement(1);
        d1.addElement(3);
        d1.addElement(2);
        d1.addElement(6);
        data.add(d1);

        MyTableMode myTableMode = MyTableMode.getMyTableMode(data);
        setModel(myTableMode);

        //设置表头
        JTableHeader tableHeader = getTableHeader();
        tableHeader.setBackground(Color.WHITE);
        tableHeader.setFont(new Font("楷体", Font.BOLD, 36));
        //设置表格体
        setFont(new Font("宋体", Font.PLAIN, 36));
        setForeground(Color.BLACK);
        setGridColor(Color.BLACK);
        setRowHeight(40);
        //多行选择
        getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //设置表格列渲染格式
        Vector<String> columns = MyTableMode.getColumns();
        for (int i = 0; i < columns.size(); i++) {
            TableColumn column = getColumn(columns.get(i));
            column.setCellRenderer(myCellRender);
        }
    }
}

//自定义JTable模式
class MyTableMode extends DefaultTableModel {
    //表头
    static Vector<String> columns = new Vector<>();
    static {
        columns.addElement("序号");
        columns.addElement("姓名");
        columns.addElement("班级");
        columns.addElement("学号");
        columns.addElement("语文");
        columns.addElement("数学");
        columns.addElement("英语");
        columns.addElement("总分");
    }

    private MyTableMode() {
        super(null, columns);
    }

    private static MyTableMode myTableMode = new MyTableMode();

    public static MyTableMode getMyTableMode(Vector<Vector<Object>> data) {
        myTableMode.setDataVector(data, columns);
        return myTableMode;
    }

    public static Vector<String> getColumns() {
        return columns;
    }

    //不可编辑
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}

//自定义渲染器
class MyCellRender extends DefaultTableCellRenderer {
    //每行每列显示之前默认调用
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //奇偶背景交替
        if (row % 2 == 0) {
            setBackground(Color.LIGHT_GRAY);
        } else {
            setBackground(Color.WHITE);
        }
        //水平居中
        setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
