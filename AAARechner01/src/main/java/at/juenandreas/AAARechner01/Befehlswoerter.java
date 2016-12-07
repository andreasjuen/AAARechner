package at.juenandreas.AAARechner01;

import java.util.HashMap;

/**
 * Diese Klasse hält eine Aufzählung aller Befehlswörter, die dem
 * Spiel bekannt sind. Mit ihrer Hilfe werden eingetippte Befehle
 * erkannt.
 *
 * @author  Andreas Juen
 * @version 14.10.2016
 */

class Befehlswoerter
{
    // eine Abbildung von Befehlswörtern auf Elemente des 
    // Aufzählungstyps Befehlswort
    private HashMap<String, Befehlswort> gueltigeBefehle;

    /**
     * Konstruktor - initialisiere die Befehlswörter.
     */
    public Befehlswoerter()
    {
        gueltigeBefehle = new HashMap<String, Befehlswort>();
        for(Befehlswort befehl : Befehlswort.values()) {
            if(befehl != Befehlswort.UNKNOWN) {
                gueltigeBefehle.put(befehl.toString(), befehl);
            }
        }
    }

    
    /**
     * Finde das Befehlswort, das mit einem Befehls-String verknüpft ist.
     * @param befehlswort das nachzuschlagende Wort.
     * @return Das zugehörige Befehlswort zum dem Wort oder UNKNOWN,
     *         wenn das Wort kein gültiges Befehlswort ist.
     */
    public Befehlswort gibBefehl(String wort)
    {
        Befehlswort befehl = gueltigeBefehle.get(wort);
        if(befehl != null) {
            return befehl;
        }
        else {
            return Befehlswort.UNKNOWN;
        }
    }
        
    /**
     * Prüfe, ob eine gegebene Zeichenkette ein gültiger
     * Befehl ist.
     * @return 'true', wenn die gegebene Zeichenkette ein gültiger
     * Befehl ist, 'false' sonst.
     */
    public boolean istBefehl(String eingabe)
    {
        return gueltigeBefehle.containsKey(eingabe);
    }

    /**
     * Gib alle gültigen Befehlswörter auf die Konsole aus.
     */
    public void alleAusgeben() 
    {
        for(String befehl : gueltigeBefehle.keySet()) {
            System.out.print(befehl + "  ");
        }
        System.out.println();
    }
}
