import java.awt.*;
import java.util.*;

public class VeeringTurtleDecorator extends TurtleDecorator{
	private double veer;
	private Turtle turtle;

	public VeeringTurtleDecorator(Turtle turtle, double veer){
		super(turtle);
		this.veer = veer;
		this.turtle = turtle;
	}

	@Override public void move(double dist){
		turtle.move(dist);
		this.turn(veer);
	}

	@Override public String toString(){
		return "VeeringTurtleDecorator";
	}
}