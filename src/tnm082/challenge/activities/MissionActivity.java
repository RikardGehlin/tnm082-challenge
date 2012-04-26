package tnm082.challenge.activities;

import java.util.List;

import tnm082.challenge.DBHandler;
import tnm082.challenge.Mission;
import tnm082.challenge.User;
import tnm082.challenge.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MissionActivity extends Activity {
	//skapar en toggleknapp
	ToggleButton tb;
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.mission_info); //layouten designas i res/layout/main.xml
	    
	    final DBHandler db = new DBHandler();
	    
	    // H�mta den Intent som vyn har
	    Intent nIntent = getIntent();
	    
	    // Ja, detta �r ju klurigt
	    String contentName = nIntent.getData().toString(); 
	    
	    // H�mta allt extra som skickades med Intent
	    Bundle extras = nIntent.getExtras();
	    
	    // H�mta missionId fr�n extravariablerna som kom med Intent
	    final int missionId = extras.getInt("mission_id");
	    
	
	    // h�mtar missions o users till listor som �r final s� vi kan anv�nda dom i v�r onclick
	    final List<Mission> mList = db.getMissions();
	    final List<User> uList = db.getUsers();
	    int thisMission = 0;
// ######## H�MTA V�R SPECIFIKA MISSION ##########
	    Log.d("Accept/avAccept","MissionId" + missionId);
	    //loop som hittar vilken plats v�rt mission har i missionlistan och sparar den variabeln som en 
	    //final value s� vi kommer �t den i v�r onclick
	    for(int i=0;i<mList.size();i++){
	    	if(missionId==mList.get(i).getId())
	    	{
	    		thisMission = i;
	    	}
	    }
	    Log.d("Accept/avAccept","thisMission" + thisMission);
	    final int finalThisMission = thisMission;
	    
	    
	    final TextView nameText = (TextView)findViewById(R.id.textView1);
        
        nameText.setText(contentName);
        //koppla ihop knappen med xml:en
        tb = (ToggleButton) findViewById(R.id.toggleButton1);
        tb.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v)
			{
				//kolla vilket state knappen �r i
				if(tb.isChecked())
				{
					//anropar accept ifr�n dbahandler
					db.accept(uList.get(0), mList.get(finalThisMission));
					Log.d("Accept/avAccept",uList.get(0).getName()+" Acceptera uppdraget " + mList.get(finalThisMission).getName());
			    	
			    } 
				else 
				{
					//anropar unaccept ifr�n dbahandler
					db.unaccept(uList.get(0), mList.get(finalThisMission));
					Log.d("Accept/avAccept",uList.get(0).getName()+" av Accepterar uppdraget " + mList.get(finalThisMission).getName());
	
			    }
			}
        });
        
        
	}
	//En funktion som anropas ifr�n .xml som lyssnar p� toggleknappen
//	public void onToggleClicked(View v, int id) {
//	    // Perform action on clicks
//	    if (((ToggleButton) v).isChecked()) {
//	    	Log.d("Accept/avAccept","Acceptera uppdrag");
//	    	
//	    } else {
//	    	Log.d("Accept/avAccept","Avacceptera uppdrag");
//	    	
//	    }
//	}    

}

//getta ID f�r valda uppdraget
//getta name och desc