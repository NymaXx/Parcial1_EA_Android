package com.example.parcial1_ea_android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button greenBtn;
    private Button yellowBtn;
    private Button redBtn;
    private EditText posXt;
    private EditText posYt;
    private EditText recordatorio;
    private Button vistaBtn;
    private Button confirmarBtn;

    //para comunicar con TCP
    private comunicacionTCP com;


    //para guardar datos
    private String posX;
    private String posY;
    private String record;
    private String importancia;
    private String mensajeRecordatorio;
    private String importanciaText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        com = new comunicacionTCP(this);
        com.solicitarConexion();

        greenBtn = findViewById(R.id.greenBtn);
        yellowBtn = findViewById(R.id.yellowBtn);
        redBtn = findViewById(R.id.yellowBtn);
        posXt = findViewById(R.id.posXt);
        posYt = findViewById(R.id.posYt);
        recordatorio = findViewById(R.id.recordatorio);
        vistaBtn = findViewById(R.id.vistaBtn);
        confirmarBtn = findViewById(R.id.confirmarBtn);

        redBtn.setOnClickListener(
                (v)-> {
                    importanciaText = "3";
                }
        );

        yellowBtn.setOnClickListener(
                (v)-> {
                    importanciaText = "2";
                }
        );

        greenBtn.setOnClickListener(
                (v)-> {
                    importanciaText = "1";
                }
        );

        confirmarBtn.setOnClickListener(
                (v) -> {
                    importancia = importanciaText;
                    posX = posXt.getText().toString();
                    posY = posYt.getText().toString();
                    record = recordatorio.getText().toString();

                    mensajeRecordatorio = posX +"," + posY +"," + record +"," + importancia;

                    if(!posX.equals("") && !posY.equals("") && !record.equals("") && !importancia.equals("")) {
                        com.enviarMensaje(mensajeRecordatorio);

                    } else {
                        runOnUiThread(
                                () -> {
                                    Toast.makeText(this, "Llene todos los campos por favor",
                                            Toast.LENGTH_SHORT).show();
                                }
                        );
                    }
                }
        );
    }
}
