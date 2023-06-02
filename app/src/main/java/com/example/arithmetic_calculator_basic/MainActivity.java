package com.example.arithmetic_calculator_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button buttonAdd, buttonSubtract, buttonDivide, buttonMultiply, buttonEquals, buttonClear;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button button00, button000, buttonSquareRoot, buttonDecimalPoint, buttonNegative;
    EditText numberInput;
    TextView textViewError;
    boolean second_input = false;
    int current_operation = -1;
    float input_1 = 0;
    float input_2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberInput = findViewById(R.id.numberInput);
        textViewError = findViewById(R.id.textViewError);

        // Number Buttons
        button0 = findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.getText().append('0');
                textViewError.setText("");
            }
        });
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.getText().append('1');
                textViewError.setText("");
            }
        });
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.getText().append('2');
                textViewError.setText("");
            }
        });
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.getText().append('3');
                textViewError.setText("");
            }
        });
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.getText().append('4');
                textViewError.setText("");
            }
        });
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.getText().append('5');
                textViewError.setText("");
            }
        });
        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.getText().append('6');
                textViewError.setText("");
            }
        });
        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.getText().append('7');
                textViewError.setText("");
            }
        });
        button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.getText().append('8');
                textViewError.setText("");
            }
        });
        button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.getText().append('9');
                textViewError.setText("");
            }
        });
        button00 = findViewById(R.id.button00);
        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.getText().append("00");
                textViewError.setText("");
            }
        });
        button000 = findViewById(R.id.button000);
        button000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.getText().append("000");
                textViewError.setText("");
            }
        });

        // Number Operators

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operateNumber(0);
            }
        });

        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operateNumber(1);
            }
        });

        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operateNumber(2);
            }
        });

        buttonDivide = findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operateNumber(3);
            }
        });

        buttonSquareRoot = findViewById(R.id.buttonSquareRoot);
        buttonSquareRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input_1 = 0;
                input_2 = 0;

                current_operation = -1;
                second_input = false;

                float input = Float.parseFloat(numberInput.getText().toString());
                double sqrt = Math.sqrt(input);
                numberInput.setText(Double.toString(sqrt));
                textViewError.setText("");
            }
        });

        // Calculator Operators

        buttonEquals = findViewById(R.id.buttonEquals);
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operateNumber(4);
            }
        });

        buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input_1 = 0;
                input_2 = 0;

                current_operation = -1;
                second_input = false;

                numberInput.setText("");
                textViewError.setText("");
            }
        });
        
        buttonNegative = findViewById(R.id.buttonNegative);
        buttonNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = numberInput.getText().toString();
                if (!text.startsWith("-")) {
                    numberInput.setText("-" + text);
                } else {
                    numberInput.setText(text.substring(1));
                }
            }
        });
        
        buttonDecimalPoint = findViewById(R.id.buttonDecimalPoint);
        buttonDecimalPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = numberInput.getText().toString();
                if (!text.contains(".")) {
                    numberInput.setText(text + ".");
                }
            }
        });
    }
    void evaluate() {
        if (current_operation < 0) {
            textViewError.setText("error = Negative operation.");
        } else {
            if (current_operation == 0) {
                // Add
                input_2 = (input_1 + input_2);
                numberInput.setText(Float.toString(input_2));
                second_input = false;
            } else if (current_operation == 1) {
                // Subtract
                input_2 = (input_1 - input_2);
                numberInput.setText(Float.toString(input_2));
                second_input = false;
            } else if (current_operation == 2) {
                // Multiply
                input_2 = (input_1 * input_2);
                numberInput.setText(Float.toString(input_2));
                second_input = false;
            } else if (current_operation == 3) {
                // Divide
                if (input_2 != 0) {
                    input_2 = (input_1 / input_2);
                    numberInput.setText(Float.toString(input_2));
                    second_input = false;
                } else {
                    numberInput.setText("");
                    input_1 = 0;
                    input_2 = 0;

                    current_operation = -1;
                    second_input = false;

                    textViewError.setText("error = Divide by zero.");
                }
            } else {
                textViewError.setText("error = Unknown operation.");
            }
        }
    }
    void operateNumber(int operation) {
        if (!second_input) {
            if (operation <= 3) {
                input_1 = Float.parseFloat(numberInput.getText().toString());
                second_input = true;

                numberInput.setText("");
                textViewError.setText("");
                current_operation = operation;
            }
        } else {
            if (operation == 4) {
                input_2 = Float.parseFloat(numberInput.getText().toString());

                evaluate();
            }
        }
    }
}