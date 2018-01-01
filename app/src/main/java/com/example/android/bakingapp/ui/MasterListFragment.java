package com.example.android.bakingapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.utilities.MasterListAdapter;
import com.example.android.bakingapp.utilities.RecepieProfileData;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hjadhav on 12/28/2017.
 */

public class MasterListFragment extends Fragment {

    // Mandatory empty constructor
    public MasterListFragment(){}
    MasterListAdapter mAdapter;

    /*RecepieProfileData[] recepieProfile = {
            new RecepieProfileData("Cupcake" , "1.5"),
            new RecepieProfileData("Donut" , "1.6"),
            new RecepieProfileData("Eclair" , "2.0-2.1"),
            new RecepieProfileData("Froyo" , "2.2-2.2.3"),
            new RecepieProfileData("GingerBread" , "2.3-2.3.7"),
            new RecepieProfileData("Honeycomb" , "3.0-3.2.6"),
            new RecepieProfileData("ICE Cream Sandwich" , "4.0-4.0.4"),
            new RecepieProfileData("Jelly Bean" , "4.1-4.3.1"),
            new RecepieProfileData("KitKat" , "4.4-4.4.4"),
            new RecepieProfileData("Lollipop" , "5.0-5.1.1")
    };*/

    // Inflates ListView for recepie names

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        /*mAdapter = new MasterListAdapter(getActivity(), Arrays.asList(recepieProfile));
        final View rootView = inflater.inflate(R.layout.fragment_master_list,container,false);
        ListView listView = rootView.findViewById(R.id.recepie_list);
        listView.setAdapter(mAdapter);*/

        return null;
    }
}
