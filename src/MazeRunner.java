import java.util.Scanner;
public class MazeRunner {
    public static void main(String[] args) {
        Maze myMap=new Maze();
        boolean status=myMap.didIWin();
        int moves=0;
        intro();;
        myMap.printMap();
        while (!status) {
            String direction=userMove(myMap);
            moves++;
            System.out.println("You have made"+moves+"moves");
            moveMessage(moves);
        }
        if (moves == 51) {
            moveMessage(moves);
        } else if (moves == 76) {
            moveMessage(moves);
        } else if (moves == 91) {
            moveMessage(moves);
        } else if (moves == 101) {
            moveMessage(moves);
        }

        if (status) {
            System.out.print("Congratulations, you made it out alive!");
            System.out.println("And you did it in " + moves + "moves");
            System.exit(0);
        }
    }

    public static void intro() {
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position: ");
    }

    public static String userMove (Maze myMap) {
        //take in desired direction of move, and check if that direction is valid and possible
        Scanner input=new Scanner (System.in);
        boolean status = myMap.didIWin();

        System.out.print("Where would you like to move? (R, L, U, D) ");
        String direction=input.nextLine();

        while (!direction.equals("R") && !direction.equals("L") && !direction.equals("U") && !direction.equals("D")) {
            System.out.print("Where would you like to move? (R, L, U, D) ");
            direction=input.nextLine();
        }
        if (direction.equals("R")) {
            if (myMap.canIMoveRight()) {
                myMap.moveRight();
            } else if (myMap.isThereAPit(direction)) {
                navigatePit(direction, myMap);
            } else {
                System.out.println("Sorry, you've hit a wall");
            }
            myMap.printMap();
            status = myMap.didIWin();
        } else if (direction.equals("L")) {
            if (myMap.canIMoveLeft()) {
                myMap.moveLeft();
            } else if (myMap.isThereAPit(direction)) {
                navigatePit(direction, myMap);
            } else {
                System.out.println("Sorry, you've hit a wall");
            }
            myMap.printMap();
            status = myMap.didIWin();
        } else if (direction.equals("U")) {
            if (myMap.canIMoveUp()) {
                myMap.moveUp();
            } else if (myMap.isThereAPit(direction)) {
                navigatePit(direction, myMap);
            } else {
                System.out.println("Sorry, you've hit a wall");
            }
            myMap.printMap();
            status = myMap.didIWin();
        } else if (direction.equals("D")) {
            if (myMap.canIMoveDown()) {
                myMap.moveDown();
            } else if (myMap.isThereAPit(direction)) {
                navigatePit(direction, myMap);
            } else {
                System.out.println("Sorry, you've hit a wall");
            }
            myMap.printMap();
            status = myMap.didIWin();
        }

        return direction;
    }

    public static void moveMessage (int moves) {
        //print message after certain number of moves
        //count moves
        if (moves == 51) {
            System.out.println("Warning: you have  made 50 moves, you have 50 remaining before the maze exit closes");
        } else if (moves == 76) {
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        } else if (moves == 91) {
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!");
        } else if (moves == 101) {
            System.out.println("Oh no! You took too long to escape, and now the maze is closed FOREVER >:[");
            System.out.println("Sorry, but you didn't escape in time - you lose!");
            System.exit(0);
        }
    }
    public static void navigatePit (String direction, Maze myMap) {
        Scanner input=new Scanner (System.in);
        System.out.print("Watch out! There's a pit ahead, jump it? ");
        String jump=input.nextLine();
        if (jump.matches("^Y.*|^y.*")) {
            myMap.jumpOverPit(direction);
        }
    }
}