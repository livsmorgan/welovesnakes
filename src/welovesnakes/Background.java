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
		
		//call update to update the actually picture location
		update();
		

		g.setColor(new Color(242, 238, 242)); //purple
		
		for(int i = 0; i < Frame.width; i+= Frame.block) {
			g.fillRect(0 + i, 0 + i, Frame.block, Frame.block); //diagonal from top left to bottom right
			g.fillRect(2 * Frame.block + i, 0 + i, Frame.block, Frame.block); 
			g.fillRect(4 * Frame.block + i, 0 + i, Frame.block, Frame.block); 
			g.fillRect(6 * Frame.block + i, 0 + i, Frame.block, Frame.block); 
			g.fillRect(8 * Frame.block + i, 0 + i, Frame.block, Frame.block); 
			
		}
		
		for(int i = 0; i < Frame.width; i += 2 * Frame.block) {
			g.fillRect(0, 0 + i, Frame.block, Frame.block); //index 0 column 
			g.fillRect(Frame.block, Frame.block + i, Frame.block, Frame.block);
			g.fillRect(2 * Frame.block, 0 + i, Frame.block, Frame.block);
			g.fillRect(3 * Frame.block, Frame.block + i, Frame.block, Frame.block);
			g.fillRect(4 * Frame.block, 0 + i, Frame.block, Frame.block);
			g.fillRect(5 * Frame.block, Frame.block + i, Frame.block, Frame.block);
			g.fillRect(6 * Frame.block, 0 + i, Frame.block, Frame.block);
			g.fillRect(7 * Frame.block, Frame.block + i, Frame.block, Frame.block);
		
		}
		
		g.setColor(new Color(229, 221, 233)); //pink
		
		for(int i = 0; i < Frame.width; i+= Frame.block) {
			g.fillRect(Frame.block + i, 0 + i, Frame.block, Frame.block); //diagonal from top left to bottom right
			g.fillRect(3 * Frame.block + i, 0 + i, Frame.block, Frame.block); 
			g.fillRect(5 * Frame.block + i, 0 + i, Frame.block, Frame.block); 
			g.fillRect(7 * Frame.block + i, 0 + i, Frame.block, Frame.block); 
			g.fillRect(9 * Frame.block + i, 0 + i, Frame.block, Frame.block); 
			
		}
		
		for(int i = 0; i < Frame.width; i += 2 * Frame.block) {
			g.fillRect(0, Frame.block + i, Frame.block, Frame.block); //index 0 column 
			g.fillRect(Frame.block, 0 + i, Frame.block, Frame.block);
			g.fillRect(2 * Frame.block, Frame.block + i, Frame.block, Frame.block);
			g.fillRect(3 * Frame.block, 0 + i, Frame.block, Frame.block);
			g.fillRect(4 * Frame.block, Frame.block + i, Frame.block, Frame.block);
			g.fillRect(5 * Frame.block, 0 + i, Frame.block, Frame.block);
			g.fillRect(6 * Frame.block, Frame.block + i, Frame.block, Frame.block);
			g.fillRect(7 * Frame.block, 0 + i, Frame.block, Frame.block);
			g.fillRect(8 * Frame.block, Frame.block + i, Frame.block, Frame.block);
		
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