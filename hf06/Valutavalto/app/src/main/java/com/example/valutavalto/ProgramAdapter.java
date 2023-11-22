package com.example.valutavalto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ProgramAdapter extends ArrayAdapter<String> {
    Context context;
    int[] images;
    String[] currencyCode;
    String[] currencyName;
    public ProgramAdapter( Context context, String[] currencyCode, int[] images, String[] currencyName) {
        super(context, R.layout.single_item, R.id.textView1, currencyCode);
        this.context = context;
        this.images = images;
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        View singleItem = convertView;
        ProgramViewHolder holder = null;
        if (singleItem == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.single_item, parent, false);
            holder = new ProgramViewHolder(singleItem);
            singleItem.setTag(holder);
        } else {
            holder = (ProgramViewHolder) singleItem.getTag();
        }
        holder.itemImage.setImageResource(images[position]);
        holder.currencyCode.setText(currencyCode[position]);
        holder.currencyName.setText(currencyName[position]);
        singleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "click", Toast.LENGTH_SHORT).show();
            }
        });
        return singleItem;
    }
}
