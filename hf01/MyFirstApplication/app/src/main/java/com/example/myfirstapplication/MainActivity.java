package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    EditText editText1, editText2;
    TextView textView;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd = findViewById(R.id.button_add);
        buttonSub = findViewById(R.id.button_sub);
        buttonDiv = findViewById(R.id.button_div);
        buttonMul = findViewById(R.id.button_mul);
        editText1 = findViewById(R.id.number1);
        editText2 = findViewById(R.id.number2);
        textView = findViewById(R.id.answer);

        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
    }

    public int getIntFromEditText(EditText editText){
        if(editText.getText().toString().equals("")){
            Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            return Integer.parseInt(editText.getText().toString());
        }
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        num1 = getIntFromEditText(editText1);
        num2 = getIntFromEditText(editText2);

        if(view.getId() == R.id.button_add) {
            textView.setText("Answer: "+(num1 + num2));
        } else if(view.getId() == R.id.button_sub) {
            textView.setText("Answer: "+(num1 - num2));
        } else if(view.getId() == R.id.button_mul) {
            textView.setText("Answer: "+(num1 * num2));
        } else if(view.getId() == R.id.button_div) {
            if (num2 != 0) {
                textView.setText("Answer: "+((float)num1 / (float)num2));
            } else {
                textView.setText("Error: Division by zero");
            }
        }
    }

}