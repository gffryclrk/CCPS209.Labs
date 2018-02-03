import java.util.*;
import java.awt.*;
// import java.util.Random;
import java.awt.geom.*;

public class RainbowTurtle extends AbstractTurtle{
	private static Random rng = new Random();

	public RainbowTurtle(){

	}

	@Override public void move(double dist){
		double a = Math.toRadians(getHeading());
		double x = getX();
		double y = getY();
		double x2 = x + dist * Math.cos(a);
		double y2 = y + dist * Math.sin(a);
		if(getPen()) {
		    Graphics2D g2 = getGraphics2D();
		    g2.setPaint(getColor());
		    g2.setStroke(getStroke());
		    // g2.draw(new CubicCurve2D.Double(x0, y0, cx, cy, cx, cy, x3, y3));
		    g2.draw(new Line2D.Double(x,y,x2,y2));
		}
		setPosition(x2, y2);
		setColor(new Color(rng.nextInt(255), rng.nextInt(255), rng.nextInt(255)));
	}

}