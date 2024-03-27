import java.util.*;

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

        coords.put('A', 7);
        coords.put('B', 6);
        coords.put('C', 5);
        coords.put('D', 4);
        coords.put('E', 3);
        coords.put('F', 2);
        coords.put('G', 1);
        coords.put('H', 0);

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
        try (
        Scanner scan = new Scanner(System.in)) {
            while(true){
                String input = scan.nextLine();
                if (!input.equals("exit")) {
                    processMove(input, board);
                    displayBoard();
                }else if(input.equals("view")){
                    displayBoard();
                }
                else{
                    System.exit(0);
                } 
            }
        }
    }

    /**
     * Processes a player's move.
     * 
     * @param move A string representing the player's move (e.g., "C3 to D4").
     * @return true if the move is valid and executed, false otherwise.
     */
    private static boolean processMove(String move, char[][] board) {
        try {
            // makes the move inputted into a list
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

                    for(int i = 0; i < c.length; i++) {
                        c[i] = Character.toUpperCase(c[i]);
                    }

                    try{
                        for (Character e: c){
                            coordsList.add(coords.get(e));
                        }

                        for (Integer j: coordsList){
                            if(j == null){
                                System.out.println("Incorrect input!");
                                return false;
                            }
                        }
                        if (isValidMove(coordsList)){
                            board[coordsList.get(0)][coordsList.get(1)] = ' ';
                            board[coordsList.get(0)][coordsList.get(1)] = 'w';
                        }coordsList.clear();
                    }catch(Exception e){
                        return false;
                    }
                }
            }
        }catch(Exception e){
            return false;
        }
        return false;
    }

    /**
     * Checks if a move is valid.
     */
    private static boolean isValidMove(ArrayList<Integer> coordsList) {
        // Implement this method to check if a move is legal according to the rules of
        // Checkers.
        System.out.println(coordsList.toString());

        //white's turn
        if (board[coordsList.get(0)][coordsList.get(1)] == 'w' && board[coordsList.get(1)][coordsList.get(2)] == ' '){
            System.out.println("TRUE");
            return true;
        }
        //black's turn
        // if(board[coordsList.get(0)][coordsList.get(1)] == 'b' && board[coordsList.get(1)][coordsList.get(2)] == ' '){
        //     System.out.println("TRUE");
        //     return true;
        // }

        System.out.println("FALSE");
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
