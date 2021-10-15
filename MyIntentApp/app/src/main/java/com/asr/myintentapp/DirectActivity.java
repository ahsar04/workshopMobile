package com.asr.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DirectActivity extends AppCompatActivity {

    EditText nmrWa, pesan;
    Button btnKirim;
    String nmrWaStr, pesanStr ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct);

//        nmrWa = findViewById(R.id.edtNmr);
        pesan = findViewById(R.id.edtPesan);
        btnKirim = findViewById(R.id.btnKirim);

        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                nmrWaStr = nmrWa.getText().toString();
                pesanStr = pesan.getText().toString();

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,pesanStr);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
//
//                if (!nmrWaStr.isEmpty()) {
//                    boolean installed = isAppInstalled("com.whatsapp");
//                    if (installed){
//                        Intent intent = new Intent(Intent.ACTION_VIEW);
//                        intent.setData(Uri.parse("https://api.whatsapp.com/send?phone="+nmrWa+"&text="+pesanStr));
//                        startActivity(intent);
//                    }else {
//                        Toast.makeText(DirectActivity.this, "Whatsapp belum terinstall!", Toast.LENGTH_LONG).show();
//                    }
//
//
//
//                } else {
//
//                    Toast.makeText(DirectActivity.this, "Nomor Whatsapp tidak boleh kosong!", Toast.LENGTH_LONG).show();
//
//                }
//
//
            }
        });

    }
//    private boolean isAppInstalled (String s){
//        PackageManager packageManager = getPackageManager();
//        boolean is_installed;
//        try {
//            packageManager.getPackageInfo(s, PackageManager.GET_ACTIVITIES);
//            is_installed = true;
//        }catch (PackageManager.NameNotFoundException e){
//            is_installed = false;
//            e.printStackTrace();
//        }
//        return is_installed;
//    }
}