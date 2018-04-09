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
		// this.x += rng.nextGaussian();
		// this.y += rng.nextGaussian();
		
		// https://www.mathsisfun.com/geometry/unit-circle.html
		// I wasn't sure if I should use nextGaussian() or nextDouble() but
		// opted for nextGaussian() because that was what the original
		// outline asked for. 
		
		// double theta = Math.PI * rng.nextDouble();
		double theta = Math.PI * rng.nextGaussian(); 
		this.x += Math.cos(theta);
		this.y += Math.sin(theta);
	}
}
