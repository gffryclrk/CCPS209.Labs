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
	    Ellipse2D el = new Ellipse2D.Double(x-(diameter/2), y-(diameter/2), diameter, diameter);
	    g2.draw(el);
	    g2.fill(el);
	}

	@Override public void move(double dist){
		turtle.move(dist);

		if(rng.nextDouble() < prob) {
			drawEgg(turtle.getGraphics2D(), getX(), getY(), diameter);

		}
	}
	@Override public String toString(){
		return "EggDecoratorTurtle";
	}
}