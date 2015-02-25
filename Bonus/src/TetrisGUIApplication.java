//TetrisGUIApplication.java
//Ella Holmes

//swing
import javax.swing.JFrame;

public class TetrisGUIApplication
{

    public static void main( String[] args )
    {
    	//create the JFame called tetrisFrame
    	JFrame tetrisFrame = new JFrame();
    	
    	//Set size of the JFrame
    	tetrisFrame.setSize(210, 470);
    	
    	//Add the TetrisGUIControler to the JFrame
    	tetrisFrame.add( new TetrisGUIControler() );

    	//Make the JFrame close on Command
    	tetrisFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    	
    	//set the JFrame Visible
    	tetrisFrame.setVisible( true );   	

    }
}
