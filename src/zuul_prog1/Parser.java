package zuul_prog1;

import java.util.Scanner;

/**
 * Dieser Parser liest Benutzereingaben und wandelt sie in Befehle um. Bei jedem
 * Aufruf liest er eine Zeile von der Konsole und versucht, diese als einen
 * Befehl aus bis zu zwei Woertern zu interpretieren. Er liefert den Befehl als
 * ein Objekt der Klasse Befehl zurueck.
 * 
 * Der Parser verfuegt ueber einen Satz an bekannten Befehlen. Er
 * vergleicht die Eingabe mit diesen Befehlen. Wenn die Eingabe
 * keinen bekannten Befehl enthaelt, dann liefert der Parser ein als 
 * unbekannter Befehl gekennzeichnetes Objekt zurueck.
 * 
 * @author tebe
 * @version 18.10.2013
 */
class Parser {
    // Lieferant fuer eingegebene Befehle
    private Scanner scanner = new Scanner(System.in);

    /**
     * @return Der naechste Befehl des Benutzers.
     */
    public Command GetCommand() {
        Command command;
        String cmd; // fuer die gesamte Eingabezeile

        System.out.print("> "); // Eingabeaufforderung
        cmd = scanner.nextLine();
        String[] words = cmd.split(" ");

        if (words.length >= 2) {
            command = new Command(words[0], words[1]);
        } else {
            command = new Command(words[0], null);
        }
        return command;
    }

}
