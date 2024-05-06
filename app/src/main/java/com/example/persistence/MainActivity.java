package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button readButton;
    private Button writeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create

        readButton = findViewById(R.id.readButton);
        readButton.setOnClickListener(this);

        writeButton = findViewById(R.id.writeButton);
        writeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.readButton:
                // Do something
            case R.id.writeButton:
                // DO something
        }
    }
}

