package com.example.ron.Players365Client;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PlayerPageActivity extends AppCompatActivity {

    private TextView name;
    private TextView goal;
    private TextView appreances;

    private ImageButton b;
    private ImageButton exit;
    private ImageButton settings;
    private ImageButton advancedSearch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_page_view);

        // Preventing screen rotation on Android
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        exit = (ImageButton) findViewById(R.id.exitButton);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitApplication();
            }
        });;

        settings = (ImageButton) findViewById(R.id.settingsButton);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsPage();
            }
        });;

        advancedSearch = (ImageButton) findViewById(R.id.advancedSearchButton);
        advancedSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdvancedSearchPage();
            }
        });

        b = (ImageButton) findViewById(R.id.homePageButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        name = (TextView)findViewById(R.id.player_name);
        goal = (TextView)findViewById(R.id.goals);
        appreances = (TextView)findViewById(R.id.appearences);

        String url ="https://api.myjson.com/bins/s1e5o";

        getPlayer(url);
        // Player= Player.replace("\"","\\\"");

        String Player2="{\"player_name\":\"Lionel Messi\",\"goals\":\"30\",\"appearences\":\"15\"}";



        // name.setText(Player);
       /*
       if(Player.equals(Player2))
       {
           name.setText("true");
       }
       else
       {
           name.setText("false");
       }
*/
        //postPlayerStatics(Player);
    }
    /*
        private void postPlayerStatics(String Player)
        {
            try {
                JsonPlayerObject p =returnParsedJsonObject(Player);
                name.setText(p.getplayerName());
                goal.setText(p.getGoals());
                appreances.setText(p.getApperences());

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    */

    public void openActivity2() {
        startActivity(new Intent(this, PlayerPageActivity.class));
    };

    public void openAdvancedSearchPage()  {
        startActivity(new Intent(this, AdvancedSearch.class));
    };

    public void openSettingsPage() {
        startActivity(new Intent(this, Settings.class));
    };

    public void exitApplication(){
        finish();
        moveTaskToBack(true);
    }

    private void getPlayer(String url)
    {
        try {
            run(url);
        } catch (IOException e) {
            //txtString.setText(e.getMessage());
            e.printStackTrace();
        }
    }

    void run(String url) throws IOException {
        //intalaize the okhttpclient
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String myResponse  = response.body().string();
                //Player= res;
                //Player= Player.replace("\"","\\\"");
                // postPlayerStatics(Player);
                PlayerPageActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            ParsedJsonObject(myResponse);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }




    private void ParsedJsonObject(String myResponse) throws JSONException {

        JSONObject json = new JSONObject(myResponse );
        name.setText(json.getString("player_name"));
        goal.setText(json.getString("goals"));
        appreances.setText(json.getString("appearences"));

    }



}
