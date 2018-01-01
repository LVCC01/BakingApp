package com.example.android.bakingapp.utilities;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by hjadhav on 12/28/2017.
 */

public class NetworkUtils {
    private static final String TAG = NetworkUtils.class.getSimpleName();

    // build URL to get access to RECEPIE Database
    public static URL buildDbUrl (String recepieDb){
        Uri builtDbUri = Uri.parse(recepieDb).buildUpon()
                .build();
        URL url = null;
        try {
            url = new URL(builtDbUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
    // getResponseFromHttpUrl method will get JSON formatted data from the database
    public static String getResponseFromHttp(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput){
                return scanner.next();
            } else {
                return null;
            }

        } finally {
            urlConnection.disconnect();
        }
    }

    public static InputStream getNetworkConnection(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            InputStream in = urlConnection.getInputStream();
            return in;
        } finally {
            urlConnection.disconnect();
        }
    }
}
