package com.example.android.bakingapp.utilities;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android.bakingapp.R;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.resource;

/**
 * Created by hjadhav on 12/31/2017.
 */

public class MasterListAdapter extends ArrayAdapter<RecepieProfileDataBasics> {

    public MasterListAdapter(Activity context, List<RecepieProfileDataBasics> recepieProfile) {
        super(context, 0 , recepieProfile);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        RecepieProfileDataBasics recepieProfileData = getItem(position);

        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_recepie,parent,false);

        TextView versionNameView = rootView.findViewById(R.id.list_item_version_name);
        versionNameView.setText(recepieProfileData.versionName);

        TextView versionNumberView = rootView.findViewById(R.id.list_item_version_number);
        versionNumberView.setText(recepieProfileData.versionNumber);

        return rootView;

    }
}
