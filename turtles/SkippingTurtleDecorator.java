

public class SkippingTurtleDecorator extends TurtleDecorator{
	private Turtle turtle;
	private int count, skip;

	public SkippingTurtleDecorator(Turtle turtle, int skip){
		super(turtle);
		this.turtle = turtle;
		this.skip = skip;
	}

	@Override public void move(double dist){
		if(count % skip == 0) turtle.setPen(false);
		else turtle.setPen(true);

		turtle.move(dist);
		count+=1;
	}
}