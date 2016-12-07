package at.juenandreas.AAARechner01;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author  Andreas Juen
 * @version 14.10.2016
 */

class Parser 
{
    private Befehlswoerter befehle;  // hält die gültigen Befehlswörter
    private Scanner leser;         // Lieferant für eingegebene Befehle

    /**
     * Erzeuge einen Parser, der Befehle von der Konsole einliest.
     */
    public Parser() 
    {   	
    	this.befehle = new Befehlswoerter();
        leser = new Scanner(System.in);
    }

    /**
     * @return Den nächsten Befehl des Benutzers.
     */
    public Befehl liefereBefehl() 
    {          	    	    	    	
    	String eingabezeile;   // für die gesamte Eingabezeile
        String wort1 = null;
        String wort2 = null;

        System.out.print("> ");     // Eingabeaufforderung

        eingabezeile = leser.nextLine();
        
        // Finde bis zu zwei Wörter in der Zeile
        Scanner zerleger = new Scanner(eingabezeile);
        if(zerleger.hasNext())
        {
            wort1 = zerleger.next();    
            if (zerleger.hasNext())
            {
                wort2 = zerleger.next();    
            }
        }
        
        return new Befehl(befehle.gibBefehl(wort1), wort2 == null ? wort1 : wort2);
    }

    /**
     * Gib eine Liste der bekannten Befehlswörter aus.
     */
    public void zeigeBefehle()
    {
        befehle.alleAusgeben();
    }   
}

