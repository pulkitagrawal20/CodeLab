package com.example.android.colormyviews;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.android.colormyviews.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        setupEventHandlers();

    }

    private void makeColored(View view) {
        // checking the id of the view and setting the color to it accordingly
        if (view.getId() == b.boxOneText.getId()) {
            view.setBackgroundColor(Color.DKGRAY);
        } else if (view.getId() == b.boxTwoText.getId()) {
            view.setBackgroundColor(Color.GRAY);
        } else if (view.getId() == b.boxThreeText.getId()) {
            view.setBackgroundColor(Color.BLUE);
        } else if (view.getId() == b.boxFourText.getId()) {
            view.setBackgroundColor(Color.MAGENTA);
        } else if (view.getId() == b.boxFiveText.getId()) {
            view.setBackgroundColor(Color.BLUE);
        } else if (view.getId() == b.redButton.getId()) {
            b.boxThreeText.setBackgroundColor(getResources().getColor(R.color.my_red));
        } else if (view.getId() == b.yellowButton.getId()) {
            b.boxFourText.setBackgroundColor(getResources().getColor(R.color.my_yellow));
        } else if (view.getId() == b.greenButton.getId()) {
            b.boxFiveText.setBackgroundColor(getResources().getColor(R.color.my_green));
        } else {
            view.setBackgroundColor(Color.LTGRAY);
        }
    }

    private void setupEventHandlers() {
        // list of all the clickable views
        List<View> clickableViews = new ArrayList<>(
                Arrays.asList(b.boxOneText, b.boxTwoText, b.boxThreeText,
                        b.boxFourText, b.boxFiveText, b.constraintLayout,
                        b.redButton, b.yellowButton, b.greenButton)
        );

        // setting the on click listeners to all the views using loop
        for (View item :
                clickableViews) {
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    makeColored(item);
                }
            });
        }
    }
}