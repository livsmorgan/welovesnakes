package welovesnakes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Background {
	
	public int x, y;
	private AffineTransform tx;
	
	public Background(int x, int y) {
		this.x = x;
		this.y = y;
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 				//initialize the location of the image
									//use your variables
	}

	/* update the picture variable location */
	private void update() {
		tx.setToTranslation(x, y);
		tx.scale(0.8, 0.8);
	}
		
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		//call update to update the actual picture location
		update();
		

		g.setColor(new Color(242, 238, 242)); //lighter purple grey
		
		for(int i = 0; i < Frame.boardWidth; i+= Frame.blocksOfBoard) {
			g.fillRect(0 + i, 0 + i, Frame.blocksOfBoard, Frame.blocksOfBoard); //diagonal from top left to bottom right
			g.fillRect(2 * Frame.blocksOfBoard + i, 0 + i, Frame.blocksOfBoard, Frame.blocksOfBoard); 
			g.fillRect(4 * Frame.blocksOfBoard + i, 0 + i, Frame.blocksOfBoard, Frame.blocksOfBoard); 
			g.fillRect(6 * Frame.blocksOfBoard + i, 0 + i, Frame.blocksOfBoard, Frame.blocksOfBoard); 
			g.fillRect(8 * Frame.blocksOfBoard + i, 0 + i, Frame.blocksOfBoard, Frame.blocksOfBoard); 
			
		}
		
		for(int i = 0; i < Frame.boardWidth; i += 2 * Frame.blocksOfBoard) {
			g.fillRect(0, 0 + i, Frame.blocksOfBoard, Frame.blocksOfBoard); //index 0 column 
			g.fillRect(Frame.blocksOfBoard, Frame.blocksOfBoard + i, Frame.blocksOfBoard, Frame.blocksOfBoard);
			g.fillRect(2 * Frame.blocksOfBoard, 0 + i, Frame.blocksOfBoard, Frame.blocksOfBoard);
			g.fillRect(3 * Frame.blocksOfBoard, Frame.blocksOfBoard + i, Frame.blocksOfBoard, Frame.blocksOfBoard);
			g.fillRect(4 * Frame.blocksOfBoard, 0 + i, Frame.blocksOfBoard, Frame.blocksOfBoard);
			g.fillRect(5 * Frame.blocksOfBoard, Frame.blocksOfBoard + i, Frame.blocksOfBoard, Frame.blocksOfBoard);
			g.fillRect(6 * Frame.blocksOfBoard, 0 + i, Frame.blocksOfBoard, Frame.blocksOfBoard);
			g.fillRect(7 * Frame.blocksOfBoard, Frame.blocksOfBoard + i, Frame.blocksOfBoard, Frame.blocksOfBoard);
		
		}
		
		g.setColor(new Color(229, 221, 233)); //darker purple
		
		
		for(int i = 0; i < Frame.boardWidth; i+= Frame.blocksOfBoard) {
			g.fillRect(Frame.blocksOfBoard + i, 0 + i, Frame.blocksOfBoard, Frame.blocksOfBoard); //diagonal from top left to bottom right
			g.fillRect(3 * Frame.blocksOfBoard + i, 0 + i, Frame.blocksOfBoard, Frame.blocksOfBoard); 
			g.fillRect(5 * Frame.blocksOfBoard + i, 0 + i, Frame.blocksOfBoard, Frame.blocksOfBoard); 
			g.fillRect(7 * Frame.blocksOfBoard + i, 0 + i, Frame.blocksOfBoard, Frame.blocksOfBoard); 
			g.fillRect(9 * Frame.blocksOfBoard + i, 0 + i, Frame.blocksOfBoard, Frame.blocksOfBoard); 
			
		}
	
		
		for(int i = 0; i < Frame.boardWidth; i += 2 * Frame.blocksOfBoard) {
			g.fillRect(0, Frame.blocksOfBoard + i, Frame.blocksOfBoard, Frame.blocksOfBoard); //index 0 column 
			g.fillRect(Frame.blocksOfBoard, 0 + i, Frame.blocksOfBoard, Frame.blocksOfBoard);
			g.fillRect(2 * Frame.blocksOfBoard, Frame.blocksOfBoard + i, Frame.blocksOfBoard, Frame.blocksOfBoard);
			g.fillRect(3 * Frame.blocksOfBoard, 0 + i, Frame.blocksOfBoard, Frame.blocksOfBoard);
			g.fillRect(4 * Frame.blocksOfBoard, Frame.blocksOfBoard + i, Frame.blocksOfBoard, Frame.blocksOfBoard);
			g.fillRect(5 * Frame.blocksOfBoard, 0 + i, Frame.blocksOfBoard, Frame.blocksOfBoard);
			g.fillRect(6 * Frame.blocksOfBoard, Frame.blocksOfBoard + i, Frame.blocksOfBoard, Frame.blocksOfBoard);
			g.fillRect(7 * Frame.blocksOfBoard, 0 + i, Frame.blocksOfBoard, Frame.blocksOfBoard);
			g.fillRect(8 * Frame.blocksOfBoard, Frame.blocksOfBoard + i, Frame.blocksOfBoard, Frame.blocksOfBoard);
		
		}
		
		

	}
	
	public void changePicture(String newFileName) {
		init(x, y);
	}
	

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 0.8);
	}


}