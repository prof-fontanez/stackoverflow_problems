package stackoverflow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Attendance
{

    public static void main(String[] args)
    {

        JFrame frame = new JFrame(); // javax.swing import
        frame.setPreferredSize(new Dimension(600, 400)); // java.awt import
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Attendance checker");

        Container c = frame.getContentPane();

        JButton button1 = new JButton("Button1");
        JLabel student1 = new JLabel("student1");
        student1.setHorizontalAlignment(SwingConstants.CENTER);
        // button1.setBackground(Color.RED);

        JPanel subpanel1 = new JPanel();
        subpanel1.setLayout(new BorderLayout()); // (hgap,vgap)
        subpanel1.add(student1, BorderLayout.CENTER);
        subpanel1.add(button1, BorderLayout.SOUTH);

        JButton button2 = new JButton("Button2");
        JLabel student2 = new JLabel("student2");
        student2.setHorizontalAlignment(SwingConstants.CENTER);
        // button1.setBackground(Color.RED);

        JPanel subpanel2 = new JPanel();
        subpanel2.setLayout(new BorderLayout()); // (hgap,vgap)
        subpanel2.add(student2, BorderLayout.CENTER);
        subpanel2.add(button2, BorderLayout.SOUTH);

        JButton button3 = new JButton("Button3");
        JLabel student3 = new JLabel("student3");
        student3.setHorizontalAlignment(SwingConstants.CENTER);
        // button1.setBackground(Color.RED);

        JPanel subpanel3 = new JPanel();
        subpanel3.setLayout(new BorderLayout()); // (hgap,vgap)
        subpanel3.add(student3, BorderLayout.CENTER);
        subpanel3.add(button3, BorderLayout.SOUTH);

        JButton button4 = new JButton("Button4");
        JLabel student4 = new JLabel("student4");
        student4.setHorizontalAlignment(SwingConstants.CENTER);
        // button1.setBackground(Color.RED);

        JPanel subpanel4 = new JPanel();
        subpanel4.setLayout(new BorderLayout()); // (hgap,vgap)
        subpanel4.add(student4, BorderLayout.CENTER);
        subpanel4.add(button4, BorderLayout.SOUTH);

        JButton button5 = new JButton("Button5");
        JLabel student5 = new JLabel("student5");
        student5.setHorizontalAlignment(SwingConstants.CENTER);
        // button1.setBackground(Color.RED);

        JPanel subpanel5 = new JPanel();
        subpanel5.setLayout(new BorderLayout()); // (hgap,vgap)
        subpanel5.add(student5, BorderLayout.CENTER);
        subpanel5.add(button5, BorderLayout.SOUTH);

        JButton button6 = new JButton("Button6");
        JLabel student6 = new JLabel("student6");
        student6.setHorizontalAlignment(SwingConstants.CENTER);
        // button1.setBackground(Color.RED);

        JPanel subpanel6 = new JPanel();
        subpanel6.setLayout(new BorderLayout()); // (hgap,vgap)
        subpanel6.add(student6, BorderLayout.CENTER);
        subpanel6.add(button6, BorderLayout.SOUTH);

        JButton button7 = new JButton("Button7");
        JLabel student7 = new JLabel("student7");
        student7.setHorizontalAlignment(SwingConstants.CENTER);
        // button1.setBackground(Color.RED);

        JPanel subpanel7 = new JPanel();
        subpanel7.setLayout(new BorderLayout()); // (hgap,vgap)
        subpanel7.add(student7, BorderLayout.CENTER);
        subpanel7.add(button7, BorderLayout.SOUTH);

        JButton button8 = new JButton("Button8");
        JLabel student8 = new JLabel("student8");
        student8.setHorizontalAlignment(SwingConstants.CENTER);
        // button1.setBackground(Color.RED);

        JPanel subpanel8 = new JPanel();
        subpanel8.setLayout(new BorderLayout()); // (hgap,vgap)
        subpanel8.add(student8, BorderLayout.CENTER);
        subpanel8.add(button8, BorderLayout.SOUTH);

        JButton button9 = new JButton("Button9");
        JLabel student9 = new JLabel("student9");
        student9.setHorizontalAlignment(SwingConstants.CENTER);
        // button1.setBackground(Color.RED);

        JPanel subpanel9 = new JPanel();
        subpanel9.setLayout(new BorderLayout()); // (hgap,vgap)
        subpanel9.add(student9, BorderLayout.CENTER);
        subpanel9.add(button9, BorderLayout.SOUTH);

        JButton button10 = new JButton("Button10");
        JLabel student10 = new JLabel("student10");
        student10.setHorizontalAlignment(SwingConstants.CENTER);
        // button1.setBackground(Color.RED);

        JPanel subpanel10 = new JPanel();
        subpanel10.setLayout(new BorderLayout()); // (hgap,vgap)
        subpanel10.add(student10, BorderLayout.CENTER);
        subpanel10.add(button10, BorderLayout.SOUTH);

        JButton button11 = new JButton("Button11");
        JLabel student11 = new JLabel("student11");
        student11.setHorizontalAlignment(SwingConstants.CENTER);
        // button1.setBackground(Color.RED);

        JPanel subpanel11 = new JPanel();
        subpanel11.setLayout(new BorderLayout()); // (hgap,vgap)
        subpanel11.add(student11, BorderLayout.CENTER);
        subpanel11.add(button11, BorderLayout.SOUTH);

        JButton button12 = new JButton("Button12");
        JLabel student12 = new JLabel("student12");
        student12.setHorizontalAlignment(SwingConstants.CENTER);
        // button1.setBackground(Color.RED);

        JPanel subpanel12 = new JPanel();
        subpanel12.setLayout(new BorderLayout()); // (hgap,vgap)
        subpanel12.add(student12, BorderLayout.CENTER);
        subpanel12.add(button12, BorderLayout.SOUTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 4, 20, 20));

        c.add(panel);

        panel.add(subpanel1);
        panel.add(subpanel2);
        panel.add(subpanel3);
        panel.add(subpanel4);
        panel.add(subpanel5);
        panel.add(subpanel6);
        panel.add(subpanel7);
        panel.add(subpanel8);
        panel.add(subpanel9);
        panel.add(subpanel10);
        panel.add(subpanel11);
        panel.add(subpanel12);

        button1.addMouseListener(new MyMouseListener());
        button2.addMouseListener(new MyMouseListener());
        button3.addMouseListener(new MyMouseListener());
        button4.addMouseListener(new MyMouseListener());
        button5.addMouseListener(new MyMouseListener());
        button6.addMouseListener(new MyMouseListener());
        button7.addMouseListener(new MyMouseListener());
        button8.addMouseListener(new MyMouseListener());
        button9.addMouseListener(new MyMouseListener());
        button10.addMouseListener(new MyMouseListener());
        button11.addMouseListener(new MyMouseListener());
        button12.addMouseListener(new MyMouseListener());

        frame.setVisible(true); // does not require import
        frame.pack();

    }
}