package com.example.valutavalto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

        lvProgram.setOnItemClickListener((parent, view, position, id) -> {
            if (position >= 0 && position < currencyCode.length) {
                ExchangeRateFragment exchangeRateFragment = new ExchangeRateFragment();

                Bundle bundle = new Bundle();
                bundle.putString("currency_code", currencyCode[position]);
                exchangeRateFragment.setArguments(bundle);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, exchangeRateFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });



    }
}