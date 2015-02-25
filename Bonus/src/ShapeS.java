import java.awt.Color;

//ShapeS.java
//Ella Holmes

public class ShapeS extends TetrisPiece
{
    /**VARIABLES**/

    /**CONSTRUCTOR**/
	public ShapeS()
	{
		super();
	}
	
	/** METHODS**/
	public void createPiece()
	{
		myColor = Color.YELLOW;
		location = new int[][][]
				{
				{
					{ 0, 0, 0, 0},
					{ 0, 0, 1, 1},
					{ 0, 1, 1, 0},
					{ 0, 0, 0, 0},

				},
				{
					{ 0, 0, 1, 0},
					{ 0, 0, 1, 1},
					{ 0, 0, 0, 1},
					{ 0, 0, 0, 0},

				},
				{
					{ 0, 0, 0, 0},
					{ 0, 0, 1, 1},
					{ 0, 1, 1, 0},
					{ 0, 0, 0, 0},

				},
				{
					{ 0, 0, 1, 0},
					{ 0, 0, 1, 1},
					{ 0, 0, 0, 1},
					{ 0, 0, 0, 0},

				},
				};
	}
}
