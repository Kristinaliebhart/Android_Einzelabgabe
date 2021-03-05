package com.example.einzelabgabge_se2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Text Input field
    private EditText input_number;

    //Text Output field
    private TextView displayServerCalculation;
    private TextView displayClientCalculation;

    //Button
    private Button serverButton;
    private  Button calcNumButton;

    private String matrikelnummer;
    private String resultFromServer;


    //Create Instances
    ASCII ascii = new ASCII();
    TCP tcp = new TCP(matrikelnummer);


    Thread thread = new Thread(tcp);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //access to fields via id
        input_number = (EditText) findViewById(R.id.textInputEditText);
        displayServerCalculation = (TextView) findViewById(R.id.textView2);
        displayClientCalculation = (TextView) findViewById(R.id.textView3);


        //add Eventlistener to the Server-Button
        serverButton = (Button) findViewById(R.id.button);
        serverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                matrikelnummer = input_number.getText().toString();
                //connect();
                tcp.setMartriculationNumber(matrikelnummer);

                thread.start();

                try {
                    thread.join(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                resultFromServer = tcp.getModiefiedNumber();
                displayServerCalculation.setText(resultFromServer);
            }
        });

        calcNumButton = (Button) findViewById(R.id.button2);
        calcNumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                matrikelnummer = input_number.getText().toString();
                String resultFromCalculation = ascii.getAscii(matrikelnummer);
                displayClientCalculation.setText(resultFromCalculation);
            }
        });
    }

}