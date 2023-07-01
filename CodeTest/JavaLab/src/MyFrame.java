import java.awt.*;
import javax.swing.*;


/**
 * @ClassName: MyFrame
 * @UserName: SinBin
 * @date: 2023-06-29 18:58
 * @Description:
 */
public class MyFrame extends JFrame {
    MyFrame() {
        init();
        setTitle("学生管理系统");
        setBounds(940, 600, 1000, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init() {
        setLayout(new FlowLayout());
    }
}
