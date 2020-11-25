package com.example.fypdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class LanguageCourses extends AppCompatActivity {

    ListView lvProgram;
    String[] programName = {"French", "German"};
    String[] programDescription = {"French description", "German description"};
    int[] programImages = {R.drawable.coursera, R.drawable.coursera};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_courses);
        lvProgram = findViewById(R.id.lvProgram);
        ProgramAdapter programAdapter = new ProgramAdapter(this, programName, programImages, programDescription);
        lvProgram.setAdapter(programAdapter);
    }
}