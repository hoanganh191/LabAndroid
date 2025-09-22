package com.example.lab02;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Bai7_Activity extends AppCompatActivity {
    AutoCompleteTextView actFruit;
    ArrayAdapter adapter;
    List<String> lsFruit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai7);
        mapping();
        lsFruit.add("Apple");
        lsFruit.add("Banana");
        lsFruit.add("Cherry");
        lsFruit.add("Date");
        lsFruit.add("Grape");
        lsFruit.add("Kiwi");
        lsFruit.add("Mango");
        lsFruit.add("Pear");
        adapter.notifyDataSetChanged();
        actFruit.setThreshold(1);
    }

    private void mapping(){
        actFruit = findViewById(R.id.actFruit);
        lsFruit = new ArrayList<>();
        adapter = new ArrayAdapter(Bai7_Activity.this, android.R.layout.simple_list_item_1, lsFruit);
        actFruit.setAdapter(adapter);
    }
}
