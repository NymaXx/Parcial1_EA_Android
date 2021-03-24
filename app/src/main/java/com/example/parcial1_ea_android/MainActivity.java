package com.example.parcial1_ea_android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button greenBtn;
    private Button yellowBtn;
    private Button redBtn;
    private EditText posXt;
    private EditText posYt;
    private EditText recordatorio;
    private Button vistaBtn;
    private Button confirmarBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greenBtn = findViewById(R.id.greenBtn);
        yellowBtn = findViewById(R.id.yellowBtn);
        redBtn = findViewById(R.id.yellowBtn);
        posXt = findViewById(R.id.posXt);
        posYt = findViewById(R.id.posYt);
        recordatorio = findViewById(R.id.recordatorio);
        vistaBtn = findViewById(R.id.vistaBtn);
        confirmarBtn = findViewById(R.id.vistaBtn);

    }
}