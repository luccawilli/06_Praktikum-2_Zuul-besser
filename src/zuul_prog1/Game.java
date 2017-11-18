package zuul_prog1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Dies ist die Hauptklasse der Anwendung "Die Welt von Zuul". "Die Welt von
 * Zuul" ist ein sehr einfaches, textbasiertes Adventure-Game. Ein Spieler kann
 * sich in einer Umgebung bewegen, die Kontrolle von anderen Personen im Raum
 * uebernehmen und Gegenstaende einpacken, sofern seine Tragkraft ausreicht. Das
 * Spiel sollte auf jeden Fall noch weiter ausgebaut werden, damit es
 * interessanter wird!
 *
 *
 * Diese Instanz dieser Klasse erzeugt und initialisiert alle anderen Objekte
 * der Anwendung: Sie legt alle Raeume und einen Parser an und startet das
 * Spiel. Sie wertet auch die Befehle aus, die der Parser liefert und sorgt fuer
 * ihre Ausfuehrung.
 *
 * @author tebe (Original: Michael Koelling und David J. Barnes)
 * @version 1.0
 */
public class Game {

    public Room currentLocation;
    public Person player;
    private List<IGame> listeners = new ArrayList<IGame>();
    private String[] randomDialog = {
        "Au du tust mir weh!!", 
        "Oh nein, du hast mich getroffen!", 
        "Was ist den mit dir los?", 
        "Neeeiiiin!!??", 
        "Ups?",
        "Man schlägt keine Frauen.",
        "Was sind Sie den für ein Mann!!",
    }; 

    /**
     * Erzeuge ein Spiel und initialisiere die Spielwelt.
     */
    public Game(IGame writeDownListener) {
        listeners.add(writeDownListener);
        generateWorld();
        start();
        MusicPlayer player = new MusicPlayer();
        player.start();
    }

    /**
     * Listener für die Ausgabe von Text.
     * Wird im View verwendet um den Text in die Textarea zu schreiben.
     * @param text Der zuschreibende Text
     */
    public void writeDown(String text) {
        // Notify everybody that may be interested.
        for (IGame hl : listeners) {
            hl.writeDown(text);   
        }
    }
    
    private void gameOver(){
         // Notify everybody that may be interested.
        for (IGame hl : listeners) {
            hl.gameOver();   
        }
    }

    /**
     * Baut die Spielewelt auf. Erzeugt die Raeume mit Verbindungen und fuellt
     * diese mit Personen und Gegenstaenden.
     */
    private void generateWorld() {
        player = new Person("Captain Kirk", 220, 10, 100, null, 83);
        ArrayList<Room> raeume = createRooms();
        fillWithPersons(raeume);
        fillWithItems(raeume);
    }

    /**
     * Erzeuge alle Raeume, verbinde ihre Ausgaenge miteinander.
     *
     * @return Die angelegten Raeume
     */
    private ArrayList<Room> createRooms() {
        HashMap<String, Room> raum = new HashMap<String, Room>();
        // die Raeume erzeugen       
        raum.put("home", new Room("Zuhause"));
        raum.put("svens", new Room("Sven's Pizza"));
        raum.put("mainplace", new Room("Marktplatz"));
        raum.put("bhf", new Room("Bahnhof"));
        raum.put("pier", new Room("Hafen"));
        raum.put("park", new Room("Park vor der Universitaet"));
        raum.put("draussen", new Room("Haupteingang der Universitaet"));
        raum.put("hoersaal", new Room("Vorlesungssaal"));
        raum.put("cafeteria", new Room("Cafeteria der Uni"));
        raum.put("labor", new Room("Rechnerraum"));
        raum.put("buero", new Room("Verwaltungsbuero der Informatik"));
        // die Ausgaenge initialisieren
        raum.get("home").SetExit(CardinalPoints.North, raum.get("mainplace"));
        raum.get("svens").SetExit(CardinalPoints.East, raum.get("mainplace"));
        raum.get("bhf").SetExit(CardinalPoints.South, raum.get("mainplace"));
        raum.get("pier").SetExit(CardinalPoints.West, raum.get("bhf"));
        raum.get("mainplace").SetExit(CardinalPoints.East, raum.get("park"));
        raum.get("park").SetExit(CardinalPoints.South, raum.get("draussen")); 
        raum.get("hoersaal").SetExit(CardinalPoints.West, raum.get("draussen"));
        raum.get("cafeteria").SetExit(CardinalPoints.East, raum.get("draussen"));
        raum.get("labor").SetExit(CardinalPoints.North, raum.get("draussen"));        
        raum.get("buero").SetExit(CardinalPoints.West, raum.get("labor"));

        // Startraum
        currentLocation = raum.get("draussen");
        ArrayList<Room> raumliste = new ArrayList<Room>();
        for (Room r : raum.values()) {
            raumliste.add(r);
        }
        return raumliste;
    }

    /**
     * Verteilt eine Anzahl Personen auf eine Liste von Raeumen. Die Zuteilung
     * erfolgt auf Basis einer Zufallsstrategie.
     *
     * @param raum Liste der Raeume
     */
    private void fillWithPersons(ArrayList<Room> raum) {
        ArrayList<Person> person = new ArrayList<Person>();
        person.add(new Person("Dr. Hans Muster", 40, 110, 2, null, 82));
        person.add(new Person("Peter Stark", 80, 200, 20, null, 87));
        person.add(new Person("Anna Pfister", 45, 90, 12, null, 65));
        person.add(new Person("Prof. Dr. Luna Berger", 35, 112, 15, null, 55));
        int counter = 0;
        while (person.size() > 0) {
            if (Math.random() > 0.5) {
                raum.get(counter).Enter(person.get(0));
                person.remove(0);
            }
            counter = (counter + 1) % raum.size();
        }
    }

    /**
     * Verteilt eine Anzahl Gegenstaende auf eine Liste von Raeumen. Die
     * Zuteilung erfolgt auf Basis einer Zufallsstrategie.
     *
     * @param raum Liste der Raeume
     */
    private void fillWithItems(ArrayList<Room> raum) {
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
                raum.get(counter).InsertItem(gegenstand.get(0));
                gegenstand.remove(0);
            }
            counter = (counter + 1) % raum.size();
        }
    }

    /**
     * Die Hauptmethode zum Spielen. Laeuft bis zum Ende des Spiels in einer
     * Schleife.
     */
    private void start() {
        writeDown("\n"
        +"Willkommen zu Zuul! \n"
        +"Zuul ist ein neues, unglaublich langweiliges Spiel. \n"
        +"\n"
        +currentLocation.GetLongDescription());
    }

    /**
     *
     */
    public void look() {
        writeDown("Sie sind: " + player.GetName());
        writeDown(currentLocation.GetLongDescription());
    }
    
    /**
     * Packt den Gegenstand mit der gegebenen Nummer, falls vorhanden, in den
     * Rucksack des Spielers und entfernt ihn aus dem aktuellen Raum.
     *
     * @param nr Nummer des Gegenstands
     */
    public void takeItem(int nr) {
        Item gegenstand = currentLocation.RemoveItem(nr);
        if (gegenstand == null) {
            writeDown("Es gibt keinen Gegenstand mit dieser Nummer: "
                    + nr);
        } else {
            if (player.GetCapacity() >= calculateWeight(player.GetBackpack()) + gegenstand.GetWeight()) {
                writeDown("Gegenstand eingepackt: " + gegenstand.GetName());
                player.GetBackpack().add(gegenstand);
            } else {
                writeDown("Gegenstand konnte nicht eingepackt werden, da er zu schwer ist.");
                currentLocation.InsertItem(gegenstand);
            }
        }
    }

    /**
     * Berechnet das Gewicht der Gegenstaende in dieser Liste
     *
     * @param rucksack Die Liste mit Gegenstaenden
     * @return Das Gewicht der Gegenstaende
     */
    private int calculateWeight(ArrayList<Item> rucksack) {
        int gewicht = 0;
        for (Item gegenstand : rucksack) {
            gewicht += gegenstand.GetWeight();
        }
        return gewicht;
    }

    /**
     * Uebernimmt, falls vorhanden, die Kontrolle der Person mit der
     * spezifizierten Nummer.
     *
     * @param nummer Nummer der Person
     */
    public void controlPerson(int nummer) {
        Person person = currentLocation.Leave(nummer);
        if (person == null) {
            writeDown("Es gibt keine Person mit Nummer " + nummer);
        } else {
            currentLocation.Enter(player);
            player = person;
            writeDown("Sie kontrollieren nun " + player.GetName());
        }
    }
    
    /**
     * Versuche, in eine Richtung zu gehen. Wenn es einen Ausgang gibt, wechsele
     * in den neuen Raum, ansonsten gib eine Fehlermeldung aus.
     * @param richtung
     */
    public void changeRoom(CardinalPoints richtung) {
        /*if (!befehl.GotSecondWord()) {
         // Gibt es kein zweites Wort, wissen wir nicht, wohin...
         System.out.println("Wohin moechten Sie gehen?");
         return;
         }*/

		//String richtung = befehl.GetSecondWord();
        // Wir versuchen, den Raum zu verlassen.
        Room naechsterRaum = currentLocation.GetExist(richtung);
        if (naechsterRaum == null) {
            writeDown("Dort ist keine Tuer!");
        } else {
            currentLocation = naechsterRaum;
            writeDown(currentLocation.GetLongDescription());
        }
    }

    /**
    *
     * @param nr
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
                while(person.GetLifePoints() > 0 || player.GetLifePoints() > 0){
                    player.SetLifePoints(player.GetLifePoints() - person.GetDamage());
                    writeDown += "\nDu hast " + person.GetDamage() + " kassiert!";
                    if(player.GetLifePoints() <= 0){                        
                        writeDown += "\n Du bist leider gestorben.... Game Over.";
                        gameOver();
                        break;
                    }
                    person.SetLifePoints(person.GetLifePoints() - player.GetDamage());
                    writeDown += "\n" + person.GetName() + " hast " + person.GetDamage() + " kassiert!";
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
     *
     * @param nr
     */
    public void takeAsWeapon(int nr) {
        try {            
            Item item = player.RemoveBackpackItem(nr);
            if (player.GetWeapon() != null) {
                player.GetBackpack().add(player.GetWeapon());
                writeDown("Der Gegenstand " + item.GetName() + " wurde aus deiner Hand entfernt und in deinen Rucksack gelegt.");
            }
            player.SetWeapon(item);
            writeDown("Der Gegenstand " + item.GetName() + " ist nun deine Waffe! \n"
                    + "Er erhöht deinen Schaden um " + item.GetDamage());
        } catch (Exception ex) {
            writeDown("Geben Sie die Nummer des Gegenstandes ein.");
        }

    }    
}
