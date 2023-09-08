package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View v)
    {
        TextView main = v.findViewById(R.id.mainText);
        switch (v.getId()){
            case(R.id.zeroButton):

            break;
            case(R.id.oneButton):

                break;


        }
    }
}