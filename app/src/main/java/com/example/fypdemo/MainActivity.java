package com.example.fypdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //reference buttons on layout
    Button btn_add, btn_viewAll, btn_next;
    EditText et_name, et_age;
    ListView lv_customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btnAdd);
        btn_viewAll = findViewById(R.id.btn_viewAll);
        btn_next = findViewById(R.id.btn_next);
        et_age = findViewById(R.id.et_age);
        et_name = findViewById(R.id.et_Name);
        lv_customerList = findViewById(R.id.lv_customerList);

        //listeners

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomerDetail customerDetail;

                try {
                    customerDetail = new CustomerDetail(-1, et_name.getText().toString(), Integer.parseInt(et_age.getText().toString()));
                    Toast.makeText(MainActivity.this, customerDetail.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error registering customer" , Toast.LENGTH_SHORT).show();
                    customerDetail = new CustomerDetail( -1, "error", 0);

                }

                DataBase dataBase = new DataBase(MainActivity.this);

                boolean success = dataBase.addOne(customerDetail);

                Toast.makeText( MainActivity.this, "Success" + success, Toast.LENGTH_SHORT).show();


            }
        });

        btn_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DataBase dataBase = new DataBase(MainActivity.this);
                List<CustomerDetail> everyone = dataBase.getEveryone();

                ArrayAdapter customerArrayAdapter = new ArrayAdapter<CustomerDetail>(MainActivity.this, android.R.layout.simple_list_item_1, everyone);
                lv_customerList.setAdapter(customerArrayAdapter);
                //Toast.makeText(MainActivity.this, everyone.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
                startActivity(intent);

            }
        });

    }
}