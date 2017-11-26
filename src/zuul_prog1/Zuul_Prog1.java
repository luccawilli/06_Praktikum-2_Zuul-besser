package zuul_prog1;

import javax.swing.*;
/**
 * Mainclass of the zuul project
 * @author Lucca
 */
public class Zuul_Prog1 {

    /**
     * inits the view, which starts the game
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
      View g = new View();
      g.setContentPane(g.getContentPane());
      g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      g.pack();      
     
      g.setVisible(true);     
    }    
}
