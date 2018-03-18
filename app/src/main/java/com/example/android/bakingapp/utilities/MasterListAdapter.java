package com.example.android.bakingapp.utilities;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.resource;

/**
 * Created by hjadhav on 12/31/2017.
 */

public class MasterListAdapter extends ArrayAdapter<RecepieProfileData> {
    private static final String TAG = MasterListAdapter.class.getSimpleName();

    // Keeps track of the context and list of images to display
    private Context mContext;
    private ArrayList<RecepieProfileData> recepieArray;

    public MasterListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<RecepieProfileData> objects) {
        super(context, resource, objects);
        mContext = context;
        recepieArray = objects;
    }

    /*public MasterListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        mContext = context;
    }*/

    /*public MasterListAdapter(Activity context, ArrayList<RecepieProfileData> recepieProfile) {
        mContext = context;
        recepieArray = recepieProfile;
    }*/

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.v(TAG,"Code reached MasterListAdapter");

       /* RecepieProfileData recepieProfileData = getItem(position);

        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_recepie,parent,false);

        TextView versionNameView = rootView.findViewById(R.id.list_item_version_name);
        versionNameView.setText(recepieProfileData.recepieNumber);

        TextView versionNumberView = rootView.findViewById(R.id.list_item_version_number);
        versionNumberView.setText(recepieProfileData.recepieName);
        Log.v(TAG,"Recepie Name: " + recepieProfileData.recepieName);

        return rootView;*/

       TextView textView;
        RecepieProfileData recepieProfileData = getItem(position);
        if (convertView == null){
            textView = new TextView(mContext);
        } else {
            textView = (TextView) convertView;
        }
        textView.setText(recepieProfileData.recepieName);
        Log.v(TAG,"Recepie Name: " + recepieProfileData.recepieName);
        return textView;
    }
}
