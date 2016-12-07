package at.juenandreas.AAARechner01;

import java.util.ArrayList;
import java.util.List;
 
public class Taschenrechner
{
 
   private List<Command> undoable;
   private int undoLevel;
 
   /**
    * Ein Taschenrechner der Befehle ausführen und rückgängig machen kann.
    */
   public Taschenrechner()
   {
      undoable = new ArrayList<Command>(10);
      undoLevel = 0;
   }
 
   /**
    * Den Befehl ausführen, der als Parameter übergeben wird.
    *
    * @param command
    */
   public void execute(Command command)
   {
      System.out.print("Berechnung: ");
      command.execute();
      addUndoable(command);
   }
 
   /**
    * Die als Parameter übergebene Anzahl von Befehlen rückgängig machen.
    *
    * @param number
    */
   public void undo(int number)
   {
      System.out.println("undo(" + number + "):");
      for (int i = 0; i < number; i++)
      {
         if (undoLevel > 0)
         {
            Command commande = undoable.get(--undoLevel);
            commande.undo();
         }
      }
   }
 
   /**
    * Die als Parameter übergebene Anzahl von Befehlen wieder ausführen.
    *
    * @param number
    */
   public void redo(int number)
   {
      System.out.println("redo(" + number + "):");
      for (int i = 0; i < number; i++)
      {
         if (undoLevel < undoable.size())
         {
            Command commande = undoable.get(undoLevel++);
            commande.execute();
         }
      }
   }
 
   //private Servicemethode:
   private void addUndoable(Command command)
   {
      //die "undoable"-Liste dem aktuellen undoLevel anpassen:
      int count = undoable.size() - undoLevel;
      for (int i = 0; i < count; i++)
      {
         undoable.remove(undoable.size() - 1);
      }
      //den neuen Befehl hinzufügen:
      undoable.add(command);
      undoLevel = undoable.size();
   }
}