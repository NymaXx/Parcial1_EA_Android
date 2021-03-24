package com.example.parcial1_ea_android;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class comunicacionTCP extends Thread{

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private MainActivity app;

    public comunicacionTCP(MainActivity app) {
        this.app = app;

    }


    public void run() {
        try {
            this.socket = new Socket("192.168.18.4", 5000);

            //Reader
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            this.reader = new BufferedReader(isr);

            //Writer
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            this.writer = new BufferedWriter(osw);

            while (true) {
                recibirMensaje();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void solicitarConexion(/*String ip*/) {
        this.start();
    }


    public void enviarMensaje(String mensaje) {
        new Thread(
                () -> {
                    try {
                        writer.write(mensaje + "\n");
                        writer.flush();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
        ).start();
    }

    //Recibir mensaje
    public void recibirMensaje() throws IOException {
        String line = reader.readLine();


    }

    public void cerrarConexion() {
        try {
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}