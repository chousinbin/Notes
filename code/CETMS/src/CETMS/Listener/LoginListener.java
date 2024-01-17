package CETMS.Listener;

import CETMS.Controller.AdminLoginController;
import CETMS.Controller.StudentLoginController;
import CETMS.Controller.TeacherLoginController;
import CETMS.Model.AdminModel;
import CETMS.Model.CurrentUser;
import CETMS.Model.StudentModel;
import CETMS.Model.TeacherModel;
import CETMS.View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener {
    private LoginView loginView;

    public LoginListener(LoginView loginView) {
        this.loginView = loginView;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginView.getLoginButton() || e.getSource() == loginView.getPwdText()) {
            //从组件获取用户名和密码
            String usr = loginView.getUsrText().getText();
            char[] chars = loginView.getPwdText().getPassword();
            String pwd = new String(chars);
            //验证是否为空
            if(usr == null || "".equals(usr.trim()) || chars == null) {
                MyJOptionPane.showMessageDialog(null, "请检查用户名和密码", "提示");
                return;
            }
            //选择管理员
            if(loginView.getAdminRadioButton().isSelected()) {
                AdminModel accountModel = new AdminModel();
                accountModel.setAdminId(usr);
                accountModel.setAdminPwd(pwd);
                CurrentUser.setUserId(usr);
                CurrentUser.setUserPwd(pwd);
                CurrentUser.setUserType("admin");
                boolean st = AdminLoginController.accountVerify(accountModel);
                if(st) {
                    loginView.dispose();
                    new AdminView();
                } else {
                    MyJOptionPane.showMessageDialog(null,
                            "请检查用户名和密码", "提示");
                }
            }
            //选择教师
            if(loginView.getTeacherRadioButton().isSelected()) {
                TeacherModel accountModel = new TeacherModel();
                accountModel.setTeacherId(usr);
                accountModel.setTeacherPwd(pwd);
                CurrentUser.setUserId(usr);
                CurrentUser.setUserPwd(pwd);
                CurrentUser.setUserType("teacher");
                boolean st = TeacherLoginController.accountVerify(accountModel);
                if(st) {
                    loginView.dispose();
                    new TeacherView();
                } else {
                    MyJOptionPane.showMessageDialog(null,
                            "请检查用户名和密码", "提示");
                }
            }
            //选择学生
            if(loginView.getStudentRadioButton().isSelected()) {
                StudentModel accountModel = new StudentModel();
                accountModel.setStudentId(usr);
                accountModel.setStudentPwd(pwd);
                CurrentUser.setUserId(usr);
                CurrentUser.setUserPwd(pwd);
                CurrentUser.setUserType("student");
                boolean st = StudentLoginController.accountVerify(accountModel);
                if(st) {
                    loginView.dispose();
                    new StudentView();
                } else {
                    MyJOptionPane.showMessageDialog(null,
                            "请检查用户名和密码", "提示");
                }
            }
        }
        //清空文本框
        if(e.getSource() == loginView.getResetButton()) {
            loginView.getUsrText().setText("");
            loginView.getPwdText().setText("");
        }
    }
}