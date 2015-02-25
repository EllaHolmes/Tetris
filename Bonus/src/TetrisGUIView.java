//TetrisGUIView.java
//Ella Holmes

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;


public class TetrisGUIView extends JPanel
{
    /****** Constructor *******/
    public TetrisGUIView()
    {
    	//create boarderLayout for  placement
    	super(new BorderLayout());  	
    }

    /*************** Methods *******************/

    /**
     * shows directions and scores
     */
    public String display( int lines, int fourLines)
    {
    	//create the JTextArea and display the directions for the user to play game
    	String directions = "Control using Arrow Keys or l,r,d,z,x \n Tetrises Cleared: " + fourLines +"\nLines Cleared: " + lines;
    	
    	return directions;
    }
    
    
    /**
     * prints the updated board
     */
    public void drawBoard( int[][] myBoard, Graphics g, Color myColor)
    {
    	
    	//Go through the whole 2d array, except for row 0.
    	//this is for the sake of symmetric rotation and is based
    	//of of the "real" game of tetris. see: https://www.freetetris.org/game.php
    	for(int i = 1; i < TetrisBoard.ROW; i++ )
    	{
    		for(int j = 0; j < TetrisBoard.COLUMN ; j++ )
        	{
    			//If block has no tetro
    			if( myBoard[i][j]== 0)
    			{
    				drawBlock( Color.WHITE, i, j,g);	
    			}
    			
    			//If block is moving tetris
    			else if( myBoard[i][j] == 2)
    			{
    				drawBlock( myColor, i, j,g);	
    			}
    			
    			//If block is a settled tetris
    			else if( myBoard[i][j] == 1)
    			{
    				drawBlock( Color.black, i, j,g);
    			}	
        	}
    	}
    }
    
    //This is called by the drawBoard method. Deals with the graphics 
    // and shows what appears in the gui
    public void drawBlock( Color myColor, int y, int x, Graphics g)
    {
    	//set color of graphic
    	g.setColor(myColor);
    	
    	//draw graphic ** really import that color is defined before**
    	g.fillRect(x*21,45+y*21,20,20);
    	
    }
}
