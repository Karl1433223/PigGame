/**
 * This is the skeleton of the Pig game. It is your job to fill in the empty
 functions to create a functional game of pig.
 * @author Adam Smith. Modified by Brian Wilkinson
 * @version 1.2
 */
class Pig {
    /**
     * The score needed to win a round.
     */
    private static int score = 0;
    private static int opponentScore =0;
    public static final int WINNING_SCORE = 100;
    public static void main(String[] args) {
// intro, initialize players
        System.out.println("Welcome to Pig!");
        PigPlayer human = new HumanPigPlayer("Human");
        PigPlayer opponent = new ComputerPigPlayer("Skynet"); // could be human too
        int[] roundsWon = new int[2];
// round 1
        System.out.println("Round 1!");
        if (playRound(human, opponent)) roundsWon[0]++;
        else roundsWon[1]++;
        System.out.println();
// round 2
        System.out.println("Round 2!");
        if (playRound(opponent, human)) roundsWon[1]++;
        else roundsWon[0]++;
// report the final results
        reportFinalTally(roundsWon, human, opponent);
    }
/**
 * Do one round, crediting the winner.
 * @param player1 the first player
 * @param player2 the second player
 * @return true if player1 won, false if player2
 */
    private static boolean playRound(PigPlayer player1, PigPlayer player2)
    {
        // This function must do the following:
        // 1. Enter a loop, with player 1 taking a turn, then player 2.
        // 2. Keep track of each player's score and the turn number.
        // 3. When a player wins, print the winner, and break out of the loop.
        // 4. Return a boolean value


        int turnNum =0;


        while (score <100 && opponentScore<100){
            int result =playTurn(player1,turnNum,score,opponentScore);
            int result1=playTurn(player2,turnNum,score,opponentScore);
            score+=result;
            opponentScore+=result1;

            turnNum++;

            System.out.println("This is you current score" +score);
            System.out.println("This is you current score" +opponentScore);

            }





    return false;
    }
/**
 * Play a single turn, returning how many points the player got.
 * @param player the player whose turn it is
 * @param turnNum the turn number (0-indexed)
 * @param score the player's score
 * @param opponentsScore the player's adversary's score
 * @return the points that the player won
 */
    private static int playTurn(PigPlayer player, int turnNum, int score, int opponentsScore) {
        // This function must do the following:
        // 1. Call the player's beginTurn() method.
        // 2. Loop so long as the player wants to continue rolling.
        // 3. Roll a die:
            // a. If a 1 is rolled, return 0.
            // b. On any other roll, add it to the pool.
        // 4. If the loop ends, return the pool's value.
        // 5. Be sure to print events frequently, so the human player can see what's happening!
        player.beginTurn(score,opponentsScore);
        int rollNum = 0;
        int pollSize = 0;

        while(player.decideIfShouldRoll(turnNum,rollNum,pollSize,score,opponentsScore)){

             int random = (int) (Math.random() * (6 )+1);
            System.out.println(random);
             if(random ==1){
                 System.out.println("You got 1");
                 return 0;

             }

             else{ pollSize+=random;
             }
             rollNum+=1;

        }

        return pollSize;
    }
    /**
     * Deliver a final report, indicating the overall winner after all
     rounds
     * have been played.
     * @param roundsWon an array of <code>int</code>s indicating the
    number of rounds each player won
     * @param player1 the first player
     * @param player2 the second player
     */

    private static void reportFinalTally(int[] roundsWon, PigPlayer player1, PigPlayer player2) {
        // This function must do the following:
        // 1. Print out both player's scores.
        // 2. Indicate who the winner was (or if there was a tie).
        System.out.println(score);
        System.out.println(opponentScore);
        if (score>opponentScore){
            System.out.println("Human is the winner");}
        if (score<opponentScore){
            System.out.println("Opponent is the winner");
        }
    }
}