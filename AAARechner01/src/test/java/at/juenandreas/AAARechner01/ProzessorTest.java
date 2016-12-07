package at.juenandreas.AAARechner01;

import junit.framework.TestCase;

public class ProzessorTest extends TestCase {

	Prozessor prozessor = new Prozessor();
	
	public void testBerechnung()
	{
		
		Befehlswort operator = Befehlswort.PLUS;
		double operand = 4.7;			
		
		assertEquals("berechnung", , prozessor.berechnung(operator, operand));
		fail("Not yet implemented");
	}

}
