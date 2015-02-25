import java.awt.Color;

//ShapeZ.java
//Ella Holmes

public class ShapeZ extends TetrisPiece
{
    /**VARIABLES**/

    /**CONSTRUCTOR**/
	public ShapeZ()
	{
		super();
	}

	/** METHODS**/
	public void createPiece()
	{
		myColor = Color.RED;
		location = new int[][][]
				{
				{
					{ 0, 0, 0, 0},
					{ 1, 1, 0, 0},
					{ 0, 1, 1, 0},
					{ 0, 0, 0, 0},
				},
				{
					{ 0, 1, 0, 0},
					{ 1, 1, 0, 0},
					{ 1, 0, 0, 0},
					{ 0, 0, 0, 0},
				},
				{
					{ 0, 0, 0, 0},
					{ 1, 1, 0, 0},
					{ 0, 1, 1, 0},
					{ 0, 0, 0, 0},
				},
				{
					{ 0, 1, 0, 0},
					{ 1, 1, 0, 0},
					{ 1, 0, 0, 0},
					{ 0, 0, 0, 0},
				},
				};
	}
}
