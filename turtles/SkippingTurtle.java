import java.util.*;
import java.awt.*;
import java.awt.geom.*;

public class SkippingTurtle extends BasicTurtle{
	private int skip, count;

	public SkippingTurtle(int skip){
		this.skip = skip;
	}

	@Override public void move(double dist){
		if(count % skip == 0) setPen(false);
		else setPen(true);

		super.move(dist);
		count += 1;
	}

	@Override public String toString(){
		return "SkippingTurtle";
	}
}