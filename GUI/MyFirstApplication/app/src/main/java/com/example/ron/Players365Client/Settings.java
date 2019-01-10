package com.example.ron.Players365Client;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Ron on 10/01/2019.
 */

public class Settings extends AppCompatActivity {

    private ImageButton homepage;
    private ImageButton advSearch;
    private ImageButton exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_page_view);


        homepage = (ImageButton) findViewById(R.id.homePageButton);
        advSearch = (ImageButton) findViewById(R.id.advancedSearchButton);
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
        });;

        advSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdvancedSearchPage();
            }
        });



    }

    private void openAdvancedSearchPage() {
        startActivity(new Intent(this, AdvancedSearch.class));
    };

    private void openHomePage() {
        startActivity(new Intent(this, MainPageActivity.class));
    };

    public void exitApplication(){
        finish();
        moveTaskToBack(true);
    }



    }
