package com.example.android.bakingapp.utilities;

import android.content.Context;
import android.util.JsonReader;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;

import static android.R.attr.key;

/**
 * Created by hjadhav on 12/31/2017.
 */

public class OpenRecepieJsonUtils {
    static String id,name,servings,image;
    static String quantity,measure,ingredient;
    static String idSteps,shortDescription,description,videoURL,thumbnailURL;
    private static final String TAG = OpenRecepieJsonUtils.class.getSimpleName();
    public static ArrayList<RecepieProfileData> recepie = new ArrayList<>();

    public static ArrayList<RecepieProfileData> getSimpleRecepieStringsFromJson
            (Context context, String detailsJsonStr) throws IOException, JSONException {


        if (detailsJsonStr != null){
            Log.v(TAG,"Code reached in detailsJsonStr ");
            JSONArray jsonArray = new JSONArray(detailsJsonStr);
            for (int n=0; n<jsonArray.length();n++){
                JSONObject jsonObj = jsonArray.getJSONObject(n);
                id = jsonObj.getString("id");
                name = jsonObj.getString("name");
                servings = jsonObj.getString("servings");
                image = jsonObj.getString("image");

                Log.v(TAG,"name:  " + name );
                Log.v(TAG,"image:  " + image );

                // Ingredients is JSON Array
                JSONArray ingredients = jsonObj.getJSONArray("ingredients");
                for (int i=0; i<ingredients.length(); i++){
                    JSONObject jsonObjIng = ingredients.getJSONObject(i);
                    quantity = jsonObjIng.getString("quantity");
                    measure = jsonObjIng.getString("measure");
                    ingredient = jsonObjIng.getString("ingredient");
                }

                // Steps is JSON Array
                JSONArray steps = jsonObj.getJSONArray("steps");
                for (int s=0; s<steps.length(); s++){
                    JSONObject jsonObjSteps = steps.getJSONObject(s);
                    idSteps = jsonObjSteps.getString("id");
                    shortDescription = jsonObjSteps.getString("description");
                    description = jsonObjSteps.getString("description");
                    videoURL = jsonObjSteps.getString("videoURL");
                    Log.v(TAG,"videoURL:  " + videoURL );
                    thumbnailURL = jsonObjSteps.getString("thumbnailURL");
                }
                RecepieProfileData recepieData = new RecepieProfileData(id,name,servings,image,quantity,measure,ingredient,idSteps,shortDescription,
                        description,videoURL,thumbnailURL);

                recepieData.setId(id);
                recepieData.setName(name);
                recepieData.setServings(servings);
                recepieData.setImage(image);
                recepieData.setQuantity(quantity);
                recepieData.setMeasure(measure);
                recepieData.setIngredient(ingredient);
                recepieData.setIdSteps(idSteps);
                recepieData.setShortDescription(shortDescription);
                recepieData.setDescription(description);
                recepieData.setVideoURL(videoURL);
                recepieData.setThumbnailURL(thumbnailURL);

                Log.v(TAG,"recepie before: "+recepie);
                recepie.add(recepieData);
                Log.v(TAG,"recepie: "+recepie);
            }
        }
        return recepie;
    }
}
