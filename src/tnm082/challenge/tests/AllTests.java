package tnm082.challenge.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		// Skapa en ny Testsvit
		TestSuite suite = new TestSuite(AllTests.class.getName());
		
		//$JUnit-BEGIN$
		
		// L�gg till testklass f�r klassen Mission
		suite.addTestSuite(MissionTest.class);
		
		// L�gg till testklass f�r klassen User
		suite.addTestSuite(UserTest.class);
		
		//$JUnit-END$
		return suite;
	}

}
