import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class grouppage {
	public static void main() throws IOException {
		
 	// creates and sets up the JFrame and panels
		JFrame selectionframe = new JFrame();
		selectionframe.add(new Paint());
		selectionframe.setSize(1077, 719); 
		selectionframe.setResizable(false);
		selectionframe.getContentPane().setBackground(new java.awt.Color(229, 233, 238)); 
		selectionframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		selectionframe.setVisible(true); 
		Buttons.addbuttons(selectionframe);
		JPanel mainpanel = new JPanel();
		mainpanel.setSize(900,500);
		mainpanel.setBackground(new java.awt.Color(150, 150, 150));
		mainpanel.setLocation(80, 200);
		selectionframe.setLayout(new BorderLayout());
		selectionframe.add(mainpanel);
		BackgroundPanels.topbarpanel(selectionframe);
		
		JPanel buttonpanel = new JPanel();
		
		
		buttonpanel.setBackground(new java.awt.Color(0, 150, 0));
		buttonpanel.setBounds(100, 100, 100, 100);
		
		//creates create groups button
		JButton randomize = new JButton ("Create Groups");
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
		//adds group size text
		JLabel text4 = new JLabel("Group size");
		mainpanel.add(text4);		
		JTextArea  row2 = new JTextArea();
		row2.setFont(new Font("Verdana",Font.PLAIN,14));
		row2.setBounds(140, 120, 30, 20);
		row2.setLineWrap(true);
		mainpanel.add(row2);

		
		// adds JLabel to add the groups to later
		JLabel text = new JLabel("");
		text.setFont(new Font("Verdana",Font.PLAIN,14));
		//text.setBounds(70, 10, 30, 20);
		
		JPanel panel = new JPanel ();
		panel.setSize(800, 600);
		panel.setBackground(new java.awt.Color(100, 150, 100));
		
		
		mainpanel.add(panel);
		JLabel selection = new JLabel("Selection: ");
		text.setFont(new Font("Verdana",Font.PLAIN,14));
		panel.add(selection);
		JLabel selectedtext = new JLabel("");
		text.setFont(new Font("Verdana",Font.PLAIN,14));
		
		panel.add(selectedtext);
		JLabel text2 = new JLabel("Text ");
		text2.setFont(new Font("Verdana",Font.PLAIN,14));
		text2.setBounds(10, 200, 30, 20);
		//mainpanel.add(text2);
		mainpanel.add(text);
		 		
		DefaultTableModel model = new DefaultTableModel(20, 20);
		JTable table = new JTable(model);
		String[][] namearray = new String[20][20];
		
		
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

		//randomly creates groups from the specified row number
		randomize.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				List<String> namelist=new ArrayList<String>(); 
				
				 int num = Integer.parseInt(row.getText());
				 int groupsize = Integer.parseInt(row2.getText());
				for (int i = 0; i < 20; i++) {
					namelist.add(namearray[num][i]);
					
				}
			Collections.shuffle(namelist);
		    for (int i = 0; i < namelist.size(); i += groupsize ) {
		    	
		    	 
		    	namelist.subList(i, Math.min(i + groupsize, namelist.size()));
		    }
		
		  
		    List<List<String>> result = new ArrayList<>();
		    List<String> remainingNames = new ArrayList<>(namelist);
		
		    while (remainingNames.size() >= groupsize) {
		        List<String> group = new ArrayList<>();
		        for (int i = 0; i < groupsize; i++) {
		            int randomIndex = (int) (Math.random() * remainingNames.size());
		            group.add(remainingNames.get(randomIndex));
		            remainingNames.remove(randomIndex);
		        }
		        result.add(group);
		    }
		    if (!remainingNames.isEmpty()) {
		        result.add(remainingNames);
		    }
		    int groupnum = 20 % groupsize; 
		    StringBuffer sb = new StringBuffer();
		    for(int i = 0; i < result.size(); i++) {
		       sb.append(result.get(i));
		       sb.append("\n");
		    }
		    String str = sb.toString();
		    selectedtext.setText(str);
		
		
			        }  
			    }); 
 	
 
		}
	//loads names into the JTable
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
	//Saves names into the file.
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
	



