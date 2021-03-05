package com.example.einzelabgabge_se2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.KeyEvent;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView2;
    EditText textInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInputEditText = (EditText)findViewById(R.id.textInputEditText);
        button=(Button)findViewById(R.id.button);
        textView2=(TextView)findViewById(R.id.textView2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = textInputEditText.getText().toString();
                String erg = getAsci(number);
                textView2.setText(erg);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        setContentView(R.layout.activity_main);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public String getAsci(String number){
        String ergebnis= "";
        char newChar;

        for(int i = 0; i < number.length(); i++){
            if (i%2 == 0){
                ergebnis+= number.charAt(i);
            }

            else {
                switch (number.charAt(i)){
                    case '1':
                        newChar = 'a';
                        break;
                    case '2':
                        newChar = 'b';
                        break;
                    case '3':
                        newChar = 'c';
                        break;
                    case '4':
                        newChar = 'd';
                        break;
                    case '5':
                        newChar = 'e';
                        break;
                    case '6':
                        newChar = 'f';
                        break;
                    case '7':
                        newChar = 'g';
                        break;
                    case '8':
                        newChar = 'h';
                        break;
                    case '9':
                        newChar = 'i';
                        break;
                    case '0':
                        newChar = 'j';


                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + i);
                }
                ergebnis+= newChar;

            }
        }

        return ergebnis;
    }
}