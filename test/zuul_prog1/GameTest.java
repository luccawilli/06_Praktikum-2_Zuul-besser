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
public class GameTest extends TestCase {
    
    public GameTest(String testName) {
        super(testName);
    }

    /**
     * Test of writeDown method, of class Game.
     */
    public void testWriteDown() {
        System.out.println("writeDown");
        String text = "";
        Game instance = new Game(new View());
        instance.writeDown(text);
    }

    /**
     * Test of look method, of class Game.
     */
    public void testLook() {
        System.out.println("look");
        Game instance = new Game(new View());
        instance.look();
    }

    /**
     * Test of takeItem method, of class Game.
     */
    public void testTakeItem() {
        System.out.println("takeItem");
        int nr = 0;
        Game instance = new Game(new View());
        instance.takeItem(nr);
    }

    /**
     * Test of controlPerson method, of class Game.
     */
    public void testControlPerson() {
        System.out.println("controlPerson");
        int number = 0;
        Game instance = new Game(new View());
        instance.controlPerson(number);
    }

    /**
     * Test of changeRoom method, of class Game.
     */
    public void testChangeRoom() {
        System.out.println("changeRoom");
        CardinalPoints direction = null;
        Game instance = new Game(new View());
        instance.changeRoom(direction);
    }

    /**
     * Test of killPerson method, of class Game.
     */
    public void testKillPerson() {
        System.out.println("killPerson");
        int nr = 0;
        Game instance = new Game(new View());
        instance.killPerson(nr);
    }

    /**
     * Test of takeAsWeapon method, of class Game.
     */
    public void testTakeAsWeapon() {
        System.out.println("takeAsWeapon");
        int nr = 0;
        Game instance = new Game(new View());
        instance.takeAsWeapon(nr);
    }

    /**
     * Test of removeAsWeapon method, of class Game.
     */
    public void testRemoveAsWeapon() {
        System.out.println("removeAsWeapon");
        Game instance = new Game(new View());
        instance.removeAsWeapon();
    }
    
}
