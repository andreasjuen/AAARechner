package at.juenandreas.AAARechner01;

import java.util.Arrays;

public class MacroCommand implements Command
{
 
   private final Command[] commands;
 
   /**
    * Ein MacroCommand kann eine Reihe von Befehlen ausführen, die als Parameter übergeben werden.
    *
    * @param commands eine Reihe von Befehlen
    */
   public MacroCommand(Command[] commands)
   {
      this.commands = commands;
   }
 
   @Override
   public void execute()
   {
      for (int i = 0; i < commands.length; i++)
      {
         commands[i].execute();
      }
   }
 
   @Override
   public void undo()
   {
      for (int i = commands.length - 1; i >= 0; i--)
      {
         commands[i].undo();
      }
   }
 
   @Override
   public String toString()
   {
      return Arrays.toString(commands);
   }
}