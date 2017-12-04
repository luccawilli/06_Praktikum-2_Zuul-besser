package zuul_prog1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * The game class, which contains the whole game.
 *
 * @author tebe (Original: Michael Koelling und David J. Barnes) and Lucca Willi
 * @version 1.1
 */
public class Game {

    /**
     * The current shown room.
     */
    public Room currentLocation;
    
    /**
     * The player, the person which is controled.
     */
    public Person player;
    
    /**
     * The background music player.
     */
    public MusicPlayer musicPlayer;
    
    /**
     * The interface events listener.
     */
    private List<IGame> listeners = new ArrayList<IGame>();
    
    /**
     * The array string with some random text for the kill method.
     */
    private final String[] randomDialog = {
        "Au du tust mir weh!!", 
        "Oh nein, du hast mich getroffen!", 
        "Was ist den mit dir los?", 
        "Neeeiiiin!!??", 
        "Ups?",
        "Man schlägt keine Frauen.",
        "Was sind Sie den für ein Mann!!",
    }; 

    /**
     * Creates the game.
     * @param actionListener The action listener, for overriding the events.
     */
    public Game(IGame actionListener) {
        listeners.add(actionListener);
        generateWorld();
        start();
        musicPlayer = new MusicPlayer();
        musicPlayer.start();
    }

    /**
     * Listener for the write down method of the igame interface.
     * Should be shown in the view.
     * @param text The text which will be written.
     */
    public void writeDown(String text) {
        // Notify everybody that may be interested.
        for (IGame hl : listeners) {
            hl.writeDown(text);   
        }
    }
    
    /**
     * Listener for the game over method of the igame interface.
     * Which disabled a big part of the controls.
     */
    private void gameOver(){
         // Notify everybody that may be interested.
        for (IGame hl : listeners) {
            hl.gameOver();   
        }
    }

    /**
     * Generates the game world.
     * And fills the rooms, items and the people into it.
     */
    private void generateWorld() {
        player = new Person("Captain Kirk", 220, 150, 100, null, 83, getClass().getResource("pictures/personCaptainKrikPicture.jpg"));
        ArrayList<Room> raeume = createRooms();
        fillWithPersons(raeume);
        fillWithItems(raeume);
    }

    /**
     * Creates the rooms and their exits.
     * @return The created rooms with exits as an arraylist.
     */
    private ArrayList<Room> createRooms() {
        HashMap<String, Room> raum = new HashMap<>();
        // create rooms     
        raum.put("home", new Room("Zuhause", getClass().getResource("pictures/roomZuhausePicture.jpg")));
        raum.put("svens", new Room("Sven's Pizza", getClass().getResource("pictures/roomSvenPizzaPicture.jpg")));
        raum.put("mainplace", new Room("Marktplatz", getClass().getResource("pictures/roomMarktplatzPicture.jpg")));
        raum.put("bhf", new Room("Bahnhof", getClass().getResource("pictures/roomHauptbahnhofPicture.jpg")));
        raum.put("pier", new Room("Hafen", getClass().getResource("pictures/roomHafenPicture.jpg")));
        raum.put("park", new Room("Park vor der Universitaet", getClass().getResource("pictures/roomParkPicture.jpg")));
        raum.put("draussen", new Room("Haupteingang der Universitaet", getClass().getResource("pictures/roomUniEingangPicture.jpg")));
        raum.put("hoersaal", new Room("Vorlesungssaal", getClass().getResource("pictures/roomHoersaalPicture.jpg")));
        raum.put("cafeteria", new Room("Cafeteria der Uni", getClass().getResource("pictures/roomCafeteriaPicture.jpg")));
        
        // create exits
        raum.get("home").SetExit(CardinalPoints.North, raum.get("mainplace"));
        raum.get("svens").SetExit(CardinalPoints.East, raum.get("mainplace"));
        raum.get("bhf").SetExit(CardinalPoints.South, raum.get("mainplace"));
        raum.get("pier").SetExit(CardinalPoints.West, raum.get("bhf"));
        raum.get("mainplace").SetExit(CardinalPoints.East, raum.get("park"));
        raum.get("park").SetExit(CardinalPoints.South, raum.get("draussen")); 
        raum.get("hoersaal").SetExit(CardinalPoints.West, raum.get("draussen"));
        raum.get("cafeteria").SetExit(CardinalPoints.East, raum.get("draussen"));
                
        // base room
        currentLocation = raum.get("draussen");
        ArrayList<Room> raumliste = new ArrayList<Room>();
        for (Room r : raum.values()) {
            raumliste.add(r);
        }
        return raumliste;
    }

    /**
     * Fills the person randomly into a room.
     * @param rooms The given rooms.
     */
    private void fillWithPersons(ArrayList<Room> rooms) {
        ArrayList<Person> person = new ArrayList<Person>();
        person.add(new Person("Dr. Hans Muster", 40, 110, 2, null, 82, getClass().getResource("pictures/personDrHansMusterPicture.jpg")));
        person.add(new Person("Peter Stark", 80, 200, 20, null, 87, getClass().getResource("pictures/personPeterStarkPicture.jpg")));
        person.add(new Person("Anna Pfister", 45, 90, 12, null, 65, getClass().getResource("pictures/personAnnaPfisterPicture.jpg")));
        person.add(new Person("Prof. Dr. Luna Berger", 35, 112, 15, null, 55, getClass().getResource("pictures/personProfDrLunaBergerPicture.jpg")));
        int counter = 0;
        while (person.size() > 0) {
            if (Math.random() > 0.5) {
                rooms.get(counter).Enter(person.get(0));
                person.remove(0);
            }
            counter = (counter + 1) % rooms.size();
        }
    }

    /**
     * Fills the rooms randomly with items.
     * @param rooms The given rooms.
     */
    private void fillWithItems(ArrayList<Room> rooms) {
        ArrayList<Item> gegenstand = new ArrayList<Item>();
        gegenstand.add(new Item("Sehr schwerer Laserpointer", 1));
        gegenstand.add(new Item("Beamer", 12));
        gegenstand.add(new Item("Workstation", 10));
        gegenstand.add(new Item("Wandtafel", 250));
        gegenstand.add(new Item("Mineralwasser (6x1.5L)", 9));
        gegenstand.add(new Item("Laptoptasche mit Laptop", 5));
        gegenstand.add(new Item("Flipchart", 11));
        gegenstand.add(new Item("Whiteboard", 8));
        gegenstand.add(new Item("Toeggelikasten", 30));
        int counter = 0;
        while (gegenstand.size() > 0) {
            if (Math.random() > 0.5) {
                rooms.get(counter).InsertItem(gegenstand.get(0));
                gegenstand.remove(0);
            }
            counter = (counter + 1) % rooms.size();
        }
    }

    /**
     * Writes the start text.
     */
    private void start() {
        writeDown("Willkommen zu Zuul! "
        +"\n Zuul ist ein neues, unglaublich langweiliges Spiel."
        +"\n\n"
        +currentLocation.GetLongDescription());
    }

    /**
     * Writes the current locations long description.
     */
    public void look() {
        writeDown("Sie sind: " + player.GetName() + "\n" + currentLocation.GetLongDescription());
    }
    
    /**
     * Adds the given item to the inventory and removes it from the room.     *
     * @param nr The index of the item.
     */
    public void takeItem(int nr) {
        Item gegenstand = currentLocation.RemoveItem(nr);
        if (gegenstand == null) {
            writeDown("Es gibt keinen Gegenstand mit dieser Nummer: "
                    + nr);
        } else {
            if (player.GetCapacity() >= calculateWeight(player) + gegenstand.GetWeight()) {
                writeDown("Gegenstand eingepackt: " + gegenstand.GetName());
                player.GetInventory().add(gegenstand);
            } else {
                writeDown("Gegenstand konnte nicht eingepackt werden, da er zu schwer ist.");
                currentLocation.InsertItem(gegenstand);
            }
        }
    }

    /**
     * Calculate the weight of the inventory.     *
     * @param person The person which inventory we want to weight.
     * @return The weight of all the items in the inventory.
     */
    private int calculateWeight(Person person) {
        int gewicht = 0;        
        for (Item gegenstand : person.GetInventory()) {
            gewicht += gegenstand.GetWeight();
        }
        Item item = person.GetWeapon();
        if(item != null){
            gewicht += item.GetWeight();
        }
        return gewicht;
    }

    /**
     * Change the person to control.
     * @param number The index of the person.
     */
    public void controlPerson(int number) {
        Person person = currentLocation.Leave(number);
        if (person == null) {
            writeDown("Es gibt keine Person mit Nummer " + number);
        } else {
            currentLocation.Enter(player);
            player = person;
            writeDown("Sie kontrollieren nun " + player.GetName());
        }
    }
    
    /**
     * Change the room.
     * @param direction The direction in which the room should be left.
     */
    public void changeRoom(CardinalPoints direction) {
        Room naechsterRaum = currentLocation.GetExist(direction);
        if (naechsterRaum == null) {
            writeDown("Dort ist keine Tuer!");
        } else {
            currentLocation = naechsterRaum;
            writeDown(currentLocation.GetLongDescription());
        }
    }

    /**
     * Kill the given person.
     * @param nr The index of the person which should be killed.
    */
    public void killPerson(int nr) {
        Person person = currentLocation.GetPerson(nr);
        String writeDown = "";
        if (person == null) {
            writeDown("Es gibt keine Person mit Nummer " + nr);
        } else {
            person.SetLifePoints(person.GetLifePoints() - player.GetDamage());
            writeDown = "Sie haben " + player.GetDamage() + " an " + person.GetName() + " angerichtet!! \n"
                    + "Restliche Lebenspunkte: " + person.GetLifePoints();
            writeDown += "\n Leider hat sich die Person gewehrt und hat einen Schaden von " + person.GetDamage() + " verursacht.";
            player.SetLifePoints(player.GetLifePoints() - person.GetDamage());
            if(player.GetLifePoints() <= 0){
                writeDown(writeDown + "\n Du bist leider gestorben.... Game Over.");
                gameOver();
                return;
            }
            Random gen = new Random();
            writeDown += "\n" + person.GetName() + ": " + randomDialog[gen.nextInt(randomDialog.length)];
            int deathMatch = gen.nextInt(2);
            if(deathMatch == 1){
                writeDown += "\nDu hast " + person.GetName() + " zu häufig geschlagen!! \n Das gibt einen Death-Match!!";
                while(person.GetLifePoints() > 0 && player.GetLifePoints() > 0){
                    player.SetLifePoints(player.GetLifePoints() - person.GetDamage());
                    writeDown += "\nDu hast " + person.GetDamage() + " kassiert!";
                    if(player.GetLifePoints() <= 0){                        
                        writeDown += "\n Du bist leider gestorben.... Game Over.";
                        gameOver();
                        break;
                    }
                    person.SetLifePoints(person.GetLifePoints() - player.GetDamage());
                    writeDown += "\n" + person.GetName() + " hat " + player.GetDamage() + " kassiert!";
                }                
                
            }
            if (person.GetLifePoints() <= 0) {
                writeDown += "\n Sie haben " + person.GetName() + " getötet!!";
                currentLocation.Leave(nr);
                Item corpse = new Item("Leiche von " + person.GetName(),
                        "Die Leiche von " + person.GetName() + ".",
                        person.GetWeight(),
                        person.GetDamage()
                );
                currentLocation.InsertItem(corpse);
            }
            
        }
        writeDown(writeDown);
    }   
    
    /**
     * Take the given item as weapon.
     * @param nr The index of the item to take as weapon.
     */
    public void takeAsWeapon(int nr) {
        try {            
            Item item = player.RemoveInventoryItem(nr);
            if (player.GetWeapon() != null) {
                player.GetInventory().add(player.GetWeapon());
                writeDown("Der Gegenstand " + item.GetName() + " wurde aus deiner Hand entfernt und in deinen Rucksack gelegt.");
            }
            player.SetWeapon(item);
            writeDown("Der Gegenstand " + item.GetName() + " ist nun deine Waffe! \n"
                    + "Er erhöht deinen Schaden um " + item.GetDamage());
        } catch (Exception ex) {
            writeDown("Geben Sie die Nummer des Gegenstandes ein.");
        }
    }    
    
    /**
     * Remove the item from the weapon-slot.     
     */
    public void removeAsWeapon() {
        try {
            if (player.GetWeapon() != null) {
                player.GetInventory().add(player.GetWeapon());
                writeDown("Der Gegenstand " + player.GetWeapon().GetName() + " wurde aus deiner Hand entfernt und in deinen Rucksack gelegt.");
                player.SetWeapon(null);
            }
        } catch (Exception ex) {
            writeDown("Geben Sie die Nummer des Gegenstandes ein.");
        }
    }    
}
