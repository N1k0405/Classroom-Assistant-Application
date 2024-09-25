import java.awt.Container;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;


public class Buttons {

	public static void addbuttons(Container frame) {
        JButton homebutton = new JButton("Home");
        homebutton.setBounds(10, 7, 100, 46);
        frame.add(homebutton);
        
        homebutton.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        		((Window) frame).dispose(); //closes current frame
        		HomePage.mainmenu();   // Opens home page frame
        	}  
        });  
       
        //adds group button
        JButton groupbutton = new JButton("Groups");
        groupbutton.setBounds(190, 7, 100, 46);
        frame.add(groupbutton);
      
        //adds selection button
        JButton selbutton = new JButton("Selection");
        selbutton.setBounds(370, 7, 100, 46);
        frame.add(selbutton);
    
        //adds grades button
        JButton gradebutton = new JButton("Grades");
	    gradebutton.setBounds(550, 7, 100, 46);
	    frame.add(gradebutton);
	        
	    //adds calendar button
	    JButton calbutton = new JButton("Calendar");
	    calbutton.setBounds(730, 7, 100, 46);
	    frame.add(calbutton);

	    //adds classes button
	    JButton classesbutton = new JButton("Classes");
        classesbutton.setBounds(910, 7, 100, 46);
        frame.add(classesbutton);
        
        calbutton.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        	((Window) frame).dispose();//closes current frame
        	calendarpage.main(); // opens class page frame
        	        }  
        	    });
        
        gradebutton.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        	((Window) frame).dispose();//closes current frame
        	gradepage.main(); // opens class page frame
        	        }  
        	    });
        classesbutton.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        	((Window) frame).dispose();//closes current frame
        	ClassFrame.main(); // opens class page frame
        	        }  
        	    });
        selbutton.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        	((Window) frame).dispose();//closes current frame
        	try {
				selectionframe.main();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // opens class page frame
        	        }  
        	    }); 
        groupbutton.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        	((Window) frame).dispose();//closes current frame
        	try {
				grouppage.main();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // opens class page frame
        	        }  
        	    }); 
        
	
	}

}

