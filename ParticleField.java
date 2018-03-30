import java.awt.*;
import javax.swing.*;

public class ParticleField extends JPanel{

	private static final int SIZE = 500;
	private ArrayList<ParticleField> particles = new ArrayList<>(1000);

	public ParticleField(){
		// particles.forEach()
		this.setPreferredSize(new Dimension(SIZE, SIZE));
		for(int i=0; i<1000; i+=1){
			particles.add(new Particle());
		}
	}

	public void paintComponent(){
		
	}
}