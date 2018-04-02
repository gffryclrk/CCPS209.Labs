import java.awt.*;
import javax.swing.*;
import java.util.*;

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
//	public int getWidth() { return SIZE; }
//	public int getHeight() { return SIZE; }

	protected java.util.List<Particle> getParticles(){
		return particles; 
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