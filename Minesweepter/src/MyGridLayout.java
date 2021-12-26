import java.awt.*;    
import javax.swing.*;    
public class MyGridLayout{    
JFrame gui;    
MyGridLayout(){ 
	
    gui=new JFrame(); 
    
    for(int i= 0;i<100;i++) {
    	JPanel p1 = new JPanel();
    	JPanel p2 = new JPanel();
    	
    	JButton buttoni = new JButton(); 
    	gui.add(buttoni);
    	
    	 
    	
    }
   /* 
    JButton b1=new JButton("1");    
    JButton b2=new JButton("2");    
    JButton b3=new JButton("3");    
    JButton b4=new JButton("4");    
    JButton b5=new JButton("5");    
    JButton b6=new JButton("6");    
    JButton b7=new JButton("7");    
    JButton b8=new JButton("8");    
    JButton b9=new JButton("9");    
     // adding buttons to the frame     
    
   */
    // setting grid layout of 3 rows and 3 columns    
    gui.setLayout(new GridLayout(10,10));    
    gui.setSize(500,500);    
    gui.setVisible(true); 
    gui.setTitle("MineSweepter");
  
    
    
}  
public void paintComponent(Graphics g) {
	   g.setColor(Color.GREEN);
	   g.fillRect(0, 0,3, 3);
	}
public static void main(String[] args) {    
    new MyGridLayout();    
}    
}  
