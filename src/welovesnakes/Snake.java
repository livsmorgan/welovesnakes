package welovesnakes;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Snake {

		public int x,y;
		private int width, height;
		public AffineTransform tx;
		private double scaleW = 3.0, scaleH = 3.0;
		public static String direction = "";
		

		public Snake(int x, int y) {
			//assigns the x and y
			this.x = x;
			this.y = y;
			tx = AffineTransform.getTranslateInstance(x, y );
			init(x, y); 	
		}
		
		 
		public void paint(Graphics g) {
			//these are the 2 lines of code needed draw an image on the screen
			Graphics2D g2 = (Graphics2D) g;
			
			//call update to update the actual picture location
			update();
			
			if(Frame.gameStart == true) {
				
				for(int i = 0; i < Frame.snakeLength;i++) {
					if(i == 0) {
						g.setColor(new Color(255, 190, 242));
						g.fillRect(Frame.x[i], Frame.y[i], Frame.block, Frame.block);
					}
					else {
						g.setColor(new Color(255, 240, 252));
						g.fillRect(Frame.x[i], Frame.y[i], Frame.block, Frame.block);
					}			
				}
			
			}
		
				
		}
		
		public static void go() {
			for(int i = Frame.snakeLength;i > 0;i--) {
				Frame.x[i] = Frame.x[i - 1];
				Frame.y[i] = Frame.y[i - 1];
			}
			
			switch(direction) {
			case "up":
				Frame.y[0] = Frame.y[0] - Frame.block;
				break;
			case "down":
				Frame.y[0] = Frame.y[0] + Frame.block;
				break;
			case "right":
				Frame.x[0] = Frame.x[0] + Frame.block;
				break;
			case "left":
				Frame.x[0] = Frame.x[0] - Frame.block;
				break;
			}
			
		}
		/* update the picture variable location */
		public void update() {
			tx.setToTranslation(x, y);
			tx.scale(3, 3);
		}
			
		
		private void init(double a, double b) {
			tx.setToTranslation(a, b);
			tx.scale(1.2, 0.9);
		}

		private Image getImage(String path) {
			Image tempImage = null;
			try {
				URL imageURL = Background.class.getResource(path);
				tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return tempImage;
		}	
}