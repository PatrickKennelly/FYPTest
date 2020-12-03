package com.example.fypdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
// This code has been modified from the YouTube tutorial https://www.youtube.com/watch?v=zEU7lpAjaGo

public class LanguageCourses extends AppCompatActivity {

    ListView lvProgram;
    String[] programName = {"French", "Chinese"};
    String[] programDescription = {"French description", "Chinese description"};
    //Integer array holds the image source id's
    int[] programImages = {R.drawable.coursera, R.drawable.coursera};
    //Create string array to hold the URL Links for the online courses
    String[] urls = {"https://www.coursera.org/learn/etudier-en-france",
    "https://www.coursera.org/learn/learn-chinese"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_courses);
        lvProgram = findViewById(R.id.lvProgram);
        //Specify the adapter and pass context
        ProgramAdapter programAdapter = new ProgramAdapter(this, programName, programImages, programDescription, urls);
        lvProgram.setAdapter(programAdapter);
    }
}