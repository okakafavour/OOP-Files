package Game;

import static Game.Direction.*;

public class Turtle {
    private boolean penUp;
    private boolean movePen;
    private Direction direction;

    public Turtle() {
        this.direction = EAST;
    }
    public boolean penUp() {
        return true;
    }

    public boolean penIsDown() {
        return false;
    }

    public boolean movePen(){
         this.penUp = penUp;
         return true;
    }

    public Direction getCurrentDirection(){
        return direction;
    }

    public void turnRight() {
        if(direction == EAST) direction = SOUTH;
        if(direction == SOUTH) direction = WEST;
        //if(direction == WEST) direction = NORTH;

    }
}
