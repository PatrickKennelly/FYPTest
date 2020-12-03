package com.example.fypdemo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
//This code is modified from the Toutube tutorial https://www.youtube.com/watch?v=zEU7lpAjaGo

public class ProgramViewHolder {
    //Declare object references for our views
    ImageView itemImage;
    TextView programTitle;
    TextView programDescription;

    //Create constructor
    ProgramViewHolder(View v)
    {
        itemImage = v.findViewById(R.id.imageView);
        programTitle = v.findViewById(R.id.textView1);
        programDescription = v.findViewById(R.id.textView2);
    }
}
