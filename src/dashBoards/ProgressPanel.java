package dashBoards;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class ProgressPanel extends JPanel{
	
	private int currentStep;

    public ProgressPanel(int currentStep) {
        this.currentStep = currentStep;
    }

	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int[] xPositions = {10, 135, 263, 382, 495};

        for (int i = 0; i < xPositions.length; i++) {
            int x = xPositions[i];

            if (i + 1 <= currentStep) {
                // filled — step is done
                g2d.setColor(new Color(102, 204, 102));
                g2d.fillOval(x, 10, 30, 30);
                g2d.setColor(new Color(34, 139, 34)); 
                g2d.drawOval(x, 10, 30, 30);
            } else {
            	g2d.setColor(new Color(34, 139, 34));
                g2d.drawOval(x, 10, 30, 30);
            }

            if (i < xPositions.length - 1) {
                g2d.setColor(Color.BLACK);
                g2d.drawLine(x + 30, 25, xPositions[i + 1], 25);
            }
        }
	}
}
