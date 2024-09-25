import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class selectionframe {
	public static void main() throws IOException {
		
 	//creates and sets up JFrame
		JFrame selectionframe = new JFrame();
		selectionframe.add(new Paint());
		selectionframe.setSize(1077, 719); 
		selectionframe.setResizable(false);
		selectionframe.getContentPane().setBackground(new java.awt.Color(229, 233, 238)); 
		selectionframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		selectionframe.setVisible(true); 
		//adds buttons
		Buttons.addbuttons(selectionframe);
		//adds and sets up panels
		JPanel mainpanel = new JPanel();
		mainpanel.setSize(500,500);
		mainpanel.setBackground(new java.awt.Color(150, 150, 150));
		mainpanel.setLocation(150, 200);
		selectionframe.setLayout(new BorderLayout());
		selectionframe.add(mainpanel);
		BackgroundPanels.topbarpanel(selectionframe);
		
		JPanel buttonpanel = new JPanel();
		
		
		buttonpanel.setBackground(new java.awt.Color(0, 150, 0));
		buttonpanel.setBounds(100, 100, 100, 100);
		
		//adds select a student text
		JButton randomize = new JButton ("Select a student");
		randomize.setSize(30, 90);
		randomize.setLocation(0, 200);
		mainpanel.add(randomize);

		//adds class row text
		JLabel text3 = new JLabel("class row:");
		mainpanel.add(text3);		
		JTextArea  row = new JTextArea();
		row.setFont(new Font("Verdana",Font.PLAIN,14));
		row.setBounds(140, 120, 30, 20);
		row.setLineWrap(true);
		mainpanel.add(row);




		JLabel text = new JLabel("");
		text.setFont(new Font("Verdana",Font.PLAIN,14));


		JPanel panel = new JPanel ();
		panel.setSize(300, 300);
		panel.setBackground(new java.awt.Color(100, 150, 100));
		mainpanel.add(panel);
		JLabel test = new JLabel("Selection: ");
		text.setFont(new Font("Verdana",Font.PLAIN,14));
		panel.add(test);
		JLabel selectedtext = new JLabel("");
		text.setFont(new Font("Verdana",Font.PLAIN,14));



		panel.add(selectedtext);
		JLabel text2 = new JLabel("Text ");
		text2.setFont(new Font("Verdana",Font.PLAIN,14));
		text2.setBounds(10, 200, 30, 20);
		mainpanel.add(text);
 		
		DefaultTableModel model = new DefaultTableModel(20, 20);
		JTable table = new JTable(model);
		
		//creates 2D array for the student names
		String[][] namearray = new String[20][20];

		//creates file 
		File classtablefile = new File("classtablefile.txt");
			try {
	 
					classtablefile.createNewFile();
				}
			catch (IOException e){
	
				}

			try {
				tableload(table,classtablefile);
			} catch (FileNotFoundException e2) {
	// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				tablesave(table,namearray,classtablefile);
			} catch (FileNotFoundException e2) {
	// TODO Auto-generated catch block
				e2.printStackTrace();
}

//randomize method - selects a random student from the specified class row
randomize.addActionListener(new ActionListener(){  
	public void actionPerformed(ActionEvent e){ 
		
		 Random rand = new Random();//creating random variable
		 int upperbound = 20; //setting upperbound
		 int int_random = rand.nextInt(upperbound); //getting random number
		 int num = Integer.parseInt(row.getText()); //parsing the input into an integer
		 selectedtext.setText(namearray[num][int_random]); //selecting a name using the random number
	        }  
	    }); 
}
	
	//loads names from file into JTable
	public static void tableload(JTable model, File classtablefile) throws FileNotFoundException {
		Scanner Reader = new Scanner(classtablefile);
		for (int count = 0; count < 20; count++) {
			for (int count2 = 0; count2 < 20; count2++) {
					Reader.useDelimiter(",");
					if (Reader.hasNext() == true) {
						model.setValueAt(Reader.next(), count, count2);
					}else {
						
					}
				
	
			}
		}
		
		
	}
	//saves name into file
	public static void tablesave(JTable model, String[][] array, File classtablefile) throws IOException{
		String temp = new String();
		for (int count = 0; count < 20; count++) {
			for (int count2 = 0; count2 < 20; count2++) {
				array[count][count2] = (String) model.getValueAt(count, count2);
					
			}
		}
		
			try {
		            BufferedWriter bf = new BufferedWriter(new FileWriter("classtablefile.txt"));
		        
		            
		            for (int count = 0; count < 20; count++) {
		    			for (int count2 = 0; count2 < 20; count2++) {
		    				if (array[count][count2] ==  null) {
		    					
		    				}
		    				else {
		    					bf.write(array[count][count2]+",");
			    			    bf.flush();
			   		            
		    				}
		    				
		    			}
		    		}
		            bf.close();	
		        } catch (IOException e) {
		            e.printStackTrace();
		        }; }
	
	}
	



