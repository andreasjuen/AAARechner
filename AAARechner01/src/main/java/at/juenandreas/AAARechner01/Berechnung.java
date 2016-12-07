package at.juenandreas.AAARechner01;

//eine konkreter Befehl, der eine arithmetische Operation berechnet
public class Berechnung implements Command
{

 private Prozessor prozessor;
 private Befehlswort operator;
 private double operand;

 public Berechnung(Prozessor prozessor, Befehlswort operator, double operand)
 {
    this.prozessor = prozessor;
    this.operator = operator;
    this.operand = operand;
 }

 public void execute()
 {
    prozessor.berechnung(operator, operand);
 }

 public void undo()
 {
    switch (operator)
    {
       case PLUS:
          prozessor.berechnung(operator.MINUS, operand);
          break;
       case MINUS:
          prozessor.berechnung(operator.PLUS, operand);
          break;
       case MAL:
          prozessor.berechnung(operator.DIVISION, operand);
          break;
       case DIVISION:
          prozessor.berechnung(operator.MAL, operand);
          break;
    }
 }

 @Override
 public String toString()
 {
    return operator + "" + operand;
 }
}