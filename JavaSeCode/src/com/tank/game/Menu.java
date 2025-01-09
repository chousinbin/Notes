package com.tank.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @Project: JavaSeCode
 * @Author: SinbinZhou
 * @Date: 2025/1/9 20:30
 * @Description:
 */
public class Menu extends JFrame {
    JPanel panel;
    JButton newGame;
    JButton lastGame;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static void main(String[] args) {
        new Menu();
    }

    Menu() {
        this.setSize(400, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("主菜单");
        this.setLocation(screenSize.width - this.getWidth() >> 1,
                screenSize.height - this.getHeight() >> 1);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(400, 300);
        this.add(panel);

        newGame = new JButton("新的游戏");
        newGame.setFont(new Font("宋体", Font.BOLD, 20));
        newGame.setBounds(50, 50, 300, 50);
        lastGame = new JButton("继续游戏");
        lastGame.setFont(new Font("宋体", Font.BOLD, 20));
        lastGame.setBounds(50, 140, 300, 50);

        panel.add(newGame);
        panel.add(lastGame);

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TankGame(0);
                dispose();
            }
        });

        lastGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (new File(Recorder.getEnemyTanksPath()).exists() &&
                new File(Recorder.getScorePath()).exists()) {
                    new TankGame(1);
                    dispose();
                } else {
                    UIManager.put("OptionPane.messageFont", new Font("宋体", Font.BOLD, 20));
                    UIManager.put("OptionPane.buttonFont", new Font("宋体", Font.BOLD, 20));
                    JOptionPane.showMessageDialog(null, "无存档，请开始新游戏！",
                            "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });
    }
}
