package com.example.sarithmetics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity implements View.OnClickListener {

    // Declare buttons for accessing different activities
    private Button playagainButton, gobackButton;
    private ImageView settings;
    private TextView txtScore;
    private int lastQuestion, maxLives, maxDuration;
    private boolean isAdditionEnabled, isSubtractionEnabled, isMultiplicationEnabled, isDivisionEnabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);

        // Find the buttons in the layout file and set their click listeners
        playagainButton = findViewById(R.id.playagain_button);
        gobackButton = findViewById(R.id.goback_button);
        txtScore = findViewById(R.id.txtScore);
        playagainButton.setOnClickListener(this);
        gobackButton.setOnClickListener(this);

        lastQuestion = getIntent().getIntExtra("lastQuestion", 0);
        txtScore.setText(String.valueOf(lastQuestion));

        Intent intent = getIntent();
        isAdditionEnabled = intent.getBooleanExtra("isAddEnabled", false);
        isSubtractionEnabled = intent.getBooleanExtra("isSubEnabled", false);
        isMultiplicationEnabled = intent.getBooleanExtra("isMulEnabled", false);
        isDivisionEnabled = intent.getBooleanExtra("isDivEnabled", false);
        maxLives = intent.getIntExtra("hearts", 0); // Retrieve the hearts value
        maxDuration = intent.getIntExtra("time", 0); // Retrieve the time value
        getSupportActionBar().hide();
    }

    // Handle button clicks
    @Override
    public void onClick(View view) {
        Intent intent;
        try {
            switch (view.getId()) {
                case R.id.playagain_button:
                    // Go to Shop activity
                    intent = new Intent(this, EndlessGameActivity.class);
                    intent.putExtra("resetPrefs", "trueReset"); // Set the reset condition to true
                    intent.putExtra("isAddEnabled", isAdditionEnabled);
                    intent.putExtra("isSubEnabled", isSubtractionEnabled);
                    intent.putExtra("isMulEnabled", isMultiplicationEnabled);
                    intent.putExtra("isDivEnabled", isDivisionEnabled);
                    intent.putExtra("hearts", maxLives);
                    intent.putExtra("time", maxDuration);
                    startActivity(intent);
                    break;
                case R.id.goback_button:
                    // Go to Shop activity
                    intent = new Intent(this, PracticeActivity.class);
                    startActivity(intent);
                    break;
                case R.id.settings_button:
                    // Go to Practice activity
                    intent = new Intent(this, SettingsActivity.class);
                    startActivity(intent);
                    break;
            }
        } catch (Exception e) {
            // Log the exception and stack trace
            Log.e("PauseActivity", "Error navigating to activity: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void onBackPressed() {
        startActivity(new Intent(this, PracticeActivity.class));
    }
}