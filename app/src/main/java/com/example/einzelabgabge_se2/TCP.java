package com.example.einzelabgabge_se2;
import android.telecom.Call;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import java.io.*;
import java.net.*;


public class TCP extends Thread{

    String martriculationNumber;
    String modiefiedNumber;

    BufferedReader inFromServer;
    DataOutputStream outToServer;
    Socket socket = null;


    public TCP(String martriculationNumber){
        this.martriculationNumber = martriculationNumber;

    }
//Client-Server Connection
// Client has to create a Socket
// IP Adress and Port must be specified
// Communication via ByteStreams

    @Override
    public void run() {

        try {

            //create client socket to connect to server
            socket = new Socket("se2-isys.aau.at", 53212);

            //Create outputStream attached to socket
             outToServer = new DataOutputStream(socket.getOutputStream());

            //Create inputStream attached to socket
            inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //send to server
            outToServer.writeBytes(martriculationNumber + "\n");

            //read the line from server
            modiefiedNumber = inFromServer.readLine();

            setModiefiedNumber(modiefiedNumber);

           //z outToServer.flush();
            inFromServer.close();
            outToServer.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMartriculationNumber(String martriculationNumber) {
        this.martriculationNumber = martriculationNumber;
    }
    public String getMartriculationNumber() {
        return martriculationNumber;
    }
    public void setModiefiedNumber(String modiefiedNumber){
        this.modiefiedNumber = modiefiedNumber;
    }
    public String getModiefiedNumber(){
        return modiefiedNumber;
    }

}

