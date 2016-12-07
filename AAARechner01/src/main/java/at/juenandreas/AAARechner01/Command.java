package at.juenandreas.AAARechner01;

//Die Schnittstelle Command wird von den Klassen Berechnung, Reset und MacroCommand umgesetzt.
public interface Command
{

 public void execute();
 public void undo();
}