import java.awt.Color;


//ShapeO.java
//Ella Holmes


public class ShapeO extends TetrisPiece
{
    /**VARIABLES**/

    /**CONSTRUCTOR**/
	public ShapeO()
	{
		super();
	}
	
	/** METHODS**/
	public void createPiece()
	{
		myColor = Color.ORANGE;
		location = new int[][][]
				{
				{
					{ 0, 0, 0, 0},
					{ 0, 1, 1, 0},
					{ 0, 1, 1, 0},
					{ 0, 0, 0, 0},
				},
				{
					{ 0, 0, 0, 0},
					{ 0, 1, 1, 0},
					{ 0, 1, 1, 0},
					{ 0, 0, 0, 0},
				},
				{
					{ 0, 0, 0, 0},
					{ 0, 1, 1, 0},
					{ 0, 1, 1, 0},
					{ 0, 0, 0, 0},
				},
				{
					{ 0, 0, 0, 0},
					{ 0, 1, 1, 0},
					{ 0, 1, 1, 0},
					{ 0, 0, 0, 0},

				},
				};
	}
}
