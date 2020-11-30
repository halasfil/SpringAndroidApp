package com.halasfilip.androidspringclient.utils;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.halasfilip.androidspringclient.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyAdapter> {

    private List<DataFetched> mDataFetched;

    public RecyclerViewAdapter(List<DataFetched> dataFetched) {
        mDataFetched = dataFetched;
        notifyDataSetChanged();

        //done

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void addItem(Integer id, String creationTime, String informationSent) {
        Stream<DataFetched> dataFetchedStream = mDataFetched.stream();

        if (dataFetchedStream.noneMatch(d -> d.getId().equals(id))){
            mDataFetched.add(new DataFetched(id, creationTime, informationSent));
            notifyItemInserted(mDataFetched.size() - 1);
        }

    }

    public static class MyAdapter extends RecyclerView.ViewHolder {
        public TextView localDateTimeTextView, textFromDBTextView;

        public MyAdapter(@NonNull View itemView) {
            //onCreate
            super(itemView);
            localDateTimeTextView = itemView.findViewById(R.id.localDateTimeTextView);
            textFromDBTextView = itemView.findViewById(R.id.textFromDBTextView);

            //done
        }
        //done
    }

    @NonNull
    @Override
    public MyAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.data_resource, parent, false);
        MyAdapter myAdap = new MyAdapter(view);
        return myAdap;
        //done

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter holder, int position) {
        // in here we will pass method to include the data we will
        // get from the springApp using retrofit client
        // method is setting values in our item to see them in the recyclerview list
        // holder.dataFromDB.setText("TEST");

//        DataResource dataResource = mDataResource.get(position);
//        holder.dataFromDB.setText(dataResource.getDataToITemInList());

        DataFetched dataFetched = mDataFetched.get(position);

        holder.textFromDBTextView.setText(dataFetched.getInformationSent());
        holder.localDateTimeTextView.setText(dataFetched.getCreationTime());

    }


    @Override
    public int getItemCount() {
        return mDataFetched.size();
    }


}
