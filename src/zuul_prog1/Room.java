package zuul_prog1;

import java.net.URL;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;

/**
 * Diese Klasse modelliert Raeume in der Welt von Zuul.
 * 
 * Ein "Raum" repraesentiert einen Ort in der virtuellen Landschaft des
 * Spiels. Ein Raum ist mit anderen Raeumen ueber Ausgaenge verbunden.
 * Fuer jeden existierenden Ausgang haelt ein Raum eine Referenz auf 
 * den benachbarten Raum. In einem Raum koennen sich Personen und 
 * Gegenstaende befinden. 
 * 
 * @author  tebe (Original: Michael Koelling und David J. Barnes)
 * @version 1.0
 */

class Room 
{
    private final String description;
    private final URL imagePath;
    private final ArrayList<Person> persons = new ArrayList<Person>();
    private final ArrayList<Item> items = new ArrayList<Item>();
    public final HashMap<CardinalPoints, Room> exits = new HashMap<CardinalPoints, Room>();

    /**
     * Erzeuge einen Raum mit einer Beschreibung. Ein Raum
     * hat anfangs keine Ausgaenge, Personen oder Gegenstaende.
     * @param beschreibung enthaelt eine Beschreibung in der Form
     *        "in einer Kueche" oder "auf einem Sportplatz".
     */
    public Room(String beschreibung, URL imagePath) 
    {
        this.description = beschreibung; 
        this.imagePath = imagePath;
    }

    /**
     * Definiere einen Ausgang fuer diesen Raum.
     * @param direction Die Richtung, in der der Ausgang liegen soll
     * @param neighbor Der Raum, der ueber diesen Ausgang erreicht wird
     */
    public void SetExit(CardinalPoints direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
        CardinalPoints againstDirection = CardinalPoints.North;
        switch(direction){            
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
     * Die Person betritt den Raum und wird fortan als im Raum
     * befindlich gelistet.
     * @param person Person, welche den Raum betritt
     */
    public void Enter(Person person) 
    {
        this.persons.add(person);
    }
    
    /**
     * Die Person mit der angegebenen Nummer wird aus dem Raum entfernt 
     * und wird fortan nicht mehr als im Raum befindlich gelistet.
     * Falls eine Person mit dieser Nummer nicht existiert, wird 'null' 
     * zurueckgegeben.
     * @param nummer Nummer der Person
     * @return Person, die den Raum verlassen hat
     */
    public Person Leave(int nummer) 
    {
    	boolean ungueltigerIndex = persons.isEmpty() || 
    			nummer > persons.size()-1 || nummer < 0;
        return ungueltigerIndex ? null : persons.remove(nummer);
    }
    
    public Person GetPerson(int nummer){
        boolean ungueltigerIndex = persons.isEmpty() || 
    			nummer > persons.size()-1 || nummer < 0;
        return ungueltigerIndex ? null : persons.get(nummer);
    }
    
    public ArrayList<Person> GetPersons(){
        return persons;
    }
    
     public ArrayList<Item> GetItems(){
        return items;
    }
    
    /**
     * Der Gegenstand wird in den Raum gelegt und wird fortan als im
     * Raum befindlich gelistet. 
     * @param gegenstand Gegenstand, welcher in den Raum gelegt wird
     */
    public void InsertItem(Item gegenstand) 
    {
        this.items.add(gegenstand);
    }   
    
    /**
     * Der Gegenstand mit der angegebenen Nummer wird aus dem Raum entfernt 
     * und wird fortan nicht mehr als im Raum befindlich gelistet.
     * Falls ein Gegenstand mit dieser Nummer nicht existiert, wird 'null' 
     * zurueckgegeben.
     * @param nummer Nummer des Gegenstands
     * @return Gegenstand, der herausgenommen wurde
     */
    public Item RemoveItem(int nummer) 
    {
    	boolean ungueltigerIndex = items.isEmpty() || 
    			nummer > items.size()-1 || nummer < 0;
        return ungueltigerIndex ? null : items.remove(nummer);
    }
    
    /**
     * @return Die kurze Beschreibung dieses Raums (die dem Konstruktor
     * uebergeben wurde).
     */
    public String GetDescription()
    {
        return description;
    }

    /**
     * Liefere eine lange Beschreibung dieses Raums, inkl.
     * Beschreibung des Rauminhaltes (Gegenstaende, Personen,...).
     * @return eine lange Beschreibung dieses Raumes.
     */
    public String GetLongDescription()
    {
        return description + ".\n" 
        		+ getExistsAsString()
        		+ getItemsAsString()
        	    + getPersonsAsString();
    }

    private String getItemsAsString() {
    	String text = "Keine Gegenstaende im Raum.\n";
    	if(items.size()>0) {
	    	int counter = 0;
	    	text = "Gegenstaende im Raum:\n";
	    	for( Item objekt : items) {
	    		text += " " + counter++ + ": " + objekt.GetName() + "\n";
	    	}
    	}
    	return text;
    }

    private String getPersonsAsString() {
		String text = "Keine Personen im Raum.\n";
    	if(persons.size()>0){
    		text="Personen im Raum:\n";
        	int counter = 0;
        	for( Person objekt : persons) {
        		text += " " + counter++ + ": " + objekt.GetName() + "\n";
        	}
    	}    	
    	return text;
    }

    /**
     * Liefere eine Zeichenkette, die die Ausgaenge dieses Raums
     * beschreibt, beispielsweise
     * "Ausgaenge: north west".
     * @return eine Beschreibung der Ausgaenge dieses Raumes.
     */
    private String getExistsAsString()
    {
        String ergebnis = "Ausgaenge: ";
        Set<CardinalPoints> keys = exits.keySet();
        for(CardinalPoints ausgang : keys)
            ergebnis += ausgang + ", " ;
        return ergebnis + "\n";
    }

    /**
     * Liefere den Raum, den wir erreichen, wenn wir aus diesem Raum
     * in die angegebene Richtung gehen. Liefere 'null', wenn in
     * dieser Richtung kein Ausgang ist.
     * @param richtung die Richtung, in die gegangen werden soll.
     * @return den Raum in der angegebenen Richtung.
     */
    public Room GetExist(CardinalPoints richtung) 
    {
        return exits.get(richtung);
    }
    
    /**
     * 
     * @return 
     */
    public URL GetImagePath() {
        return imagePath;
    }
        
}

