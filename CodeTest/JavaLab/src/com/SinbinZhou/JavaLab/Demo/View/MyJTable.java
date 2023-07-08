package com.SinbinZhou.JavaLab.Demo.View;

import com.SinbinZhou.JavaLab.Demo.Model.TableModel;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Vector;

/**
 * @ClassName: MyJTable
 * @UserName: SinBin
 * @date: 2023-07-08 23:21
 * @Description:
 */
public class MyJTable extends JTable {
    public MyJTable(TableModel tableModel) {
        //设置model

        setModel(tableModel);
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
        Vector<Object> columns = tableModel.getColumns();
        for (int i = 0; i < columns.size(); i++) {
            TableColumn column = getColumn(columns.get(i));
            column.setCellRenderer(new MyCellRender());
        }
    }
}
