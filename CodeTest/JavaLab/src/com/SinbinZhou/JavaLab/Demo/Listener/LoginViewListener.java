package com.SinbinZhou.JavaLab.Demo.Listener;
import com.SinbinZhou.JavaLab.Demo.Model.Account;
import com.SinbinZhou.JavaLab.Demo.Jdbc.AccountVerify;
import com.SinbinZhou.JavaLab.Demo.View.LoginView;
import com.SinbinZhou.JavaLab.Demo.View.MainView;

import javax.swing.*;
import java.awt.event.*;
/**
 * @ClassName: LoginListener
 * @UserName: SinBin
 * @date: 2023-07-06 15:02
 * @Description:
 * 登录界面两个按钮的监视器
 */
public class LoginViewListener implements ActionListener {
    LoginView loginView;
    public LoginViewListener(LoginView loginView) {
        this.loginView = loginView;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginView.getLoginButton() || e.getSource() == loginView.getPwdText()) {
            //从组件获取用户名和密码
            String usr = loginView.getUsrText().getText();
            char[] chars = loginView.getPwdText().getPassword();
            //验证是否为空
            if(usr == null || "".equals(usr.trim()) || chars == null) {
                JOptionPane.showMessageDialog(loginView, "请检查用户名和密码");
                return;
            }
            String pwd = new String(chars);
            //从数据库users表中查询用户
            Account account = new Account();
            account.setUsrName(usr);
            account.setPwd(pwd);
            boolean st = AccountVerify.accountVerify(account);
            if(st) {
                loginView.dispose();
                new MainView();
            } else {
                /*
                待优化
                默认 消息框大小 和 文字大小 过小
                 */
                JOptionPane.showMessageDialog(loginView, "请检查用户名和密码");
            }
        }
        if(e.getSource() == loginView.getResetButton()) {
            loginView.getUsrText().setText("");
            loginView.getPwdText().setText("");
        }
    }
}
