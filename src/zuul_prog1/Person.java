package zuul_prog1;

import java.net.URL;
import java.util.ArrayList;

/**
 * The person class, which defines persons.
 * @author tebe and Lucca Willi
 * @version 1.0
 *
 */
public class Person {

    /**
     * The name of the person.
     */
    private final String name;
    
    /**
     * The lifepoints of the person.
     */
    private int lifePoints;
    
    /**
     * The weight of the person.
     */
    private final int weight;
    
    /**
     * The damage the person can generated.
     */
    private final int damage;
    
    /**
     * The capacity of how many weight a person can carry.
     */
    private final int capacity;
    
    /**
     * The image path of the person.
     */
    private final URL imagePath;
    
    /**
     * The weapon that the person holds.
     */
    private Item weapon;
    
    /**
     * The inventory of the person.
     */
    private final ArrayList<Item> inventory = new ArrayList<Item>();

    /**
     * Creates a person.
     * @param name The name of the person
     * @param capacity The capacity
     * @param lifePoints The lifepoints the person has.
     * @param damage The damage a person can give.
     * @param weapon The weapon the person carries.
     * @param weight The weight of the person.
     * @param imagePath The image path of the persons image.
     */
    public Person(String name, int capacity, int lifePoints, int damage, Item weapon, int weight, URL imagePath) {
        this.capacity = capacity;
        this.name = name;
        this.lifePoints = lifePoints;
        this.damage = damage;
        this.weapon = weapon;
        this.weight = weight;
        this.imagePath = imagePath;
    }

    /**
     * Gets the inventory of the person.
     * @return A arraylist of the inventory.
     */
    public ArrayList<Item> GetInventory() {
        return inventory;
    }

    /**
     * Removes an item with the given number from the inventory.
     * @param nr The index of the item in the inventory.
     * @return The removed item.
     */
    public Item RemoveInventoryItem(int nr) {
        boolean ungueltigerIndex = inventory.isEmpty()
                || nr > inventory.size() - 1 || nr < 0;
        return ungueltigerIndex ? null : inventory.remove(nr);
    }

    /**
     * Gets the capacity.
     * @return The capacity of the person.
     */
    public int GetCapacity() {
        return capacity;
    }

    /**
     * Gets the name of the person.
     * @return The name of the person.
     */
    public String GetName() {
        return name;
    }

    /**
     * Gets the lifepoints of the person.
     * @return The lifepoints
     */
    public int GetLifePoints() {
        return lifePoints;
    }

    /**
     * Sets the lifepoint of the person
     * @param newLifePoints The new lifepoint value.
     */
    public void SetLifePoints(int newLifePoints) {
        lifePoints = newLifePoints;
    }

    /**
     * Gets the damage (plus the damge of the weapon).
     * @return The damage of the person.
     */
    public int GetDamage() {
        if (weapon != null) {
            return damage + weapon.GetDamage();
        } else {
            return damage;
        }
    }

    /**
     * Gets the weapon of the person.
     * @return The weapon of the person
     */
    public Item GetWeapon() {
        return weapon;
    }

    /**
     * Sets the weapon of the person
     */
    public void SetWeapon(Item newWeapon) {
        weapon = newWeapon;
    }

    /**
     * Gets the weight of the person.
     * @return The weight of the person.
     */
    public int GetWeight() {
        return weight;
    }

    /**
     * Gets the image of the person
     * @return The image path of the person.
     */
    public URL GetImagePath() {
        return imagePath;
    }

}
