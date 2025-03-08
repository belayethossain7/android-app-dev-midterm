package com.demoapp.techworld;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Load data from arrays.xml
        Resources res = getResources();
        String[] techNames = res.getStringArray(R.array.tech_names);
        String[] techUrls = res.getStringArray(R.array.tech_urls);

        // Set Adapter
        TechAdapter adapter = new TechAdapter(this, techNames, techUrls);
        recyclerView.setAdapter(adapter);
    }
}