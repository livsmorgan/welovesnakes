package welovesnakes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.util.Random;

public class Apple {

		public static int x, y;
		public AffineTransform tx;
		Random random;
		

		public Apple(int x, int y) {
			//assigns the x and y
			this.x = x;
			this.y = y;
			tx = AffineTransform.getTranslateInstance(x, y );
			init(x, y); 

		}
		
		public void paint(Graphics g) {
			//these are the 2 lines of code needed draw an image on the screen
			Graphics2D g2 = (Graphics2D) g;
			
			/*
			if(Frame.gameStart == true) {
				g.setColor(Color.red);
				g.fillOval(x, y, Frame.block, Frame.block);
			
			}
			*/
			
			//update();
				
		}
		
	
		
		
		/* update the picture variable location */
		private void update() {
			tx.setToTranslation(x, y);
			tx.scale(1, 1);
		}
		
		private void init(double a, double b) {
			tx.setToTranslation(a, b);
			tx.scale(1.2, 0.9);
		}

		
}
