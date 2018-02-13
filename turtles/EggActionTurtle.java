import java.util.*;
import java.awt.geom.*;
import java.awt.*;

public class EggActionTurtle extends ActionTurtle{

    public EggActionTurtle(){
        addAction(new LayEggAction(0.5, 10));
    }

    public class LayEggAction implements Action{
        double prob, diameter;
        Random rng = new Random();

        public LayEggAction(double prob, double diameter){
            this.prob = prob;
            this.diameter = diameter;
        }

        @Override public void action(Turtle turtle){
            
            if(rng.nextDouble() < prob){

            	Graphics2D g2 = turtle.getGraphics2D();
               	g2.draw(new Ellipse2D.Double(turtle.getX()-(diameter/2), turtle.getY()-(diameter/2), diameter, diameter));
    		}        
        }
    }
    @Override public String toString(){
    	return "EggActionTurtle";
    }
}