package com.example.navigationdrawerexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbarManual);
        setSupportActionBar(toolbar);

        //for Setting Action bar in Toolbar
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menunavigation_black_24dp);


        ////////////////////////////////////
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);


        //listener for navigation View

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                switch (menuItem.getItemId()) {

                    case R.id.audio:
                        menuItem.setChecked(true);
                        displayMessage("Audio Selected");
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.build:
                        menuItem.setChecked(true);
                        displayMessage("Build Selected");
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.camera:
                        menuItem.setChecked(true);
                        displayMessage("Camera Selected");
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.extension:
                        menuItem.setChecked(true);
                        displayMessage("Extension Selected");
                        drawerLayout.closeDrawers();
                        return true;

                }
                return false;
            }
        });
    }


    public void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    //Method for Open Drawer Menu by clicking Action Bar Icon


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case android.R.id.home://home-->default id for action bar
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
