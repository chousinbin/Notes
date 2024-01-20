import javax.swing.*;
public class HelloWorldSwing {
    /**{
     * ��������ʾGUI�������̰߳�ȫ�Ŀ��ǣ�
     * ����������¼������߳��е��á�
     */
    private static void createAndShowGUI() {
        // ȷ��һ��Ư������۷��
        JFrame.setDefaultLookAndFeelDecorated(true);

        // ���������ô���
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ��� "Hello World" ��ǩ
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        // ��ʾ����
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // ��ʾӦ�� GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}