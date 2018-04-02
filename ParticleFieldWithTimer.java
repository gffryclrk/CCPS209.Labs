import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
 import java.awt.event.WindowAdapter;
 import java.awt.event.WindowEvent;

import javax.swing.*;
//import javax.swing.Timer; 


public class ParticleFieldWithTimer extends ParticleField{
	private java.util.List<Particle> pl;
	private static javax.swing.Timer pft;

	public ParticleFieldWithTimer(){
		pl = getParticles();

		/*
		int delay = 20;
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				pl.forEach(x -> x.move());
				repaint();
			}
		};
		pft = new javax.swing.Timer(delay, taskPerformer);
		*/
		pft = new javax.swing.Timer(20, (ae) -> { 
			pl.forEach(x -> x.move()); 
			repaint(); 
		});
		pft.start();
	}
	public static void stopTimer() {
		pft.stop();
	}

	public static void main(String[] args){
		JFrame f = new JFrame("Particle field on a timer!");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setLayout(new FlowLayout());
		
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
//				stopTimer();
				stopTimer();
				System.out.println("Timer stopped!");
				f.dispose();
			}
		});

		

		f.add(new ParticleFieldWithTimer());
		f.pack();
		f.setVisible(true);
	}
}