import java.awt.*;
import javax.swing.*; 
import java.awt.event.*;

class E {
    public static void main(String args[]){
        MyFrame f=new MyFrame();
    }
} 

public class MyFrame extends JFrame implements ActionListener {

    private JTextField textField1, textField2, resultField;
    private JButton addButton;

    MyFrame(){
        init();

        setTitle("加法计算器");
        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }  

     void init(){
        Container container = getContentPane();
        FlowLayout layout = new FlowLayout();
        container.setLayout(layout);

        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false); // 禁止编辑
        addButton = new JButton("加法计算");

        container.add(textField1);
        container.add(new JLabel("+"));
        container.add(textField2);
        container.add(addButton);
        container.add(new JLabel("="));
        container.add(resultField);

        addButton.addActionListener(this);
     }

    public void actionPerformed(ActionEvent e) {
        int num1 = Integer.parseInt(textField1.getText());
        int num2 = Integer.parseInt(textField2.getText());
        int sum = num1 + num2;

        resultField.setText(Integer.toString(sum));
    }
}
