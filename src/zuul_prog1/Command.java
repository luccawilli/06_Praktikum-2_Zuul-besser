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
public class Command {
    
    private String _word1;
    private String _word2;
    
    public Command(String word1, String word2){
        _word1 = word1;
        _word2 = word2;
    }
    
    public Boolean GotSecondWord(){  
      if(_word2 == null){
          return false;
      }
      return !_word2.isEmpty();
    }
    
    public String GetSecondWord(){
      return _word2;
    } 
    
    public Commands GetCommand(){
      switch (_word1.toUpperCase()) {		
		case "UMSEHEN":
			return Commands.UMSEHEN;
		case "HILFE":
			return Commands.HILFE;
		case "GEHE":
			return Commands.GEHE;
		case "BEENDEN":
			return Commands.BEENDEN;
		case "UEBERNIMM":
			return Commands.UEBERNIMM;
		case "NIMM":
			return Commands.NIMM;
                case "TOETEN":
                        return Commands.TOETEN;
                case "RUCKSACK":
                        return Commands.RUCKSACK;
		default:
			return Commands.UNBEKANNT;			
		}
    }
}
