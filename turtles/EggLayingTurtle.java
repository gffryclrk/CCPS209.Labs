import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class EggLayingTurtle extends BasicTurtle{
	private double prob, diameter;
	Random rng = new Random();

	public EggLayingTurtle(double prob, double diameter){
		this.prob = prob;
		this.diameter = diameter;
	}

	static void drawEgg(Graphics2D g2, double x, double y, double diameter){
	    Ellipse2D el = new Ellipse2D.Double(x-(diameter/2), y-(diameter/2), diameter, diameter);
	    g2.draw(el);
	    g2.fill(el);
	}

	@Override public void move(double dist){
		super.move(dist);

		
		if(rng.nextDouble() < prob) {
			drawEgg(getGraphics2D(), getX(), getY(), diameter);
		}
	}
	@Override public String toString(){
		return "EggLayingTurtle";
	}

}