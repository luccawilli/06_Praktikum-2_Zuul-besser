package zuul_prog1;

import java.net.URL;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;

/**
 * Creates the rooms for zuul.
 *
 * @author tebe (Original: Michael Koelling und David J. Barnes and Lucca Willi
 * @version 1.1
 */
public class Room {
    /**
     * The discription of the room.
     */
    private final String description;
    
    /**
     * The image path for the picture of the room.
     */
    private final URL imagePath;
    
    /**
     * A list of all the person which are currently in this room.
     */
    private final ArrayList<Person> persons = new ArrayList<Person>();
    
    /**
     * A list of all the items which are currently in this room.
     */
    private final ArrayList<Item> items = new ArrayList<Item>();
    
    /**
     * A list of all the exists of this room.
     */
    public final HashMap<CardinalPoints, Room> exits = new HashMap<CardinalPoints, Room>();

    /**
     * Creates the room
     * @param beschreibung Contains the description of the room.
     * @param imagePath The image path for the image.
     */
    public Room(String beschreibung, URL imagePath) {
        this.description = beschreibung;
        this.imagePath = imagePath;
    }

    /**
     * Adds a exit to the room.
     * @param direction The direction in which the exit should be.
     * @param neighbor The room to which the exit should lead.
     */
    public void SetExit(CardinalPoints direction, Room neighbor) {
        exits.put(direction, neighbor);
        CardinalPoints againstDirection = CardinalPoints.North;
        switch (direction) {
            case North:
                againstDirection = CardinalPoints.South;
                break;
            case West:
                againstDirection = CardinalPoints.East;
                break;
            case East:
                againstDirection = CardinalPoints.West;
                break;
        }
        neighbor.exits.put(againstDirection, this);
    }

    /**
     * Adds a person to the room.
     * @param person The person which should be added.
     */
    public void Enter(Person person) {
        this.persons.add(person);
    }

    /**
     * Removes the person with the index number from the room.
     * @param number The index number of the person.
     * @return The person which will be removed.
     */
    public Person Leave(int number) {
        boolean ungueltigerIndex = persons.isEmpty()
                || number > persons.size() - 1 || number < 0;
        return ungueltigerIndex ? null : persons.remove(number);
    }

    /**
     * Gets the person with the index number from the room.
     * @param number The index number of the person.
     * @return The person with the given index.
     */
    public Person GetPerson(int number) {
        boolean ungueltigerIndex = persons.isEmpty()
                || number > persons.size() - 1 || number < 0;
        return ungueltigerIndex ? null : persons.get(number);
    }

    /**
     * Gets all persons in the room.
     * @return A arraylist, containing all the persons of the room. 
     */
    public ArrayList<Person> GetPersons() {
        return persons;
    }

    /**
     * Gets all items of the room.
     * @return A arraylist, containing all the items of the room.
     */
    public ArrayList<Item> GetItems() {
        return items;
    }

    /**
     * Adds a item to the room
     * @param item The item wich should be added.
     */
    public void InsertItem(Item item) {
        this.items.add(item);
    }

    /**
     * Removes the item with the index number from the room.
     * @param number The index of the item.
     * @return The item with the given index.
     */
    public Item RemoveItem(int number) {
        boolean ungueltigerIndex = items.isEmpty()
                || number > items.size() - 1 || number < 0;
        return ungueltigerIndex ? null : items.remove(number);
    }

    /**
     * Gets the description of the room.
     * @return The description.
     */
    public String GetDescription() {
        return description;
    }

    /**
     * Gets the long (better formated) description.
     * @return The long description.
     */
    public String GetLongDescription() {
        return description + ".\n"
                + getExistsAsString()
                + getItemsAsString()
                + getPersonsAsString();
    }

    /**
     * Gets the items as a string list.
     * @return The items as a formated string.
     */
    private String getItemsAsString() {
        String text = "Keine Gegenstaende im Raum.\n";
        if (items.size() > 0) {
            int counter = 0;
            text = "Gegenstaende im Raum:\n";
            for (Item objekt : items) {
                text += " " + counter++ + ": " + objekt.GetName() + "\n";
            }
        }
        return text;
    }

    /**
     * Gets the persons as a string list.
     * @return The persons as a formated string.
     */
    private String getPersonsAsString() {
        String text = "Keine Personen im Raum.\n";
        if (persons.size() > 0) {
            text = "Personen im Raum:\n";
            int counter = 0;
            for (Person objekt : persons) {
                text += " " + counter++ + ": " + objekt.GetName() + "\n";
            }
        }
        return text;
    }

    /**
     * Gets the exits as a string list.
     * @return The exits as a formated string.
     */
    private String getExistsAsString() {
        String ergebnis = "Ausgaenge: ";
        Set<CardinalPoints> keys = exits.keySet();
        for (CardinalPoints ausgang : keys) {
            ergebnis += ausgang + ", ";
        }
        return ergebnis + "\n";
    }

    /**
     * Gets the exit in the given direction.
     * @param direction The direction the exist lies.
     * @return 
     */
    public Room GetExist(CardinalPoints direction) {
        return exits.get(direction);
    }

    /**
     * Gets the image path of the room.
     * @return The image path as url.
     */
    public URL GetImagePath() {
        return imagePath;
    }
}
