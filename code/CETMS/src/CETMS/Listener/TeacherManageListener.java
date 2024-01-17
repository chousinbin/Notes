package CETMS.Listener;

import CETMS.Controller.TeacherManageController;
import CETMS.Model.MyTableModel;
import CETMS.Model.TeacherModel;
import CETMS.View.MyJOptionPane;
import CETMS.View.MyJTable;
import CETMS.View.TeacherManageView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherManageListener implements ActionListener, ListSelectionListener {
    private TeacherManageView teacherManageView;
    private TeacherModel teacherModel;
    private TeacherModel newTeacherModel;
    private boolean preQuerySt;  // 空关键字为false
    private String queryKey;

    public TeacherManageListener(TeacherManageView teacherManageView) {
        this.teacherManageView = teacherManageView;
    }
    // 选择行数据触发
    @Override
    public void valueChanged(ListSelectionEvent e) {
        MyJTable myJTable = teacherManageView.getMyJTable();
        int selectedRow = myJTable.getSelectedRow();

        if (selectedRow != -1) {
            // 提取选中行数据到实体对象中
            teacherModel = new TeacherModel();
            teacherModel.setTeacherId((String) myJTable.getValueAt
                    (selectedRow, 0));
            teacherModel.setTeacherName((String) myJTable.getValueAt
                    (selectedRow, 1));
            teacherModel.setTeacherSex((String) myJTable.getValueAt
                    (selectedRow, 2));
            teacherModel.setTeacherPhone((String) myJTable.getValueAt
                    (selectedRow, 3));
            // 显示选中的数据到更新框
            teacherManageView.getTeacherIdText().setText
                    (teacherModel.getTeacherId());
            teacherManageView.getTeacherNameText().setText
                    (teacherModel.getTeacherName());
            teacherManageView.getTeacherSexText().setText
                    (teacherModel.getTeacherSex());
            teacherManageView.getTeacherPhoneText().setText
                    (teacherModel.getTeacherPhone());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 教师查询
        if (e.getSource() == teacherManageView.getTeacherQueryButton()) {
            queryKey = teacherManageView.getTeacherQueryText().getText();
            if (queryKey == null || queryKey.equals("")) preQuerySt = false;
            else preQuerySt = true;
            MyTableModel myTableModel = TeacherManageController.teacherQuery
                    (new MyTableModel(), queryKey);
            teacherManageView.getMyJTable().setMyTableModel(myTableModel);
        }

        // 教师添加
        if (e.getSource() == teacherManageView.getTeacherAddButton()) {
            // 接收插入信息
            String teacherId = teacherManageView.getTeacherIdText().getText();
            String teacherName = teacherManageView.getTeacherNameText().getText();
            String teacherSex = teacherManageView.getTeacherSexText().getText();
            String teacherPhone = teacherManageView.getTeacherPhoneText().
                    getText();

            // 判断是否未录入完整
            if (teacherId == null || "".equals(teacherId) ||
                    teacherName == null || "".equals(teacherName) ||
                    teacherSex == null || "".equals(teacherSex) ||
                    teacherPhone == null || "".equals(teacherPhone)) {
                MyJOptionPane.showMessageDialog(null,
                        "教师信息不完整",
                        "提示");
                return;
            }

            // 把数据传入教师实体对象
            teacherModel = new TeacherModel();
            teacherModel.setTeacherId(teacherId);
            teacherModel.setTeacherName(teacherName);
            teacherModel.setTeacherSex(teacherSex);
            teacherModel.setTeacherPhone(teacherPhone);

            // 向数据库插入
            boolean st = TeacherManageController.teacherAdd(teacherModel);
            if (!st) {
                MyJOptionPane.showMessageDialog(null,
                        "添加失败",
                        "提示");
            } else {
                MyJOptionPane.showMessageDialog(null,
                        "添加成功",
                        "提示");
                cleanInformation();  // 入库成功，清除文本框信息
                // 更新查询界面
                MyTableModel myTableModel = TeacherManageController.teacherQuery
                        (new MyTableModel(), null);
                teacherManageView.getMyJTable().setMyTableModel(myTableModel);
            }
        }

        // 删除按钮被点击
        if (e.getSource() == teacherManageView.getTeacherDeleteButton()) {
            MyJTable myJTable = teacherManageView.getMyJTable();
            MyTableModel myTableModel;
            // 选中行的索引
            int selectedRow = myJTable.getSelectedRow();
            // 未选中则退出
            if (selectedRow == -1) return;
            // 存放行数据的数组
            Object[] rowData = new Object[myJTable.getColumnCount()];
            // 提取选中行的数据
            for (int i = 0; i < myJTable.getColumnCount(); i++) {
                rowData[i] = myJTable.getValueAt(selectedRow, i);
            }
            // 得到要删除的教师工号
            String teacherId = (String) rowData[0];
            // 执行删除操作
            TeacherManageController.teacherDelete(teacherId);
            // 回显的查询结果要和上次查询类型一样
            if (!preQuerySt) {
                myTableModel = TeacherManageController.teacherQuery
                        (new MyTableModel(), null);
            } else {
                myTableModel = TeacherManageController.teacherQuery
                        (new MyTableModel(), queryKey);
            }
            // 删除完重新回显查询结果
            teacherManageView.getMyJTable().setMyTableModel(myTableModel);
            // 清空输入框
            cleanInformation();
        }

        // 更新按钮被触发
        if (e.getSource() == teacherManageView.getTeacherUpdateButton()) {
            // 接收更新信息
            String teacherId = teacherManageView.getTeacherIdText().getText();
            String teacherName = teacherManageView.getTeacherNameText().getText();
            String teacherSex = teacherManageView.getTeacherSexText().getText();
            String teacherPhone = teacherManageView.getTeacherPhoneText().getText();

            // 判断是否未录入完整
            if (teacherId == null || "".equals(teacherId) ||
                    teacherName == null || "".equals(teacherName) ||
                    teacherSex == null || "".equals(teacherSex) ||
                    teacherPhone == null || "".equals(teacherPhone)) {
                MyJOptionPane.showMessageDialog(null,
                        "教师信息不完整",
                        "提示");
                return;
            }

            // 把更新的数据传入新的教师实体对象
            newTeacherModel = new TeacherModel();
            newTeacherModel.setTeacherId(teacherId);
            newTeacherModel.setTeacherName(teacherName);
            newTeacherModel.setTeacherSex(teacherSex);
            newTeacherModel.setTeacherPhone(teacherPhone);

            if (!teacherModel.getTeacherId().equals(newTeacherModel.getTeacherId())) {
                MyJOptionPane.showMessageDialog(null,
                        "不能修改教师工号",
                        "提示");
                return;
            }
            // 根据教师工号和更新的实体进行数据库记录更新
            boolean st = TeacherManageController.teacherUpdate(newTeacherModel);
            if (!st) {
                MyJOptionPane.showMessageDialog(null,
                        "更新失败", "提示");
            } else {
                MyJOptionPane.showMessageDialog(null,
                        "更新成功", "提示");
                cleanInformation();  // 更新成功，清除文本框信息
                // 更新查询界面
                MyTableModel myTableModel = TeacherManageController.teacherQuery
                        (new MyTableModel(), null);
                teacherManageView.getMyJTable().setMyTableModel(myTableModel);
            }
        }
    }

    private void cleanInformation() {
        teacherManageView.getTeacherIdText().setText("");
        teacherManageView.getTeacherNameText().setText("");
        teacherManageView.getTeacherSexText().setText("");
        teacherManageView.getTeacherPhoneText().setText("");
    }
}