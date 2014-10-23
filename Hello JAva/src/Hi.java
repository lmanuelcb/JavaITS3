
public class Hi extends javax.swing.JComponent {
public static void main(String[] args) {
javax.swing.JFrame f = new javax.swing.JFrame("HelloJava1"); f.setSize(300, 300);
f.getContentPane().add(new Hi ( )); f.setVisible(true);
}
public void paintComponent(java.awt.Graphics g) { g.drawString("Hello, Java!", 125, 95);
} }
