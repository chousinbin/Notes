package CETMS.Listener;

import CETMS.Controller.StudentManageController;
import CETMS.Model.MyTableModel;
import CETMS.Model.StudentModel;
import CETMS.View.MyJOptionPane;
import CETMS.View.MyJTable;
import CETMS.View.StudentManageView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManageListener implements ActionListener, ListSelectionListener {
    private StudentManageView studentManageView;
    private StudentModel studentModel;
    private StudentModel newStudentModel;
    private boolean preQuerySt;  //空关键字为false
    private String queryKey;

    public StudentManageListener(StudentManageView studentManageView) {
        this.studentManageView = studentManageView;
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        MyJTable myJTable = studentManageView.getMyJTable();
        int selectedRom = myJTable.getSelectedRow();

        if(selectedRom != -1)
        {
            //把选中行的数据提取到实体对象中
            studentModel = new StudentModel();
            studentModel.setStudentId((String)myJTable.getValueAt(selectedRom, 0));
            studentModel.setStudentName((String)myJTable.getValueAt(selectedRom, 1));
            studentModel.setStudentSex((String) myJTable.getValueAt(selectedRom, 2));
            studentModel.setStudentSchool((String) myJTable.getValueAt(selectedRom, 3));
            studentModel.setStudentAcademy((String) myJTable.getValueAt(selectedRom, 4));
            studentModel.setStudentMajor((String) myJTable.getValueAt(selectedRom, 5));
            studentModel.setStudentClass((String)myJTable.getValueAt(selectedRom, 6));
            //实体对象存放的选中的数据 显示到 修改框
            studentManageView.getStudentIdText().setText(studentModel.getStudentId());
            studentManageView.getStudentNameText().setText(studentModel.getStudentName());
            studentManageView.getStudentSexText().setText(studentModel.getStudentSex());
            studentManageView.getStudentSchoolText().setText(studentModel.getStudentSchool());
            studentManageView.getStudentAcademyText().setText(studentModel.getStudentAcademy());
            studentManageView.getStudentMajorText().setText(studentModel.getStudentMajor());
            studentManageView.getStudentClassText().setText(studentModel.getStudentClass());
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //查询数据库, 返回列表模型, 添加到面板
        if(e.getSource() == studentManageView.getStudentQueryButton()) {
            queryKey = studentManageView.getStudentQueryText().getText();
            if(queryKey == null) preQuerySt = false;
            else preQuerySt = true;
            MyTableModel myTableModel = StudentManageController.studentQuery
                    (new MyTableModel(), queryKey);
            studentManageView.getMyJTable().setMyTableModel(myTableModel);
        }
        //触发插入
        if(e.getSource() == studentManageView.getStudentAddButton()) {
            //接收插入信息
            String studentId = studentManageView.getStudentIdText().getText();
            String studentName = studentManageView.getStudentNameText().getText();
            String studentSex = studentManageView.getStudentSexText().getText();
            String studentSchool = studentManageView.getStudentSchoolText().getText();
            String studentAcademy = studentManageView.getStudentAcademyText().getText();
            String studentMajor = studentManageView.getStudentMajorText().getText();
            String studentClass = studentManageView.getStudentClassText().getText();
            //判断是否未录入完整
            if(studentId == null || "".equals(studentId) ||
                    studentName == null || "".equals(studentName) ||
                    studentSex == null || "".equals(studentSex) ||
                    studentSchool == null || "".equals(studentSchool) ||
                    studentAcademy == null || "".equals(studentAcademy) ||
                    studentMajor == null || "".equals(studentMajor) ||
                    studentClass == null || "".equals(studentClass)
                ) {
                MyJOptionPane.showMessageDialog(null,
                        "信息不完整", "提示");
                return;
            }
            //把数据传入学生实体对象
            studentModel.setStudentId(studentId);
            studentModel.setStudentName(studentName);
            studentModel.setStudentSex(studentSex);
            studentModel.setStudentSchool(studentSchool);
            studentModel.setStudentAcademy(studentAcademy);
            studentModel.setStudentMajor(studentMajor);
            studentModel.setStudentClass(studentClass);
            //向数据库插入
            boolean st = StudentManageController.studentAdd(studentModel);
            if(!st) {
                MyJOptionPane.showMessageDialog(null,
                        "添加失败", "提示");
            } else {
                MyJOptionPane.showMessageDialog(null,
                        "添加成功", "提示");
                cleanInformation();
                //更新查询界面
                MyTableModel myTableModel = StudentManageController.studentQuery
                        (new MyTableModel(), null);
                studentManageView.getMyJTable().setMyTableModel(myTableModel);
            }
        }
        // 删除学生
        if(e.getSource() == studentManageView.getStudentDeleteButton()) {
            MyJTable myJTable = studentManageView.getMyJTable();
            MyTableModel myTableModel = new MyTableModel();
            //选中行的索引
            int selectedRom = myJTable.getSelectedRow();
            if(selectedRom == -1) return;
            //存放行数据的数组
            Object[] rowDate = new Object[myJTable.getColumnCount()];
            //提取选中行的数据
            for (int i = 0; i < myJTable.getColumnCount(); i++) {
                rowDate[i] = myJTable.getValueAt(selectedRom, i);
            }
            //得到要删除的学生id
            String studentId = (String)rowDate[0];
            //执行删除操作
            StudentManageController.studentDelete(studentId);
            //回显的查询结果要和上次查询类型一样
            if(!preQuerySt) {
                myTableModel = StudentManageController.studentQuery(new MyTableModel(), null);
            } else {
                myTableModel = StudentManageController.studentQuery(new MyTableModel(), queryKey);
            }
            //删除完重新回显查询结果
            studentManageView.getMyJTable().setMyTableModel(myTableModel);
            //清空输入框
            cleanInformation();
        }

        //更新按钮被触发
        if(e.getSource() == studentManageView.getStudentUpdateButton()) {
            //接收新的信息
            String studentId = studentManageView.getStudentIdText().getText();
            String studentName = studentManageView.getStudentNameText().getText();
            String studentSex = studentManageView.getStudentSexText().getText();
            String studentSchool = studentManageView.getStudentSchoolText().getText();
            String studentAcademy = studentManageView.getStudentAcademyText().getText();
            String studentMajor = studentManageView.getStudentMajorText().getText();
            String studentClass = studentManageView.getStudentClassText().getText();
            //判断是否未录入完整
            if(studentId == null || "".equals(studentId) ||
                    studentName == null || "".equals(studentName) ||
                    studentSex == null || "".equals(studentSex) ||
                    studentSchool == null || "".equals(studentSchool) ||
                    studentAcademy == null || "".equals(studentAcademy) ||
                    studentMajor == null || "".equals(studentMajor) ||
                    studentClass == null || "".equals(studentClass)
            ) {
                MyJOptionPane.showMessageDialog(null,
                        "商品信息不完整", "提示");
                return;
            }
            // 把数据传入新的学生对象
            newStudentModel = new StudentModel();
            newStudentModel.setStudentId(studentId);
            newStudentModel.setStudentName(studentName);
            newStudentModel.setStudentSex(studentSex);
            newStudentModel.setStudentSchool(studentSchool);
            newStudentModel.setStudentAcademy(studentAcademy);
            newStudentModel.setStudentMajor(studentMajor);
            newStudentModel.setStudentClass(studentClass);

            if(!studentModel.getStudentId().equals(newStudentModel.getStudentId())) {
                MyJOptionPane.showMessageDialog(null,
                        "不能修改学号", "提示");
                return;
            }
            // 根据id和更新的学生实体进行数据库记录更新
            boolean st = StudentManageController.studentUpdate(newStudentModel);
            if(!st) {
                MyJOptionPane.showMessageDialog(null,
                        "修改失败", "提示");
            } else {
                MyJOptionPane.showMessageDialog(null,
                        "修改成功", "提示");
                cleanInformation();
                // 更新查询界面
                MyTableModel myTableModel = StudentManageController.studentQuery
                        (new MyTableModel(), null);
                studentManageView.getMyJTable().setMyTableModel(myTableModel);
            }
        }
    }

    public void cleanInformation() {
        studentManageView.getStudentIdText().setText("");
        studentManageView.getStudentNameText().setText("");
        studentManageView.getStudentSexText().setText("");
        studentManageView.getStudentSchoolText().setText("");
        studentManageView.getStudentAcademyText().setText("");
        studentManageView.getStudentMajorText().setText("");
        studentManageView.getStudentClassText().setText("");
    }
}
