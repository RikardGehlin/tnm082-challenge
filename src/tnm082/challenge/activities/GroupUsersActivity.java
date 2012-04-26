package tnm082.challenge.activities;

import java.util.ArrayList;
import java.util.List;

import tnm082.challenge.DBHandler;
import tnm082.challenge.Group;
import tnm082.challenge.R;
import tnm082.challenge.User;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;

/**
 * Kodad av: Flaaten
 * Task nr: 19
 * Datum: 2012-04-19
 * Estimerad tid: 2h
 * Faktisk tid: 
 * Testad/av: Ja/Nej / namn
 * Utcheckad/av: Ja/Nej / namn
 */


public class GroupUsersActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  
	  setContentView(R.layout.single_group);

	  // Skapa en DBHandler f�r att h�mta data
	  DBHandler db = new DBHandler();
	  
	  // H�mta en grupps information
	  Group group;
	  
	  // Skapa en list item f�r att h�lla alla users som �r med i gruppen
	  List<User> memberList = new ArrayList<User>();
	  memberList = db.getUsers();//Notera att detta igentligen skall vara en funktion som h�mtar users som tillh�r denna gruppen
	  
	 //h�mtar id:et fr�n groupactivity och sparar den i en string array med usernames
	  String[] USERS = new String[] {
			  							"Klasse Dummy",
										"Dummy Dalton",
										"Dixie Dummy",
										"Duh Me",
										"Klasse Dummy",
										"Dummy Dalton",
										"Dixie Dummy",
										"Duh Me",
										"Klasse Dummy",
										"Dummy Dalton",
										"Dixie Dummy",
										"Duh Me",
			  							"Kathult af Dhumey"
			  						};
		
	  //skapar listan
	  //setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, USERS));
	  
	  // H�mta listview fr�n XML-layouten
	  ListView lv = (ListView) findViewById(R.id.listGroupMembers);
	  
	  // Bind en ArrayAdapter med en str�nglista fylld med gruppdatat
	  lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, USERS));
	} 
}
