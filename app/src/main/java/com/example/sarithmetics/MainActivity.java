package com.example.sarithmetics;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Declare buttons for accessing different activities
    private Button missionsButton;
    private Button shopButton;
    private Button practiceButton;
    private ImageView settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the buttons in the layout file and set their click listeners
        missionsButton = findViewById(R.id.missions_button);
        shopButton = findViewById(R.id.shop_button);
        practiceButton = findViewById(R.id.practice_button);
        settings = findViewById(R.id.settings_button);
        missionsButton.setOnClickListener(this);
        shopButton.setOnClickListener(this);
        practiceButton.setOnClickListener(this);
        settings.setOnClickListener(this);
    }

    // Handle button clicks
    @Override
    public void onClick(View view) {
        Intent intent;
        try {
            switch (view.getId()) {
                case R.id.missions_button:
                    // Go to Missions activity
                    intent = new Intent(this, MissionsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.shop_button:
                    // Go to Shop activity
                    intent = new Intent(this, ShopActivity.class);
                    startActivity(intent);
                    break;
                case R.id.practice_button:
                    // Go to Practice activity
                    intent = new Intent(this, PracticeActivity.class);
                    startActivity(intent);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    break;
                case R.id.settings_button:
                    // Go to Practice activity
                    intent = new Intent(this, SettingsActivity.class);
                    startActivity(intent);
                    break;
            }
        } catch (Exception e) {
            // Log the exception and stack trace
            Log.e("MainActivity", "Error navigating to activity: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void onBackPressed() {

    }
}