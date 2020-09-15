package com.halasfilip.androidspringclient;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerViewAdapter myQuestionAdapter;
    private RecyclerView.LayoutManager myLayoutManager;

    private RecyclerView recyclerView;
    private Button addDataButton, getDataButton;
    private EditText dataToBeSentEditText;

    private ArrayList<DataResource> dataResourcesList;

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
                myQuestionAdapter.addItem(new DataResource(), dataToBeSentEditText.getText().toString());
            }
        });

    }

    private void createList() {
        dataResourcesList = new ArrayList<>();

    }

    private void buildRecyclerView() {
        recyclerView.setHasFixedSize(false);
        myLayoutManager = new LinearLayoutManager(this);
        myQuestionAdapter = new RecyclerViewAdapter(dataResourcesList);

        recyclerView.setLayoutManager(myLayoutManager);
        recyclerView.setAdapter(myQuestionAdapter);
    }
}
