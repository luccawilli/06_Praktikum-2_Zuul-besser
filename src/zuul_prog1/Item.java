package zuul_prog1;

/**
 * The item class, to generate items.
 *
 * @author tebe and Lucca Willi
 * @version 1.1
 *
 */
public class Item {

    /**
     * The name of the item.
     */
    private final String name;
    
    /**
     * The description of the item.
     */
    private final String description;
    
    /**
     * The weight of the item.
     */
    private final int weight;
    
    /**
     * The damage of the weapon. 
     * (Will be added to the damage the person given, when carried).
     */
    private final int damage;

    /**
     * Inits the item in short.
     * Don't leave the name blank.
     * @param name The name of the item.
     * @param weight The weight of the item.
     */
    public Item(String name, int weight) {
        this(name, "", weight, 0);
    }

    /**
     * Creates the whole item.
     * Don't leave the name blank.
     * @param name The name of the item.
     * @param description The desciription of the item.
     * @param weight The weight of the item.
     * @param damage The damge of the item.
     */
    public Item(String name, String description, int weight, int damage) {
        this.name = name;
        this.weight = weight;
        this.description = description;
        this.damage = damage;
        if (!isDefinitionValid()) {
            throw new IllegalArgumentException(
                    "Gegenstandsdefinition ist ungueltig.");
        }
    }

    /**
     * Checks if the definition in valid.
     * @return True if name, description are not null and the weigth is highter then 0.
     */
    private boolean isDefinitionValid() {
        return !(name == null || description == null || weight <= 0);
    }

    /**
     * Gets the name of the item.
     * @return The name.
     */
    public String GetName() {
        return name;
    }

    /**
     * The description of the item.
     * @return The description.
     */
    public String GetDesciption() {
        return description;
    }

    /**
     * Gets the weight of the item.
     * @return The weight.
     */
    public int GetWeight() {
        return weight;
    }

    /**
     * Gets the damage of the item.
     * @return The damage
     */
    public int GetDamage() {
        return damage;
    }
}
