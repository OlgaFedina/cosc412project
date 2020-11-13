package com.example.datatest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText entry_title, entry_date, entry_desc;
    Button add_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        entry_title = findViewById(R.id.entry_title);
        entry_date = findViewById(R.id.entry_date);
        entry_desc = findViewById(R.id.entry_desc);
        add_Button = findViewById(R.id.add_button);
        add_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addEntry(entry_title.getText().toString().trim(),
                        entry_date.getText().toString().trim(),
                        entry_desc.getText().toString().trim());
            }
        });
    }
}