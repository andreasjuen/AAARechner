package at.juenandreas.AAARechner01;

import java.util.IllegalFormatWidthException;

public class Start
{
	private Parser parser;
    Prozessor prozessor;
    Taschenrechner taschenrechner;
	
	public Start()
	{
		prozessor = new Prozessor();
		taschenrechner = new Taschenrechner();
		parser = new Parser();
	}
	
    public void abspielen() 
    {                  	
    	willkommenstextAusgeben();
              
        boolean beendet = false;
        while (! beendet) {
            System.out.println("################################################################");
            Befehl befehl = parser.liefereBefehl();
            beendet = verarbeiteBefehl(befehl);           
        }
        System.out.println("Programm wurde beendet");
    }
  
    private boolean verarbeiteBefehl(Befehl befehl) 
    {
        boolean moechteBeenden = false;

        Befehlswort befehlswort = befehl.gibBefehlswort();
        String zweitesWort = befehl.gibZweitesWort();
        double operand = 0.0;
        int zahl = 0;
        
        boolean fehler = false;
        switch(befehlswort)
        { 
	        case UNDO:
	        	try
	        	{
	        		zahl = Integer.valueOf(zweitesWort);
	        	}
	        	catch(NumberFormatException ex)
	        	{
	        		System.out.println("Bitte Geben Sie nur Zahlen ein");
	        		fehler = true;
	        	}
	        	
	        	if(!fehler)
	        	{
		            taschenrechner.undo(zahl);		
	        	}
	        	else
	        		fehler = false;
	        	
	        	break;
	        case REDO:
	        	try
	        	{
	        		zahl = Integer.valueOf(zweitesWort);
	        	}
	        	catch(NumberFormatException ex)
	        	{
	        		System.out.println("Bitte Geben Sie nur Zahlen ein");
	        		fehler = true;
	        	}
	        	
	        	if(!fehler)
	        	{
	        		taschenrechner.redo(1);
	        	}
	        	else
	        		fehler = false;
	        	
	        	break;
	        case BEENDEN:
	        	moechteBeenden = true;
	        	break;
	        case UNKNOWN:
	        	try
	        	{
	        		operand = Double.valueOf(zweitesWort);
	        	}
	        	catch(NumberFormatException ex)
	        	{
	        		System.out.println("Bitte Geben Sie nur Zahlen ein");
	        		fehler = true;
	        	}
	        	
	        	if(!fehler)
	        	{
		        	taschenrechner.execute(new Berechnung(prozessor, Befehlswort.UNKNOWN, operand));	        		
	        	}
	        	else
	        		fehler = false;

	        	break;
	        case RESET:
	        	taschenrechner.execute(new Reset(prozessor));
	        	break;
	        default:
	        	try
	        	{
	        		operand = Double.valueOf(zweitesWort);
	        	}
	        	catch(NumberFormatException ex)
	        	{
	        		System.out.println("Bitte Geben Sie nur Zahlen ein");
	        		fehler = true;
	        	}
	        	
	        	if(!fehler)
	        	{
		        	taschenrechner.execute(new Berechnung(prozessor, befehl.gibBefehlswort(), operand));	        		
	        	}
	        	else 
	        		fehler = false;
	        	
        } 
        return moechteBeenden;
    }
            
    private void willkommenstextAusgeben()
    {
        System.out.println();
        System.out.println("Rechner \n***********************");
        System.out.println("Version 0.1 (c)by Andreas Juen");
        System.out.println("Tippen sie '" + Befehlswort.HELP + "', wenn Sie Hilfe brauchen.");
        System.out.println();
    }

}
