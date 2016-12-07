package at.juenandreas.AAARechner01;


/**
 * Repräsentationen für alle gültigen Befehlswörter des Spiels,
 * zusammen mit einer Zeichenkette in einer bestimmten Sprachen.
 * 
 * @author  Andreas Juen
 * @version 14.10.2016
 */
public enum Befehlswort
{
    PLUS("+"),
	MINUS("-"),
	DIVISION("/"),
	MAL("*"),
	UNKNOWN("?"),
	HELP("help"),
	UNDO("undo"),
	REDO("redo"),
	BEENDEN("beenden"),
	RESET("reset");
     
    // Das Befehlswort als Zeichenkette.
    private String befehlswort;
    
    /**
     * Initialisieren mit dem entsprechenden Befehlswort.
     * @param befehlswort das Befehlswort als Zeichenkette.
     */
    Befehlswort(String befehlswort)
    {
        this.befehlswort = befehlswort;
    }
    
    @Override
    public String toString()
    {
        return befehlswort;
    }
    
}

