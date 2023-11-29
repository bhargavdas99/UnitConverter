package com.example.myconv;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setTitle("Unit Converter by Bhargab");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        textView=findViewById(R.id.textView2);
        editText=findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "RESULT CALCULATED", Toast.LENGTH_SHORT).show();
                String s = editText.getText().toString();
                double org = Double.parseDouble(s);
                double fin = org * 2.54;
                textView.setText(fin+" cm");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "RESULT CALCULATED", Toast.LENGTH_SHORT).show();
                String s = editText.getText().toString();
                int dotIndex = s.indexOf('.');
                double fin;
                if (dotIndex >= 0 && dotIndex < s.length() - 1) {
                    String beforeDecimal = s.substring(0, dotIndex);
                    String afterDecimal = s.substring(dotIndex + 1);
                    double a = Double.parseDouble(beforeDecimal);
                    double b = Double.parseDouble(afterDecimal);
                    fin = (a * 30.48) + (b*2.54);
                }
                else {
                    double org = Double.parseDouble(s);
                    fin = org * 30.48;
                }
                textView.setText(fin+" cm");
            }
        });
    }
}