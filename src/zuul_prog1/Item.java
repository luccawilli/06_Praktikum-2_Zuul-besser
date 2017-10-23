package zuul_prog1;
/**
 * Diese Klasse modeliert einen Gegenstand
 * mit seinem Namen und seiner Beschreibung sowie 
 * seinem Gewicht.
 *  
 * @author tebe
 * @version 1.0
 *
 */
public class Item {
	private final String name;
	private final String description;
	private final int weight;
        private final int damage;
        private final boolean isWeapon;
        
	
	/**
	 * Erzeugt einen Gegenstand mit Namen und 
	 * Gewicht aber ohne genauere Beschreibung.
	 * 
	 * Der Name darf nicht null sein und das
	 * Gewicht muss groesser als 0 sein.
	 *  
	 * @param name Der Name des Gegenstands
	 * @param gewicht Das Gewicht des Gegenstands
	 */
	public Item(String name, int gewicht) {
		this(name, "", gewicht, 0, false);
	}

	/**
	 * Erzeugt einen Gegenstand mit Namen und 
	 * Gewicht und genauere Beschreibung.
	 * 
	 * Name und Beschreibung duerfen nicht null sein und das
	 * Gewicht muss groesser als 0 sein.
	 * 
	 * @param name Der Name des Gegenstands
	 * @param gewicht Das Gewicht des Gegenstands
	 */
	public Item(String name, String beschreibung, int gewicht, int damage, boolean isWeapon){		
		this.name = name;
		this.weight = gewicht;
		this.description = beschreibung;
                this.damage = damage;
                this.isWeapon = isWeapon;
		if(! isDefinitionValid()) {
			throw new IllegalArgumentException(
					"Gegenstandsdefinition ist ungueltig.");
		}
	}
	
	private boolean isDefinitionValid(){
		return !(name == null || description == null || weight <= 0);
	}
	
	/**
	 * @return Der Name des Gegenstands
	 */
	public String GetName() {
		return name;
	}

	/**
	 * Gibt die Beschreibung des Gegenstandes zurueck.
	 * Falls der Gegenstand ueber keine Beschreibung
	 * verfuegt, wird ein leerer String zurueckgegeben.
	 * @return Die Beschreibung des Gegenstands
	 */
	public String GetDesciption() {
		return description;
	}

	/**
	 * @return Das Gewicht des Gegenstands
	 */
	public int GetWeight() {
		return weight;
	}
        
        /**
	 * @return the damage of the item
	 */
	public int GetDamage() {
		return damage;
	}
        
        /**
	 * @return the is Weapon of the item
	 */
	public boolean IsWeapon() {
		return isWeapon;
	}
}
