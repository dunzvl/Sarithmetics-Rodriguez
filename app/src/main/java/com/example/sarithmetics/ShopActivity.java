package com.example.sarithmetics;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity implements View.OnClickListener {

    // Declare buttons for accessing different activities
    private Button vigorButton, safeguardButton, frenzyButton, mysteryButton;
    private TextView coins;
    private RelativeLayout overlayLayout;
    private PopupWindow popupWindow;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        sessionManager = new SessionManager(this);

        // Find the buttons in the layout file and set their click listeners
        vigorButton = findViewById(R.id.vigor_button);
        safeguardButton = findViewById(R.id.safeguard_button);
        frenzyButton= findViewById(R.id.frenzy_button);
        mysteryButton = findViewById(R.id.mystery_button);
        overlayLayout = findViewById(R.id.overlayLayout2);
        vigorButton.setOnClickListener(this);
        safeguardButton.setOnClickListener(this);
        frenzyButton.setOnClickListener(this);
        mysteryButton.setOnClickListener(this);
        getSupportActionBar().hide();

    }

    // Handle button clicks
    @Override
    public void onClick(View view) {
        Intent intent;
        try {
            switch (view.getId()) {
                case R.id.vigor_button:
                    showVigorPopup();
                    break;
                case R.id.safeguard_button:
                    showSafeguardPopup();
                    break;
                case R.id.frenzy_button:
                    showFrenzyPopup();
                    break;
                case R.id.mystery_button:
                    showMysteryPopup();
                    break;
            }
        } catch (Exception e) {
            // Log the exception and stack trace
            Log.e("PracticeActivity", "Error navigating to activity: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private void showVigorPopup() {
        // Create a dialog object
        final Dialog popupDialog = new Dialog(this);
        final Dialog missingDialog = new Dialog(this);

        // Set the custom layout for the dialog
        popupDialog.setContentView(R.layout.vigor_popup);
        missingDialog.setContentView(R.layout.notenough_popup);

        // Find the close button inside the popup layout
        Button closeButton = popupDialog.findViewById(R.id.btnBuyVigor);

        // Create an instance of the SessionManager
        SessionManager sessionManager = new SessionManager(this);

        // Set a click listener for the close button
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dismiss/close the popup dialog
                MyDatabaseHelper myDB = new MyDatabaseHelper(ShopActivity.this);
                if (myDB.updateCoins(-50)) {
                    // Dismiss the popup dialog
                    popupDialog.dismiss();
                    String buttonId = getResources().getResourceEntryName(v.getId());
                    sessionManager.addPowerups(buttonId);
                } else {
                    // Show the missingDialog dialog
                    missingDialog.show();
                    // Delay dismissal of missingDialog dialog after 3 seconds
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            missingDialog.dismiss();
                        }
                    }, 3000);
                    String buttonId = getResources().getResourceEntryName(v.getId());
                    sessionManager.addPowerups(buttonId);
                    // Dismiss the popup dialog
                    popupDialog.dismiss();
                }
            }
        });

        // Show the popup dialog
        popupDialog.show();
    }

    private void showSafeguardPopup() {
        // Create a dialog object
        final Dialog popupDialog = new Dialog(this);
        final Dialog missingDialog = new Dialog(this);

        // Set the custom layout for the dialog
        popupDialog.setContentView(R.layout.safeguard_popup);
        missingDialog.setContentView(R.layout.notenough_popup);

        // Find the close button inside the popup layout
        Button closeButton = popupDialog.findViewById(R.id.btnBuySafeguard);

        // Set a click listener for the close button
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dismiss/close the popup dialog
                MyDatabaseHelper myDB = new MyDatabaseHelper(ShopActivity.this);
                if (myDB.updateCoins(-50)) {
                    // Dismiss the popup dialog
                    popupDialog.dismiss();
                    String buttonId = getResources().getResourceEntryName(v.getId());
                    sessionManager.addPowerups(buttonId);
                } else {
                    // Show the missingDialog dialog
                    missingDialog.show();

                    // Delay dismissal of missingDialog dialog after 3 seconds
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            missingDialog.dismiss();
                        }
                    }, 3000);
                    String buttonId = getResources().getResourceEntryName(v.getId());
                    sessionManager.addPowerups(buttonId);
                    // Dismiss the popup dialog
                    popupDialog.dismiss();
                }
            }
        });

        // Show the popup dialog
        popupDialog.show();
    }

    private void showFrenzyPopup() {
        // Create a dialog object
        final Dialog popupDialog = new Dialog(this);
        final Dialog missingDialog = new Dialog(this);

        // Set the custom layout for the dialog
        popupDialog.setContentView(R.layout.frenzy_popup);
        missingDialog.setContentView(R.layout.notenough_popup);

        // Find the close button inside the popup layout
        Button closeButton = popupDialog.findViewById(R.id.btnBuyFrenzy);

        // Set a click listener for the close button
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dismiss/close the popup dialog
                MyDatabaseHelper myDB = new MyDatabaseHelper(ShopActivity.this);
                if (myDB.updateCoins(-50)) {
                    // Dismiss the popup dialog
                    popupDialog.dismiss();
                    String buttonId = getResources().getResourceEntryName(v.getId());
                    sessionManager.addPowerups(buttonId);
                } else {
                    // Show the missingDialog dialog
                    missingDialog.show();

                    // Delay dismissal of missingDialog dialog after 3 seconds
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            missingDialog.dismiss();
                        }
                    }, 3000);
                    String buttonId = getResources().getResourceEntryName(v.getId());
                    sessionManager.addPowerups(buttonId);
                    // Dismiss the popup dialog
                    popupDialog.dismiss();
                }
            }
        });

        // Show the popup dialog
        popupDialog.show();
    }

    private void showMysteryPopup() {
        // Create a dialog object
        final Dialog popupDialog = new Dialog(this);
        final Dialog missingDialog = new Dialog(this);

        // Set the custom layout for the dialog
        popupDialog.setContentView(R.layout.mystery_popup);
        missingDialog.setContentView(R.layout.notenough_popup);

        // Find the close button inside the popup layout
        Button closeButton = popupDialog.findViewById(R.id.btnBuyMystery);

        // Set a click listener for the close button
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dismiss/close the popup dialog
                MyDatabaseHelper myDB = new MyDatabaseHelper(ShopActivity.this);
                if (myDB.updateCoins(-50)) {
                    // Dismiss the popup dialog
                    String buttonId = getResources().getResourceEntryName(v.getId());
                    sessionManager.addPowerups(buttonId);
                    popupDialog.dismiss();
                } else {
                    // Show the missingDialog dialog
                    missingDialog.show();

                    // Delay dismissal of missingDialog dialog after 3 seconds
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            missingDialog.dismiss();
                        }
                    }, 3000);
                    String buttonId = getResources().getResourceEntryName(v.getId());
                    sessionManager.addPowerups(buttonId);
                    // Dismiss the popup dialog
                    popupDialog.dismiss();
                }
            }
        });

        // Show the popup dialog
        popupDialog.show();
    }


}