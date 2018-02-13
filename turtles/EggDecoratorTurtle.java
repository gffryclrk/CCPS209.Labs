import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class EggDecoratorTurtle extends TurtleDecorator{
	private Turtle turtle;
	private double prob, diameter;
	Random rng = new Random();

	public EggDecoratorTurtle(Turtle turtle, double prob, double diameter){
		super(turtle);
		this.turtle = turtle;
		this.prob = prob;
		this.diameter = diameter;
	}

	static void drawEgg(Graphics2D g2, double x, double y, double diameter){
	    // g2.fill(new Ellipse2D.Double(x, y, diameter));
	    g2.draw(new Ellipse2D.Double(x-(diameter/2), y-(diameter/2), diameter, diameter));
	}

	@Override public void move(double dist){
		turtle.move(dist);

		if(rng.nextDouble() < prob) {
			//Graphics2D g2 = turtle.getGraphics2D();
			//g2.setPaint(getColor());
			//g2.setStroke(getStroke());
			drawEgg(turtle.getGraphics2D(), getX(), getY(), diameter);
			// drawEgg(getGraphics2D, getX(), getY(), diameter);

		}
	}
	@Override public String toString(){
		return "EggDecoratorTurtle";
	}
}