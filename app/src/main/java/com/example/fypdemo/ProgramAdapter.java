package com.example.fypdemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

//This code is modified from YouTube tutorial https://www.youtube.com/watch?v=zEU7lpAjaGo
// The code to link ListView image is modified from the YouTube tutorial https://www.youtube.com/watch?v=7VnmXuvr_cM
public class ProgramAdapter extends ArrayAdapter<String> {

    Context context;
    //Arrays for our dataset
    int[] images;
    String[] programName;
    String[] programDescription;
    String[] urls;

    public ProgramAdapter( Context context, String[] programName, int[] images, String[] programDescription, String[] urls) {
        //Single item is the xml defined in layout folder
        super(context, R.layout.single_item, R.id.textView1, programName);
        //Initialize the context
        this.context = context;
        this.images = images;
        this.programName = programName;
        this.programDescription = programDescription;
        this.urls = urls;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

    View singleItem = convertView;
    //Using findviewbyid can be an expensive task for application so I created a new class ProgramViewHolder
    //This class reduces number of calls to findviewbyid
        ProgramViewHolder holder = null;
    if(singleItem == null){
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        singleItem = layoutInflater.inflate(R.layout.single_item, parent, false);
        holder = new ProgramViewHolder(singleItem);
        singleItem.setTag(holder);

    }
    else{
        holder = (ProgramViewHolder) singleItem.getTag();
    }
    holder.itemImage.setImageResource(images[position]);
    holder.programTitle.setText(programName[position]);
    holder.programDescription.setText(programDescription[position]);
    singleItem.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Toast.makeText(getContext(), "You clicked:"+ programName[position], Toast.LENGTH_SHORT).show();
            Intent openLinksIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urls[position]));
            context.startActivity(openLinksIntent);
        }
    });

    return singleItem;
    }
}
