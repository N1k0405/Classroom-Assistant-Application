import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.Timer;

public class Clock {
	public static void main(Container frame) {
		  
    	JTextField  timeLabel = new JTextField();
    	final SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,60));
        timeLabel.setOpaque(false);
        timeLabel.setBounds(190, 70, 298, 70);	
       
        //setting second interval
        int interval = 1000;
        new Timer(interval, new ActionListener() {

        public void actionPerformed(ActionEvent e) {
                Calendar now = Calendar.getInstance();
                timeLabel.setText(dateFormat.format(now.getTime()));
            }
        }).start();
        frame.add(timeLabel);  
	}

}
