
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;  
	
	public class Grid  {
		
		private int numRows =10;
		private int numColumns=10;
		private	int numBombs;
		private boolean bombGrid[ ][ ];
		private int countGrid[][];
	
		
	
	public Grid() {
		numRows=10;
		numColumns=10;
		numBombs = 25;
		bombGrid = new boolean[numRows][numColumns];
		
		countGrid= new int[numRows][numColumns];
		//(rows x columns Grid), default value of 25 bombs 
		//overload construtorS
		createBombGrid();
		createCountGrid();
		
		//10 rows, 10 columns, (10 x 10 Grid), 25 bombs
	}
	public Grid(int rows, int columns) {
	
		this.numRows = rows;
		this.numColumns = columns;
		numBombs =25;
		 //(rows x columns Grid), default value of 25 bombs 	
		bombGrid = new boolean[this.numRows][this.numColumns];
		countGrid= new int[this.numRows][this.numColumns];
		createBombGrid();
		createCountGrid();
	
	}
	
	public Grid(int rows, int columns, int numBombs) {
		this.numRows= rows;
		this.numColumns = columns;
		
		if(numBombs!=25) {
			this.numBombs= numBombs;
		}
		bombGrid = new boolean[this.numRows][this.numColumns];
		countGrid= new int[this.numRows][this.numColumns];
		
		
		createBombGrid();
		createCountGrid();
		
		
		
		
		
	
	}
	
	
	
	public int getNumRows() {
		return this.numRows;
	}
	
	public int getNumColumns() {
		return this.numColumns;
	}
	public int getNumBombs() {
		return this.numBombs;
	}
	
	public boolean [][]getBombGrid(){
		return this.bombGrid;
	}
	public int [][]getCountGrid(){
		
		return countGrid;
	}
	
	public boolean isBombAtLocation(int rows, int columns) {
	

			if(rows >=0 && columns >= 0 && rows < numRows && columns < numColumns && bombGrid[rows][columns] == true){
			return true;
			}
			return false;
			}

	

	
	public int getCountAtLocation(int row, int column) {
		
		int currentValue = 0;
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				
		
						
					int count = 0;
				//current row location start
					if(i>0&&isBombAtLocation(i+1,j)==true&&j>0&&isBombAtLocation(i+1,j)) { //current left 
						count ++;
					}
					if(i>0&&isBombAtLocation(i,j)==true&&j>0&&isBombAtLocation(i,j)) { //current
						count ++;
					}
					if(i>0&&isBombAtLocation(i,j+1)==true&&j>0&&isBombAtLocation(i,j+1)==true) { //current right
						count ++;
					}
			
				// end curent row location
					
				//up one row start , 3 spot, 
					if(i>0&&isBombAtLocation(i-1,j-1)==true&&j>0&&isBombAtLocation(i-1,j-1)==true) { // left up one
						count ++;
					}
					if(i>0&&isBombAtLocation(i-1,j-1)==true&&j>0&&isBombAtLocation(i-1,j-1)==true) { // up one
						count ++;
					}
					if(i>0&&isBombAtLocation(i-1,j+1)==true&&j>0&&isBombAtLocation(i-1,j+1)==true) { // right up one
						count ++;
					}
					
					///end one row end
					
					///down one row start//
					if(i>0&&isBombAtLocation(i+1,j-1)==true&&j>0&&isBombAtLocation(i+1,j-1)==true) { //down one left
						count ++;
					}
					if(i>0&&isBombAtLocation(i+1,j+1)==true&&j>0&&isBombAtLocation(i+1,j+1)==true) { //down one  
						count ++;
					}
					if(i>0&&isBombAtLocation(i+1,j)==true&&j>0&&isBombAtLocation(i+1,j)==true) { //down one right
						count ++;
					}
																				
				
					//down one end
					
					
				countGrid[i][j] = count;
				currentValue= count;
				
					}
			
					}
		return currentValue;
		
				
	}
	
	
	
	public void createBombGrid() {
		
		
		if (getNumBombs()==25) {  ///check delfault value is it the same as user input value for bombs
			for(int a=0;a<getNumBombs();a++) {
			Random random = new Random();
			
			int randomRows= random.nextInt(100);
			int randomColumns= random.nextInt(100);
			
			

		  // randomly putting true or false into the bombgrid until it reach to 100 cell.
		    
				if (isBombAtLocation(randomRows,randomColumns)==true) {	
				//randomBombGrid[randomRows][randomColumns]=true;
				bombGrid[randomRows][randomColumns]=true;
		//check if its true if not bomb is generated
				//if it's equal to false it wont do anything
				}else {
					
					for(int i=0;i<this.numRows;i++){
						for(int j=0;j<this.numColumns;j++){
						
						if(isBombAtLocation(this.numRows,this.numColumns)!=true) {
					bombGrid[i][j]=false;
				}
				
					
						
		 else if(getNumBombs()!=25) {
			 numBombs= getNumBombs();
			 for(int b=0;b<numBombs;a++) {
					Random random1 = new Random();
					
					int randomRows1= random1.nextInt(100);
					int randomColumns1= random1.nextInt(100);
					
					

				  // randomly putting true or false into the bombgrid until it reach to 100 cell.
				    
						if (isBombAtLocation(randomRows1,randomColumns1)==true) {	
						//randomBombGrid[randomRows][randomColumns]=true;
						bombGrid[randomRows1][randomColumns1]=true;
				//check if its true if not bomb is generated
						//if it's equal to false it wont do anything
						}else {
							
							for(int x=0;i<this.numRows;i++){
								for(int y=0;j<this.numColumns;j++){
								
								if(isBombAtLocation(this.numRows,this.numColumns)!=true) {
							bombGrid[x][y]=false;
						}
								}
							}
						}
			 }
		 }
						}
			
					}
				}
			}
		}
		}
				
		
	
				
		
				
	
		
		
	
	

	public void createCountGrid() {
		
			
		//called by constructors to create and populate countGrid from bombGrid
		// Scanner sc = new Scanner(System.in);
		for(int i=0;i<this.numRows;i++){
			for(int j=0;j<this.numColumns;j++){
				
				
			int count = 0;
		//current row location start
			if(i>0&&isBombAtLocation(i+1,j)==true&&j>0&&isBombAtLocation(i+1,j)) { //current left 
				count ++;
			}
			if(i>0&&isBombAtLocation(i,j)==true&&j>0&&isBombAtLocation(i,j)) { //current
				count ++;
			}
			if(i>0&&isBombAtLocation(i,j+1)==true&&j>0&&isBombAtLocation(i,j+1)==true) { //current right
				count ++;
			}
	
		// end curent row location
			
		//up one row start , 3 spot, 
			if(i>0&&isBombAtLocation(i-1,j-1)==true&&j>0&&isBombAtLocation(i-1,j-1)==true) { // left up one
				count ++;
			}
			if(i>0&&isBombAtLocation(i-1,j-1)==true&&j>0&&isBombAtLocation(i-1,j-1)==true) { // up one
				count ++;
			}
			if(i>0&&isBombAtLocation(i-1,j+1)==true&&j>0&&isBombAtLocation(i-1,j+1)==true) { // right up one
				count ++;
			}
			
			///end one row end
			
			///down one row start//
			if(i>0&&isBombAtLocation(i+1,j-1)==true&&j>0&&isBombAtLocation(i+1,j-1)==true) { //down one left
				count ++;
			}
			if(i>0&&isBombAtLocation(i+1,j+1)==true&&j>0&&isBombAtLocation(i+1,j+1)==true) { //down one  
				count ++;
			}
			if(i>0&&isBombAtLocation(i+1,j)==true&&j>0&&isBombAtLocation(i+1,j)==true) { //down one right
				count ++;
			}
																		
		
			//down one end
			
			
			countGrid[i][j] = count;
			}
			}
		}
	
	


		
		
	
	
	public class Minesweepter {

	
		public void main(String args[]){
			
	
		   
		  Grid grid = new Grid(); 
		   
		    boolean[][] bombGrid = null;
		    int[][] countGrid = grid.getCountGrid();
		 
		
	
		    for(int r=0;r<grid.getNumRows();r++){
		    for(int c=0;c<grid.getNumColumns();c++){
		    System.out.print(bombGrid[r][c] + " ");
		    }
		    System.out.println();
		    }

		    for(int rr=0;rr<grid.getNumRows();rr++){
		    for(int cc=0;cc<grid.getNumColumns();cc++){
		    System.out.print(countGrid[rr][cc] + " ");
		    
		    }
		    System.out.println();
		    }  
		
		    class MyGridLayout{    
		    	JFrame gui;    
		    	MyGridLayout(){ 
		    		
		    	    gui=new JFrame(); 
		    	    
		    	    for(int i= 0;i<100;i++) {
		    	    	JPanel p1 = new JPanel();
		    	    	JPanel p2 = new JPanel();
		    	    	
		    	    	JButton buttoni = new JButton(); 
		    	    	gui.add(buttoni);
		    	    	
		    	    	 
		    	    	
		    	    }
		    	   
		    	
		    	    // setting grid layout of 10 rows and 10 columns    
		    	    gui.setLayout(new GridLayout(10,10));    
		    	    gui.setSize(500,500);    
		    	    gui.setVisible(true); 
		    	    gui.setTitle("MineSweepter");
		    	    gui.setResizable(false);
		    	  
		    	    
		    	    
		    	}  
		    	public void paintComponent(Graphics g) {
		    		   g.setColor(Color.GREEN);
		    		   g.fillRect(0, 0,3, 3);
		    		
		          
		    	}    
	
	
		
		    }
		}
	}
	}
			    
		    
		    
	
	







	
	
		   
	


	






	
	
		   
	


	