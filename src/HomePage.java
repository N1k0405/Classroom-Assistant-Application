import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;


public class HomePage {
	 public static void mainmenu()   {
		 
		 
		 JFrame frame = new JFrame("Home page");  

		 // creates text area for the note pad
	     JTextArea  notepad = new JTextArea();
	     notepad.setFont(new Font("Verdana",Font.PLAIN,14));
	     notepad.setBounds(710, 110, 335, 400);
	     notepad.setLineWrap(true);
	     File notepadfile = new File("teacherappnotepad.txt"); 
	     try {
	        	 notepadfile.createNewFile(); //touches the file to create it
	     } 
	     catch (IOException e){
	     }
	       
	        try {
				Scanner Reader = new Scanner(notepadfile);
				while (Reader.hasNextLine()) {
			        String data = Reader.nextLine(); // reads data from file
			        notepad.append(data);  //Assigns text from file to variable 'data'
			        notepad.append("\n"); // Separates text into lines
				}
			} catch (FileNotFoundException e1) {	 //catches error
				e1.printStackTrace();
			}
	        
	     
	        
	        /*Save textarea to file*/
	        frame.addWindowListener(new WindowAdapter(){ 
	     
	       public void windowClosing(WindowEvent f) { 
		        try {
		        	//creates buffered writer to write text to the file
		            BufferedWriter bf = new BufferedWriter(new FileWriter("teacherappnotepad.txt"));
		            bf.write(notepad.getText()); //gets text and writes it to file
		            bf.flush();
		            bf.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }; frame.dispose();
	        	} }); 
	       
	        //creates notes label
	        JLabel noteslabel = new JLabel("Notes");
	        noteslabel.setFont(new Font("Verdana",Font.BOLD,18));
	        noteslabel.setSize(100, 20);
	        noteslabel.setLocation(710, 75);
	        frame.add(noteslabel);
	        
	        //creates to do list label
	        JLabel todolabel = new JLabel("To Do List");
	        todolabel.setFont(new Font("Verdana",Font.BOLD,14));
	        todolabel.setSize(100, 20);
	        todolabel.setLocation(320,515);
	        frame.add(todolabel);
	        
	        //creates events label
	        JLabel eventlabel = new JLabel("Events");
	        eventlabel.setFont(new Font("Verdana",Font.BOLD,14));
	        eventlabel.setSize(100, 20);
	        eventlabel.setLocation(20,515);
	        frame.add(eventlabel);
	        
	        //creates checkbox button
	        JButton checkbox = new JButton();
	        checkbox.setBackground(new java.awt.Color(180, 180, 180));
	        checkbox.setOpaque(true);
	        checkbox.setBorderPainted(false);
	        frame.add(checkbox);
	        checkbox.setSize(20, 20);
	        checkbox.setLocation(320,550);
	        boolean checkboxclick = false;
	        Color btnDefault;
	        btnDefault = checkbox.getBackground();
	        Color btnSecond = new Color(0,180,0);
	  
	        //changes checkbox color
	        checkbox.addActionListener(new ActionListener(){  
	        	public void actionPerformed(ActionEvent click){  
	        	
	        		if (checkbox.getBackground().equals(btnDefault)) {
	        			checkbox.setBackground(btnSecond);
	        			
	        
	        		} else {
	        			checkbox.setBackground(btnDefault);
	       
	        		}
	        		
	        		
	        		checkbox.getBackground();
	        	}
	        	    }); 
	        //creates checkbox button
	        JButton checkbox2 = new JButton();
	        checkbox2.setBackground(new java.awt.Color(180, 180, 180));
	        checkbox2.setOpaque(true);
	        checkbox2.setBorderPainted(false);
	        frame.add(checkbox2);
	        checkbox2.setSize(20, 20);
	        checkbox2.setLocation(320,590);
	        boolean checkboxclick2 = false;
	        //changes check box color
	        checkbox2.addActionListener(new ActionListener(){  
	        	public void actionPerformed(ActionEvent click){  
	        	
	        		if (checkbox2.getBackground().equals(btnDefault)) {
	        			checkbox2.setBackground(btnSecond);
	        			
	        
	        		} else {
	        			checkbox2.setBackground(btnDefault);
	       
	        		}
	        		
	        		
	        		checkbox2.getBackground();
	        	}
	        	    });  
	        //creates checkbox button
	        JButton checkbox3 = new JButton();
	        checkbox3.setBackground(new java.awt.Color(180, 180, 180));
	        checkbox3.setOpaque(true);
	        checkbox3.setBorderPainted(false);
	        frame.add(checkbox3);
	        checkbox3.setSize(20, 20);
	        checkbox3.setLocation(320,630);
	        boolean checkboxclick3 = false;
	        //changes checkbox color
	        checkbox3.addActionListener(new ActionListener(){  
	        	
	        	
	        	public void actionPerformed(ActionEvent click){  
	        	
	        		if (checkbox3.getBackground().equals(btnDefault)) {
	        			checkbox3.setBackground(btnSecond);
	        			
	        
	        		} else {
	        			checkbox3.setBackground(btnDefault);
	       
	        		}
	        		
	        		
	        		checkbox3.getBackground();
	        	}
	        	    });  
	        
	        //creates the text field and file for the to do section
	        JTextField todo1= new JTextField ();
	        todo1.setSize(270, 20);
	        todo1.setLocation(340,550);
	        frame.add(todo1);
	        
	        File todofield = new File("todofield.txt");
	        try {
	        	
	        	 todofield.createNewFile();
	        }
	        catch (IOException e){
	        	
	        }
	        
	        
	        try {
				Scanner Reader = new Scanner(todofield);
				while (Reader.hasNextLine()) {
			        String data = Reader.nextLine();
			        todo1.setText(data);
			        
				}
			} catch (FileNotFoundException e1) {	
				e1.printStackTrace();
				
			}
	        
	        frame.addWindowListener(new WindowAdapter(){ 
	   	     
	 	       public void windowClosing(WindowEvent f) { 
	 		        try {
	 		            BufferedWriter bf = new BufferedWriter(new FileWriter("todofield.txt"));
	 		            bf.write(todo1.getText());
	 		            bf.flush();
	 		            bf.close();
	 		        } catch (IOException e) {
	 		            e.printStackTrace();
	 		        }; frame.dispose();
	 		        
	 	        	} }); 
	        //creates the text field and file for the to do section
	        JTextField todo2= new JTextField ();
	        todo2.setSize(270, 20);
	        todo2.setLocation(340,590);
	        frame.add(todo2);
	        
	        File todofield2 = new File("todofield2.txt");
	        try {
	        	
	        	 todofield2.createNewFile();
	        }
	        catch (IOException e){
	        	
	        }
	        
	        
	        try {
				Scanner Reader = new Scanner(todofield2);
				while (Reader.hasNextLine()) {
			        String data = Reader.nextLine();
			        todo2.setText(data);
			        
				}
			} catch (FileNotFoundException e1) {	
				e1.printStackTrace();
				
			}
	        
	        frame.addWindowListener(new WindowAdapter(){ 
	   	     
	 	       public void windowClosing(WindowEvent f) { 
	 		        try {
	 		            BufferedWriter bf = new BufferedWriter(new FileWriter("todofield2.txt"));
	 		            bf.write(todo2.getText());
	 		            bf.flush();
	 		            bf.close();
	 		        } catch (IOException e) {
	 		            e.printStackTrace();
	 		        }; frame.dispose();
	 		        
	 	        	} }); 
	        //creates the text field and file for the to do section
	        JTextField todo3= new JTextField ();
	        todo3.setSize(270, 20);
	        todo3.setLocation(340,630);
	        frame.add(todo3);
	        
	        File todofield3 = new File("todofield3.txt");
	        try {
	        	
	        	 todofield3.createNewFile();
	        }
	        catch (IOException e){
	        	
	        }
	        
	        
	        try {
				Scanner Reader = new Scanner(todofield3);
				while (Reader.hasNextLine()) {
			        String data = Reader.nextLine();
			        todo3.setText(data);
			        
				}
			} catch (FileNotFoundException e1) {	
				e1.printStackTrace();
				
			}
	        
	        frame.addWindowListener(new WindowAdapter(){ 
	   	     
	 	       public void windowClosing(WindowEvent f) { 
	 		        try {
	 		            BufferedWriter bf = new BufferedWriter(new FileWriter("todofield3.txt"));
	 		            bf.write(todo3.getText());
	 		            bf.flush();
	 		            bf.close();
	 		        } catch (IOException e) {
	 		            e.printStackTrace();
	 		        }; frame.dispose();
	 		        
	 	        	} }); 
	      
	    

	        //creates events/upcoming notes section and file
	        JTextArea  upcoming = new JTextArea();
	        upcoming.setFont(new Font("Verdana",Font.PLAIN,14));
	        upcoming.setSize(280,130);
	        upcoming.setLocation(20, 540);
	        upcoming.setLineWrap(true);
	        frame.add(upcoming);
	        File upcomingfile = new File("upcomingnotes.txt");
	        try {
	        	 
	        	upcomingfile.createNewFile();
	        }
	        catch (IOException e){
	        	
	        }
	       
	        try {
				Scanner Reader = new Scanner(upcomingfile);
				while (Reader.hasNextLine()) {
			        String data = Reader.nextLine();
			        upcoming.append(data);
			        upcoming.append("\n");
				}
			} catch (FileNotFoundException e1) {	
				e1.printStackTrace();
			}
	        
	        frame.addWindowListener(new WindowAdapter(){ 
	 	       public void windowClosing(WindowEvent f) { 
	 		        try {
	 		            BufferedWriter bf = new BufferedWriter(new FileWriter("upcomingnotes.txt"));
	 		            bf.write(upcoming.getText());
	 		            bf.flush();
	 		            bf.close();
	 		        } catch (IOException e) {
	 		            e.printStackTrace();
	 		        }; frame.dispose();
	 	        	} }); 
	        
	       
	      
	     
	        	 
	     //adds components and sets up JFrame
	        frame.add(notepad);
	        Clock.main(frame);
	        Buttons.addbuttons(frame);
	        BackgroundPanels.homepagepanels(frame);
	        BackgroundPanels.topbarpanel(frame);
	        frame.add(new Paint());
	        frame.setSize(1077, 719); 
	        frame.setResizable(false);
	        frame.getContentPane().setBackground(new java.awt.Color(229, 233, 238)); 
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	        frame.setVisible(true); 
	        
		        
	        

	     


	}
	 
}



