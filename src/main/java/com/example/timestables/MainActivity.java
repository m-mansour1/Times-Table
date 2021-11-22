package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    TextView text;
    ListView lview;
    SeekBar sbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text= findViewById(R.id.tView);
        lview = findViewById(R.id.lView);
        sbar = findViewById(R.id.sBar);
        sbar.setMax(20);
        sbar.setMin(1);
        sbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar sBar, int i, boolean fromUser) {
                Toast.makeText(MainActivity.this, "Generating the multiplication " +
                        "table of " + i, Toast.LENGTH_SHORT).show();
                writetables(i);
            }
            @Override
            public void onStartTrackingTouch(SeekBar sBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar sBar) { }
        });
    }

    public void writetables(int table){
        LinkedList<String> Tables  = new LinkedList<>();
        for (int i =1; i<=10;i++){
            Tables.add(table + " * " + i + " = " + table * i);
        }
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Tables);
        lview.setAdapter(arrayAdapter);
        text.setText("Multiplication Table of " + table);


    }
}