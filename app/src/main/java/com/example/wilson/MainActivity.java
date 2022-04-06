package com.example.wilson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
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
    SmartClubFragment fifthFragment = new SmartClubFragment();
    SmartClubFragment2 sixthFragment = new SmartClubFragment2();
    StoryFragment seventhFragment = new StoryFragment();

    @SuppressLint("NonConstantResourceId")
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

            case R.id.smart:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_act, fifthFragment).commit();
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

    //onclick for story feature
    public void onClickStory(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.main_act, seventhFragment).commit();
    }
    public void onClickStoryOff(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_act, secondFragment).commit();
    }


    //change head colors
    public void onClickRed(View view){
        SmartClubFragment.onClickRed(view);
    }
    public void onClickBlack(View view){
        SmartClubFragment.onClickBlack(view);
    }
    public void onClickBlue(View view){
        SmartClubFragment.onClickBlue(view);
    }
    //change grip colors
    public void onClickOrangeGrip(View view){
        SmartClubFragment2.onClickOrangeGrip(view);
    }
    public void onClickBlueGrip(View view){
        SmartClubFragment2.onClickBlueGrip(view);
    }
    public void onClickRedGrip(View view){
        SmartClubFragment2.onClickRedGrip(view);
    }

    public void switchFragForward(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.main_act, sixthFragment).commit();
    }
    public void switchFragBackward(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.main_act, fifthFragment).commit();
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