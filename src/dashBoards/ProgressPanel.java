package dashBoards;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class ProgressPanel extends JPanel{
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        //1
        g2d.setColor(new Color(48, 46, 127));
        g2d.drawOval(10, 10, 30, 30);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(40, 25, 135, 25);
        
        //2
        g2d.setColor(new Color(48, 46, 127));
        g2d.drawOval(135, 10, 30, 30);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(165, 25, 263, 25);
        
        //3
        g2d.setColor(new Color(48, 46, 127));
        g2d.drawOval(263, 10, 30, 30);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(293, 25, 382, 25);
        
        //4
        g2d.setColor(new Color(48, 46, 127));
        g2d.drawOval(382, 10, 30, 30);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(412, 25, 495, 25);
        
        //5
        g2d.setColor(new Color(48, 46, 127));
        g2d.drawOval(495, 10, 30, 30);
        
    }
}
