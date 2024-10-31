package com.example.dailyjournalapp;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DiaryCollection extends AppCompatActivity {

    private ListView listDiary;
    private Button addDiary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_collection);

        listDiary = findViewById(R.id.listDiary);
        addDiary = findViewById(R.id.btnAddDiary);

        ArrayAdapter<String> adapterDiary = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                DiaryDB.getTitles()
        );

        listDiary.setAdapter(adapterDiary);
        listDiary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent diary = new Intent(getApplicationContext(), DiaryPage.class);
                diary.putExtra("diary", (Serializable) DiaryDB.getDiaries(i));
                startActivity(diary);
            }
        });

        addDiary.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), AddDiary.class);
            startActivity(i);
        });
    }
}