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
public class RoomTest extends TestCase {
    
    public RoomTest(String testName) {
        super(testName);
    }

    /**
     * Test of SetExit method, of class Room.
     */
    public void testSetExit() {
        System.out.println("SetExit");
        CardinalPoints direction = CardinalPoints.East;
        Room neighbor = new Room("A", getClass().getResource("pictures/roomZuhausePicture.jpg"));
        Room instance = new Room("B", getClass().getResource("pictures/roomZuhausePicture.jpg"));
        instance.SetExit(direction, neighbor);
    }

    /**
     * Test of Enter method, of class Room.
     */
    public void testEnter() {
        System.out.println("Enter");
        Person person = new Person("P", 10, 10, 10, null, 10, getClass().getResource("pictures/roomZuhausePicture.jpg"));
        Room instance = new Room("B", getClass().getResource("pictures/roomZuhausePicture.jpg"));
        instance.Enter(person);
    }

    /**
     * Test of Leave method, of class Room.
     */
    public void testLeave() {
        System.out.println("Leave");
        int number = 0;
        Person person = new Person("P", 10, 10, 10, null, 10, getClass().getResource("pictures/roomZuhausePicture.jpg"));
        Room instance = new Room("B", getClass().getResource("pictures/roomZuhausePicture.jpg"));
        instance.Enter(person);
        Person expResult = person;
        Person result = instance.Leave(number);
        assertEquals(expResult, result);
    }

    /**
     * Test of GetPerson method, of class Room.
     */
    public void testGetPerson() {
        System.out.println("GetPerson");
        int number = 0;
        Person person = new Person("P", 10, 10, 10, null, 10, getClass().getResource("pictures/roomZuhausePicture.jpg"));
        Room instance = new Room("B", getClass().getResource("pictures/roomZuhausePicture.jpg"));
        instance.Enter(person);
        Person expResult = person;
        Person result = instance.GetPerson(number);
        assertEquals(expResult, result);
    }

    /**
     * Test of GetPersons method, of class Room.
     */
    public void testGetPersons() {
        System.out.println("GetPersons");
        Room instance = new Room("B", getClass().getResource("pictures/roomZuhausePicture.jpg"));
        ArrayList<Person> expResult = new ArrayList<Person>();
        ArrayList<Person> result = instance.GetPersons();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetItems method, of class Room.
     */
    public void testGetItems() {
        System.out.println("GetItems");
        Room instance = new Room("B", getClass().getResource("pictures/roomZuhausePicture.jpg"));
        ArrayList<Item> expResult = new ArrayList<Item>();
        ArrayList<Item> result = instance.GetItems();
        assertEquals(expResult, result);
    }

    /**
     * Test of InsertItem method, of class Room.
     */
    public void testInsertItem() {
        System.out.println("InsertItem");
        Item item = new Item("Box", 1);
        Room instance = new Room("B", getClass().getResource("pictures/roomZuhausePicture.jpg"));
        instance.InsertItem(item);        
    }

    /**
     * Test of RemoveItem method, of class Room.
     */
    public void testRemoveItem() {
        System.out.println("RemoveItem");
        int number = 0;
        Item item = new Item("Box", 1);
        Room instance = new Room("B", getClass().getResource("pictures/roomZuhausePicture.jpg"));
        instance.InsertItem(item);
        Item expResult = item;
        Item result = instance.RemoveItem(number);
        assertEquals(expResult, result);
    }

    /**
     * Test of GetDescription method, of class Room.
     */
    public void testGetDescription() {
        System.out.println("GetDescription");
        Room instance = new Room("B", getClass().getResource("pictures/roomZuhausePicture.jpg"));
        String expResult = "B";
        String result = instance.GetDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetLongDescription method, of class Room.
     */
    public void testGetLongDescription() {
        System.out.println("GetLongDescription");
        Room instance = new Room("B", getClass().getResource("pictures/roomZuhausePicture.jpg"));
        String expResult = "B" + ".\n" + "Ausgaenge: \n" +
            "Keine Gegenstaende im Raum.\n" +
            "Keine Personen im Raum.\n";
        String result = instance.GetLongDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of GetExist method, of class Room.
     */
    public void testGetExist() {
        System.out.println("GetExist");
        CardinalPoints direction = CardinalPoints.East;
        Room neighbor = new Room("A", getClass().getResource("pictures/roomZuhausePicture.jpg"));
        Room instance = new Room("B", getClass().getResource("pictures/roomZuhausePicture.jpg"));
        instance.SetExit(direction, neighbor);        
        
        Room expResult = neighbor;
        Room result = instance.GetExist(direction);
        assertEquals(expResult, result);        
    }

    /**
     * Test of GetImagePath method, of class Room.
     */
    public void testGetImagePath() {
        System.out.println("GetImagePath");
        Room instance = new Room("B", getClass().getResource("pictures/roomZuhausePicture.jpg"));
        URL expResult = getClass().getResource("pictures/roomZuhausePicture.jpg");
        URL result = instance.GetImagePath();
        assertEquals(expResult, result);
    }
    
}
