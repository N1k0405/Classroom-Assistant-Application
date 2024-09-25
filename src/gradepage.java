import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class gradepage {
	public static void main() {
		
		//creates jframe
		
 		JFrame classframe = new JFrame();
 		classframe.setLayout(new BorderLayout());
 		Buttons.addbuttons(classframe);
 		BackgroundPanels.topbarpanel(classframe);
 		
 		//setting up jframe
 		
 		classframe.add(new Paint());
 		classframe.setSize(1077, 719); 
 		classframe.setResizable(false);
 		classframe.getContentPane().setBackground(new java.awt.Color(229, 233, 238)); 
 		classframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
 		classframe.setVisible(true); 
 		
 		// adds save button
 		JButton savebutton = new JButton("Save");
 		savebutton.setSize(70,40);
 		classframe.add(savebutton);
 		savebutton.setLocation(30, 160);
 		
 		//creates JTable
 		DefaultTableModel model = new DefaultTableModel(400, 20);
 		JTable table = new JTable(model);
 	
 		JPanel Centerpanel = new JPanel();
 		JScrollPane scroll=new JScrollPane(table); 
 		Centerpanel.add(scroll);
 		classframe.add(Centerpanel);
 		table.setBackground(new java.awt.Color(160, 160, 160));
 		scroll.setSize(1000, 400);
 		scroll.setLocation(30, 200);
 		Centerpanel.setLayout(new BorderLayout());
 		

 		 String[][] namearray = new String[400][20];
 		
 		
 		  File gradetablefile = new File("gradetablefile.txt");
	        try {
	        	 
	        	gradetablefile.createNewFile();
	        }
	        catch (IOException e){
	        }
	        
	        File classtablefile = new File("classtablefile.txt");
	        try {
	        	 
	        	classtablefile.createNewFile();
	        }
	        catch (IOException e){
	        }
	        try {
	        	tableloadgrades(table,gradetablefile);
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	        try {
	        	tableloadnames(table,classtablefile);
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	        
	       
	        
	        
	        savebutton.addActionListener(new ActionListener(){  
	        	public void actionPerformed(ActionEvent e){  
	        	              try {
								tablesave(table,namearray ,gradetablefile);
								
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
	        	              
	        	  
	        	     
	        	        }  
	        
	        	    });  
 	
 
}
	//loads names into the JTable
	public static void tableloadnames(JTable model, File file) throws FileNotFoundException {
		Scanner Reader = new Scanner(file);
		for (int count = 0; count < 400; count++) {
			Reader.useDelimiter(",");
			if (Reader.hasNext() == true) {
				model.setValueAt(Reader.next(), count, 0);
			}else {
				
			}
			//for (int count2 = 0; count2 < 20; count2++) {
					
				
	
			//}
		}
	
		
		
	}
	//loads grades into the JTable
	public static void tableloadgrades(JTable model, File file) throws FileNotFoundException {
		Scanner Reader = new Scanner(file);
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
	//Saving the JTable
	public static void tablesave(JTable model, String[][] array, File file) throws IOException{
		
		for (int count = 0; count < 20; count++) {
			for (int count2 = 0; count2 < 20; count2++) {
				array[count][count2] = (String) model.getValueAt(count, count2);
					
			}
		}
		
			try {
		            BufferedWriter bf = new BufferedWriter(new FileWriter("gradetablefile.txt"));
		        
		            
		            for (int count = 0; count < 20; count++) {
		    			for (int count2 = 0; count2 < 20; count2++) {
		    				if (array[count][count2] ==  null) {
		    					bf.write(",");
		    					 bf.flush();
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
	
	



