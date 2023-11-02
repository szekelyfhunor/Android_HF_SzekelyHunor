package com.example.contextmenu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.example.contextmenu.R;

import java.util.Arrays;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private TextView selectedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView text1 = findViewById(R.id.text1);
        registerForContextMenu(text1);

        TextView text2 = findViewById(R.id.text2);
        registerForContextMenu(text2);

        TextView text3 = findViewById(R.id.text3);
        registerForContextMenu(text3);

        TextView text4 = findViewById(R.id.text4);
        registerForContextMenu(text4);

        TextView text5 = findViewById(R.id.text5);
        registerForContextMenu(text5);

        TextView text6 = findViewById(R.id.text6);
        registerForContextMenu(text6);

        TextView text7 = findViewById(R.id.text7);
        registerForContextMenu(text7);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.example_menu, menu);

        selectedTextView = (TextView) v;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.piros) {
            selectedTextView.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
            return true;
        }

        if (item.getItemId() == R.id.zold) {
            selectedTextView.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark));
            return true;
        }

        if (item.getItemId() == R.id.sarga) {
            selectedTextView.setTextColor(ContextCompat.getColor(this, android.R.color.holo_orange_light));
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_sort) {
            TextView[] textViews = new TextView[7];
            textViews[0] = findViewById(R.id.text1);
            textViews[1] = findViewById(R.id.text2);
            textViews[2] = findViewById(R.id.text3);
            textViews[3] = findViewById(R.id.text4);
            textViews[4] = findViewById(R.id.text5);
            textViews[5] = findViewById(R.id.text6);
            textViews[6] = findViewById(R.id.text7);

            Arrays.sort(textViews, new Comparator<TextView>() {
                @Override
                public int compare(TextView textView1, TextView textView2) {
                    String text1 = textView1.getText().toString();
                    String text2 = textView2.getText().toString();
                    return text1.compareTo(text2);
                }
            });

            for (int i = 0; i < textViews.length; i++) {
                registerForContextMenu(textViews[i]);
            }

            return true;
        } else if (id == R.id.menu_delete) {
            TextView[] textViews = new TextView[7];
            textViews[0] = findViewById(R.id.text1);
            textViews[1] = findViewById(R.id.text2);
            textViews[2] = findViewById(R.id.text3);
            textViews[3] = findViewById(R.id.text4);
            textViews[4] = findViewById(R.id.text5);
            textViews[5] = findViewById(R.id.text6);
            textViews[6] = findViewById(R.id.text7);

            for (int i = 0; i < textViews.length; i++) {
                ViewGroup parent = (ViewGroup) textViews[i].getParent();
                parent.removeView(textViews[i]);
            }

            textViews = new TextView[7]; // Újra inicializáljuk a tömböt üres TextView-kel

            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


}
