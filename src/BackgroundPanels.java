import java.awt.Container;
import javax.swing.JPanel;

public class BackgroundPanels {
	public static void homepagepanels(Container frame) {
		 
	      
     

        //Bottom bar
        JPanel panelbot = new JPanel(); 
        panelbot.setSize(1077,181);
        panelbot.setBackground(new java.awt.Color(150, 150, 150));
        panelbot.setLocation(0,510);
       
        //side bar
        JPanel panelright = new JPanel(); 
        panelright.setSize(398,450);
        panelright.setBackground(new java.awt.Color(180, 180, 180));
        panelright.setLocation(680,60);
        
        //to-do list box
        JPanel paneltodo = new JPanel();
        paneltodo.setSize(300,130);
        paneltodo.setBackground(new java.awt.Color(210, 210, 210));
        paneltodo.setLocation(320,540);
        
        frame.add(paneltodo);
        frame.add(panelright);
        frame.add(panelbot);
       
	}
	
	public static void topbarpanel(Container frame) {
		//Top Bar
        JPanel paneltop = new JPanel();
        paneltop.setSize(1077,60);
        paneltop.setBackground(new java.awt.Color(150, 150, 150));
        paneltop.setLocation(0, 0);
		frame.add(paneltop);
	}
}
