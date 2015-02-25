import java.awt.Color;

//ShapeJ.java
//Ella Holmes

public class ShapeJ extends TetrisPiece
{
    /**VARIABLES**/

    /**CONSTRUCTOR**/
	public ShapeJ()
	{
		super();
	}
	
    /** METHODS**/
    public void createPiece()
    {
    	myColor = Color.CYAN;
    	location = new int[][][]
       {
    		{
           	 { 0, 0, 0, 0},
   	   		 { 1, 1, 1, 0},
    	   	 { 0, 0, 1, 0},
      		 { 0, 0, 0, 0},
       		},
	    	{
   	       	 { 0, 1, 0, 0},
   	   		 { 0, 1, 0, 0},
       		 { 1, 1, 0, 0},
         	 { 0, 0, 0, 0},
   	      	},
   	      	{
       		 { 1, 0, 0, 0},
   	      	 { 1, 1, 1, 0},
   	      	 { 0, 0, 0, 0},
       		 { 0, 0, 0, 0},
       		},
   	  		{
       		{ 0, 1, 1, 0},
           	{ 0, 1, 0, 0},
           	{ 0, 1, 0, 0},
       		{ 0, 0, 0, 0},
   	       	},
   	   	};
    }
}
