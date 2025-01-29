package com.example.mechnicfinder;

import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchMechanicsTask extends AsyncTask<String, Void, String> {
    private GoogleMap mMap;

    public FetchMechanicsTask(GoogleMap mMap) {
        this.mMap = mMap;
    }

    @Override
    protected String doInBackground(String... urls) {
        String response = "";
        try {
            URL url = new URL(urls[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            response = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    protected void onPostExecute(String result) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray results = jsonObject.getJSONArray("results");

            for (int i = 0; i < results.length(); i++) {
                JSONObject place = results.getJSONObject(i);
                JSONObject location = place.getJSONObject("geometry").getJSONObject("location");

                LatLng mechanicLocation = new LatLng(location.getDouble("lat"), location.getDouble("lng"));
                String name = place.getString("name");

                mMap.addMarker(new MarkerOptions().position(mechanicLocation).title(name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
