package com.example.ron.Players365Client;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Ron on 10/01/2019.
 */

public class AdvancedSearch extends AppCompatActivity {

    private ImageButton homepage;
    private ImageButton settings;
    private ImageButton exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advancedsearch);


        homepage = (ImageButton) findViewById(R.id.homePageButton);
        settings = (ImageButton) findViewById(R.id.settingsButton);
        exit = (ImageButton) findViewById(R.id.exitButton);

        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitApplication();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsPage();
            }
        });



    }

    private void openSettingsPage() {
        startActivity(new Intent(this, Settings.class));
    };

    private void openHomePage() {
        startActivity(new Intent(this, MainPageActivity.class));
    };

    public void exitApplication(){
        finish();
        moveTaskToBack(true);
    }



}
