/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuul_prog1;

import junit.framework.TestCase;

/**
 *
 * @author Lucca
 */
public class ViewTest extends TestCase {
    
    public ViewTest(String testName) {
        super(testName);
    }

    /**
     * Test of writeDown method, of class View.
     */
    public void testWriteDown() {
        System.out.println("writeDown");
        String text = "";
        View instance = new View();
        instance.writeDown(text);
    }

    /**
     * Test of gameOver method, of class View.
     */
    public void testGameOver() {
        System.out.println("gameOver");
        View instance = new View();
        instance.gameOver();        
    }

    /**
     * Test of main method, of class View.
     */
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        View.main(args);
    }
    
}
