import java.util.*;

public class ActionTurtle extends BasicTurtle{
    List<Action> actionList = new ArrayList<Action>();

    public void addAction(Action action){
        actionList.add(action);
    }

    @Override public void move(double dist){
        super.move(dist);
        for(Action a : actionList){
            a.action(this);
        }
    }
}