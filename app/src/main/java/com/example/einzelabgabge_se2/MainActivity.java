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

    //where the result should be stored
    private String matrikelnummer;
    private String resultFromServer;

    //Create Instance
    ASCII ascii = new ASCII();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onStart() {
        super.onStart();

        //access to fields via id
        serverButton = (Button) findViewById(R.id.button);
        input_number = (EditText) findViewById(R.id.textInputEditText);
        displayServerCalculation = (TextView) findViewById(R.id.textView2);

        //add Eventlistener to the Server-Button
        serverButton.setOnClickListener((View.OnClickListener) view -> {
            String getnum = input_number.getText().toString();

            TCP tcp = new TCP(getnum);
            tcp.start();

            try {
                tcp.join();
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }

            resultFromServer = tcp.getModiefiedNumber();
            displayServerCalculation.setText(resultFromServer);
        });

        //calculate ascii
        calcNumButton = (Button) findViewById(R.id.button2);
        calcNumButton.setOnClickListener((View.OnClickListener) view -> {
            displayClientCalculation = (TextView) findViewById(R.id.textView3);
            matrikelnummer = input_number.getText().toString();
            String resultFromCalculation = ascii.getAscii(matrikelnummer);
            displayClientCalculation.setText(resultFromCalculation);
        });
    }

}
