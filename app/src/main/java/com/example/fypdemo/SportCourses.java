package com.example.fypdemo;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SportCourses extends AppCompatActivity {
    ListView lvSportProgram;
    String[] programName = {"Sport", "Fitness"};
    String[] programDescription = {"Description", "Description"};
    //Integer array holds the image source id's
    int[] programImages = {R.drawable.coursera, R.drawable.coursera};
    //Create string array to hold the URL Links for the online courses
    String[] urls = {"https://www.coursera.org/learn/youth-sports",
            "https://www.coursera.org/learn/hacking-exercise-health"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_courses);
        lvSportProgram = findViewById(R.id.lvSportProgram);
        //Specify the adapter and pass context
        ProgramAdapter programAdapter = new ProgramAdapter(this, programName, programImages, programDescription, urls);
        lvSportProgram.setAdapter(programAdapter);
    }
}
