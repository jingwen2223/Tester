import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class game extends JFrame{
	
	 Grid = new Grid();
	  for(int a =0;a<10;a++) {   
		    for(int b =0;<a++) {   

	      
		    JFrame gui;        //making frame called gui
		    gui=new JFrame();  
		    JPanel panel = new JPanel();
		   JButton button = new JButton(""); 
  	 
  	int [][]num = null;
	    num [a][b] = num[a][b]; 
		JLabel label = new JLabel();   		
		
	
	    
  						//Using for-loop to generate 100 button 
  	panel(gui.add(button)); // adding buttons into the frame  
  
  	panel.add(label);
   
   button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
          
              label.setVisible(true);
          }
   
	   
  
   
   });
	    
	    
	    gui.setLayout(new GridLayout(10,10));  // setting grid layout 10 by 10   
	    gui.setSize(500,500);
	    gui.setTitle("Minesweepter");
	    gui.setVisible(true); 
	   	gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
	  }
