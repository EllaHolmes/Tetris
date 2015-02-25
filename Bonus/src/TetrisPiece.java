import java.awt.Color;

//TetrisPiece.java
//Ella Holmes
//October 16 2014


//This is an abstract class because all of the tetris Pieces share the same qualities
public abstract class TetrisPiece
{
	/************** VARIABLES ****************/
	//because the children of this class are all 
	//using this variable, make it protected
	//this holds the shape and rotation
	//[rotation] [y axis] [x axis]
	protected int[][][] location;
	
	protected Color myColor;
	

	/*********** CONSTUCTOR **********/
	//TetrisPiece is created in the TetrisGame Class
	public TetrisPiece()
	{
		//create the piece in all 4 different
		//rotation locations in a int 3D array
		createPiece();
	}


	/************ METHODS *************/

	//do not define because it is abstract and
	//will be defined in each instance subclass
	//This will define location[][][]
	public abstract void createPiece();

	//returns location when called in the TetrisBoard class
	//there the tetro is moved and added to the board if it can 
	public int[][][] getLocation() {
		//return the mod of rotateNum b/c it is 
		//the variable that is changed based on args
		//must be the absolute value because mod can return a negative int
		return location; }
	
	public Color getColor()
	{
		return myColor;
	}
}
