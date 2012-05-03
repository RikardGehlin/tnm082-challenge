package tnm082.challenge;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
public class DBHandler extends ListActivity{
	/**
	 * Kodad av: Rikard unt HC
	 * Task nr:2
	 * Datum: 2012-04-17
	 * Estimerad tid: 4h
	 * Faktisk tid: 12h+
	 * Testad/av: Nej / namn
	 * Utcheckad/av: Ja / Rikard unt HC
	 * @param Inga inparametrar
	 * @return List<Mission>, List<User>, List<Group> - Returnerar en lista med alla Missions, Users eller Groups i databasen.
	 */
	
	/**
	 * Kodad av: HC
	 * Task nr: 9
	 * Datum: 2012-04-18
	 * Estimerad tid: 2h
	 * Faktisk tid: 2h
	 * Testad/av: Nej / namn
	 * Utcheckad/av: Ja / HC
	 * @param User u och Mission m eller Group g
	 * @return Inget - Accepterar eller avbryter ett uppdrag eller grupp f�r en user.
	 */
	
	/**
	 * Kodad av: HC
	 * Task nr: 20
	 * Datum: 2012-04-20
	 * Estimerad tid: 2h
	 * Faktisk tid: 2h
	 * Testad/av: Nej / namn
	 * Utcheckad/av: Ja / HC
	 * @param User u och Mission m eller Group g
	 * @return Inget - Accepterar eller avbryter ett uppdrag eller grupp f�r en user.
	 */
	
	/**
	 * Kodad av: HC
	 * Task nr: 4 och 5
	 * Datum: 2012-04-26
	 * Estimerad tid: 16h
	 * Faktisk tid: 4h
	 * Testad/av: Ja
	 * Utcheckad/av: Ja / HC
	 * @param User u och String state = "active" eller "completed"
	 * @return List<Mission> - Returnerar alla aktiva eller avklarade uppdrag f�r en user.
	 */
	

	// Returnerar en lista med alla missions i databasen
	public List<Mission> getMissions() 
	
	//h�mta alla missions i en grupp
	{
		JSONArray jArray;
		String result = null;
		InputStream is = null;
		StringBuilder sb=null;		
		
		 ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		 nameValuePairs.add(new BasicNameValuePair("query", ""));
		// Skapar en http post som initierar en php-fil p� servern.
		// Php-filen g�r queryn och skriver ut den h�mtade datan i JSON
		try
		{
		     HttpClient httpclient = new DefaultHttpClient();
		     HttpPost httppost = new HttpPost("http://marcusstenbeck.com/tnm082/DB-Mission.php");
		     httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		     HttpResponse response = httpclient.execute(httppost);
		     HttpEntity entity = response.getEntity();
		     is = entity.getContent();
		}catch(Exception e)
		{
			Log.e("log_tag", "Error in http connection"+e.toString());
		}
		// L�ser in data fr�n php-filen och sparar som JSON
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			sb = new StringBuilder();
			sb.append(reader.readLine() + "\n");

			String line="0";
			while ((line = reader.readLine()) != null) 
			{
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e)
		{
			Log.e("log_tag", "Error converting result "+e.toString());
		}
		// Parsar den inl�sta datan och sparar
		int m_id;
		String m_name, m_desc;
		List<Mission> Mlist = new ArrayList<Mission>();
		Mission Mtmp;
		try
		{
			jArray = new JSONArray(result);
			JSONObject json_data=null;
			for(int i = 0; i < jArray.length(); i++){
				json_data = jArray.getJSONObject(i);
				m_id = json_data.getInt("Mission_ID");
				m_name = json_data.getString("Mission_name");
				m_desc = json_data.getString("Mission_description");
				Mtmp = new Mission(m_id, m_name, m_desc);
				Mlist.add(i,Mtmp);
				
				
			}
		}catch(JSONException e1)
		{
			Toast.makeText(getBaseContext(), "No Mission Found" ,Toast.LENGTH_LONG).show();
		}catch (ParseException e1) 
		{
			e1.printStackTrace();
		}
		// Returnerar listan
		return Mlist;
	}

	// Returnerar en lista med alla aktiva eller avklarade missions f�r en user
	public List<Mission> getMissions(User u, String state) 
	{
		JSONArray jArray;
		String result = null;
		InputStream is = null;
		StringBuilder sb=null;		
		
		 ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		 if (state.equals("active") || state.equals("completed"))
			 nameValuePairs.add(new BasicNameValuePair("query", "WHERE Mission_ID IN (SELECT Mission_ID FROM UserMissions WHERE User_ID = " + u.getId() + " AND UserMissions_status = \"" + state + "\")"));
		 

		// Skapar en http post som initierar en php-fil p� servern.
		// Php-filen g�r queryn och skriver ut den h�mtade datan i JSON
		try
		{
		     HttpClient httpclient = new DefaultHttpClient();
		     HttpPost httppost = new HttpPost("http://marcusstenbeck.com/tnm082/DB-Mission.php");
		     httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		     HttpResponse response = httpclient.execute(httppost);
		     HttpEntity entity = response.getEntity();
		     is = entity.getContent();
		}catch(Exception e)
		{
			Log.e("log_tag", "Error in http connection"+e.toString());
		}
		// L�ser in data fr�n php-filen och sparar som JSON
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			sb = new StringBuilder();
			sb.append(reader.readLine() + "\n");

			String line="0";
			while ((line = reader.readLine()) != null) 
			{
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e)
		{
			Log.e("log_tag", "Error converting result "+e.toString());
		}
		// Parsar den inl�sta datan och sparar
		int m_id;
		String m_name, m_desc;
		List<Mission> Mlist = new ArrayList<Mission>();
		Mission Mtmp;
		try
		{
			jArray = new JSONArray(result);
			JSONObject json_data=null;
			for(int i = 0; i < jArray.length(); i++){
				json_data = jArray.getJSONObject(i);
				m_id = json_data.getInt("Mission_ID");
				m_name = json_data.getString("Mission_name");
				m_desc = json_data.getString("Mission_description");
				Mtmp = new Mission(m_id, m_name, m_desc);
				Mlist.add(i,Mtmp);
				
			}
		}catch(JSONException e1)
		{
			Toast.makeText(getBaseContext(), "No Mission Found" ,Toast.LENGTH_LONG).show();
		}catch (ParseException e1) 
		{
			e1.printStackTrace();
		}
		// Returnerar listan
		return Mlist;

	}	

	
	// Returnerar en lista med alla missions f�r en grupp
	public List<Mission> getMissions(int o) 
	
	//h�mta alla missions i en grupp
	{
		JSONArray jArray;
		String result = null;
		InputStream is = null;
		StringBuilder sb=null;		
		
		 ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		 nameValuePairs.add(new BasicNameValuePair("query", "WHERE Mission_ID IN (SELECT Mission_ID FROM MissionsInGroup WHERE Group_ID = " + o + ")"));
		 // Skapar en http post som initierar en php-fil p� servern.
		// Php-filen g�r queryn och skriver ut den h�mtade datan i JSON
		try
		{
		     HttpClient httpclient = new DefaultHttpClient();
		     HttpPost httppost = new HttpPost("http://marcusstenbeck.com/tnm082/DB-Mission.php");
		     httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		     HttpResponse response = httpclient.execute(httppost);
		     HttpEntity entity = response.getEntity();
		     is = entity.getContent();
		}catch(Exception e)
		{
			Log.e("log_tag", "Error in http connection"+e.toString());
		}
		// L�ser in data fr�n php-filen och sparar som JSON
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			sb = new StringBuilder();
			sb.append(reader.readLine() + "\n");

			String line="0";
			while ((line = reader.readLine()) != null) 
			{
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e)
		{
			Log.e("log_tag", "Error converting result "+e.toString());
		}
		// Parsar den inl�sta datan och sparar
		int m_id;
		String m_name, m_desc;
		List<Mission> Mlist = new ArrayList<Mission>();
		Mission Mtmp;
		try
		{
			jArray = new JSONArray(result);
			JSONObject json_data=null;
			for(int i = 0; i < jArray.length(); i++){
				json_data = jArray.getJSONObject(i);
				m_id = json_data.getInt("Mission_ID");
				m_name = json_data.getString("Mission_name");
				m_desc = json_data.getString("Mission_description");
				Mtmp = new Mission(m_id, m_name, m_desc);
				Mlist.add(i,Mtmp);
				
			}
		}catch(JSONException e1)
		{
			Toast.makeText(getBaseContext(), "No Mission Found" ,Toast.LENGTH_LONG).show();
		}catch (ParseException e1) 
		{
			e1.printStackTrace();
		}
		// Returnerar listan
		return Mlist;
	}
	
	

	// Returnerar en lista med alla users i databasen
	public List<User> getUsers() 
	{
		JSONArray jArray;
		String result = null;
		InputStream is = null;
		StringBuilder sb=null;		
		
		 ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		// Skapar en http post som initierar en php-fil p� servern.
		// Php-filen g�r queryn och skriver ut den h�mtade datan i JSON
		try
		{
		     HttpClient httpclient = new DefaultHttpClient();
		     HttpPost httppost = new HttpPost("http://marcusstenbeck.com/tnm082/DB-User.php");
		     httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		     HttpResponse response = httpclient.execute(httppost);
		     HttpEntity entity = response.getEntity();
		     is = entity.getContent();
		}catch(Exception e)
		{
			Log.e("log_tag", "Error in http connection"+e.toString());
		}
		// L�ser in data fr�n php-filen och sparar som JSON
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			sb = new StringBuilder();
			sb.append(reader.readLine() + "\n");

			String line="0";
			while ((line = reader.readLine()) != null) 
			{
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e)
		{
			Log.e("log_tag", "Error converting result "+e.toString());
		}
		// Parsar den inl�sta datan och sparar
		int u_id;
		String u_name, u_pass;
		List<User> Ulist = new ArrayList<User>();
		User Utmp;
		try
		{
			jArray = new JSONArray(result);
			JSONObject json_data=null;
			for(int i = 0; i < jArray.length(); i++){
				json_data = jArray.getJSONObject(i);
				u_id = json_data.getInt("User_ID");
				u_name = json_data.getString("User_name");
				u_pass = json_data.getString("User_password");
				Utmp = new User(u_name, u_pass, u_id);
				Ulist.add(i,Utmp);
				
			}
		}catch(JSONException e1)
		{
			Toast.makeText(getBaseContext(), "No User Found" ,Toast.LENGTH_LONG).show();
		}catch (ParseException e1) 
		{
			e1.printStackTrace();
		}
		// Returnerar listan
		return Ulist;
	}
	
	/**
	 * Kodad av: Mathias
	 * Task nr: 8, sprint 2
	 * Datum: 2012-04-26
	 * Estimerad tid: 8h
	 * Faktisk tid:1h 
	 * Testad/av: Nej/Ja / namn
	 * Utcheckad/av: Ja/Nej / namn
	 * @param groupID - ID f�r den grupp vars anv�ndare man vill h�mta ut.
	 * @return List<User> - En lista �ver alla anv�ndare i gruppen. Anv�nder sig av klassen User.
	 */
	public List<User> getUsersInGroup(int groupID){
		
		//Lokala metodvariabler.
		JSONArray jArray;
		String result = null;
		InputStream is = null;
		StringBuilder sb=null;
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		
		//Textstr�ng som best�mmer vilken php-fil fr�n FTP som skall anv�ndas. Skickar �ven med ett get-objekt f�r grupp-id, som kommer att h�mtas och hanteras i php-filen.
		String php_src = "http://marcusstenbeck.com/tnm082/DB-UsersInGroup.php?group_id="+Integer.toString(groupID); //G�r dessuom om id till en textstr�ng.
		// Skapar en http post som initierar en php-fil p� servern.
		// Php-filen g�r queryn och skriver ut den h�mtade datan i JSON
		try
		{
		     HttpClient httpclient = new DefaultHttpClient();
		     HttpPost httppost = new HttpPost(php_src); //I php-filen h�mas alla id'n f�r anv�ndare i en grupp.
		     httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		     HttpResponse response = httpclient.execute(httppost);
		     HttpEntity entity = response.getEntity();
		     is = entity.getContent(); //H�matar inneh�llet och spar i variabeln is.
		}catch(Exception e)
		{
			Log.e("log_tag", "Error in http connection"+e.toString());
		}
		
		// L�ser in data fr�n php-filen och sparar som JSON
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8); //Anv�nder is f�r att l�sa data med bufferedreader.
			sb = new StringBuilder();
			sb.append(reader.readLine() + "\n");
			
			String line="0";
			while ((line = reader.readLine()) != null) //S� l�nge som det finns data att h�mta ska det sparas �ver i en textstr�ng. 
			{
				sb.append(line + "\n");
			}
			is.close(); //St�nger is.
			result=sb.toString(); //L�ser in JSON-data till en textstr�ng.
		}catch(Exception e)
		{
			Log.e("log_tag", "Error converting result "+e.toString());
		}
		
		// Skapar variabler att lagra data i.
		int u_id;
		String u_name;
		String u_pwd; 
		
		//H�r �r listan med users som kommer att returneras.
		List<User> usersInGroup = new ArrayList<User>();
		
		try
		{
			jArray = new JSONArray(result);
			JSONObject json_data=null;
			for(int i = 0; i < jArray.length(); i++){
				json_data = jArray.getJSONObject(i);
				
				//H�mtar data fr�n json, lagrar �ver detta i variabler 
				u_id = json_data.getInt("User_ID");
				u_name = json_data.getString("User_name");
				u_pwd = json_data.getString("User_password");
				
				//Skapar tillf�llig uservariabel och s�tter in denna i listan som skall returneras.
				User tmpUser = new User(u_name, u_pwd, u_id);
				usersInGroup.add(i, tmpUser);		
			}
		}catch(JSONException e1)
		{
			Toast.makeText(getBaseContext(), "No User Found" ,Toast.LENGTH_LONG).show();
		}catch (ParseException e1) 
		{
			e1.printStackTrace();
		}
		
		return usersInGroup;
	}

	// Returnerar en lista med alla groups i databasen
	public List<Group> getGroups() 
	{
		JSONArray jArray;
		String result = null;
		InputStream is = null;
		StringBuilder sb=null;		
		
		 ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		// Skapar en http post som initierar en php-fil p� servern.
		// Php-filen g�r queryn och skriver ut den h�mtade datan i JSON
		try
		{
		     HttpClient httpclient = new DefaultHttpClient();
		     HttpPost httppost = new HttpPost("http://marcusstenbeck.com/tnm082/DB-Group.php");
		     httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		     HttpResponse response = httpclient.execute(httppost);
		     HttpEntity entity = response.getEntity();
		     is = entity.getContent();
		}catch(Exception e)
		{
			Log.e("log_tag", "Error in http connection"+e.toString());
		}
		// L�ser in data fr�n php-filen och sparar som JSON
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			sb = new StringBuilder();
			sb.append(reader.readLine() + "\n");

			String line="0";
			while ((line = reader.readLine()) != null) 
			{
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e)
		{
			Log.e("log_tag", "Error converting result "+e.toString());
		}
		// Parsar den inl�sta datan och sparar
		int g_id;
		String g_name;
		List<Group> Glist = new ArrayList<Group>();
		Group Gtmp;
		try
		{
			jArray = new JSONArray(result);
			JSONObject json_data=null;
			for(int i = 0; i < jArray.length(); i++){
				json_data = jArray.getJSONObject(i);
				Gtmp = new Group();
				g_id = json_data.getInt("Group_ID");
				g_name = json_data.getString("Group_name");
				Gtmp.setName(g_name);
				Gtmp.setId(g_id);
				Glist.add(i,Gtmp);
				
			}
		}catch(JSONException e1)
		{
			Toast.makeText(getBaseContext(), "No User Found" ,Toast.LENGTH_LONG).show();
		}catch (ParseException e1) 
		{
			e1.printStackTrace();
		}
		// Returnerar listan
		return Glist;
	}
	
	// Kallas n�r en anv�ndare (userID) rapporterar ett uppdrag (missionID) som klart/done/genomf�rt
	public void updateMission(int userID, int missionID)
	{
		InputStream is = null;
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("User_ID", Integer.toString(userID)));
		nameValuePairs.add( new BasicNameValuePair("Mission_ID", Integer.toString(missionID)));
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://marcusstenbeck.com/tnm082/DB-updateMission.php");
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();
		}catch(Exception e){
			Log.e("log_tag", "Error in http connection"+e.toString());
		}
	}	

	// Kallas n�r en User u accepterar ett Mission eller Grupp
	public void accept(User u, Object o)
	{				
		InputStream is = null;
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("User_ID", Integer.toString(u.getId())));
		
		if(o instanceof Mission)
			nameValuePairs.add( new BasicNameValuePair("Mission_ID", Integer.toString(((Mission) o).getId())));
		else if (o instanceof Group)
			nameValuePairs.add( new BasicNameValuePair("Group_ID", Integer.toString(((Group) o).getId())));				
			
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost();
			if(o instanceof Mission)
				httppost = new HttpPost("http://marcusstenbeck.com/tnm082/DB-accept.php?type=mission");
			else if(o instanceof Group)
				httppost = new HttpPost("http://marcusstenbeck.com/tnm082/DB-accept.php?type=group");
			
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();
		}catch(Exception e){
			Log.e("log_tag", "Error in http connection"+e.toString());
		}
	}
	
	// Kallas n�r en User u avaktiverar ett Mission eller Grupp
	public void unaccept(User u, Object o)
	{				
		InputStream is = null;
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("User_ID", Integer.toString(u.getId())));
		
		if(o instanceof Mission)
			nameValuePairs.add( new BasicNameValuePair("Mission_ID", Integer.toString(((Mission) o).getId())));
		else if (o instanceof Group)
			nameValuePairs.add( new BasicNameValuePair("Group_ID", Integer.toString(((Group) o).getId())));				
			
		try{
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost();
			if(o instanceof Mission)
				httppost = new HttpPost("http://marcusstenbeck.com/tnm082/DB-unaccept.php?type=mission");
			else if(o instanceof Group)
				httppost = new HttpPost("http://marcusstenbeck.com/tnm082/DB-unaccept.php?type=group");
			
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();
		}catch(Exception e){
			Log.e("log_tag", "Error in http connection"+e.toString());
		}
	}
}
