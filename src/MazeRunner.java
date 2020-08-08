import java.util.Scanner;
public class MazeRunner {
    public static void main(String[] args) {

        userMove();
    }

    public static void intro() {
        Maze myMap = new Maze();
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position: ");
        myMap.printMap();
    }

    public static String userMove() {
        //take in desired direction of move, and check if that direction is valid and possible
        Maze myMap = new Maze();
        Scanner input = new Scanner(System.in);

        boolean status = myMap.didIWin();
        System.out.print("Where would you like to move? (R, L, U, D) ");
        String direction = input.next();


        while (!status) {
            while (!direction.equals("R") && !direction.equals("L") && !direction.equals("U") && !direction.equals("D")) {
                System.out.print("Where would you like to move? (R, L, U, D) ");
                direction = input.next();
            }

            //testing if the direction the user entered is a wall
            switch (direction) {
                case "R":
                    if (myMap.canIMoveRight()) {
                        myMap.moveRight();
                        myMap.printMap();
                        status=myMap.didIWin();
                    } else {
                        System.out.println("Sorry, you've hit a wall");
                        myMap.printMap();
                    }
                    break;
                case "L":
                    if (myMap.canIMoveLeft()) {
                        myMap.moveLeft();
                        myMap.printMap();
                        status=myMap.didIWin();
                    } else {
                        System.out.println("Sorry, you've hit a wall");
                        myMap.printMap();
                    }
                    break;
                case "U":
                    if (myMap.canIMoveUp()) {
                        myMap.moveUp();
                        myMap.printMap();
                        status=myMap.didIWin();
                    } else {
                        System.out.println("Sorry, you've hit a wall");
                        myMap.printMap();
                    }
                    break;
                default:
                    if (myMap.canIMoveDown()) {
                        myMap.moveDown();
                        myMap.printMap();
                        status=myMap.didIWin();
                    } else {
                        System.out.println("Sorry, you've hit a wall");
                        myMap.printMap();
                    }
                    break;
            }
        }
        return direction;

    }
    /*public static void moveMessage (moves) {
        //print message after certain number of moves
        //count moves
    }
    public static void navigatePit (direction) {

    }*/
}