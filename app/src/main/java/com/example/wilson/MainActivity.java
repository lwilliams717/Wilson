package com.example.wilson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;
    private MainActivity m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);

        //homeRecycler = findViewById(R.id.home_recycler);

    }
    HomeFragment firstFragment = new HomeFragment();
    CommunityFragment secondFragment = new CommunityFragment();
    ChatFragment thirdFragment = new ChatFragment();
    ProfileFragment fourthFragment = new ProfileFragment();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_act, firstFragment).commit();
                return true;

            case R.id.community:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_act, secondFragment).commit();
                return true;

            case R.id.chat:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_act, thirdFragment).commit();
                return true;

            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_act, fourthFragment).commit();
                return true;
        }
        return false;
    }

    public void onClickStore(View view) {
        openBrowser("https://www.wilson.com/en-us/golf");
    }

    public void onClickBrow(View view) {
        openBrowser("https://www.wilson.com/en-us/blog/golf");
    }

    public void openBrowser(String url){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

}