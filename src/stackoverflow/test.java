package stackoverflow;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class test extends JFrame
{

    public static void main(String[] args)
    {
        // 1. Create the frame.
        JFrame frame = new JFrame("FrameDemo");
        JPanel panel = new JPanel();
        panel.setSize(new Dimension(400, 400));

        // 2. Optional: What happens when the frame closes?
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Create components and put them in the frame.
        JLabel emptyLabel = new JLabel("BLAHBLAHBHALBAHLKKDJF");
        panel.add(emptyLabel);
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        // 4. Size the frame.
//        frame.pack();

        // 5. Show it.
        frame.setVisible(true);
    }
}