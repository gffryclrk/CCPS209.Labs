import java.util.*;
import java.awt.*;
import java.awt.geom.*;

public class SkippingTurtle extends AbstractTurtle{
	private int skip, count;

	public SkippingTurtle(int skip){
		this.skip = skip;
	}

	@Override public void move(double dist){
		if(count % skip == 0) setPen(false);
		else setPen(true);

		double a = Math.toRadians(getHeading());
		double x = getX();
		double y = getY();
		double x2 = x + dist * Math.cos(a);
		double y2 = y + dist * Math.sin(a);
		if(getPen()) {
		    Graphics2D g2 = getGraphics2D();
		    g2.setPaint(getColor());
		    g2.setStroke(getStroke());
		    g2.draw(new Line2D.Double(x,y,x2,y2));
		}
		
		setPosition(x2, y2);
		count += 1;
	}

}