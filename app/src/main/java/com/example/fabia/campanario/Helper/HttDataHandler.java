package com.example.fabia.campanario.Helper;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by DIEGO on 01/11/2017.
 */

public class HttDataHandler {
    static  String stream=null;

    public HttDataHandler() {
    }
    public String GetHTTPData (String urlString){
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb =  new StringBuilder();
                String line;
                while((line= r.readLine())!=null)
                    sb.append(line);
                stream = sb.toString();
                urlConnection.disconnect();

            }
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {

        }
        return stream;

    }
}
