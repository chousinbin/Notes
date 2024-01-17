package CETMS.Listener;

import CETMS.View.LoginView;
import CETMS.View.StudentView;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TempListener implements ChangeListener {
    private StudentView studentView;

    public TempListener(StudentView studentView) {
        this.studentView = studentView;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // 处理选项卡切换的逻辑
        int selectedIndex = studentView.getTabbedPane().getSelectedIndex();
        String selectedTabTitle = studentView.getTabbedPane().getTitleAt(selectedIndex);

        if(selectedTabTitle == "切换账号") {
            studentView.dispose();
            new LoginView();
        }
    }
}
