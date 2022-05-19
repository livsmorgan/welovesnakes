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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	int score = 0;
	int highScore = 0;
	int counter = 0;
	public static boolean gameStart = false;
	static int width = 700;
	static int height = 700; 
	static int block = 70;
	static int unitsOfBoard = (width * height)/(block / block);
	static final int[] x = new int[unitsOfBoard];
	static final int[] y = new int[unitsOfBoard];
	static int speed = 150;
	
	
	//creating objects
	Background	bg = new Background(0, 0);
	


	public void paint(Graphics g) {
		super.paintComponent(g);
		bg.paint(g);
	
		//draws score label 
		g.setColor(Color.black);
		g.setFont(new Font("Times New Roman",Font.BOLD, 20));
		g.drawString("score: "+ score, 30, 45);
		
		//draws instructions to play
		
	
		
		
		//check if the score is greater than the current high score and switch if applicable
				if(highScore < score) {
					highScore = score;
				}
				
				//draw high score label
				g.setColor(Color.black);
				g.drawString("high score: " + highScore, 200,45 );
		
		
		
	}
	
	public static void main(String[] args) {
		Frame f = new Frame();
	}
	
	public Frame() {
		JFrame f = new JFrame("dino");
		f.setSize(new Dimension(width, height));
		f.setBackground(Color.black);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,1));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
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
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
			System.out.println(arg0.getKeyCode());
			
			//to start the game w space bar
			if(arg0.getKeyCode() == 32) {
				gameStart = true;
				
			}	
			if(arg0.getKeyCode() == 10) {
				gameStart = false; 
				highScore = 0;
				
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