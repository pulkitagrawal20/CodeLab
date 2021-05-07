package com.example.android.hellotoast;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {
    private int mCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }
    //Increase Counter and Show in the Text Field:
    public void countUp(View view) {
        TextView mShowCount=findViewById(R.id.show_count);
        if(mShowCount!=null){
            mShowCount.setText(Integer.toString(++mCount));
        }
    }
    //Show toast message:
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }


    }
