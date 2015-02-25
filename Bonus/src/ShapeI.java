import java.awt.Color;

//ShapeI.java
//Ella Holmes

public class ShapeI extends TetrisPiece
{
    /**VARIABLES**/

    /**CONSTRUCTOR**/
	public ShapeI()
	{
		super();
	}

	/** METHODS**/
	public void createPiece()
	{
		myColor = Color.BLUE;
		location = new int[][][]
				{
				{
					{ 0, 0, 0, 0},
					{ 1, 1, 1, 1},
					{ 0, 0, 0, 0},
					{ 0, 0, 0, 0},
				},
				{
					{ 0, 1, 0, 0},
					{ 0, 1, 0, 0},
					{ 0, 1, 0, 0},
					{ 0, 1, 0, 0},
				},
				{
					{ 0, 0, 0, 0},
					{ 1, 1, 1, 1},
					{ 0, 0, 0, 0},
					{ 0, 0, 0, 0},
				},
				{
					{ 0, 1, 0, 0},
					{ 0, 1, 0, 0},
					{ 0, 1, 0, 0},
					{ 0, 1, 0, 0},
				},
				};
	}
}
