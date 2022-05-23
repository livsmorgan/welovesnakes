package welovesnakes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	int score = 0;
	int highScore = 0;
	public static boolean gameStart = false;
	Random random = new Random();
	Timer timer;
	public static int width = 700;
	public static int height = 700; 
	public static int block = 70;
	public static int unitsOfBoard = (width * height)/(block / block);
	public static final int[] x = new int[unitsOfBoard];
	public static final int[] y = new int[unitsOfBoard];
	public static int speed = 150;
	public static int snakeLength = 3;
	public int appleCordX;
	public int appleCordY;
	public static String direction = "";
	
	//objects(background)
	
	Background	bg = new Background(0, 0);
	
	
	public void start() {
		gameStart = true;
		apple();
		timer = new Timer(speed,this);
		timer.start();
	}

	public void paint(Graphics g) {
		super.paintComponent(g);
		bg.paint(g);
		
		//apple object(circle)
		if(gameStart == true) {
			
			g.setColor(Color.red);
			g.fillOval(appleCordX, appleCordY, Frame.block, Frame.block);
			
			
			for(int i = 0; i < snakeLength;i++) {
				if(i == 0) {
					g.setColor(new Color(255, 190, 242));
					g.fillRect(x[i], y[i], block, block);
				}
				else {
					g.setColor(new Color(255, 240, 252));
					g.fillRect(x[i], y[i], block, block);
				}			
			}
			
		
		}
		
		/**
		//draws score label 
				g.setColor(Color.black);
				g.setFont(new Font("Times New Roman",Font.BOLD, 25));
				g.drawString("score: "+ score, 30, 45);
				
		//check if the score is greater than the current high score and switch if applicable
				if(highScore < score) {
					highScore = score;
				}
				
				//draw high score label
				g.setColor(Color.black);
				g.drawString("high score: " + highScore, 200,45 );
		*/
		
	}
	
	public void go() {
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
	
	public void appleCount() {
		if(y[0] == appleCordY && x[0] == appleCordX ) {
			apple();
			score ++;
			snakeLength ++;
		}
	}
	
	
	public void collide() {
		
		if(x[0] < 0 || x[0] > width || y[0] > height || y[0] < 0) {
			gameStart = false;
		}
		for(int i = snakeLength; i > 0; i--) {
			if(y[0] == y[i] && x[0] == x[i]) { //head and body
				gameStart = false;
			}
		}

		if(gameStart == false) {
			timer.stop();
		}
		
	}
	
	public void apple() {
		appleCordX = random.nextInt((width/block)) * block;
		appleCordY = random.nextInt((height/block)) * block;
	}
	
	
	public static void main(String[] args) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("we love snakes");
		f.setSize(new Dimension(width, height));
		f.setBackground(Color.black);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,1));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(speed, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	 
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(gameStart == true) {
			collide();
			appleCount();
			go();
			
		}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
			System.out.println(arg0.getKeyCode());
			switch(arg0.getKeyCode()) {
			case 32:
				start();
				break;
			case 10:
				gameStart = false; 
				highScore = 0;
				break;
			case 38:
				if(Snake.direction != "down") {
					Snake.direction = "up";
				}
				break;
			case 40:
				if(Snake.direction != "up") {
					Snake.direction = "down";
				}
				break;
			case 39:
				if(Snake.direction != "left") {
					Snake.direction = "right";
				}
				break;
			case 37:
				if(Snake.direction != "right") {
					Snake.direction = "left";
				}
				
			
			}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}