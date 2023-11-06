package picasso.view;



import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import picasso.model.Pixmap;
import picasso.util.ThreadedCommand;
import picasso.view.commands.*;

/**
 * Main container for the Picasso application
 *
 * @author Robert Duvall (rcd@cs.duke.edu)
 * @author Stephen Ewing
 */
@SuppressWarnings("serial")
public class Frame extends JFrame{
	
	JButton button;
	private JTextField textField;
	
	/**
	 * 
	 * creates Frame with buttons for Image generator
	 * @param size
	 */
	public Frame(Dimension size) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// create GUI components
		Canvas canvas = new Canvas(this);
		canvas.setSize(size);
	
		// add commands to test here
	
		
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());

		textField = new JTextField(20);

		
		textField.setPreferredSize(new Dimension(250,40));

		commands.add(textField);
		commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas, new Evaluator(textField) ));
		commands.add("Save", new Writer());

		// add our container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.NORTH);
		
		
		
		pack();
	}



}