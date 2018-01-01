package com.example.android.bakingapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.utilities.NetworkUtils;
import com.example.android.bakingapp.utilities.OpenRecepieJsonUtils;
import com.example.android.bakingapp.utilities.RecepieProfileData;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by hjadhav on 12/28/2017.
 */

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<RecepieProfileData>> {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String SEARCH_QUERY_URL_EXTRA = "query";
    URL url;
    private static final int RECEPIE_SEARCH_LOADER = 22;
    String recepieDataLink;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportLoaderManager().initLoader(RECEPIE_SEARCH_LOADER,null,this);
        recepieDataLink = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";
        loadRecepieData(recepieDataLink);
    }
    private void loadRecepieData(String link){
        url = NetworkUtils.buildDbUrl(link);

        Bundle queryBundle = new Bundle();
        queryBundle.putString(SEARCH_QUERY_URL_EXTRA , url.toString());

        LoaderManager loaderManager = getSupportLoaderManager();
        Loader<ArrayList<RecepieProfileData>> recepieSearchLoader = loaderManager.getLoader(RECEPIE_SEARCH_LOADER);
        if (recepieSearchLoader == null){
            loaderManager.initLoader(RECEPIE_SEARCH_LOADER,queryBundle,this);
        } else {
            loaderManager.restartLoader(RECEPIE_SEARCH_LOADER,queryBundle,this);
        }
    }

    @Override
    public Loader<ArrayList<RecepieProfileData>> onCreateLoader(int id, final Bundle args) {
        return new AsyncTaskLoader<ArrayList<RecepieProfileData>>(this) {

            ArrayList<RecepieProfileData> mRecepieJson;
            @Override
            protected void onStartLoading() {
                if (args == null){
                    return;
                }
                if (mRecepieJson != null){
                    deliverResult(mRecepieJson);
                } else {
                    forceLoad();
                }
            }

            @Override
            public ArrayList<RecepieProfileData> loadInBackground() {
                String searchQueryUrlString = args.getString(SEARCH_QUERY_URL_EXTRA);
                if (searchQueryUrlString == null || TextUtils.isEmpty(searchQueryUrlString)){
                    return null;
                }
                ArrayList<RecepieProfileData> filteredJsonData;

                try {
                    URL url = new URL(searchQueryUrlString);
                    InputStream in = NetworkUtils.getNetworkConnection(url);
                    filteredJsonData = OpenRecepieJsonUtils.getSimpleRecepieStringsFromJson(MainActivity.this,in);
                    Log.v(TAG,"filteredJsonData:" + filteredJsonData);
                    return filteredJsonData;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    return null;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            public void deliverResult(ArrayList<RecepieProfileData> data) {
                mRecepieJson = data;
                if (mRecepieJson != null && mRecepieJson.size()>0){
                    super.deliverResult(mRecepieJson);
                } else {
                    forceLoad();
                }
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<RecepieProfileData>> loader, ArrayList<RecepieProfileData> data) {

    }

    @Override
    public void onLoaderReset(Loader<ArrayList<RecepieProfileData>> loader) {

    }
}
