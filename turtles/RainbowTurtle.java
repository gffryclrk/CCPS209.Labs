import java.util.*;
import java.awt.*;
import java.awt.geom.*;

public class RainbowTurtle extends BasicTurtle{

	private static Random rng = new Random();

	@Override public void move(double dist){
		super.move(dist);
		setColor(new Color(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255)));
	}

	@Override public String toString(){
		return "RainbowTurtle";
	}
}