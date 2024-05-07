package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button readButton;
    private Button writeButton;
    private SQLiteDatabase database;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create
        databaseHelper = new DatabaseHelper(this);
        database = databaseHelper.getWritableDatabase();

        readButton = findViewById(R.id.readButton);
        readButton.setOnClickListener(this);

        writeButton = findViewById(R.id.writeButton);
        writeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.readButton:
                displayChewingGumData();
                break;
            case R.id.writeButton:
                writeChewingGumData();
                break;
        }
    }
    private void displayChewingGumData() {
        List<ChewingGum> chewingGums = databaseHelper.getChewingGum();
        StringBuilder sb = new StringBuilder();

        for (ChewingGum gum : chewingGums) {
            sb.append("ID: ").append(gum.getId()).append("\n");
            sb.append("Taste: ").append(gum.getTaste()).append("\n");
            sb.append("Chewiness: ").append(gum.getChewiness()).append("\n");
            sb.append("Color: ").append(gum.getColor()).append("\n\n");
        }
        textViewChewingGum.setText(sb.toString());
    }
}

