package zuul_prog1;

/**
 *  interface to get the events of the game class.
 */
public interface IGame {
    // method to write returned text.
    void writeDown(String text);
    // method to call game over -- end the game
    void gameOver();
}
