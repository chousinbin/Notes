package CETMS.Listener;

import CETMS.Controller.PwdUpdateController;
import CETMS.Model.CurrentUser;
import CETMS.View.MyJOptionPane;
import CETMS.View.PwdUpdateView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PwdUpdateListener implements ActionListener {
    private PwdUpdateView pwdUpdateView;

    public PwdUpdateListener(PwdUpdateView pwdUpdateView) {
        this.pwdUpdateView = pwdUpdateView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pwdUpdateView.getResetButton()) {
            reset();
        }

        if(e.getSource() == pwdUpdateView.getSubmitButton()) {
            char[] oldPwdChar = pwdUpdateView.getOldPwdText().getPassword();
            char[] newPwdChar = pwdUpdateView.getNewPwdText().getPassword();
            String oldPwd = new String(oldPwdChar);
            String newPwd = new String(newPwdChar);
            if(newPwd.equals("") || newPwd == null) {
                MyJOptionPane.showMessageDialog(
                        null,
                        "新密码不能为空",
                        "提示");
                reset();
                return;
            }
            // 验证旧密码
            if(!oldPwd.equals(CurrentUser.getUserPwd())) {
                MyJOptionPane.showMessageDialog(
                        null,
                        "旧密码不正确",
                        "提示");
                reset();
                return;
            }

            String userId = CurrentUser.getUserId();
            boolean st = PwdUpdateController.pwdUpdate(
                    CurrentUser.getUserType(), CurrentUser.getUserId(), newPwd);
            if(st) {
                // 更新当前用户的密码
                CurrentUser.setUserPwd(newPwd);
                MyJOptionPane.showMessageDialog(
                        null,
                        "新密码为: " + newPwd + " 请牢记",
                        "提示");
            } else {
                MyJOptionPane.showMessageDialog(
                        null,
                        "密码更新失败",
                        "提示");
            }
            reset();
        }
    }

    private void reset() {
        pwdUpdateView.getOldPwdText().setText("");
        pwdUpdateView.getNewPwdText().setText("");
    }
}