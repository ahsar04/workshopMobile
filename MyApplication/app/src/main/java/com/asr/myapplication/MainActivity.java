package com.asr.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private static final String[] kota = new String[]  {"Indonesia","Filipina","Kamboja","Laos","Myanmar","Thailand","Vietnam","Brunai","Malaysia","Singpura","Timor Leste"};
    AutoCompleteTextView autoCompleteTextView;
    private  Button btnReg;
    MessageActivity settingActivity=new MessageActivity();
    Spinner joSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Register");




        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> autoComplateAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,kota);
        autoCompleteTextView.setAdapter(autoComplateAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });

        joSpinner = findViewById(R.id.jobSpinner);

        ArrayAdapter<CharSequence>spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.job, R.layout.support_simple_spinner_dropdown_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        joSpinner.setAdapter(spinnerAdapter);

        joSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnReg = (Button) findViewById(R.id.btnRegister);
        btnReg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openSettingActivity();
            }
        });
    }
    public void openSettingActivity(){
        Intent intent = new Intent(this, MessageActivity.class);
        startActivity(intent);
    }
}