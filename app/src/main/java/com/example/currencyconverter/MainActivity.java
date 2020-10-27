package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.*;

import java.util.*;
import java.lang.*;

public class MainActivity extends AppCompatActivity {

    EditText editUSD, editEUR, editVND, from;
    TextView to;
    Spinner spinner1, spinner2;

    double usd2eur = 0.84;
    double usd2vnd = 23178.0;

    HashMap<String, Double> cv = new HashMap<String, Double>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cv.put("USD", 1.0);
        cv.put("VND", 23178.0);
        cv.put("EUR", 0.84);
        cv.put("CNY", 6.71);
        cv.put("THB", 31.3);
        cv.put("GBP", 0.77);
        cv.put("SGD", 1.3);
        cv.put("AUD", 1.4);
        cv.put("LAK", 9257.0);
        cv.put("PHP", 48.5);

        from = (EditText) findViewById(R.id.from);
        to = (TextView) findViewById(R.id.res);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list1 = new ArrayList<String>();
//        Vietnam
        list1.add("USD");
//        My
        list1.add("VND");
//        chau au
        list1.add("EUR");
//        trung quoc
        list1.add("CNY");
//        thailan
        list1.add("THB");
//        bang anh
        list1.add("GBP");
//        singapore
        list1.add("SGD");
//        uc
        list1.add("AUD");
//        lao
        list1.add("LAK");
//        philippin
        list1.add("PHP");

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(dataAdapter1);

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list2 = new ArrayList<String>();
        list2.add("USD");
        list2.add("VND");
        list2.add("EUR");
        list2.add("CNY");
        list2.add("THB");
        list2.add("GBP");
        list2.add("SGD");
        list2.add("AUD");
        list2.add("LAK");
        list2.add("PHP");

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);


        from.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence,
                                          int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence,
                                      int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try{
                    String string1 = spinner1.getSelectedItem().toString();
                    String string2 = spinner2.getSelectedItem().toString();

                    Set<String> keySet = cv.keySet();
                    String string3 = from.getText().toString();
                    System.out.println(string3);
                    double input_number = Double.parseDouble(string3);
                    double res = 0;
                    double ts = 0, ms = 0;

                    ts = cv.get(string1);
                    ms = cv.get(string2);

                    res = input_number * ( ms/ts );
                    System.out.println(string1);
                    to.setText(String.format("%.5f", res));
                } catch(Exception e){
                    to.setText("");
                }

            }
        });

    }

}