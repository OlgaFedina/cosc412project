package com.example.kenny;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonone;
    Button buttontwo;
    TextView textviewone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textviewone = findViewById(R.id.textView1);

        buttonone = findViewById(R.id.button1);
        buttontwo = findViewById(R.id.button2);

        buttonone.setOnClickListener(this);
        buttontwo.setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button1:
                Toast.makeText(this, "button one is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                Toast.makeText(this, "button two is clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

