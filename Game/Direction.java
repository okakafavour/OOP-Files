package Game;

public enum Direction {
    EAST("West","South"),
    SOUTH("West", "East" ),
    WEST("North", "South");


    private String right , left;

    Direction(String left, String right){
        this.right = right;
        this.left = left;

    }



    public Direction turnRight(){
        return Direction.valueOf(right);
    }

    public Direction turnLeft(){
        return Direction.valueOf(left);
    }
}

