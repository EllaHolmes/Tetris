import java.awt.Color;

//TetrisBoard.java
//Ella Holmes
//October 16 2014


public class TetrisBoard
{

	/********** VARIABLES ***********/
	//These are the size coordinates of the board and 2d Array
	//row is 20 because the array is 19 X 10 where the first row
	//is not drawn due to rotational preferences
	public static int ROW = 19;
	public static int COLUMN = 10;

	//create2 2d arrays so that one can deal with the logic
	private int[][] logicBoard = new int[ROW][COLUMN];

	//variables to where the tetro is placed on the board
	private int tetroY = 0;
	private int tetroX = 3;

	//vaiables to where the tetro attempts to be placed in the board
	private int nextY = 0;
	private int nextX = 3;

	//rotateNum is += 1 if clicked clockwise
	//and -= 1 if clicked counterClockwise
	//this is 4 because there are 4 rotation
	//position in each shape and 4 % 4 = 0
	private int rotateNum = 4;
	private int nextR = 4;

	//create new is looked at by the tetrisApplication
	//this indicated weather a new tetro should be added 
	//to the board. this is redefined in the settle method
	//and then again the the tetris App. if statement.
	public boolean createNew = false;

	//score is added whenever a line is cleared
	private int score = 0;
	private int numTetris = 0;
	
	//time in mill-sec that is updated once score is a multiple of 10
	private int speed = 1000;
	


	/******* CONSTRUCTOR **********/
	//Created in the TetrisGame Class
	public TetrisBoard()
	{

		//create the board
		initBoard();

	}


	/******** METHODS *************/

	/******************************************
	 * when first called initiate every spot in the 2dArray Board as empty
	 * other times it reads what to keep on the board or erase. this is 
	 * determined by numerical values.
	 */
	private void initBoard()
	{
		//Start by creating a double for loop size of the board
		for(int i = 0; i < ROW; i++ )
		{
			for(int j = 0; j < COLUMN; j++ )
			{
				//if there is a settled tetro (1)
				if ( logicBoard[i][j] == 1)
				{
					//keep that tetro there
					logicBoard[i][j] = 1;
				}

				//if there is a falling tetro (2)
				else if( logicBoard[i][j] == 2)
				{
					//erase the it! we do this
					//because we redraw the moving tetro
					//so it looks like its moving
					logicBoard[i][j] = 0;
				}

				//if it is any other spot
				else
				{
					//the spot is empty (0)
					logicBoard[i][j] = 0;
				}
			}
		}
	}


	/******************************************
	 * update board is called when a tetro passes all of the
	 * check move methods and conditions it adds the tetro
	 * starting at the desired x, y coordinates
	 */
	public void updateBoard( int[][] tetro)
	{
		//Since it is safe to move to the desired location
		//change the constants to the new values
		tetroY = nextY;
		tetroX = nextX;
		rotateNum = nextR;

		//Initialize the board. it erases the previous 
		//location (2) so we can draw the new location of (2)
		initBoard();

		//for the whole tetro piece
		for(int i = 0; i<4; i++)
		{
			for (int j = 0; j <4; j++)
			{
				if (tetro[i][j] == 1)
				{
					//add the tetris to the board with the new x and y
					logicBoard[tetroY + i][ tetroX + j] = 2;
				}
			}
		}		
	}


	/******************************************
	 * this method will check to see if the destination the new 
	 * tetro will move is possible if not it redraws the previous shape.
	 */
	public void checkMove( TetrisPiece tetro)
	{
		//retrieve the shape of the created tetro
		int[][][] testTetro = tetro.getLocation();
		

		//calculate the desired rotational position
		//is absolutle value b/c mod can be negative
		int r = Math.abs( nextR % 4);

		//check if the tetro piece voilated any of the other conditions
		int clear = checkCollision( testTetro[r], nextX, nextY);

		//If all 4 blocks of the tetris piece pass the conditions
		if(clear == 4)
		{
			
			//Update the board with the new tetro
			updateBoard( testTetro[r] );

			//Check if the tetro is above another tetro
			checkBelow();
		}

		//If tetro does not pass the check methods
		else
		{
			//Then reset all the variable to what they 
			//were before a user command changed the value.
			nextX = tetroX;
			nextY = tetroY;
			nextR = rotateNum;
		}	
	}


	/******************************************
	 * Called by Check Move. This determines if the movement is valid
	 * or not. If it is valid, checkCollision should return 4.
	 */
	public int checkCollision( int[][] tetro, int x, int y)
	{
		//empty int that will be added to if none of the conditions
		//are true to any of the 4 squares in the tetro.
		int checked = 0;

		//for loop that will go through the 4 X 4 tetro array
		for(int i = 0; i<4; i++)
		{
			for (int j = 0; j <4; j++)
			{
				//for the shape of the tetro
				if (tetro[i][j] == 1)
				{
					//if any part of tetro trys to move 
					//past the bottom of the tetris board
					if( y + i >= logicBoard.length)
					{
						//settle the tetro and create another.
						settle();
					}

					//if tetro tries to go off the top of the board 
					//(think rotation although this may not ever occur)
					else if( y+i < 0 )
					{
						//DO NOTHING

					}

					//if tetro tries to go off the right of the board 
					else if( x + j >= logicBoard[0].length)
					{
						//DO NOTHING

					}

					//if tetro tries to go off the left of the board
					else if( x+j < 0 )
					{
						//DO NOTHING

					}

					//if current tetro tries to move into a settled tetro
					else if( logicBoard[y+i][x+j] == 1)
					{
						//DO NOTHING
					}

					//if none of these conditions are violated
					else
					{
						//then that one block of the tetris piece passes
						checked += 1;
					}
				}	
			}
		}
		return checked;
	}


	/******************************************
	 * Invoked from check move. checkBelow detects
	 * if there is a piece below. if so it will settle.
	 */
	public void checkBelow()
	{
		//look through the whole board except for the bottom line
		for(int i = 0; i<ROW - 1; i++)
		{
			for (int j = 0; j <COLUMN; j++)
			{
				//if there is currently moving tetro sitting ontop of a settled tetro
				if (logicBoard[i][j] == 2 && logicBoard[i + 1][j] == 1)
				{
					//add that tetro to the landscape
					settle();
				}			
			}
		}
	}


	/******************************************
	 * when all tetrominos has reached the bottom and 
	 * can no longer move, create a new tetromino
	 */
	private void settle()
	{
		//search through the whole logicBoard
		for(int i = 0; i < ROW; i++ )
		{
			for(int j = 0; j < COLUMN; j++ )
			{
				//if it was a moving tetris (2)
				if( logicBoard[i][j] == 2)
				{
					//make it a perminate tetris
					logicBoard[i][j] = 1;
				}
			}
		}

		//check if there are any full rows
		lineFull();

		//reset the X,Y values to the original state
		nextY = 0;
		nextX = 3;
		tetroY = 0;
		tetroX = 3;
		rotateNum = 4;

		//Indicate that a new tetro needs to be made
		createNew = true;
	}


	/******************************************
	 * Called from settled. When there is a whole line that 
	 * is full this clears the line and moves everything down
	 */
	private void lineFull()
	{
		//empty int that is added to when there's are 4 full lines
		//Keeps track of a "Tetris"
		int fourLines = 0;

		//Look through the whole tetris board
		for(int i = 0; i < ROW; i++ )
		{
			//empty int that stores how many 1 are in row i
			int fullLine = 0;

			for(int j = 0; j < COLUMN; j++ )
			{
				//If there is a 1 (a settled tetris)
				if( logicBoard[i][j] == 1)
				{
					//add one/ count the tetris piece
					fullLine += 1;
				}

				//If the line is full (a full row of tetris)
				if( fullLine == 10)
				{
					//Update the score by one
					score += 1;
					checkTime();

					//and one to fourLines
					fourLines += 1;

					//then clear that line i and
					//move everything above i down one.
					clearAndShift( i );
				}
			}
		}

		//If fourLines = 4, meaning a "Tetris"
		if(fourLines == 4)
		{
			//Add 1 to the Tetris Score.
			numTetris += 1;
		}  
	}


	/******************************************
	 * Invoked from lineFull(). If there is a full line
	 * this will clear that line and move all the tetrises
	 * above line l to shift down a row.
	 */
	private void clearAndShift( int l)
	{
		//Starting at the full row and working up (-1) the tetrisBoard
		for(int i = l; i > 0; i-- )
		{  
			for(int j = 0; j < COLUMN; j++)
			{
				logicBoard[i][j] = 0;
				
				//make that row equal to the row above it.
				logicBoard[i][j] = logicBoard[i - 1][j];
			}
		}

		//Refresh the board with its new values.
		initBoard();
	}

	
	private void checkTime()
	{
		if( score % 10 == 0 && score != 0)
		{
			speed /= 2;
		}
	}

	/******************************************
	 *Below are all the getters and setter used
	 *they are all called in the TetrisGame class
	 */
	//LogicBoard goes to Application then 
	//sent to view to be printed
	public int[][] getLogicBoard(){
		return logicBoard;}

	//so does the score( # lines cleared)
	public int getScore(){
		return score;}

	//and numTetris( # of 4 lines cleared in a row)
	public int getNumTetris(){
		return numTetris;}

	//used by application to determine if another
	//tetro should be made
	public boolean getCreateNew(){
		return createNew;}
	
	public int getSpeed(){
		return speed;}

	//invoked in TG userCommand. x = +-1
	public void setNextX( int x){
		nextX += x;}

	//invoked in TG userCommand. y = +1
	public void setNextY( int y){
		nextY += y;}

	//Once new piece is created set back to false
	public void setCreateNew( boolean create){
		createNew = create;}

	//invoked in TG userCommand. r = +-1
	public void setRotate( int r){
		nextR += r;}
	
}
