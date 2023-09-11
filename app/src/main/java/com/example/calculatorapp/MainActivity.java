package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean checkOperators(String numbers)
    {

        if((numbers.charAt(numbers.length() - 1) != '+') ||
                (numbers.charAt(numbers.length() - 1) != '-') ||
                (numbers.charAt(numbers.length() - 1) != '*') ||
                (numbers.charAt(numbers.length() - 1) != '/'))
        {
            return true;
        }
        return false;
    }


    public void buttonClick(View v)
    {
        TextView main = findViewById(R.id.mainText);

        int id = v.getId();

        Log.i("lol", main.getText().toString());
        if (id == R.id.zeroButton) {
            main.setText(main.getText().toString() + "0");
        }
        else if (id == R.id.oneButton) {
            main.setText(main.getText().toString() + "1");
        }
        else if (id == R.id.twoButton) {
            main.setText(main.getText().toString() + "2");
        }
        else if (id == R.id.threeButton) {
            main.setText(main.getText().toString() + "3");
        }
        else if (id == R.id.fourButton) {
            main.setText(main.getText().toString() + "4");
        }
        else if (id == R.id.fiveButton) {
            main.setText(main.getText().toString() + "5");
        }
        else if (id == R.id.sixButton) {
            Log.i("lol", Integer.toString(R.id.sixButton));
            main.setText(main.getText().toString() + "6");
        }
        else if (id == R.id.sevenButton) {
            main.setText(main.getText().toString() + "7");
        }
        else if (id == R.id.eightButton) {
            main.setText(main.getText().toString() + "8");
        }
        else if (id == R.id.nineButton) {
            main.setText(main.getText().toString() + "9");
        }
        else if (id == R.id.plusButton) {
            if(!main.getText().toString().isEmpty())
            {
                if(checkOperators(main.getText().toString()) == false)
                {
                    main.setText(main.getText().toString() + "+");
                }
            }
        }
        else if (id == R.id.minusButton) {
            if(main.getText() != "")
            {
                main.setText(main.getText().toString() + "-");
            }
        }
        else if (id == R.id.multiplyButton) {
            if(main.getText() != "")
            {
                main.setText(main.getText().toString() + "*");
            }
        }
        else if (id == R.id.divideButton) {
            if(main.getText() != "")
            {
                main.setText(main.getText().toString() + "/");
            }
        }
    }
}