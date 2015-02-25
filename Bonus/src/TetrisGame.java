//TetrisGame.java
//Ella Holmes
//October 16 2014

import java.awt.Color;
//import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class TetrisGame
{
    /********************* VARIABLES **********************/
	//create the tetris board
	TetrisBoard tetrisBoard;
	
	//the current Tetris piece that is randomly generated
	//should be the only piece reacting to commands
    private TetrisPiece currentTetro;
    
    //assign numbers to the shapes for the switch 
    //statement in randomTetro method. These are required
    //by the switch statement to be final variables.
    final private int I = 0;
    final private int J = 1;
    final private int L = 2;
    final private int O = 3;
    final private int S = 4;
    final private int T = 5;
    final private int Z = 6;


    /******************** CONSTRUCTORS ********************/
    //Created from the TetrisApplication class
    public TetrisGame()
    {
		//create the tetris board
		tetrisBoard = new TetrisBoard();
		
    	//when object TetrisGame is first created
    	//create a random tetro.
    	randomTetro();
    }


    /********************* METHODS *********************/
    
    /**
     * randomly picks and creates a tetromino
     */
    public void randomTetro()
    {
    	//randomly generate a number btw 0 and 6
    	//Math.floor() rounds it down to an int.
    	int tetroType = (int) Math.floor( Math.random() * 7 );

    	//Switch statement determines what tetro to create
    	//based on the randomly generated number.
    	//"break" ends the case search.
    	switch( tetroType )
    	{
    	case I: 
    		currentTetro = new ShapeI();
    		break;
    	case J:
    		currentTetro = new ShapeJ();
    		break;
    	case L:
			currentTetro = new ShapeL();
			break;
    	case O:
			currentTetro = new ShapeO();
			break;
    	case S:
			currentTetro = new ShapeS();
			break;
    	case T:
			currentTetro = new ShapeT();
			break;
    	case Z:
			currentTetro = new ShapeZ();
			break;
    	}
    	
		//pass the current piece and pass it to Tetris Board
    	//it must go through check move to make it to the board.
		tetrisBoard.checkMove(currentTetro);
    }


	
    
	 /**
     * takes the users demand and sets 
     * the relevant TetrisBoard variables
     */
	public void userCommand( char e )
	{	
		switch( e )
		{
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_D:
			setNextY( 1 );
			break;

		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_R:
			tetrisBoard.setNextX( 1 );
			break;

		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_L:
			tetrisBoard.setNextX( -1 );
			break;

		case KeyEvent.VK_UP:
		case KeyEvent.VK_X:
			tetrisBoard.setRotate( 1 );
			break;

		case KeyEvent.VK_Z:   
			tetrisBoard.setRotate( -1 );
			break;
		}
		
		tetrisBoard.checkMove( currentTetro);
	}
    
    
    /**
     *Below are all the getters and setters so the Tetris Application
     *can gather information from the board and the board can update its
     *Variable that are manipulated in this tetris Game Class.
     */
    public TetrisPiece getcurrentTetro(){
		return currentTetro;}
    
    
    public int getScore(){
    	int score = tetrisBoard.getScore();
    	return score;}
    
    
    public int getNumTetris(){
    	int numTetris = tetrisBoard.getNumTetris();
    	return numTetris;}
    
    
    public int[][] getLogicBoard(){
    	int[][] logicBoard = tetrisBoard.getLogicBoard();
    	return logicBoard;}
    
    
    public boolean getCreateNew(){
    	boolean createNew = tetrisBoard.getCreateNew();
    	return createNew;}
    
    
    public void setCreateNew( boolean create){
    	tetrisBoard.setCreateNew( create );}
    
    public void setNextY( int y){
    	tetrisBoard.setNextY( y );}
    
    public Color getColor()
    {
    	return currentTetro.getColor();
    }
    
	public int getSpeed(){
		return tetrisBoard.getSpeed();}

}
