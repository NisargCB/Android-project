package com.example.android_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

//import com.example.android_project.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

//    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.account) {
////            Intent intent = new Intent(MainActivity.this, com.example.android_project.ProfilePage.class);
////
////            startActivity(intent);
//            Toast.makeText(this, "Profile Account Item Clicked", Toast.LENGTH_SHORT).show();
//
//            return true;
//
//        }
//        else if (id == R.id.search) {
////            Intent intent = new Intent(MainActivity.this, com.example.android_project.ProfilePage.class);
////
////            startActivity(intent);
//            Toast.makeText(this, "Search Item Clicked", Toast.LENGTH_SHORT).show();
//
//            return true;
//
//        }
//        else{
//
//        return super.onOptionsItemSelected(item);}
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.profile_icon) {
            // Handle the profile icon click
            startActivity(new Intent(this, ProfilePage.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }





}




