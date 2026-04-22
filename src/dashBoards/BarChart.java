package dashBoards;
import javax.swing.*;
import java.awt.*;

public class BarChart extends JPanel {
   
	int[] strands = {0, 0, 0, 0, 0, 0};
	
	BarChart(int []totalPerStrand){
		for(int i = 0; i < totalPerStrand.length; i++) {
			strands[i] = totalPerStrand[i];
		}
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Strand Distribution", 10, 20);
        g.drawLine(10, 30, 330, 30);
        
        int space = 40;
        int startPos = 50;
        for(int i = 0; i < strands.length; i++) {
        	double percentage = 300 * (strands[i] / 800.00); 
        	int barPerc = (int) Math.round(percentage);
        	
        	g.drawRect(19, startPos, 300, 20);
            g.setColor(Color.red);
            
            switch(i) {
            case 0:
            	g.setColor(Color.CYAN);
            break;
            case 1:
            	g.setColor(Color.ORANGE);
            break;
            case 2:
            	g.setColor(Color.PINK);
            break;
            case 3:
            	g.setColor(Color.GREEN);
            break;
            case 4:
            	g.setColor(Color.red);
            break;
            case 5:
            	g.setColor(Color.YELLOW);
            break;
            }
            
            g.fillRect(20, startPos+1, barPerc-1, 20-1);
            g.setColor(Color.black);
            
            startPos += space;
        }
       
    }
}