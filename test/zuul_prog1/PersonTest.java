/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuul_prog1;

import java.net.URL;
import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author Lucca
 */
public class PersonTest extends TestCase {
    
    public PersonTest(String testName) {
        super(testName);
    }

    /**
     * Test of GetInventory method, of class Person.
     */
    public void testGetInventory() {
        System.out.println("GetInventory");
        Person instance = new Person("P", 10, 10, 10, null, 10, getClass().getResource("pictures/roomZuhausePicture.jpg"));
        ArrayList<Item> expResult = new ArrayList<Item>();
        ArrayList<Item> result = instance.GetInventory();
        assertEquals(expResult, result);
    }

    /**
     * Test of RemoveInventoryItem method, of class Person.
     */
    public void testRemoveInventoryItem() {
        System.out.println("RemoveInventoryItem");
        int nr = 0;
        Person instance = new Person("P", 10, 10, 10, null, 10, getClass().getResource("pictures/roomZuhausePicture.jpg"));
        Item item = new Item("I", 1);
        instance.GetInventory().add(item);
        Item expResult = item;
        Item result = instance.RemoveInventoryItem(nr);
        assertEquals(expResult, result);
    }

    /**
     * Test of GetCapacity method, of class Person.
     */
    public void testGetCapacity() {
        System.out.println("GetCapacity");
        Person instance = new Person("P", 10, 10, 10, null, 10, getClass().getResource("pictures/roomZuhausePicture.jpg"));
        int expResult = 10;
        int result = instance.GetCapacity();
        assertEquals(expResult, result);        
    }

    /**
     * Test of GetName method, of class Person.
     */
    public void testGetName() {
        System.out.println("GetName");
        Person instance = new Person("P", 10, 10, 10, null, 10, getClass().getResource("pictures/roomZuhausePicture.jpg"));
        String expResult = "P";
        String result = instance.GetName();
        assertEquals(expResult, result);        
    }

    /**
     * Test of GetLifePoints method, of class Person.
     */
    public void testGetLifePoints() {
        System.out.println("GetLifePoints");
        Person instance = new Person("P", 10, 10, 10, null, 10, getClass().getResource("pictures/roomZuhausePicture.jpg"));
        int expResult = 10;
        int result = instance.GetLifePoints();
        assertEquals(expResult, result);       
    }

    /**
     * Test of SetLifePoints method, of class Person.
     */
    public void testSetLifePoints() {
        System.out.println("SetLifePoints");
        int newLifePoints = 0;
        Person instance = new Person("P", 10, 10, 10, null, 10, getClass().getResource("pictures/roomZuhausePicture.jpg"));
        instance.SetLifePoints(newLifePoints);
        assertEquals(newLifePoints, instance.GetLifePoints()); 
    }

    /**
     * Test of GetDamage method, of class Person.
     */
    public void testGetDamage() {
        System.out.println("GetDamage");
        Person instance = new Person("P", 10, 10, 10, null, 10, getClass().getResource("pictures/roomZuhausePicture.jpg"));
        int expResult = 10;
        int result = instance.GetDamage();
        assertEquals(expResult, result);      
    }

    /**
     * Test of GetWeapon method, of class Person.
     */
    public void testGetWeapon() {
        System.out.println("GetWeapon");
        Person instance = new Person("P", 10, 10, 10, null, 10, getClass().getResource("pictures/roomZuhausePicture.jpg"));
        Item expResult = null;
        Item result = instance.GetWeapon();
        assertEquals(expResult, result);
    }

    /**
     * Test of SetWeapon method, of class Person.
     */
    public void testSetWeapon() {
        System.out.println("SetWeapon");
        Item newWeapon = new Item("I", "II", 10, 10);
        Person instance = new Person("P", 10, 10, 10, null, 10, getClass().getResource("pictures/roomZuhausePicture.jpg"));
        instance.SetWeapon(newWeapon);
        Item result = instance.GetWeapon();
        assertEquals(newWeapon, result);        
    }

    /**
     * Test of GetWeight method, of class Person.
     */
    public void testGetWeight() {
        System.out.println("GetWeight");
        Person instance = new Person("P", 10, 10, 10, null, 10, getClass().getResource("pictures/roomZuhausePicture.jpg"));
        int expResult = 10;
        int result = instance.GetWeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetImagePath method, of class Person.
     */
    public void testGetImagePath() {
        System.out.println("GetImagePath");
        Person instance = new Person("P", 10, 10, 10, null, 10, getClass().getResource("pictures/roomZuhausePicture.jpg"));
        URL expResult = getClass().getResource("pictures/roomZuhausePicture.jpg");
        URL result = instance.GetImagePath();
        assertEquals(expResult, result);
    }
    
}
