import java.util.InputMismatchException;
import java.util.Scanner;

class EscapeRoom {
    int lives = 3;
    Scanner sc = new Scanner(System.in);

    public void startGame() {
        System.out.println("================================");
        System.out.println("       ESCAPE ROOM GAME");
        System.out.println("================================");
        System.out.println("You have " + lives + " lives.");
        System.out.println("Solve all 4 rooms to escape!\n");

        if (!room1()) return;
        if (!room2()) return;
        if (!room3()) return;
        if (!room4()) return;

        System.out.println("\n==============================");
        System.out.println(" EXIT DOOR OPENS ");
        System.out.println(" YOU ESCAPED!");
        System.out.println("==============================");
    }

    boolean loseLife() {
        lives--;
        System.out.println("Wrong Answer!");
        System.out.println("Lives Left: " + lives);

        if (lives == 0) {
            System.out.println("\nGAME OVER!");
            return false;
        }
        return true;
    }

    // Room 1
    boolean room1() {
        while (true) {
            try {
                System.out.println("\nRoom 1 - Guess Number");
                System.out.print("Guess a number between 1 and 5: ");
                int num = sc.nextInt();

                if (num == 3) {
                    System.out.println("Door 1 Unlocked!");
                    return true;
                } else {
                    if (!loseLife()) return false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input!");
                sc.next();
            }
        }
    }

    // Room 2
    boolean room2() {
        while (true) {
            try {
                System.out.println("\nRoom 2 - Array Puzzle");
                int arr[] = {10,20,30,40,50};

                System.out.print("Enter index of value 30: ");
                int index = sc.nextInt();

                if (index == 2) {
                    System.out.println("Door 2 Unlocked!");
                    return true;
                } else {
                    if (!loseLife()) return false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input!");
                sc.next();
            }
        }
    }

    // Room 3
    boolean room3() {
        while (true) {
            System.out.println("\nRoom 3 - String Puzzle");
            System.out.print("Complete the word: JA__ : ");

            String ans = sc.next();

            if (ans.equalsIgnoreCase("VA")) {
                System.out.println("Door 3 Unlocked!");
                return true;
            } else {
                if (!loseLife()) return false;
            }
        }
    }

    // Room 4
    boolean room4() {
        while (true) {
            try {
                System.out.println("\nRoom 4 - Java MCQ Challenge");
                System.out.println("Which keyword is used to inherit a class?");
                System.out.println("1. implement");
                System.out.println("2. extends");
                System.out.println("3. import");
                System.out.println("4. package");

                System.out.print("Enter option: ");
                int choice = sc.nextInt();

                if (choice == 2) {
                    System.out.println("Door 4 Unlocked!");
                    return true;
                } else {
                    if (!loseLife()) return false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input!");
                sc.next();
            }
        }
    }
}

public class EscapeRoomGame {
    public static void main(String[] args) {
        EscapeRoom game = new EscapeRoom();
        game.startGame();
    }
}