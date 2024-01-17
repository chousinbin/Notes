package CETMS.Listener;

import CETMS.Controller.GradeManageController;
import CETMS.Model.CurrentUser;
import CETMS.Model.GradeModel;
import CETMS.Model.MyTableModel;
import CETMS.View.GradeManageView;
import CETMS.View.MyJOptionPane;
import CETMS.View.MyJTable;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class GradeManageListener implements ActionListener, ListSelectionListener {
    private GradeManageView gradeManageView;
    private GradeModel gradeModel;
    private boolean preQuerySt;  //空关键字为false
    private String queryKey;

    public GradeManageListener(GradeManageView gradeManageView) {
        this.gradeManageView = gradeManageView;
    }

    public void valueChanged(ListSelectionEvent e) {
        MyJTable myJTable = gradeManageView.getMyJTable();
        int selectedRom = myJTable.getSelectedRow();

        if(selectedRom != -1)
        {
            //把选中行的数据提取到实体对象中
            gradeModel = new GradeModel();
            gradeModel.setGradeId((Integer) myJTable.getValueAt
                    (selectedRom, 0));
            gradeModel.setTestDate((String)myJTable.getValueAt
                    (selectedRom, 1));
            gradeModel.setTestType((String) myJTable.getValueAt
                    (selectedRom, 2));
            gradeModel.setStudentId((String) myJTable.getValueAt
                    (selectedRom, 7));
            gradeModel.setListeningGrade(((BigDecimal) myJTable.getValueAt
                    (selectedRom, 9)).floatValue());
            gradeModel.setReadingGrade(((BigDecimal) myJTable.getValueAt
                    (selectedRom, 10)).floatValue());
            gradeModel.setWritingGrade(((BigDecimal) myJTable.getValueAt
                    (selectedRom, 11)).floatValue());
            gradeModel.setSumGrade(((BigDecimal) myJTable.getValueAt
                    (selectedRom, 12)).floatValue());

            //实体对象存放的选中的数据 显示到 修改框
            gradeManageView.getStudentIdText().setText(gradeModel.getStudentId());
            gradeManageView.getListeningGradeText().setText(String.valueOf(gradeModel.getListeningGrade()));
            gradeManageView.getReadingGradeText().setText(String.valueOf(gradeModel.getReadingGrade()));
            gradeManageView.getWritingGradeText().setText(String.valueOf(gradeModel.getWritingGrade()));
        }
    }

    public void actionPerformed(ActionEvent e) {
        //查询数据库, 返回列表模型, 添加到面板
        if(e.getSource() == gradeManageView.getGradeQueryButton()) {
            queryKey = gradeManageView.getGradeQueryText().getText();
            if(queryKey == null) preQuerySt = false;
            else preQuerySt = true;
            MyTableModel myTableModel = GradeManageController.gradeQuery
                    (new MyTableModel(), queryKey);
            gradeManageView.getMyJTable().setFont
                    (new Font("宋体", Font.PLAIN, 24));
            gradeManageView.getMyJTable().setMyTableModel(myTableModel);
        }

        //触发插入
        if(e.getSource() == gradeManageView.getGradeAddButton()) {
            //接收插入信息
            String testYear = gradeManageView.getTestYearComboBox().
                    getSelectedItem().toString();
            String testMonth = gradeManageView.getTestMonthComboBox().
                    getSelectedItem().toString();
            String testDate = testYear + "年" + testMonth + "月";
            String testType = gradeManageView.getTestTypeComboBox().
                    getSelectedItem().toString();
            String studentId = gradeManageView.getStudentIdText().getText();
            String teacherID = CurrentUser.getUserId();
            float listeningGrade;
            float readingGrade;
            float writingGrade;
            float sumGrade;
            try {
                listeningGrade = Float.parseFloat
                        (gradeManageView.getListeningGradeText().getText());
                readingGrade = Float.parseFloat
                        (gradeManageView.getReadingGradeText().getText());
                writingGrade = Float.parseFloat
                        (gradeManageView.getWritingGradeText().getText());
                sumGrade = listeningGrade + readingGrade + writingGrade;
            } catch (NumberFormatException ee) {
                ee.printStackTrace();
                MyJOptionPane.showMessageDialog(null,
                        "成绩只能是小数", "提示");
                return;
            }
            //判断是否未录入完整
            if(studentId == null || "".equals(studentId) ||
                    testYear == null || "".equals(testYear) ||
                    testMonth == null || "".equals(testMonth) ||
                    testType == null || "".equals(testType)
            ) {
                MyJOptionPane.showMessageDialog(null,
                        "成绩信息不完整", "提示");
                return;
            }
            //把数据传入成绩实体对象
            gradeModel.setTestDate(testDate);
            gradeModel.setTestType(testType);
            gradeModel.setStudentId(studentId);
            gradeModel.setListeningGrade(listeningGrade);
            gradeModel.setReadingGrade(readingGrade);
            gradeModel.setWritingGrade(writingGrade);
            gradeModel.setSumGrade(sumGrade);
            gradeModel.setTeacherId(teacherID);
            //向数据库插入
            boolean st = GradeManageController.gradeAdd(gradeModel);
            if(st == false) {
                MyJOptionPane.showMessageDialog(null,
                        "添加失败", "提示");
            } else {
                MyJOptionPane.showMessageDialog(null,
                        "添加成功", "提示");
                cleanInformation();
                //更新查询界面
                MyTableModel myTableModel = GradeManageController.gradeQuery
                        (new MyTableModel(), null);
                gradeManageView.getMyJTable().setMyTableModel(myTableModel);
            }
        }
        // 删除成绩
        if(e.getSource() == gradeManageView.getGradeDeleteButton()) {
            MyJTable myJTable = gradeManageView.getMyJTable();
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
            //得到要删除的成绩id
            int gradeId = (int)rowDate[0];
            //执行删除操作
            GradeManageController.gradeDelete(gradeId);
            //回显的查询结果要和上次查询类型一样
            if(preQuerySt == false) {
                myTableModel = GradeManageController.gradeQuery(new MyTableModel(),
                        null);
            } else {
                myTableModel = GradeManageController.gradeQuery(new MyTableModel(),
                        queryKey);
            }
            //删除完重新回显查询结果
            gradeManageView.getMyJTable().setMyTableModel(myTableModel);
            //清空输入框
            cleanInformation();
        }

        //更新按钮被触发
        if(e.getSource() == gradeManageView.getGradeUpdateButton()) {
            //接收新信息
            String testYear = gradeManageView.getTestYearComboBox().getSelectedItem().toString();
            String testMonth = gradeManageView.getTestMonthComboBox().getSelectedItem().toString();
            String testDate = testYear + "年" + testMonth + "月";
            String testType = gradeManageView.getTestTypeComboBox().getSelectedItem().toString();
            String studentId = gradeManageView.getStudentIdText().getText();
            String teacherId = CurrentUser.getUserId();
            float listeningGrade;
            float readingGrade;
            float writingGrade;
            float sumGrade;
            // 类型转换
            try {
                listeningGrade = Float.parseFloat
                        (gradeManageView.getListeningGradeText().getText());
                readingGrade = Float.parseFloat
                        (gradeManageView.getReadingGradeText().getText());
                writingGrade = Float.parseFloat
                        (gradeManageView.getWritingGradeText().getText());
                sumGrade = listeningGrade + readingGrade + writingGrade;
            } catch (NumberFormatException ee) {
                ee.printStackTrace();
                MyJOptionPane.showMessageDialog(null,
                        "成绩只能是小数", "提示");
                return;
            }
            //判断是否未录入完整
            if(studentId == null || "".equals(studentId) ||
                    testYear == null || "".equals(testYear) ||
                    testMonth == null || "".equals(testMonth) ||
                    testType == null || "".equals(testType)
            ) {
                MyJOptionPane.showMessageDialog(null,
                        "成绩信息不完整", "提示");
                return;
            }
            //把数据传入成绩实体对象
            gradeModel.setTestDate(testDate);
            gradeModel.setTestType(testType);
            gradeModel.setStudentId(studentId);
            gradeModel.setTeacherId(teacherId);
            gradeModel.setListeningGrade(listeningGrade);
            gradeModel.setReadingGrade(readingGrade);
            gradeModel.setWritingGrade(writingGrade);
            gradeModel.setSumGrade(sumGrade);

            //根据id和更新的实体进行数据库记录更新
            boolean st = GradeManageController.gradeUpdate(gradeModel);
            if(st == false) {
                MyJOptionPane.showMessageDialog(null,
                        "修改失败", "提示");
            } else {
                MyJOptionPane.showMessageDialog(null,
                        "修改成功", "提示");
                cleanInformation();
                //更新查询界面
                MyTableModel myTableModel = GradeManageController.gradeQuery(new MyTableModel(), null);
                gradeManageView.getMyJTable().setMyTableModel(myTableModel);
            }
        }
    }
    public void cleanInformation() {
        gradeManageView.getStudentIdText().setText("");
        gradeManageView.getListeningGradeText().setText("");
        gradeManageView.getReadingGradeText().setText("");
        gradeManageView.getWritingGradeText().setText("");
    }
}
