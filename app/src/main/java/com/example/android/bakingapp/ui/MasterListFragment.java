package com.example.android.bakingapp.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.utilities.MasterListAdapter;
import com.example.android.bakingapp.utilities.NetworkUtils;
import com.example.android.bakingapp.utilities.OpenRecepieJsonUtils;
import com.example.android.bakingapp.utilities.RecepieProfileData;
import com.example.android.bakingapp.utilities.RecepieProfileDataBasics;

import org.json.JSONException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hjadhav on 12/28/2017.
 */

// This fragment displays all the names of dishes in one large list
// The list can appear as grid or list of images
public class MasterListFragment extends Fragment   {
    private static final String TAG = MasterListFragment.class.getSimpleName();
    RecyclerView recyclerView ;
    MasterListAdapter mAdapter;

    // Mandatory empty constructor
    public MasterListFragment(){}

    /*MasterListAdapter mAdapter;
    private static final String SEARCH_QUERY_URL_EXTRA = "query";
    private static final int RECEPIE_SEARCH_LOADER = 22;
    private ArrayList<RecepieProfileData> recepieArray;
    URL url;
    String link = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";

    RecyclerView recyclerView ;*/

    // Inflates ListView for recepie names
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_master_list,container,false);
        GridView gridView = rootView.findViewById(R.id.menu_grid_view);
        gridView.setAdapter(mAdapter);

        // This adapter takes in the context and an ArrayList of ALL the dishes to display
        mAdapter = new MasterListAdapter(getActivity(), recepieArray);
        Log.v(TAG,"mAdapter:" + mAdapter);
        final View rootView = inflater.inflate(R.layout.fragment_master_list,container,false);
        Log.v(TAG,"rootView:" + rootView);

        // Get a reference to the recycler view in the fragment_master_list xml layout file
        recyclerView = new RecyclerView(getContext());
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recepie_list);

        /*if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(),2));
        }*/
        int numberOfColumns = 1;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),numberOfColumns));

        /*LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);*/
        recyclerView.setHasFixedSize(true);
        // set the adapter on recyclerView


        Log.v(TAG,"CODE REACHED THE MASTER LIST FRAGMENT METHOD");
        Log.v(TAG,"rootView:" + rootView);
       /* Log.v(TAG,"NUM_LIST_ITEMS:" + NUM_LIST_ITEMS);
        Log.v(TAG,"recepieProfile:" + Arrays.asList(recepieProfile));*/

        loadRecepieData(link);
        return rootView;
    }
   /* private void loadRecepieData(String link){
        url = NetworkUtils.buildDbUrl(link);
        Log.v(TAG,"URL:" + url);

        Bundle queryBundle = new Bundle();
        queryBundle.putString(SEARCH_QUERY_URL_EXTRA,url.toString());

        LoaderManager loaderManager = getLoaderManager();
        Loader<ArrayList<RecepieProfileData>> recepieSearchLoader = loaderManager.getLoader(RECEPIE_SEARCH_LOADER);

        if (recepieSearchLoader == null){
            loaderManager.initLoader(RECEPIE_SEARCH_LOADER,queryBundle,this);
        } else {
            loaderManager.restartLoader(RECEPIE_SEARCH_LOADER,queryBundle,this);
        }
    }*/

 /*   @Override
    public Loader<ArrayList<RecepieProfileData>> onCreateLoader(int id, final Bundle args) {
        return new AsyncTaskLoader<ArrayList<RecepieProfileData>>(getContext()) {
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
                ArrayList<RecepieProfileData> filteredJsonData;
                String searchQueryUrlString = args.getString(SEARCH_QUERY_URL_EXTRA);
                Log.v(TAG,"searchQueryUrlString:" + searchQueryUrlString);

                if (searchQueryUrlString == null || TextUtils.isEmpty(searchQueryUrlString)){
                    return null;
                }

                try {
                    URL url = new URL(searchQueryUrlString);
                    Log.v(TAG,"url2:" + url);
                    String jsonDataFromHttp = NetworkUtils.getResponseFromHttp(url);
                    filteredJsonData = OpenRecepieJsonUtils.getSimpleRecepieStringsFromJson(this.getContext(),jsonDataFromHttp);
                    Log.v(TAG,"filteredJsonData:" + filteredJsonData);
                    return filteredJsonData;
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            public void deliverResult(ArrayList<RecepieProfileData> data) {
                mRecepieJson = data;
                Log.v(TAG,"mRecepieJson:" + mRecepieJson);
                if (mRecepieJson != null && mRecepieJson.size()>0){
                    super.deliverResult(data);
                } else {
                    forceLoad();
                }
            }
        };
    }*/

 /*   @Override
    public void onLoadFinished(Loader<ArrayList<RecepieProfileData>> loader, ArrayList<RecepieProfileData> data) {
        if (data != null && !data.equals("")){
            mAdapter.setRecepieData(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<RecepieProfileData>> loader) {

    }*/

}
