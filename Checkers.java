import java.util.*;
import java.util.HashMap;

public class Checkers {

    /**
     * Represents the game board as a 2D array.
     * 'b' for Black pieces, 'w' for White pieces, ' ' for Empty spaces, 'B' for
     * Black Kings, and 'W' for White Kings.
     */

    private static char[][] board = new char[8][8];
    public String[] moveArray = new String[4];
    public static Map<Character, Integer> coords = new HashMap<>();
    public static ArrayList<Integer> coordsList = new ArrayList<>();


    /**
     * Initialises the board with pieces in their starting positions.
     */

    private static void initialiseBoard() {

        board = new char[][]{
            {' ', 'b', ' ', 'b', ' ', 'b', ' ', 'b'},
            {'b', ' ', 'b', ' ', 'b', ' ', 'b', ' '},
            {' ', 'b', ' ', 'b', ' ', 'b', ' ', 'b'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'w', ' ', 'w', ' ', 'w', ' ', 'w', ' '},
            {' ', 'w', ' ', 'w', ' ', 'w', ' ', 'w'},
            {'w', ' ', 'w', ' ', 'w', ' ', 'w', ' '},
        };

        coords.put('A', 0);
        coords.put('B', 1);
        coords.put('C', 2);
        coords.put('D', 3);
        coords.put('E', 4);
        coords.put('F', 5);
        coords.put('G', 6);
        coords.put('H', 7);

        coords.put('1', 0);
        coords.put('2', 1);
        coords.put('3', 2);
        coords.put('4', 3);
        coords.put('5', 4);
        coords.put('6', 5);
        coords.put('7', 6);
        coords.put('8', 7);
        
    }

    /**
     * Displays the current state of the board to the console.
     */

    private static void displayBoard() {

        for (int i = 0; i < 8; i ++){
            System.out.print("|");
            for (int j = 0; j < 8; j ++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    /**
     * Main game loop. Handles player turns and checks for game end conditions.
     */
    private static void startGame() {
        // Implement the game loop, handling player input, turn switching, and win
        // condition checking.
        Scanner scan = new Scanner(System.in);

        while(true){
            String input = scan.nextLine();
            if (!input.equals("exit")) {
                processMove(input);
                displayBoard();
            }else if(input.equals("view")){
                displayBoard();
            }
            else{
                System.exit(0);
            } 
        }
    }

    /**
     * Processes a player's move.
     * 
     * @param move A string representing the player's move (e.g., "C3 to D4").
     * @return true if the move is valid and executed, false otherwise.
     */
    private static boolean processMove(String move) {
        try {
            String moveFiltered = move.replace(" to", "");
            if (!move.equals(moveFiltered)){
                String[] moveArray = moveFiltered.split(" ");
                // check if two placements are given
                if (moveArray.length < 3) {
                    String s = "";
                    for (String e: moveArray){
                        s += e;
                    }
                    char[] c = s.toCharArray();

                    if (!Character.isUpperCase(c[0]) || !Character.isUpperCase(c[2])){
                        System.out.println("Incorrect input!");
                    }else{
                        try{
                            for (Character e: c){
                                coordsList.add(coords.get(e));
                            }

                            for (Integer j: coordsList){
                                if(j == null){
                                    System.out.println("Incorrect input!");
                                    return false;
                                }
                            isValidMove(coordsList);
                            }

                        }catch (Exception e){
                            System.out.println("Incorrect input!");
                        }
                    }
                }
                return true;
            }else{
                System.out.println("Incorrect input!");
            }
        } catch (Exception e) {
            System.out.println("Incorrect input!");
        }
        return false;
    }

    /**
     * Checks if a move is valid.
     */
    private static boolean isValidMove(coordsList) {
        // Implement this method to check if a move is legal according to the rules of
        // Checkers.
        if (board[coordsList[0]][coordsList[1]] == 'w'|| board[coordsList[0]][coordsList[1]] == 'b'){
            return true;
        }
        return false;
    }

    /**
     * Checks if the game has ended.
     * 
     * The program should terminate if the game has finished.
     */
    private static void isGameOver() {
        // Implement this method to check for win conditions.
    }

    /**
     * Main method to run the game.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        initialiseBoard();
        displayBoard();
        startGame();
    }
}
