import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
 * 程序功能：
 * 实现一个简单的加法计算器。
 * 1. 在窗口或面板中添加多个组件，并进行合理的布局。
 * 2. 在确定按钮上添加ActionListener动作监视器，
 * 将两个文本框中输入的数据相加，在第三个文本框中显示答案。
 */

class E {
    public static void main(String args[]){
        MyFrame f = new MyFrame();
    }
}

public class MyFrame extends JFrame implements ActionListener {
    MyFrame(){
       init();
        //设置窗口的标题

        //设置窗口的大小

        //设置窗口的可见性 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 

    void  init(){

    }

    public void actionPerformed (ActionEvent e) {  /* 处理事件,窗口本身作监视器*/

    }
}