package com.example.valutavalto;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProgramViewHolder {
    ImageView itemImage;
    TextView currencyName;
    TextView currencyCode;
    ProgramViewHolder(View v){
        itemImage = v.findViewById(R.id.imageView3);
        currencyCode = v.findViewById(R.id.textView1);
        currencyName = v.findViewById(R.id.textView2);

    }
}
