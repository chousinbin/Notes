package CETMS.View;

import CETMS.Listener.PwdUpdateListener;

import javax.swing.*;
import java.awt.*;

public class PwdUpdateView extends JPanel {
    private JLabel oldPwdLabel;
    private JLabel newPwdLabel;
    private JPasswordField oldPwdText;
    private JPasswordField newPwdText;
    private JButton resetButton;
    private JButton submitButton;
    private Font font;
    private Dimension dimension;
    private PwdUpdateListener pwdUpdateListener;

    public PwdUpdateView() {
        setLayout(new FlowLayout());
        createObject();
        addComponent();
        setSizeFont();
        resetButton.addActionListener(pwdUpdateListener);
        submitButton.addActionListener(pwdUpdateListener);
    }

    private void setSizeFont() {
        oldPwdLabel.setFont(font);
        newPwdLabel.setFont(font);
        resetButton.setFont(font);
        submitButton.setFont(font);
        oldPwdText.setFont(font);
        newPwdText.setFont(font);
        oldPwdText.setEchoChar('*');
        newPwdText.setEchoChar('*');
        oldPwdText.setPreferredSize(dimension);
        newPwdText.setPreferredSize(dimension);
        resetButton.setFont(font);
        submitButton.setFont(font);
    }

    private void addComponent() {
        add(oldPwdLabel);
        add(oldPwdText);
        add(newPwdLabel);
        add(newPwdText);
        add(submitButton);
        add(resetButton);
    }

    private void createObject() {
        oldPwdLabel = new JLabel("旧密码");
        newPwdLabel = new JLabel("新密码");
        oldPwdText = new JPasswordField();
        newPwdText = new JPasswordField();
        resetButton = new JButton("重置");
        submitButton = new JButton("提交");
        dimension = new Dimension(500, 50);
        font = new Font("宋体", Font.PLAIN, 36);
        pwdUpdateListener = new PwdUpdateListener(this);
    }

    public JPasswordField getOldPwdText() {
        return oldPwdText;
    }

    public void setOldPwdText(JPasswordField oldPwdText) {
        this.oldPwdText = oldPwdText;
    }

    public JPasswordField getNewPwdText() {
        return newPwdText;
    }

    public void setNewPwdText(JPasswordField newPwdText) {
        this.newPwdText = newPwdText;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public void setResetButton(JButton resetButton) {
        this.resetButton = resetButton;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }
}
