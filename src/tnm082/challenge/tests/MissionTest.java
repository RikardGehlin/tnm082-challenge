package tnm082.challenge.tests;

import tnm082.challenge.Mission;
import junit.framework.TestCase;

public class MissionTest extends TestCase {
	
	public void testMission() {
		Mission m = new Mission();
		
		assertNotNull(m.getName());
		assertNotNull(m.getDesc());
		assertNotNull(m.getId());
	}

	public void testMissionIntStringString() {
		// F�rbered variabler f�r konstruktorn
		int theId = 1;
		String theName = "Team Tiger";
		String theDesc = "A pretty awesome team of well-trained tigers of code. From the jungle. Boo-yah!";
		
		// Skapa objektet
		Mission m = new Mission(theId, theName, theDesc);
		
		// kolla s� att konstruktorn har tilldelat alla variabler
		assertEquals(theId, m.getId());
		assertEquals(theName, m.getName());
		assertEquals(theDesc, m.getDesc());
	}
/*
	public void testMissionMission() {
		fail("Not yet implemented");
	}
*/
	public void testGetId() {
		Mission m = new Mission();
		
		// kolla s� att vi f�r tillbaka n�got
		assertNotNull(m.getId());
	}

	public void testSetId() {
		Mission m = new Mission();
		
		// S�tt ett id
		int theId = 1;
		m.setId(theId);
		
		// Se till att det satta id:t returneras
		assertEquals(theId, m.getId());
	}

	public void testGetName() {
		Mission m = new Mission();

		// Kolla s� att vi f�r tillbaka n�got
		assertNotNull(m.getName());
	}

	public void testSetName() {
		Mission m = new Mission();
		
		// S�tt ett namn
		String theName = "Test Name"; 
		m.setName(theName);
		
		// Kolla s� att det satta namnet returneras
		assertEquals(theName, m.getName());
	}

	public void testGetDesc() {
		Mission m = new Mission();
		
		// Kolla s� att vi f�r tillbaka n�got
		assertNotNull(m.getName());
	}

	public void testSetDesc() {
		Mission m = new Mission();
		
		// S�tt en uppdragsbeskrivning
		String theDesc = "Description of an awesome challenge."; 
		m.setDesc(theDesc);
		
		// Kolla s� att uppdragsbeskrivningen returneras
		assertEquals(theDesc, m.getDesc());
	}

}
