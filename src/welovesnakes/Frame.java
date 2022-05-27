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
	
	//for the creation of the board and the needed parameters 
	static int boardWidth = 700;
	static int boardHeight = 700;
	static int blocksOfBoard = 70; //should be width or height/ divided by 10
	static int unitsOfBoard = boardWidth / (blocksOfBoard) * 10;
	//public static int[][] board = new int[unitsOfBoard][unitsOfBoard];
	public int[] xBoard = new int[unitsOfBoard];
	public int[] yBoard = new int[unitsOfBoard];
	
	//score variables
	int score = 0;
	int highScore = 0;
	
	//needed for the randomization of the Food
	int xFood = 0;
	int yFood = 0;
	public Random r = new Random();
	
	//speed of the snake probably using timer 
	int speed = 300;
	int d = 0;
	
	//whether or not the game is running 
	public static boolean playing = false; 
	
	//objects(background)
	Background	bg = new Background(0, 0);
	
	//size of the snake
	int snakeLength = 3;
	
	//to start the game
	public void startGame() {
		playing = true; 
		makeNewFood();
		Timer t = new Timer(speed, this);
		t.start();
	}
	

	public void paint(Graphics g) {
		super.paintComponent(g);
		//paint the background from the background class
		bg.paint(g);
		
		//draws the snake and the 
		if(playing == true) {
			
			//color of the Food(light pink)
			g.setColor(new Color(244, 183, 233));
			//create the Food, which is a pink circle
			g.fillOval(xFood, yFood, blocksOfBoard*3/4, blocksOfBoard*3/4);
			
			//make the snake
			for(int i = 0; i < snakeLength; i++) {
				//the head of the snake is a darker color than the body
				//creation of the head of the snake
				if(i == 0) {
					g.setColor(new Color(158,121,200)); //purple square for the head
					g.fillRect(xBoard[i], yBoard[i], blocksOfBoard, blocksOfBoard);
				//creation of the body of the snake
				}else {
					g.setColor(new Color(206, 189, 227)); //light purple square for the body
					g.fillRect(xBoard[i], yBoard[i], blocksOfBoard, blocksOfBoard);
				}
					
			}
			
		}
		
	}
	
	public void makeNewFood(){
		
		//randomizes the location of the new Food to fit within each of the blocks
		//x coordinate for the apple
		xFood = r.nextInt(boardWidth/blocksOfBoard) * blocksOfBoard + 9;
		//y coordinate for the apple
		yFood = r.nextInt(boardHeight/blocksOfBoard)* blocksOfBoard + 9;		
		
	}
	
	public void runSnake() {
		//moving forward in whatever direction the snake is facing
		for(int i = 0; i < snakeLength; i++) {
			xBoard[i+1] = xBoard[i];
			yBoard[i+1] = yBoard[i];
		}
		
		//
		switch(d) {
			case 0:
				xBoard[0] = blocksOfBoard + xBoard[0];
				break;
			case 90: 
				yBoard[0] = -blocksOfBoard + yBoard[0];
				break;
			case 180: 
				xBoard[0] = -blocksOfBoard + xBoard[0];
				break;
			case 270:
				yBoard[0] = blocksOfBoard + yBoard[0];
				break;
		}
		
		
		
	}
	
	public static void main(String[] args) {
		new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("we love snakes");
		f.setSize(new Dimension(boardWidth, boardHeight));
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
		if(playing == true) {
			runSnake();
		}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
			System.out.println(arg0.getKeyCode());
			switch(arg0.getKeyCode()) {
			//to start the game
				case 32: //space bar
					startGame();
					break;
					
			//two ways to move snake: arrows or wasd
				case 39: //right arrow 
					d = 0;
					break;
				case 68: //d key
					d = 0;
					break;
				case 38: //up arrow
					d = 90;
					break;
				case 87: //w key
					d = 90;
					break;
				case 37: //left arrow
					d = 180;
					break;
				case 65: //a key
					d = 180;
					break;
				case 40: //down arrow
					d = 270;
					break;
				case 83: //s key
					d = 270;
					break;
					
			//controls the desired speed of the snake in the apple
				case 49: //number 1 key
					speed = 200;
					break;
				case 50: //number 2 key
					speed = 250;
					break;
				case 51: //number 3 key
					speed = 300;
					break;
					
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