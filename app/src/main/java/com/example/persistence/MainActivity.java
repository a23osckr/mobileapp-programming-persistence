package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button readButton;
    private Button writeButton;
    private TextView textViewChewingGum;

    private SQLiteDatabase database;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewChewingGum = findViewById(R.id.textView);

        textViewChewingGum.setMovementMethod(new ScrollingMovementMethod());

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

    private void writeChewingGumData() {
        EditText editTextTaste = findViewById(R.id.editTextTaste);
        EditText editTextChewiness = findViewById(R.id.editTextChewiness);
        EditText editTextColor = findViewById(R.id.editTextColor);

        String taste = editTextTaste.getText().toString().trim();
        String chewiness = editTextChewiness.getText().toString().trim();
        String color = editTextColor.getText().toString().trim();

        // Check if any field is empty
        if (taste.isEmpty() || color.isEmpty() || chewiness.isEmpty()) {
            if (taste.isEmpty()) {
                editTextTaste.setError("Please enter taste");
            }
            if (color.isEmpty()) {
                editTextColor.setError("Please enter color");
            }
            if (chewiness.isEmpty()) {
                editTextChewiness.setError("Please enter chewiness");
            }
            return;
        }

        // Add data
        databaseHelper.addChewingGum(taste, Integer.parseInt(chewiness), color);

        // Clear fields
        editTextTaste.setText("");
        editTextChewiness.setText("");
        editTextColor.setText("");

        // Data added successfully
        Toast.makeText(this, "Chewing gum data added successfully", Toast.LENGTH_SHORT).show();
    }
}

