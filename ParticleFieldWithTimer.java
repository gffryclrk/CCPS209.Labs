import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;


public class ParticleFieldWithTimer extends ParticleField{
    private java.util.List<Particle> pl;
    private static javax.swing.Timer pft;

    public ParticleFieldWithTimer(){
        pl = getParticles();

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