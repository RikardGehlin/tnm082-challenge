package tnm082.challenge;

import junit.framework.TestCase;

public class UserTest extends TestCase {
	
	public void testGetName() {
		User u = new User();
		
		// kolla s� att vi f�r tillbaka n�got
		assertNotNull(u.getName());
	}

	public void testSetName() {
		User u = new User();
		
		// S�tt ett namn
		String theName = "Ture Sventon";
		u.setName(theName);
		
		// Se till att det satta namnet returneras
		assertEquals(theName, u.getName());
	}

	public void testGetPass() {
		User u = new User();
		
		// kolla s� att vi f�r tillbaka n�got
		assertNotNull(u.getPass());
	}

	public void testSetPass() {
		User u = new User();
		
		// S�tt ett password
		String thePass = "mellon";
		u.setPass(thePass);
		
		// Se till att det satta passwordet returneras
		assertEquals(thePass, u.getPass());
	}

	public void testGetId() {
		User u = new User();
		
		// kolla s� att vi f�r tillbaka n�got
		assertNotNull(u.getId());
	}

	public void testDoneIt() {
		fail("Not yet implemented");
	}

	public void testAdd_do() {
		fail("Not yet implemented");
	}

	public void testRemove_do() {
		fail("Not yet implemented");
	}

}
