package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random r = new Random();
    int randomNumber = r.nextInt(100)+1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.toastMaker);
        final EditText numField = findViewById(R.id.numberPick);
        final TextView evaluacio = findViewById(R.id.textView1);
        final Button sol = findViewById(R.id.solutionButton);
        final Button restartNum = findViewById(R.id.restartButton);

        restartNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randomNumber = r.nextInt(100)+1;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence text = "Felicidades, has adivinado el numero";
                int duration = Toast.LENGTH_SHORT;

                String res = numField.getText().toString();
                if (res.equals("")) {           //Si no posa res
                    res = "1111";
                }
                int num = Integer.parseInt(res);

                if (num == randomNumber) {
                    evaluacio.setText("Has adivinado el numero! ("+Integer.toString(num)+")");
                    Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                    toast.show();
                } else if (num < randomNumber) {
                    evaluacio.setText("El numero es mes gran que "+Integer.toString(num));
                    Toast toast = Toast.makeText(getApplicationContext(), "Mal, prueba otra vez", duration);
                    toast.show();
                } else if (num > randomNumber) {
                    evaluacio.setText("El numero es mes petit que "+Integer.toString(num));
                    Toast toast = Toast.makeText(getApplicationContext(), "Mal, prueba otra vez", duration);
                    toast.show();
                }

            }
        });

        sol.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view) {
                int duration = Toast.LENGTH_LONG;
                Toast solutionMessage = Toast.makeText(getApplicationContext(), "La solucio es "+Integer.toString(randomNumber), duration);
                solutionMessage.show();
            }
        });
    }
    


}
