package com.example.dailyjournalapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddPage extends AppCompatActivity {

    EditText diaryTitle, inputPage;
    Button addPage, btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_page);

        String diary_title = getIntent().getStringExtra("title");
        int index = getIntent().getIntExtra("index", DiaryDB.getDiaries().size() - 1);

        diaryTitle = findViewById(R.id.editDiaryTitle);
        inputPage = findViewById(R.id.inputPage);

        diaryTitle.setText(diary_title);

        addPage = findViewById(R.id.btnAddPage);
        addPage.setOnClickListener(view -> {
            String input = inputPage.getText().toString();

            if (!isEmptyPage(input))
            {
                Diary diary = DiaryDB.getDiaries(index);
                diary.addPage(input);
                diary.setDateUpdate();
                diary.setTimeUpdate();
                DiaryDB.updateDiary(diary, index);
                Intent i = new Intent(getApplicationContext(), DiaryCollection.class);
                startActivity(i);
            }
        });

        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), DiaryCollection.class);
            startActivity(i);
        });
    }

    private boolean isEmptyPage(String input) { return input.isEmpty() || input.isBlank(); }
}