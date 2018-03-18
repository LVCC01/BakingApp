package com.example.android.bakingapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.utilities.MasterListAdapter;
import com.example.android.bakingapp.utilities.RecepieProfileData;

import java.util.ArrayList;

/**
 * Created by hjadhav on 3/11/2018.
 */

public class MasterListFragment extends Fragment {
    private static final String TAG = MasterListFragment.class.getSimpleName();
    private ArrayList<RecepieProfileData> recepieArray;

    // Mandatory empty constructor
    public MasterListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_master_list,container,false);
        GridView gridView = rootView.findViewById(R.id.menu_grid_view);
        MasterListAdapter mAdapter = new MasterListAdapter(getContext(),R.layout.fragment_master_list,recepieArray);
        gridView.setAdapter(mAdapter);
        return rootView;
    }
}
