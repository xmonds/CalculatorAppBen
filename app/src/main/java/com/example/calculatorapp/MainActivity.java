package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean checkOperators(String numbers)
    {
        if((numbers.charAt(numbers.length() - 1) == '+') ||
                (numbers.charAt(numbers.length() - 1) == '-') ||
                (numbers.charAt(numbers.length() - 1) == '*') ||
                (numbers.charAt(numbers.length() - 1) == '/'))
        {
            Log.i("lol", "HLEO");
            return true;
        }
        Log.i("lol", "HKRIEJGRE");
        return false;
    }

    public String solve(String numbers)
    {
        int numCalcs = 0;
        List<String> equationList = new ArrayList<>();
        String temp = "";
        for(int i = 0; i < numbers.length(); i++)
        {
            if((numbers.charAt(i) == '+') ||
                    (numbers.charAt(i) == '-') ||
                    (numbers.charAt(i) == '*') ||
                    (numbers.charAt(i) == '/'))
            {
                numCalcs++;
            }
            if(numCalcs > 1)
            {
                equationList.add(temp);// no, actually try and combine the numbers
            }
            temp += numbers.charAt(i);
        }

        for(int i = numCalcs; numCalcs > 0; numCalcs--)
        {

        }
        return Integer.toString(numCalcs);
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
            if(!main.getText().toString().isEmpty())
            {
                if(checkOperators(main.getText().toString()) == false)
                {
                    main.setText(main.getText().toString() + "-");
                }
            }
        }
        else if (id == R.id.multiplyButton) {
            if(!main.getText().toString().isEmpty())
            {
                if(checkOperators(main.getText().toString()) == false)
                {
                    main.setText(main.getText().toString() + "*");
                }
            }
        }
        else if (id == R.id.divideButton) {
            if(!main.getText().toString().isEmpty())
            {
                if(checkOperators(main.getText().toString()) == false)
                {
                    main.setText(main.getText().toString() + "/");
                }
            }
        }
        else if (id == R.id.deleteButton) {
            if(!main.getText().toString().isEmpty())
            {
                String text = main.getText().toString().substring(0, main.getText().length() - 1);
                main.setText(text);
            }
        }
        else if (id == R.id.equalsButton) {
            Log.i("lol", solve(main.getText().toString()));
        }

    }
}