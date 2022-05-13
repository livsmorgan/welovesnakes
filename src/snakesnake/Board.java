package snakesnake;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends JPanel implements ActionListener {
	static final int screenWidth = 700;
	static final int screenHeight = 700;
	static final int size = 70;
	static final int units = (screenWidth*screenHeight)/(size*size);
	static final int delay = 175; //changes speed of the snake 
	final int x[] = new int[units];
	final int y[] = new int[units];
	int snakeLength = 3;
	int applesEaten = 0;
	int appleX;
	int appleY;
	char direction = 'R';
	boolean running = false;
	Timer timer;
	Random random;
	
	public Board(){
		random = new Random();
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.white);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}
	public void startGame() {
		newApple();
		running = true;
		timer = new Timer(delay,this);
		timer.start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
		
	}
	public void draw(Graphics g) {
		
		if(running) {
			
			g.setColor(Color.red);
			g.fillOval(appleX, appleY, size, size);
		
			for(int i = 0; i< snakeLength;i++) {
				if(i == 0) {
					g.setColor(Color.blue);
					g.fillRect(x[i], y[i], size, size);
				}
				else {
					g.setColor(new Color(45,180,0));
					g.fillRect(x[i], y[i], size, size);
				}			
			}
			g.setColor(Color.black);
			g.setFont( new Font("Times New Roman",Font.BOLD, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			
			g.drawString("score: "+ applesEaten, (screenWidth - metrics.stringWidth("score: "+applesEaten))/2, g.getFont().getSize());
		}
		else {
			gameOver(g);
		}
		
	} 
	public void newApple(){
		appleX = random.nextInt((int)(screenWidth/size))*size;
		appleY = random.nextInt((int)(screenHeight/size))*size;
	}
	public void move(){
		for(int i = snakeLength;i>0;i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		
		switch(direction) {
		case 'U':
			y[0] = y[0] - size;
			break;
		case 'D':
			y[0] = y[0] + size;
			break;
		case 'L':
			x[0] = x[0] - size;
			break;
		case 'R':
			x[0] = x[0] + size;
			break;
		}
		
	}
	public void checkApple() {
		if((x[0] == appleX) && (y[0] == appleY)) {
			snakeLength++;
			applesEaten++;
			newApple();
		}
	}
	public void checkCollisions() {
		//checks if head collides with body
		for(int i = snakeLength;i > 0; i--) {
			if((x[0] == x[i])&& (y[0] == y[i])) {
				running = false;
			}
		}
		//check if head touches left border
		if(x[0] < 0) {
			running = false;
		}
		//check if head touches right border
		if(x[0] > screenWidth) {
			running = false;
		}
		//check if head touches top border
		if(y[0] < 0) {
			running = false;
		}
		//check if head touches bottom border
		if(y[0] > screenHeight) {
			running = false;
		}
		
		if(!running) {
			timer.stop();
		}
	}
	public void gameOver(Graphics g) {
		//Score
		g.setColor(Color.red);
		g.setFont( new Font("Times New Roman",Font.BOLD, 40));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Score: "+applesEaten, (screenWidth - metrics1.stringWidth("Score: "+applesEaten))/2, g.getFont().getSize());
		//Game Over text
		g.setColor(Color.white);
		g.setFont( new Font("Ink Free",Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (screenWidth - metrics2.stringWidth("Game Over"))/2, screenHeight/2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(running) {
			move();
			checkApple();
			checkCollisions();
		}
		repaint();
	}
	
	/*
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
			System.out.println(arg0.getKeyCode());
			if(arg0.getKeyCode() == 32) {
				startGame();
			}
	}
	*/
	
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(direction != 'R') {
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(direction != 'L') {
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if(direction != 'D') {
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if(direction != 'U') {
					direction = 'D';
				}
				break;
			}
		}
	}

}



