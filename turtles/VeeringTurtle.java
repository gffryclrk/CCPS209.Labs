import java.util.*;
import java.awt.geom.*;
import java.awt.*;

public class VeeringTurtle extends AbstractTurtle{
    private double veer;

    public VeeringTurtle(double veer){
        this.veer = veer;
    }

    @Override public void move(double dist){
        double a = Math.toRadians(getHeading());
        double x = getX();
        double y = getY();
        double x2 = x + dist * Math.cos(a);
        double y2 = y + dist * Math.sin(a);
        // double len = Math.sqrt((x-x2)*(x-x2) + (y-y2)*(y-y2));
        // double t = rng.nextDouble() * 0.08 + 0.42;
        // if(len > LENCUTOFF) {
        //     move(t * dist);
        //     move((1-t) * dist);
        //     return;
        // }
        // double cx = (t*x + (1-t)*x2) + (rng.nextDouble() - 0.5) * CWOBBLE * len;
        // double cy = (t*y + (1-t)*y2) + (rng.nextDouble() - 0.5) * CWOBBLE * len;
        // double x0 = x + EWOBBLE * rng.nextDouble() * (x - cx);
        // double y0 = y + EWOBBLE * rng.nextDouble() * (y - cy);
        // double x3 = x2 + EWOBBLE * rng.nextDouble() * (x2 - cx);
        // double y3 = y2 + EWOBBLE * rng.nextDouble() * (y2 - cy);
        if(getPen()) {
            Graphics2D g2 = getGraphics2D();
            g2.setPaint(getColor());
            g2.setStroke(getStroke());
            // g2.draw(new CubicCurve2D.Double(x0, y0, cx, cy, cx, cy, x3, y3));
            g2.draw(new Line2D.Double(x,y,x2,y2));
        }
        setPosition(x2, y2);
    }

    @Override public String toString(){
        return "VeeringTurtle";
    }
}