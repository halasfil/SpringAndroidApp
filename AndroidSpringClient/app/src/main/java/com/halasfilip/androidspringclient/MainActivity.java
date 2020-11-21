package com.halasfilip.androidspringclient;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.halasfilip.androidspringclient.retrofitUtils.InterfaceAPIRetrofit;
import com.halasfilip.androidspringclient.utils.DataResource;
import com.halasfilip.androidspringclient.utils.RecyclerViewAdapter;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerViewAdapter myQuestionAdapter;
    private RecyclerView.LayoutManager myLayoutManager;

    private RecyclerView recyclerView;
    private Button addDataButton, getDataButton;
    private EditText dataToBeSentEditText;

    private ArrayList<DataResource> dataResourcesList;

    private InterfaceAPIRetrofit interfaceAPIRetrofit;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        addDataButton = findViewById(R.id.addDataButton);
        getDataButton = findViewById(R.id.getDataButton);
        dataToBeSentEditText = findViewById(R.id.dataToBeSentEditText);

        createList();
        buildRecyclerView();

        addDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                myQuestionAdapter.addItem(new DataResource(), dataToBeSentEditText.getText().toString());

                String data = dataToBeSentEditText.getText().toString();
                sendDataToDB(data);
            }
        });

    }

    private void sendDataToDB(String dataToSend) {

        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        interfaceAPIRetrofit = retrofit.create(InterfaceAPIRetrofit.class);

        DataResource dataResource = new DataResource(dataToSend);

        Call<ResponseBody> call = interfaceAPIRetrofit.sendDataToDB(dataResource);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(MainActivity.this, "Success " + response, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Błąd " + t, Toast.LENGTH_LONG).show();
                String TAG  = "TU SIĘ ZJEBAŁO";
                Log.d(TAG, "onFailure: " + t);
            }
        });


    }

    private void createList() {
        dataResourcesList = new ArrayList<>();

        //download data from DB

    }

    private void buildRecyclerView() {
        recyclerView.setHasFixedSize(false);
        myLayoutManager = new LinearLayoutManager(this);
        myQuestionAdapter = new RecyclerViewAdapter(dataResourcesList);

        recyclerView.setLayoutManager(myLayoutManager);
        recyclerView.setAdapter(myQuestionAdapter);
    }
}
