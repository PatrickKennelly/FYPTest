package com.example.fypdemo;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ComputerCourses extends AppCompatActivity {

    ListView lvComputerProgram;
    String[] programName = {"Java", "C++"};
    String[] programDescription = {"Description", "Description"};
    //Integer array holds the image source id's
    int[] programImages = {R.drawable.coursera, R.drawable.coursera};
    //Create string array to hold the URL Links for the online courses
    String[] urls = {"https://www.coursera.org/specializations/object-oriented-programming",
            "https://www.coursera.org/specializations/coding-for-everyone"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_courses);
        lvComputerProgram = findViewById(R.id.lvComputerProgram);
        //Specify the adapter and pass context
        ProgramAdapter programAdapter = new ProgramAdapter(this, programName, programImages, programDescription, urls);
        lvComputerProgram.setAdapter(programAdapter);
    }
}
