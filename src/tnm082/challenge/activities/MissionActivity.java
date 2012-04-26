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
	    
	
	    // H�mta missions s� att vi kan leta upp v�r mission
	    final List<Mission> mList = db.getMissions();
	    final List<User> uList = db.getUsers();
	    int thisMission = 0;
// ######## H�MTA V�R SPECIFIKA MISSION ##########
	    Log.d("Accept/avAccept","MissionId" + missionId);
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
        
        tb = (ToggleButton) findViewById(R.id.toggleButton1);
        tb.setOnClickListener(new OnClickListener()
        {
			public void onClick(View v)
			{
				if(tb.isChecked())
				{
					
					db.accept(uList.get(0), mList.get(finalThisMission));
					Log.d("Accept/avAccept",uList.get(0).getName()+" Acceptera uppdraget " + mList.get(finalThisMission).getName());
			    	
			    } 
				else 
				{
					
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