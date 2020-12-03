package com.example.fypdemo;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class HistoryCourses extends AppCompatActivity {

    ListView lvHistoryProgram;
    String[] programName = {"World History", "Ancient Greek"};
    String[] programDescription = {"Description", "Description"};
    //Integer array holds the image source id's
    int[] programImages = {R.drawable.coursera, R.drawable.coursera};
    String[] urls = {"https://www.coursera.org/learn/modern-world",
            "https://www.coursera.org/learn/ancient-greeks"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_courses);
        lvHistoryProgram = findViewById(R.id.lvHistoryProgram);
        //Specify the adapter and pass context
       ProgramAdapter programAdapter = new ProgramAdapter(this, programName, programImages, programDescription, urls);
       lvHistoryProgram.setAdapter(programAdapter);
    }
}
