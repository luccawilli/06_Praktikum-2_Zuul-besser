package zuul_prog1;

import java.net.URL;
import java.util.ArrayList;
/**
 * Diese Klasse modeliert eine Person, die einen Namen
 * hat und einen Rucksack traegt. Im Rucksack kann sie 
 * Gegenstaende herumtragen. Gegenstaende sollen nur dann in den
 * Rucksack gepackt werden, wenn der Rucksack nicht schwerer wird
 * als die Tragkraft der Person. 
 * 
 * @author tebe
 * @version 1.0
 *
 */
public class Person {
	private final String name;
        private int lifePoints;
        private final int weight;
        private final int damage;
	private final int capacity;
        private final URL imagePath;
        private Item weapon;
	private final ArrayList<Item> backpack = new ArrayList<Item>();

	/**
	 * Erzeugt eine Person mit Namen und Tragkraft.
        * @param name
	* @param capacity
        * @param lifePoints
        * @param damage
        * @param weapon
        * @param weight
        * @param imagePath
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

	public ArrayList<Item> GetBackpack() {
		return backpack;
	}
        
        public Item RemoveBackpackItem(int nr){
            boolean ungueltigerIndex = backpack.isEmpty() || 
    			nr > backpack.size()-1 || nr < 0;
            return ungueltigerIndex ? null : backpack.remove(nr);
        }

	/**
	 * Gibt die Tragkraft zurueck.
	 * @return Die Tragkraft
	 */
	public int GetCapacity() {
		return capacity;
	}

	/**
	 * @return Der Name der Person
	 */
	public String GetName() {
		return name;
	}
        
        /**
	 * @return the lifepoints of the person
	 */
	public int GetLifePoints() {
		return lifePoints;
	}
        
        public void SetLifePoints(int newLifePoints){
                lifePoints = newLifePoints;
        }
        
        /**
	 * @return the damage of the person
	 */
	public int GetDamage() {
            if(weapon != null){
                return damage + weapon.GetDamage();
            }
            else{
                return damage;
            }		
	}
        
        /**
	 * @return the weapon of the person
	 */
	public Item GetWeapon() {
		return weapon;
	}
        
        /**
         * sets the weapon of the person
	 */
	public void SetWeapon(Item newWeapon) {
                weapon = newWeapon;
	}
        
        /**
	 * @return the weight of the person
	 */
	public int GetWeight() {
		return weight;
	}
        
        /**
	 * @return the image of the person
	 */
	public URL GetImagePath() {
		return imagePath;
	}
        
}
