package com.example.android.bakingapp.utilities;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android.bakingapp.R;
import com.example.android.bakingapp.ui.MasterListFragment;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.resource;

/**
 * Created by hjadhav on 12/31/2017.
 */

public class MasterListAdapter extends RecyclerView.Adapter<MasterListAdapter.RecepieViewHolder> {

    private static final String TAG = MasterListAdapter.class.getSimpleName();
    public RecepieProfileDataBasics recepieProfileData ;
    public static List<RecepieProfileDataBasics> recepieProfileDataBasicsList = new ArrayList<>();
    public RecepieProfileData recepieProfileDataReal;
    private ArrayList<RecepieProfileData> recepieArray;


   /* public MasterListAdapter(Activity context, List<RecepieProfileDataBasics> recepieProfile) {
        super(context, recepieProfile);
    }*/
    public MasterListAdapter(Activity context, List<RecepieProfileDataBasics> recepieProfile){
        recepieProfileDataBasicsList = recepieProfile;
    }
    public MasterListAdapter(Activity context , ArrayList<RecepieProfileData> recepieArrayData){
        Log.v(TAG,"CODE REACHED MasterListAdapter");
        recepieArray = recepieArrayData;
    }

    private int mNumberItems;
    public MasterListAdapter (int numberOfItems){
        mNumberItems = numberOfItems;
    }

    /*@NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        RecepieProfileDataBasics recepieProfileData = getItem(position);

        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_recepie,parent,false);

        TextView versionNameView = rootView.findViewById(R.id.list_item_version_name);
        versionNameView.setText(recepieProfileData.versionName);

        TextView versionNumberView = rootView.findViewById(R.id.list_item_version_number);
        versionNumberView.setText(recepieProfileData.versionNumber);

        return rootView;

    }*/

    @Override
    public RecepieViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.list_item_recepie;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImeediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImeediately);
        RecepieViewHolder viewHolder = new RecepieViewHolder(view);

        Log.v(TAG,"CODE REACHED RecepieViewHolder");

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecepieViewHolder holder, int position) {
//        recepieProfileData = recepieProfileDataBasicsList.get(position);
        recepieProfileDataReal = recepieArray.get(position);
        Log.v(TAG,"CODE REACHED THIS BIND VIEW HOLDER METHOD");
        holder.bindNumber();
        holder.bindName();
    }

    @Override
    public int getItemCount() {

//        return recepieProfileDataBasicsList.size();
        if (null == recepieArray) return 0;
        return recepieArray.size();
    }

    class RecepieViewHolder extends RecyclerView.ViewHolder {
        TextView versionNumberView;
        TextView versionNameView;

        public RecepieViewHolder(View itemView) {
            super(itemView);
            versionNumberView = itemView.findViewById(R.id.list_item_version_number);
            versionNameView = itemView.findViewById(R.id.list_item_version_name);
        }
        void bindNumber (){
            Log.v(TAG,"CODE REACHED THIS BIND NUMBER METHOD");
//            versionNumberView.setText(recepieProfileData.versionName);
            versionNumberView.setText(recepieProfileDataReal.getId());
        }
        void bindName (){
            Log.v(TAG,"CODE REACHED THIS BIND NAME METHOD");
//            versionNameView.setText(recepieProfileData.versionNumber);
            versionNameView.setText(recepieProfileDataReal.getName());
        }
    }

        public void setRecepieData(ArrayList<RecepieProfileData> data){
            recepieArray = data;
            Log.v(TAG,"recepieArray: " + recepieArray);
            notifyDataSetChanged();
    }

}
