 package com.example.valutavalto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;


 public class MainActivity extends AppCompatActivity {

    ListView  lvProgram;
    String[] currencyCode = {"DKK", "EUR", "INR", "NOK", "CHF"};
    String[] currencyName = {"Dan korona", "Euro", "Indiai rupia", "Norveg korona", "Svajci frank"};
    int[] images = {R.drawable.denmark, R.drawable.european, R.drawable.india, R.drawable.norway, R.drawable.switzerland};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvProgram = findViewById(R.id.lvProgram);
        ProgramAdapter programAdapter = new ProgramAdapter(this, currencyCode, images, currencyName);
        lvProgram.setAdapter(programAdapter);
    }
}