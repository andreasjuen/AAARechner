package at.juenandreas.AAARechner01;

public class Prozessor
{
 
   private double resultat;
   private Befehlswort operator;
   private double operand;
 
   /**
    * Ein Prozessor für arithmetische Operationen
    */
   public Prozessor(){
   }
 
   /**
    * Berechnung von arithmetischen Operationen, wobei das Resultat kumuliert wird.
    * Das aktuelle Resultat wird auf dem Bildschirm angezeigt 
    * und kann mit Hilfe der Methode getResultat() abgefragt werden.
    * @param operator Addition=+, Substraktion=-, Multiplikation=* Division=/
    * @param operand eine Zahl vom Typ "double"
    */
   public void berechnung(Befehlswort operator, double operand)
   {
      this.operator = operator;
      this.operand = operand;
      
      switch (operator)
      {
         case PLUS:
            resultat += operand;
            break;
         case MINUS:
            resultat -= operand;
            break;
         case MAL:
            resultat *= operand;
            break;
         case DIVISION:
        	if(operand != 0)
        	{
        		resultat /= operand;
        	}
        	else
        	{
        		System.out.println("Bitte nicht mit 0 diviedieren");
        	}
        	
            break;
         case UNKNOWN:
             resultat = operand;
             break;
      }
      System.out.println(this);
   }
 
   public double getResultat()
   {
      return resultat;
   }
 
   @Override
   public String toString()
   {
      return operator + " " + operand + " = " + resultat;
   }
}
