import java.awt.Color;

//ShapeL.java
//Ella Holmes

public class ShapeL extends TetrisPiece
{
    /**VARIABLES**/

    /**CONSTRUCTOR**/
	public ShapeL()
	{
		super();
	}

    /** METHODS**/
    public void createPiece()
    {
    	myColor = Color.GREEN;
    	location = new int[][][]
    			{
    			{
    				{ 0, 0, 0, 0},
    				{ 1, 1, 1, 0},
    				{ 1, 0, 0, 0},
    				{ 0, 0, 0, 0},
    			},
    			{
    				{ 0, 1, 0, 0},
    				{ 0, 1, 0, 0},
    				{ 0, 1, 1, 0},
    				{ 0, 0, 0, 0},
    			},
    			{
    				{ 0, 0, 1, 0},
    				{ 1, 1, 1, 0},
    				{ 0, 0, 0, 0},
    				{ 0, 0, 0, 0},
    			},
    			{
    				{ 1, 1, 0, 0},
    				{ 0, 1, 0, 0},
    				{ 0, 1, 0, 0},
    				{ 0, 0, 0, 0},
    			},
    			};
    }
}
