package com.example.valutavalto;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExchangeRateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExchangeRateFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExchangeRateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExchangeRateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExchangeRateFragment newInstance(String param1, String param2) {
        ExchangeRateFragment fragment = new ExchangeRateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exchange_rate, container, false);

        // Kinyeri a kiválasztott valuta kódját az Argumentumokból
        Bundle bundle = getArguments();
        if (bundle != null) {
            String currencyCode = bundle.getString("currency_code", "");

            // Példa: Árfolyam megjelenítése egy TextView-ben
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textView = view.findViewById(R.id.textView);
            textView.setText("Árfolyamok a(z) " + currencyCode + " valutához");
        }

        return view;
    }
}