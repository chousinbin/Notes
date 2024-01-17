package CETMS.Listener;

import CETMS.Controller.GradeQueryController;
import CETMS.Model.CurrentUser;
import CETMS.Model.MyTableModel;
import CETMS.View.GradeQueryView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeQueryListener implements ActionListener {
    private GradeQueryView gradeQueryView;

    public GradeQueryListener(GradeQueryView gradeQueryView) {
        this.gradeQueryView = gradeQueryView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == gradeQueryView.getQueryButton()) {
            String studentId = CurrentUser.getUserId();
            MyTableModel myTableModel = GradeQueryController.gradeQuery(studentId);
            gradeQueryView.getMyTable().setRowSelectionAllowed(false);
            gradeQueryView.getMyTable().setMyTableModel(myTableModel);
        }
    }
}
