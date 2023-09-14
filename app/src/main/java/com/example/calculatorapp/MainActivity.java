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
            return true;
        }
        return false;
    }

    public String solve(String numbers)
    {
        if(numbers.length() % 2 > 0 && numbers.length() > 1) {
            int numCalcs = 0;
            List<String> equationList = new ArrayList<>();
            List<Character> operatorList = new ArrayList<>();
            String temp = "";
            for (int i = 0; i < numbers.length(); i++) {
                if ((numbers.charAt(i) == '+') ||
                        (numbers.charAt(i) == '-') ||
                        (numbers.charAt(i) == '*') ||
                        (numbers.charAt(i) == '/')) {
                    numCalcs++;
                    operatorList.add(numbers.charAt(i));
                    equationList.add(temp);
                    temp = "";
                    i++;
                }
                if (i == numbers.length() - 1) {
                    equationList.add(temp + numbers.charAt(i));
                } else {
                    temp += numbers.charAt(i);
                }
            }
            double calcNum;
            for (int i = 0; i < operatorList.size(); ) {
                if (numbers.indexOf("*") > 0 ||
                        numbers.indexOf("/") > 0) {

                    for (int j = 0; j < operatorList.size(); ) {
                        if (operatorList.get(j) == '*') {
                            calcNum = Double.parseDouble(equationList.get(j)) * Double.parseDouble(equationList.get(j + 1));
                            equationList.set(j, Double.toString(calcNum));
                            equationList.remove(j + 1);
                            operatorList.remove(j);
                            j = 0;
                        } else if (operatorList.get(j) == '/') {
                            if(!equationList.get(j).equals("0") && !equationList.get(j + 1).equals("0"))
                            {
                                calcNum = Double.parseDouble(equationList.get(j)) / Double.parseDouble(equationList.get(j + 1));
                                equationList.set(j, Double.toString(calcNum));
                                equationList.remove(j + 1);
                                operatorList.remove(j);
                                j = 0;
                            }
                            else
                            {
                                return "0";
                            }
                        } else {
                            j++;
                        }
                    }
                }

                if (operatorList.size() > 0) {
                    if (operatorList.get(i) == '+') {
                        calcNum = Double.parseDouble(equationList.get(i)) + Double.parseDouble(equationList.get(i + 1));
                        equationList.set(i, Double.toString(calcNum));
                        equationList.remove(i + 1);
                        operatorList.remove(i);
                    } else if (operatorList.get(i) == '-') {
                        calcNum = Double.parseDouble(equationList.get(i)) - Double.parseDouble(equationList.get(i + 1));
                        equationList.set(i, Double.toString(calcNum));
                        equationList.remove(i + 1);
                        operatorList.remove(i);
                    }
                }


                i = 0;
            }


            return equationList.get(0);
        }
        return "";
    }


    public void buttonClick(View v)
    {
        TextView main = findViewById(R.id.mainText);

        int id = v.getId();

        Log.i("lol", main.getText().toString());
        if (id == R.id.zeroButton) {
            if(!main.getText().toString().isEmpty()) {
                main.setText(main.getText().toString() + "0");
            }
        }
        else if (id == R.id.oneButton) {
            main.setText(main.getText().toString() + "1");;
        }
        else if (id == R.id.twoButton) {
            main.setText(main.getText().toString() + "2");;
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
            if(checkOperators(main.getText().toString()) == false)
            {
                main.setText(solve(main.getText().toString()));
            }
        }
    }
}