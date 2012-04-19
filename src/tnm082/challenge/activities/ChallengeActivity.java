package tnm082.challenge.activities;

import tnm082.challenge.R;
import tnm082.challenge.R.drawable;
import tnm082.challenge.R.layout;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Kodad av: Rikard
 * Task nr: 11,7,5,14
 * Datum: 2012-04-17
 * Estimerad tid: 1h+2h+8h+2h
 * Faktisk tid: 1h
 * Testad/av: Ja/Nej / namn
 * Utcheckad/av: Ja/Nej / namn
 */

//challengeActivity extendar tabactivity eftersom tabbarna alltid �r synliga 
public class ChallengeActivity extends TabActivity {
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main); //layouten designas i res/layout/main.xml

	    Resources res = getResources(); // Resource object to get Drawables
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab

	    // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, FeedActivity.class);

	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("artists").setIndicator("Feed", //Titel p� tabben
	                      res.getDrawable(R.drawable.tab_design)) //fil som styr �ver loggan
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	    //Tab f�r profilen
	    intent = new Intent().setClass(this, UserActivity.class);
	    spec = tabHost.newTabSpec("songs").setIndicator("Profile", //Titel p� tabben
	                      res.getDrawable(R.drawable.tab_design)) //fil som styr �ver loggan
	                  .setContent(intent);
	    tabHost.addTab(spec);
		
	    
	    // Do the same for the other tabs
	    intent = new Intent().setClass(this, ListsActivity.class);
	    spec = tabHost.newTabSpec("albums").setIndicator("Lists", //Titel p� tabben
	                      res.getDrawable(R.drawable.tab_design)) //fil som styr �ver loggan
	                  .setContent(intent);
	    tabHost.addTab(spec);

	    
	    intent = new Intent().setClass(this, TextActivity.class);
	    spec = tabHost.newTabSpec("songs").setIndicator("Text", //Titel p� tabben
	                      res.getDrawable(R.drawable.tab_design)) //fil som styr �ver loggan
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    
	    
	    

	    tabHost.setCurrentTab(0);
	}
}