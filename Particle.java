import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Particle {
	
	Random rng = new Random();
	private double x, y; 
	
	public Particle() {
		
		this.x = rng.nextDouble()*500;
		this.y = rng.nextDouble()*500;
	}
	
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	void move(){
		x += rng.nextGaussian();
		y += rng.nextGaussian();
	}

	public class ParticleField extends JPanel{

		private static final int SIZE = 500;
		private ArrayList<Particle> particles = new ArrayList<>(1000);

		public ParticleField(){
			// particles.forEach()
			this.setPreferredSize(new Dimension(SIZE, SIZE));
			this.setBackground(Color.WHITE);

			for(int i=0; i<1000; i+=1){
				particles.add(new Particle());
			}
		}

		public void paintComponent(Graphics g){
			super.paintComponent(g);

			for(Particle particle : particles){
				g.drawRect((int)particle.getX(), (int)particle.getY(), 3, 3);
			}
		}

		public static void main(String[] args){
			JFrame f = new JFrame("Some particles!");
			f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			f.setLayout(new FlowLayout());

			f.add(new ParticleField());
			f.pack();
			f.setVisible(true);
		}
	}
}
