package tnm082.challenge.activities;

import tnm082.challenge.R;
import tnm082.challenge.R.layout;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Kodad av: Markus Olsson
 * Task nr: 12
 * Datum: 2012-04-17
 * Estimerad tid: 2h
 * Faktisk tid: xh
 * Testad/av: Ja/Nej / namn
 * Utcheckad/av: Ja/Nej / namn
 */

public class UserActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user); //H�mtar layout fr�n res/layout/user.xml
        
  	  //setListAdapter(new ArrayAdapter<String>(this, R.layout.user, listView1));
  	  
  	  //ListView mission_list = getListView();
	  //mission_list.setTextFilterEnabled(true);

  	    }
    
    static final String[] listView1 = new String[] {
    	"Current Mission", "Qued Mission 1", "Qued Mission 2", "Qued Mission 3", "Qued Mission 4",
    	"Qued Mission 5", "Qued Mission 6"};
    }