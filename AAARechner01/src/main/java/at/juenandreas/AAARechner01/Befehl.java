package at.juenandreas.AAARechner01;

/**
 * @author  Andreas Juen
 * @version 14.10.2016
 */

class Befehl
{
    private Befehlswort befehlswort;
    private String zweitesWort;

    /**
     * Erzeuge ein Befehlsobjekt. beide Parameter müssen angegeben werden,
     * aber der zweite darf 'null' sein.
     * @param befehlswort das Befehlswort. UNKNOWN, wenn dieser Befehl nicht
     *                   vom Spiel erkannt wurde.
     * @param zweitesWort Das zweite Wort des Befehls. Darf null sein.
     */
    public Befehl(Befehlswort befehlswort, String zweitesWort)
    {
        this.befehlswort = befehlswort;
        this.zweitesWort = zweitesWort;
    }

    /**
     * Liefere das Befehlswort (das erste Wort) dieses Befehls.
     * Wenn der Befehl nicht verstanden wurde, ist das Ergebnis
     * UNKNOWN.
     * @return das Befehlswort.
     */
    public Befehlswort gibBefehlswort()
    {
        return befehlswort;
    }

    /**
     * @return Das zweite Wort dieses Befehls. Liefere 'null', wenn
     * es kein zweites Wort gab.
     */
    public String gibZweitesWort()
    {
        return zweitesWort;
    }

    /**
     * @return 'true', wenn dieser Befehl nicht verstanden wurde.
     */
    public boolean istUnbekannt()
    {
        return (befehlswort == Befehlswort.UNKNOWN);
    }

    /**
     * @return 'true', wenn dieser Befehl ein zweites Wort hat.
     */
    public boolean hatZweitesWort()
    {
        if(zweitesWort != null)
            return true;        
        return false;
    }
}


