package com.example.android.bakingapp.utilities;

import android.content.Context;
import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;

/**
 * Created by hjadhav on 12/31/2017.
 */

public class OpenRecepieJsonUtils {

    public static ArrayList<RecepieProfileData> getSimpleRecepieStringsFromJson
            (Context context, InputStream inputStream) throws IOException {

        JsonReader reader = new JsonReader(new InputStreamReader(inputStream,"UTF-8"));
        try {
            return readMessagesArray(reader);
        } finally {
            reader.close();
        }
    }
    public static ArrayList<RecepieProfileData> readMessagesArray(JsonReader reader) throws IOException {
        ArrayList<RecepieProfileData> recepieData = new ArrayList<>();
        reader.beginArray();
        while (reader.hasNext()){
            recepieData.add(readMessage(reader));
        }
        reader.endArray();
        return recepieData;
    }
    public static RecepieProfileData readMessage(JsonReader reader) throws IOException {
        int id = 0;
        String name = null;

        reader.beginObject();
        while (reader.hasNext()){
            String topic = reader.nextName();
            if (topic.equals("id")){
                id = reader.nextInt();
            } else if (topic.equals("name")){
                name = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new RecepieProfileData(id , name);
    }
}
