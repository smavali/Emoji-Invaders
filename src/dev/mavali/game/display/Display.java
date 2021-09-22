package dev.mavali.game.display;

import dev.mavali.game.constant.Constants;

import java.awt.*;
import javax.swing.JFrame;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	
	private String title;

	public Display(String title){
		this.title = title;
		createDisplay();
	}
	
	private void createDisplay(){
		frame = new JFrame(title);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		com.apple.eawt.FullScreenUtilities.setWindowCanFullScreen(frame,true);
		com.apple.eawt.Application.getApplication().requestToggleFullScreen(frame);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(Constants.screenSize));
		canvas.setMaximumSize(new Dimension(Constants.screenSize));
		canvas.setMinimumSize(new Dimension(Constants.screenSize));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}

	public Canvas getCanvas(){
		return canvas;
	}
	
	public JFrame getFrame(){
		return frame;
	}

	public void disableCanvas(){
		canvas.setBounds(0,0,0,0);
	}
	
}
