package stackoverflow;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class MyMouseListener extends MouseAdapter
{
    public void mousePressed(MouseEvent a)
    {
        Object c = a.getSource();
        if (c instanceof JButton)
        {
            JButton btn = (JButton)c;

            if (a.getClickCount() == 1)
            {
                btn.setBackground(Color.ORANGE);
            }

            else if (a.getClickCount() == 2)
            {
                btn.setBackground(Color.RED);
            }

            else if (a.getClickCount() == 3)
            {
                btn.setBackground(Color.BLACK);
            }
        }
    }
}
