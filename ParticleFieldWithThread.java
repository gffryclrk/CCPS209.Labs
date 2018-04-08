import java.awt.*;
import javax.swing.*;


public class ParticleFieldWithThread extends ParticleField{
	private java.util.List<Particle> pl;
	private static boolean running = true;

	public ParticleFieldWithThread(){
		pl = getParticles();

		new Thread(new Runnable() {
			public void run(){
				while(running){
					try{
						Thread.sleep(20);
						pl.forEach(x -> x.move());
						repaint();
					}catch (Exception e){
						System.out.println("Thread failed: " + e);
					}
				}
			}
		}).start();


	}

	public static void main(String[] args){
		JFrame f = new JFrame("Particle field running on a thread!");
		f.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent we){
				running = false;
				System.out.println("Thread terminated!");
				f.dispose();
			}
		});

		f.add(new ParticleFieldWithThread());
		f.pack();
		f.setVisible(true);
	}
}