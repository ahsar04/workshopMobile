package com.asr.fragmenapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;//variabel navigation viea

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//mengambil jendela fragmen untuk tampil fullscreen

        navigationView = findViewById(R.id.bottomNav);//deklarasi variabel untuk bottom navigation
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container,new HomeFragment()).commit();//get default fragmen
        navigationView.setSelectedItemId(R.id.navHome);//set devauld fragmen navHOme

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;//deklarasi variabel dengan nilai null
                switch (item.getItemId()){//cek item id
                    case R.id.navHome://apabila item = navHome
                        fragment = new HomeFragment();//tampilkan HomeFragmen
                        break;//hentikan switch
                    case R.id.navSearch:
                        fragment = new SearchFragment();
                        break;
                    case R.id.navLive:
                        fragment = new LiveTvFragment();
                        break;
                    case R.id.navHistory:
                        fragment = new HistoryFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.body_container,fragment).commit();//getting fragmen berdasarkan id yang ada
                return true;
            }
        });
    }
}