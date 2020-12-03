package com.example.fypdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//This code was modified from the YouTube tutorial https://www.youtube.com/watch?v=FcMiw16bouA

public class SpinnerActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner = findViewById(R.id.spinner2);

        List<String> interests = new ArrayList<>();
        interests.add(0, "Choose Interest");
        interests.add("Sport");
        interests.add("Nature");
        interests.add("History");
        interests.add("Computers");
        interests.add("Languages");
        interests.add("Reading");
        interests.add("Health");
        interests.add("Science");

        //Style the spinner and populate it
        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, interests);

        //Dropdown layout style
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //attaching data adapter to the spinner
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("Choose Interest"))
                {
                    //do nothing
                }
                else {

                    //on selecting a spinner item
                    String item = parent.getItemAtPosition(position).toString();

                    //show selected spinner item
                    Toast.makeText(parent.getContext(), "Selected: " +item, Toast.LENGTH_SHORT).show();

                    //if I want to do anything else on an item selection, I do it here

                    if (parent.getItemAtPosition(position).equals("Languages"))
                    {
                        Intent intent = new Intent(SpinnerActivity.this, LanguageCourses.class);
                        startActivity(intent);

                    }else if(parent.getItemAtPosition(position).equals("History")){
                        Intent intent = new Intent(SpinnerActivity.this, HistoryCourses.class);
                        startActivity(intent);

                    }else if(parent.getItemAtPosition(position).equals("Health")){
                        Intent intent = new Intent(SpinnerActivity.this, HealthCourses.class);
                        startActivity(intent);

                    }else if(parent.getItemAtPosition(position).equals("Sport")){
                        Intent intent = new Intent(SpinnerActivity.this, SportCourses.class);
                        startActivity(intent);

                    }else if(parent.getItemAtPosition(position).equals("Computers")){
                        Intent intent = new Intent(SpinnerActivity.this, ComputerCourses.class);
                        startActivity(intent);
                    }
                    //if (parent.getItemAtPosition(position).equals("History"))
                    //{
                      //  Intent intent = new Intent(SpinnerActivity.this, HistoryCourses.class);
                        //startActivity(intent);
                    //}


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                //TODO Auto-generated method

            }
        });

    }
}