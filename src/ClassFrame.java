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

public class ClassFrame {
	public static void main() {
		
 		JFrame classframe = new JFrame();
 		classframe.setLayout(new BorderLayout());
 		Buttons.addbuttons(classframe);
 		BackgroundPanels.topbarpanel(classframe);
 		
 		//setting up JFrame
 		classframe.add(new Paint());
 		classframe.setSize(1077, 719); 
 		classframe.setResizable(false);
 		classframe.getContentPane().setBackground(new java.awt.Color(229, 233, 238)); 
 		classframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
 		classframe.setVisible(true); 
 		
 		//Add Save Button
 		JButton savebutton = new JButton("Save");
 		savebutton.setSize(70,40);
 		classframe.add(savebutton);
 		savebutton.setLocation(135, 160);
 		
 		//Add reload Button
 		JButton loadbutton = new JButton("Re-load");
 		loadbutton.setSize(70,40);
 		classframe.add(loadbutton);
 		loadbutton.setLocation(870, 160);
 		
 		//creates JTable
 		DefaultTableModel model = new DefaultTableModel(20, 20);
 		JTable table = new JTable(model);
 	
 		JPanel Centerpanel = new JPanel();
 		JScrollPane scroll=new JScrollPane(table); 
 		Centerpanel.add(scroll);
 		classframe.add(Centerpanel);
 		table.setBackground(new java.awt.Color(160, 160, 160));
 		scroll.setSize(800, 400);
 		scroll.setLocation(140, 200);
 		Centerpanel.setLayout(new BorderLayout());
 		
 		 String[][] namearray = new String[20][20];
 		
 		//Creates file for text
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
	        loadbutton.addActionListener(new ActionListener(){  
	        	public void actionPerformed(ActionEvent e){ 
	        		try {
						tableload(table,classtablefile);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
	     			        
	        	}	
	 		});
	        
	        
	        savebutton.addActionListener(new ActionListener(){  
	        	public void actionPerformed(ActionEvent e){  
	        	              try {
								tablesave(table,namearray ,classtablefile);
								
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}  
	        	              
	        	  
	        	     
	        	        }  
	        
	        	    });  
}
	// loads text into the JTable
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
	//Saves text into the text file
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
		        }; 
		
	}
}


