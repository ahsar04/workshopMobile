package com.asr.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {

    ListView listView;
    String[] mTitle = {"Jane","Smith","tono","dine","dave","juminem","sariyem","Jane","Smith","tono","dine","dave","juminem","sariyem"};
    String[] mDescription = {"BARU tetep asiikk! cukup Rp65rb dpt Unlimited 30hr","BARU tetep asiikk! cukup Rp65rb dpt Unlimited 30hr","BARU tetep asiikk! cukup Rp65rb dpt Unlimited 30hr","cukup Rp65rb dpt Unlimited 30hr","cukup Rp65rb dpt Unlimited 30hr","cukup Rp65rb dpt Unlimited 30hr","cukup Rp65rb dpt Unlimited 30hr","BARU tetep asiikk! cukup Rp65rb dpt Unlimited 30hr","BARU tetep asiikk! cukup Rp65rb dpt Unlimited 30hr","BARU tetep asiikk! cukup Rp65rb dpt Unlimited 30hr","cukup Rp65rb dpt Unlimited 30hr","cukup Rp65rb dpt Unlimited 30hr","cukup Rp65rb dpt Unlimited 30hr","cukup Rp65rb dpt Unlimited 30hr"};
    int [] mImage = {R.drawable.female,R.drawable.male,R.drawable.male,R.drawable.female,R.drawable.male,R.drawable.female,R.drawable.female,R.drawable.female,R.drawable.male,R.drawable.male,R.drawable.female,R.drawable.male,R.drawable.female,R.drawable.female};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle,mDescription,mImage);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),""+parent.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
            }
        });


    }
    class MyAdapter extends ArrayAdapter<String>{
        Context contxt;
        String rTitle[];
        String rdescription[];
        int rImage[];

        MyAdapter(Context c,String title[],String description[],int image[]){
            super(c,R.layout.list_row,R.id.mainTitle,title);
            this.contxt = c;
            this.rTitle = title;
            this.rdescription = description;
            this.rImage = image;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.list_row,parent,false);
            ImageView image = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.mainTitle);
            TextView myDescription = row.findViewById(R.id.subTitle);

            image.setImageResource(rImage[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rdescription[position]);

            return row;
        }

    }
}