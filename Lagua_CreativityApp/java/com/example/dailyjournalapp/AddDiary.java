package com.example.dailyjournalapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;

public class AddDiary extends AppCompatActivity {

    private Button createDiary;
    private EditText diaryTitle;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diary);

        diaryTitle = findViewById(R.id.inputDiaryTitle);

        createDiary = findViewById(R.id.btnCreateDiary);
        createDiary.setOnClickListener(view -> {

            Diary diary = new Diary(diaryTitle.getText().toString());
            DiaryDB.addDiary(diary);

            index = DiaryDB.getDiaries().size() - 1;

            Intent i = new Intent(getApplicationContext(), AddPage.class);
            i.putExtra("title", diary.getTitle());
            i.putExtra("index", index);
            startActivity(i);
        });
    }
}