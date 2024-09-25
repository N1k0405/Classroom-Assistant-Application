import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Scanner;
import javax.swing.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class calendarpage {
	public static void main() {
		
 		JFrame classframe = new JFrame();
 		classframe.setLayout(new BorderLayout());
 		Buttons.addbuttons(classframe);
 		BackgroundPanels.topbarpanel(classframe);
 		
 		// initializing properties for the JDatePanelImpl
 		Properties p = new Properties();
 		p.put("text.today", "Today");
 		p.put("text.month", "Month");
 		p.put("text.year", "Year");
 		
 		//Utilizing the JDatePicker Library
 		UtilDateModel model = new UtilDateModel();
 		JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
 		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel,new formatter());
 		 
		//setting up the jframe
 		classframe.add(new Paint());
 		classframe.setSize(1077, 719); 
 		classframe.setResizable(false);
 		classframe.getContentPane().setBackground(new java.awt.Color(229, 233, 238)); 
 		classframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
 		classframe.setVisible(true); 
 		
 		
 		JPanel mainpanel = new JPanel();
		mainpanel.setBackground(new java.awt.Color(150, 150, 150));

		mainpanel.setLayout(new GridBagLayout());
	    mainpanel.setPreferredSize(new Dimension(400, 400));
 		classframe.add(mainpanel);
 	
 		//adds the save events button
 		JButton savebutton = new JButton("Save Events");
 		savebutton.setSize(130,40);
 		mainpanel.add(savebutton);
 		savebutton.setLocation(135, 160);
 	
 		mainpanel.add(datePicker);
 		
 		//adds the input area
 		  JTextArea  calNotes = new JTextArea();
 		 calNotes.setFont(new Font("Verdana",Font.PLAIN,14));
 		
 		 
 		 calNotes.setPreferredSize(new Dimension(300,300));
 		 calNotes.setBackground(new java.awt.Color(229, 233, 238));
 		calNotes.setLineWrap(true);
 		mainpanel.add(calNotes);
 		//creating the file for the text 
	        File calNotefile = new File("calendarnotes.txt"); 
	        try {
	        	 
	        	calNotefile.createNewFile(); //touches the file to create it
	        }
	        catch (IOException e){
	        	
	        }
	   

 		
 	datePicker.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			  
			   calNotes.setText("");
			
			   java.util.Date utilDate = (java.util.Date) datePicker.getModel().getValue();
			   java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			   
			   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		       String dateString = dateFormat.format(sqlDate);
			   
			   //loading old data from the text file
		       try {
		            Scanner scanner = new Scanner(calNotefile);
		            while (scanner.hasNextLine()) {
		                String line = scanner.nextLine();
		                if (line.contains(dateString)) {
		                   
		                   line = line.replaceAll("~", "\n");
		                   line = line.replace(dateString, "");
		                   calNotes.setText(line);
		                    
		                    break;
		                }
		              
		            }
		            scanner.close(); 
		        } catch (FileNotFoundException h) {
		            h.printStackTrace();
		        }		   
		}
 		
 	});
 	savebutton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			 BufferedWriter writer;
			try {
				
		          
		          
		       // Gets the selected date from the date picker
		          java.util.Date utilDate = (java.util.Date) datePicker.getModel().getValue();
		          java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		          // Formats the date as a string
		          DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		          String dateString = dateFormat.format(sqlDate);

		          // Creates a BufferedWriter to write to the file
		          
		          writer = new BufferedWriter(new FileWriter("calendarnotes.txt", true));
		          

		          // Writes the date and notes to the file, replacing any newlines with a unique symbol
		          writer.write(dateString + " " + calNotes.getText().replaceAll("\\r|\\n", "~"));
		          writer.newLine();

		          // Flushes and close the writer
		          writer.flush();
		          writer.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	          
			
		}
 		
 	}
);
	}

	
}