package tnm082.challenge.activities;

import java.util.ArrayList;
import java.util.List;

import tnm082.challenge.DBHandler;
import tnm082.challenge.Mission;
import tnm082.challenge.R;

import android.app.ListActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


/**
 * Kodad av: Rikard
 * Task nr: 5,7,11
 * Datum: 2012-04-17
 * Estimerad tid: 8h+2h+1h
 * Faktisk tid: 1h
 * Testad/av: Ja/Nej / namn
 * Utcheckad/av: Ja/Nej / namn
 */

public class FeedActivity extends ListActivity{
    /** Ropad n�r den aktivitet �r f�rst skapad. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.feed_overview); //design som hittas i res/layout/feed_overview.xml
        
        DBHandler db = new DBHandler();
        List<Mission> Mlist = new ArrayList<Mission>();
  	  Mlist = db.getMissions();
  	  int feedSize = Mlist.size();
  	
  	 String[] FEED = new String[feedSize];
  	  for (int i=0; i<feedSize; i++)
  	  {FEED[i] = Mlist.get(i).getName();}
	 

  	//skapar listan med design som hittas i res/layout/list_item.xml och fylls med data ifr�n listan COUNTRIES (se l�ngre ned)
  	  setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, FEED));  

  	  ListView lv = getListView();
  	  lv.setTextFilterEnabled(true);
  	  

  	  lv.setOnItemClickListener(new OnItemClickListener() {
  	    public void onItemClick(AdapterView<?> parent, View view,
  	        int position, long id) {
  	      // When clicked, show a toast with the TextView text
  	      Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
  	          Toast.LENGTH_SHORT).show();
  	    }
  	  });
    }
        
}
