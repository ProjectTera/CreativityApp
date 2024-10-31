package com.example.dailyjournalapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.List;

public class DiaryPage extends AppCompatActivity {

    private TextView diaryTitle, txtInput, txtCreated, txtUpdated;
    private Button btnNext, btnPrev, btnToHome, btnAddNewPage;
    private int pageNumber = 0;
    private ProgressBar pbPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_page);

        diaryTitle = findViewById(R.id.diaryTitle);
        txtInput = findViewById(R.id.txtInput);
        txtCreated = findViewById(R.id.txtCreated);
        txtUpdated = findViewById(R.id.txtUpdated);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrevious);
        btnToHome = findViewById(R.id.btnToHome);
        btnAddNewPage = findViewById(R.id.btnAddNewPage);

        Diary diary = (Diary) getIntent().getSerializableExtra("diary");
        List<String> pages = diary.getPages();
        String dateCreated = txtCreated.getText() + diary.getDateCreated() + " " + diary.getTimeCreated();
        String dateUpdated = txtUpdated.getText() + diary.getDateUpdated() + " " + diary.getTimeUpdated();

        diaryTitle.setText(diary.getTitle());
        txtInput.setText(pages.get(0));
        txtCreated.setText(dateCreated);
        txtUpdated.setText(dateUpdated);

        btnNext.setOnClickListener(view ->  {
            pageNumber++;
            pageNumber = pageNumber >= pages.size() ? pages.size() - 1 : pageNumber;
            txtInput.setText(pages.get(pageNumber));
        });

        btnPrev.setOnClickListener(view -> {
            pageNumber--;
            pageNumber = Math.max(pageNumber, 0);
            txtInput.setText(pages.get(pageNumber));
        });

        btnToHome.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), DiaryCollection.class);
            startActivity(i);
        });

        btnAddNewPage.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), AddPage.class);
            i.putExtra("diary", (Serializable) diary);
            startActivity(i);
        });
    }

}