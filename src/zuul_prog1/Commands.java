/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuul_prog1;
/**
 *
 * @author Lucca
 */

public enum Commands{
    UNBEKANNT,
    UMSEHEN,
    HILFE,
    GEHE,
    BEENDEN,
    UEBERNIMM,
    NIMM,
    TOETEN,
    RUCKSACK;

    public static String GetCommandsText(){
      return "UMSEHEN,\n" +
        "HILFE,\n" +
        "GEHE,\n" +
        "BEENDEN,\n" +
        "UEBERNIMM,\n" +
        "NIMM,\n" +
        "TOETEN,\n" +
        "RUCKSACK";
    }
}
