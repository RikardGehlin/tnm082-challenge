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
	 * Kodad av: Rikard / HC
	 * Task nr:2
	 * Datum: 2012-03-23
	 * Estimerad tid: 4h
	 * Faktisk tid: 6h
	 * Testad/av: Ja/Nej / namn
	 * Utcheckad/av: Ja /	Rikard / HC
	 * @param namn - beskrivning.
	 * @return namn - beskrivning.

	 */

	public List<Mission> getMissions() 
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
		return Mlist;
	}

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
				Utmp = new User();
				u_id = json_data.getInt("User_ID");
				u_name = json_data.getString("User_name");
				u_pass = json_data.getString("User_password");
				Utmp.setName(u_name);
				Utmp.setPass(u_pass);
				Ulist.add(i,Utmp);
				
			}
		}catch(JSONException e1)
		{
			Toast.makeText(getBaseContext(), "No User Found" ,Toast.LENGTH_LONG).show();
		}catch (ParseException e1) 
		{
			e1.printStackTrace();
		}
		return Ulist;
	}

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
				Glist.add(i,Gtmp);
				
			}
		}catch(JSONException e1)
		{
			Toast.makeText(getBaseContext(), "No User Found" ,Toast.LENGTH_LONG).show();
		}catch (ParseException e1) 
		{
			e1.printStackTrace();
		}
		return Glist;
	}
	
	
}