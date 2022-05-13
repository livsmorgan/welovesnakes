package snakesnake;
import javax.swing.JFrame;

public class Frame extends JFrame{
	Frame(){
		
		this.add(new Board());
		this.setTitle("snake game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
