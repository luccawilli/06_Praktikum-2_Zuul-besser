package zuul_prog1;

/**
 *  Interface to get the events of the game class.
 *  @author Lucca Willi
 */
public interface IGame {
    /**
     * Method to write returned text.
     * @param text The text to write.
     */
    void writeDown(String text);
    
    /**
     * Method to call game over -- end the game
     */
    void gameOver();
}
