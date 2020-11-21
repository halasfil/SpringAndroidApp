package com.halasfilip.androidspringclient.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.halasfilip.androidspringclient.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyAdapter> {

    private ArrayList<DataResource> mDataResource;

    public RecyclerViewAdapter(ArrayList<DataResource> dataResources) {
        mDataResource = dataResources;
    }

    public static class MyAdapter extends RecyclerView.ViewHolder {
        public TextView dataFromDB;

        public MyAdapter(@NonNull View itemView) {
            super(itemView);
            dataFromDB = itemView.findViewById(R.id.dataFromDB);
        }
    }

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_resource, parent, false);
        MyAdapter myAdap = new MyAdapter(view);
        return myAdap;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter holder, int position) {
        // in here we will pass method to include the data we will
        // get from the springApp using retrofit client
        // method is setting values in our item to see them in the recyclerview list
        // holder.dataFromDB.setText("TEST");

//        DataResource dataResource = mDataResource.get(position);
//        holder.dataFromDB.setText(dataResource.getDataToITemInList());
    }

    @Override
    public int getItemCount() {
        return mDataResource.size();
    }

    public void addItem(DataResource dataResource, String s) {
        //adding item will be parsed to be send as a retrofit object to springApp
//        dataResource.setInformationSent(s);
        mDataResource.add(dataResource);


        notifyItemInserted(mDataResource.size() - 1);
    }
}
