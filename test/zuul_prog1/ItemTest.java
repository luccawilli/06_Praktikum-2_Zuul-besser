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
public class ItemTest extends TestCase {
    
    public ItemTest(String testName) {
        super(testName);
    }

    /**
     * Test of GetName method, of class Item.
     */
    public void testGetName() {
        System.out.println("GetName");
        Item instance = new Item("Hallo", 1);
        String expResult = "Hallo";
        String result = instance.GetName();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetDesciption method, of class Item.
     */
    public void testGetDesciption() {
        System.out.println("GetDesciption");
        Item instance = new Item("Hallo", 1);
        String expResult = "";
        String result = instance.GetDesciption();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetWeight method, of class Item.
     */
    public void testGetWeight() {
        System.out.println("GetWeight");
        Item instance = new Item("Hallo", 1);
        int expResult = 1;
        int result = instance.GetWeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetDamage method, of class Item.
     */
    public void testGetDamage() {
        System.out.println("GetDamage");
        Item instance = new Item("Hallo", 1);
        int expResult = 0;
        int result = instance.GetDamage();
        assertEquals(expResult, result);
    }
    
}
