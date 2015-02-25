//TetrisGUIControler.java
//Ella Holmes

import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.JPanel;

public class TetrisGUIControler extends JPanel implements KeyListener
{
	/** Variables **/
	//promt instances of classes
	private TetrisGame tetrisGame;
	private TetrisGUIView tetrisGUIView;

	//create JText area for directions
	private JTextArea text = new JTextArea();
	
	private Timer simulationTimer;

	/****** Constructor ********/
	public TetrisGUIControler()
	{	
		//Call super constructor of JPanel while making 
		//a border layout for the panels
		super(new BorderLayout());

		//For some reason you need this for this to 
		//respond the the key listener
		setFocusable(true);
		//then add the key listener to this panel
		addKeyListener( this );

		//create an instance of the classes
		tetrisGame = new TetrisGame();
		tetrisGUIView = new TetrisGUIView();

		// don't let the user change the text
		text.setEditable( false );
		//wrap the line
		text.setLineWrap( true );
		// wrap without splitting words
		text.setWrapStyleWord(true);

		//add text and grid to this jpanel 
		add(text, BorderLayout.NORTH);
		add(tetrisGUIView, BorderLayout.CENTER);

		//now create the timer
		createTimer();

	}

	/**
	 * These 3 methods below allow for the keyboard 
	 *send the user Command and control the game
	 */ 
	public void keyPressed(KeyEvent e)
	{
		//if key is pressed send the key to the user command method
		tetrisGame.userCommand( (char) e.getKeyCode() );

		//call play game so there is no delay with the 
		//graphics
		playGame();

		//Then repaint the board
		repaint();
	}

	//Don't need to use this method
	public void keyReleased(KeyEvent e){}

	//Don't need to use this method
	public void keyTyped(KeyEvent e){}


	/*
	 *This method is required to use graphics
	 *this is called when repaint() is called
	 *This updates the information for the GUIView
	 */
	public void paint( Graphics g)
	{
		// update the view
		text.setText( tetrisGUIView.display( tetrisGame.getScore(), tetrisGame.getNumTetris()) );
		tetrisGUIView.drawBoard( tetrisGame.getLogicBoard(), g, tetrisGame.getColor());
	}

	/*
	 * As the controller, create a timer to advance time i.
	 */
	public void createTimer()
	{
		// create a timer to advance the physics engine
		simulationTimer = new Timer( tetrisGame.getSpeed() , new ActionListener( ){

			public void actionPerformed(ActionEvent e)
			{
				// advance the physics world
				tetrisGame.userCommand( (char) KeyEvent.VK_DOWN );

				//Play game (check if another tetris is made)
				playGame();

				//repaint every second
				repaint();
			}

		} );

		// start the simulation
		simulationTimer.start();

	}


	/**
	 * This Method checks if another tetris needs to be made
	 */
	private void playGame()
	{
		//get newtetro?
		boolean create = tetrisGame.getCreateNew();

		//if new tetro needs to be made
		if( create == true)
		{
			//make the new tetro
			tetrisGame.randomTetro();

			//and set the createNew variable to false again
			tetrisGame.setCreateNew(false);
			
			simulationTimer.setDelay(tetrisGame.getSpeed());
			
			System.out.println(tetrisGame.getSpeed());

			//draw the board with the new tetro immediately after created
			repaint();
		}
	}
	
}




