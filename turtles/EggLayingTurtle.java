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
	    // g2.fill(new Ellipse2D.Double(x, y, diameter));
	    g2.draw(new Ellipse2D.Double(x, y, x+diameter, y+diameter));
	}

	@Override public void move(double dist){
		super.move(dist);

		
		if(rng.nextDouble() < prob) {
			Graphics2D g2 = getGraphics2D();
			g2.setPaint(getColor());
			g2.setStroke(getStroke());
			drawEgg(g2, getX(), getY(), diameter);
			// TurtleDemo.TurtleSpiral.drawEgg();

		}
	}

}