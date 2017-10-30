package zuul_prog1;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

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

    private Parser parser;
    public Room currentLocation;
    public Person player;
    private List<WriteDown> listeners = new ArrayList<WriteDown>();

    /**
     * Erzeuge ein Spiel und initialisiere die Spielwelt.
     */
    public Game(WriteDown writeDownListener) {
        listeners.add(writeDownListener);
        generateWorld();
        parser = new Parser();
        start();
    }

    public void writeDown(String text) {
        // Notify everybody that may be interested.
        for (WriteDown hl : listeners) {
            hl.writeDown(text);
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
        raum.put("draussen", new Room("Vor dem Haupteingang der Universitaet"));
        raum.put("hoersaal", new Room("In einem Vorlesungssaal"));
        raum.put("cafeteria", new Room("In der Cafeteria der Uni"));
        raum.put("labor", new Room("In einem Rechnerraum"));
        raum.put("buero", new Room("Im Verwaltungsbuero der Informatik"));
        // die Ausgaenge initialisieren
        raum.get("draussen").SetExist(CardinalPoints.East, raum.get("hoersaal"));
        raum.get("draussen").SetExist(CardinalPoints.South, raum.get("labor"));
        raum.get("draussen").SetExist(CardinalPoints.West, raum.get("cafeteria"));
        raum.get("hoersaal").SetExist(CardinalPoints.West, raum.get("draussen"));
        raum.get("cafeteria").SetExist(CardinalPoints.East, raum.get("draussen"));
        raum.get("labor").SetExist(CardinalPoints.North, raum.get("draussen"));
        raum.get("labor").SetExist(CardinalPoints.East, raum.get("buero"));
        raum.get("buero").SetExist(CardinalPoints.West, raum.get("labor"));

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
        startText();

		// Die Hauptschleife. Hier lesen wir wiederholt Befehle ein
        // und fuehren sie aus, bis das Spiel beendet wird.
        //boolean beendet = false;
		/*while (!beendet) {
         Command befehl = parser.GetCommand();
         beendet = processCommand(befehl);
         }*/
        writeDown("Danke fuer dieses Spiel. Auf Wiedersehen.");
    }

    /**
     * Einen Begruessungstext fuer den Spieler ausgeben.
     */
    private void startText() {
        writeDown("\n");
        writeDown("Willkommen zu Zuul!");
        writeDown("Zuul ist ein neues, unglaublich langweiliges Spiel.");
        writeDown("Tippen sie '" + Commands.HILFE
                + "', wenn Sie Hilfe brauchen.");
        writeDown("\n");
        writeDown(currentLocation.GetLongDescription());
    }

    /**
     * Verarbeite einen gegebenen Befehl (fuehre ihn aus).
     *
     * @param befehl Der zu verarbeitende Befehl.
     * @return 'true', wenn der Befehl das Spiel beendet, 'false' sonst.
     */
    private boolean processCommand(Command befehl) {
        boolean moechteBeenden = false;

        Commands befehlswort = befehl.GetCommand();

        switch (befehlswort) {
            case UNBEKANNT:
                writeDown("Ich weiss nicht, was Sie meinen...");
                break;
            case UMSEHEN:
                look();
                break;
            case HILFE:
                getHelp();
                break;
            case GEHE:
                //changeRoom(befehl);
                break;
            case BEENDEN:
                moechteBeenden = shutdown(befehl);
                break;
            case UEBERNIMM:
                control(befehl);
                break;
            case NIMM:
                take(befehl);
                break;
            case TOETEN:
                kill(befehl);
                break;
            case RUCKSACK:
                if (befehl.GotSecondWord()) {
                    takeAsWeapon(befehl.GetSecondWord());
                } else {
                    showBackpack();
                }
                break;
            default:
                writeDown("Befehlswort ohne zugehoerige Aktion.");
                break;
        }
        return moechteBeenden;
    }

    /**
     *
     */
    public void look() {
        writeDown("Sie sind: " + player.GetName());
        writeDown(currentLocation.GetLongDescription());
    }

    /**
     * Packt den spezifizierten Gegenstand in den Rucksack des Spielers und
     * entfernt ihn aus dem aktuellen Raum.
     *
     * Falls der bezeichnete Gegenstand nicht vorhanden ist, aendert sich
     * nichts.
     *
     * @param befehl Der auszufuehrende Befehl
     */
    public void take(Command befehl) {
        if (befehl.GotSecondWord()) {
            int kennummer = Integer.parseInt(befehl.GetSecondWord());
            takeItem(kennummer);
        } else {
            writeDown("Geben Sie die Nummer des Gegenstands an.");
        }
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
                writeDown("Gegenstand konnte nicht eingepackt werden.");
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
     * Uebernimmt die Kontrolle der spezifizierten Person. Der Spieler steuert
     * anschliessend neu diese Person.
     *
     * Falls die bezeichnete Person nicht vorhanden ist, aendert sich nichts.
     *
     * @param befehl Der auszufuehrende Befehl
     */
    public void control(Command befehl) {
        if (befehl.GotSecondWord()) {
            int nummer = Integer.parseInt(befehl.GetSecondWord());
            controlPerson(nummer);
        } else {
            writeDown("Geben Sie die Nummer der Person an.");
        }
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
     * Gib Hilfsinformationen aus. Hier geben wir eine etwas alberne und unklare
     * Beschreibung aus, sowie eine Liste der Befehlswoerter.
     */
    public void getHelp() {
        writeDown("Sie haben sich verlaufen. Sie sind allein.");
        writeDown("Sie irren auf dem Unigelaende herum.");
        writeDown("\n");
        getCommands();
    }

    /**
     * Gibt eine Liste der vorhandenen Befehlswoerter aus.
     */
    private void getCommands() {
        writeDown("Ihnen stehen folgende Befehle zur Verfuegung:");
        writeDown(Commands.GetCommandsText());
    }

    /**
     * Versuche, in eine Richtung zu gehen. Wenn es einen Ausgang gibt, wechsele
     * in den neuen Raum, ansonsten gib eine Fehlermeldung aus.
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
     * Der Befehl zum Beenden wurde eingegeben. Ueberpruefe den Rest des
     * Befehls, ob das Spiel wirklich beendet werden soll.
     *
     * @return 'true', wenn der Befehl das Spiel beendet, 'false' sonst.
     */
    public boolean shutdown(Command befehl) {
        if (befehl.GotSecondWord()) {
            writeDown("Was soll beendet werden?");
            return false;
        } else {
            return true;
        }
    }

    public void kill(Command befehl) {
        if (befehl.GotSecondWord()) {
            int nummer = Integer.parseInt(befehl.GetSecondWord());
            killPerson(nummer);
        } else {
            writeDown("Geben Sie die Nummer der Person an.");
        }
    }

    public void killPerson(int nr) {
        Person person = currentLocation.GetPerson(nr);
        if (person == null) {
            writeDown("Es gibt keine Person mit Nummer " + nr);
        } else {
            person.SetLifePoints(person.GetLifePoints() - player.GetDamage());
            writeDown("Sie haben " + player.GetDamage() + " an " + person.GetName() + " angerichtet!!");
            writeDown("Restliche Lebenspunkte: " + person.GetLifePoints());
            if (person.GetLifePoints() <= 0) {
                writeDown("Sie haben " + person.GetName() + " getötet!!");
                currentLocation.Leave(nr);
                Item corpse = new Item("Leiche von " + person.GetName(),
                        "Die Leiche von " + person.GetName() + ".",
                        person.GetWeight(),
                        person.GetDamage(),
                        true
                );
                currentLocation.InsertItem(corpse);
            }

        }
    }

    public void showBackpack() {
        writeDown("Dein Rucksack enthält folgendes: ");
        for (Item item : player.GetBackpack()) {
            writeDown("" + item.GetName());
        }
    }

    public void takeAsWeapon(String command) {
        try {
            int nummer = Integer.parseInt(command);
            Item item = player.RemoveBackpackItem(nummer);
            if (player.GetWeapon() != null) {
                player.GetBackpack().add(player.GetWeapon());
                writeDown("Der Gegenstand " + item.GetName() + " wurde aus deiner Hand entfernt und in deinen Rucksack gelegt.");
            }
            player.SetWeapon(item);
            writeDown("Der Gegenstand " + item.GetName() + " ist nun deine Waffe!");
            writeDown("Er erhöht deinen Schaden um " + item.GetDamage());
        } catch (Exception ex) {
            writeDown("Geben Sie die Nummer des Gegenstandes ein.");
        }

    }    
}
