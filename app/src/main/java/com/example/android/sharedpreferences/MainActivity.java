package com.example.android.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.android.sharedpreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding b;
    SharedPreferences preferences;

    //initializing constants keys to transfer data between Activities:
    private static final String COUNT_KEY ="count" ;
    private static final String COLOR_KEY ="Color" ;

    //Count of text view:
    private int Count;

    //Background color of the buttons:
    private int backgroundColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        b=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        preferences=getPreferences(MODE_PRIVATE);
        
        setUpOnClickListener();

        if(preferences!=null){
            Count=preferences.getInt(COUNT_KEY,0);
            UpdateCount();

            backgroundColor=preferences.getInt(COLOR_KEY,getResources().getColor(R.color.Gray));
            UpdateBGColor();
        }

    }

    //Event Handlers for the TextViews and Buttons:
    private void setUpOnClickListener() {
        b.countIncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IncCount();
            }
        });
        b.resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResetButton();
            }
        });
        b.blackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColor=getResources().getColor(R.color.black);
               UpdateBGColor();
            }
        });
        b.redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColor=getResources().getColor(R.color.Red);
                UpdateBGColor();
            }
        });
        b.blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColor=getResources().getColor(R.color.Blue);
                UpdateBGColor();
            }
        });
        b.greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColor=getResources().getColor(R.color.Green);
                UpdateBGColor();
            }
        });
    }

    //Reset Count and Background color:
    private void ResetButton() {
        Count=0;
        UpdateCount();

        backgroundColor=getResources().getColor(R.color.Gray);
        UpdateBGColor();

        //clearing the data stored in the shared preferences:
        preferences.edit().clear().apply();

    }

    //increase the count of the TextView:
    private void IncCount() {
        ++Count;
        UpdateCount();
    }
    // displaying count in the TextView:
    private void UpdateBGColor() {
        b.countTextView.setBackgroundColor(backgroundColor);
    }

    //displaying background Color in the TextView:
    private void UpdateCount() {
        b.countTextView.setText(String.valueOf(Count));
    }

    @Override
    protected void onPause() {
        super.onPause();
        preferences.edit()
                .putInt(COUNT_KEY,Count)
                .putInt(COLOR_KEY,backgroundColor)
                .apply();
    }
}