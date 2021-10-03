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

public class SettingActivity extends AppCompatActivity {

    ListView listView;
    String[] mTitle = {"Account","Preferences","Audience and Visibility","Permission","Your Information","Community Standards and Legal Police","Logout"};
    String[] mDescription = {"Personal and account information","Your time on this app","Profile information","Manage permission and location","Access a log of your activity","Term of service",""};
    int [] mImage = {R.drawable.account,R.drawable.prefer,R.drawable.audience,R.drawable.permission,R.drawable.info,R.drawable.legal_police,R.drawable.logout};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
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