import java.util.*;
import java.awt.*;

public class RainbowTurtleDecorator extends TurtleDecorator{
    private Turtle turtle;
    private static Random rng = new Random();

    public RainbowTurtleDecorator(Turtle turtle){
        super(turtle);
        this.turtle = turtle;
    }

    @Override public void move(double dest){
        turtle.move(dest);
        turtle.setColor(new Color(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255)));
    }
}