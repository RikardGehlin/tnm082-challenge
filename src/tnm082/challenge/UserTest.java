package tnm082.challenge;

import junit.framework.TestCase;

public class UserTest extends TestCase {
	
	public void testGetName()
	{
		// Skapa en User
		User u = new User();
		
// BORDE KOLLA S� ATT DET SOM RETURNERAS �R EN TEXTSTR�NG
		
		// kolla s� att vi f�r tillbaka n�got n�r vi ber om ett namn
		assertNotNull(u.getName());
	}

	public void testSetName()
	{
		// Skapa en User
		User u = new User();
		
		// S�tt ett namn
		String theName = "Ture Sventon";
		u.setName(theName);
		
		// Se till att namnet som sattes returneras
		assertEquals(theName, u.getName());
	}

	public void testGetPass()
	{
		// Skapa en User
		User u = new User();
		
		// kolla s� att vi f�r tillbaka n�got
		assertNotNull(u.getPass());
	}

	public void testSetPass()
	{
		// Skapa en user
		User u = new User();
		
		// S�tt ett password
		String thePass = "mellon";
		u.setPass(thePass);
		
		// Se till att det satta passwordet returneras
		assertEquals(thePass, u.getPass());
	}

	public void testGetId()
	{
		// Skapa en User
		User u = new User();
		
		// kolla s� att vi f�r tillbaka n�got
		assertNotNull(u.getId());
	}

	public void testCompleteMission()
	{
		fail("Not yet implemented");
	}

	public void testAcceptMission() {
		/*
		User u = new User();
		
		// Create mission
		Mission m = new Mission();
		
		// Accept mission
		u.acceptMission(m);
		
		// Check if mission exists in acceptedMissions list
		//u.
		 */
		fail("Not yet implemented");
	}

	public void testCancelMission() {
		fail("Not yet implemented");
	}

}
