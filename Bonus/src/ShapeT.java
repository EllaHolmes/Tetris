import java.awt.Color;

//ShapeT.java
//Ella Holmes

public class ShapeT extends TetrisPiece
{
    /**VARIABLES**/

    /**CONSTRUCTOR**/
	public ShapeT()
	{
		super();
	}
	
	/** METHODS**/
	public void createPiece()
	{
		myColor = Color.MAGENTA;
		location = new int[][][]
				{
				{
					{ 0, 0, 0, 0},
					{ 1, 1, 1, 0},
					{ 0, 1, 0, 0},
					{ 0, 0, 0, 0},
				},
				{
					{ 0, 1, 0, 0},
					{ 1, 1, 0, 0},
					{ 0, 1, 0, 0},
					{ 0, 0, 0, 0},
				},
				{
					{ 0, 1, 0, 0},
					{ 1, 1, 1, 0},
					{ 0, 0, 0, 0},
					{ 0, 0, 0, 0},
				},
				{
					{ 0, 1, 0, 0},
					{ 0, 1, 1, 0},
					{ 0, 1, 0, 0},
					{ 0, 0, 0, 0},
				},
				};
	}
}
