package at.juenandreas.AAARechner01;

//ein konkreter Befehl, der den Prozessor zurücksetzt:
public class Reset implements Command
{

 private Prozessor prozessor;
 private double resultat;

 public Reset(Prozessor prozessor)
 {
    this.prozessor = prozessor;
 }

 @Override
 public void execute()
 {
    resultat = prozessor.getResultat();
    prozessor.berechnung(Befehlswort.MINUS, resultat);
 }

 @Override
 public void undo()
 {
    prozessor.berechnung(Befehlswort.PLUS, resultat);
 }

 @Override
 public String toString()
 {
    return "Reset{" + resultat + '}';
 }
}