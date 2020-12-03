package com.example.fypdemo;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class HealthCourses extends AppCompatActivity {


    ListView lvHealthProgram;
    String[] programName = {"Food & Health", "Anatomy"};
    String[] programDescription = {"Description", "Description"};
    //Integer array holds the image source id's
    int[] programImages = {R.drawable.coursera, R.drawable.coursera};
    //Create string array to hold the URL Links for the online courses
    String[] urls = {"https://www.coursera.org/learn/food-and-health",
            "https://www.coursera.org/specializations/anatomy"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_courses);
        lvHealthProgram = findViewById(R.id.lvHealthProgram);
        //Specify the adapter and pass context
        ProgramAdapter programAdapter = new ProgramAdapter(this, programName, programImages, programDescription, urls);
        lvHealthProgram.setAdapter(programAdapter);
    }
}

