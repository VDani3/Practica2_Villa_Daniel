package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random r = new Random();
    int randomNumber = r.nextInt(100)+1, intents, temps = 0;
    public static ArrayList<Record> ranking = new ArrayList<Record>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.toastMaker);
        final EditText numField = findViewById(R.id.numberPick);
        final TextView evaluacio = findViewById(R.id.textView1);
        final Button sol = findViewById(R.id.solutionButton);
        final Button restartNum = findViewById(R.id.restartButton);
        final Button laderboard = findViewById(R.id.laderboard);

        //Para reiniciar el numero a encontrar
        restartNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randomNumber = r.nextInt(100)+1;
                evaluacio.setText("Inserta un numero del 1 al 100");
                Toast toast = Toast.makeText(getApplicationContext(), "Numero cambiado", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        //Boton para chequear si esta bien o mal
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence text = "Felicidades, has adivinado el numero";
                int duration = Toast.LENGTH_SHORT;

                String res = numField.getText().toString();
                if (res.equals("")) {           //Si no posa res
                    evaluacio.setText("Tienes que poner un numero");
                    Toast toast = Toast.makeText(getApplicationContext(), "No puede ser vacio", duration);
                    toast.show();
                } else {
                    int num = Integer.parseInt(res);

                    if (num == randomNumber) {
                        evaluacio.setText("Has adivinado el numero! ("+Integer.toString(num)+")");
                        Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                        toast.show();
                        mostrarAlerta();
                    } else if (num < randomNumber) {
                        evaluacio.setText("El numero es mes gran que "+Integer.toString(num));
                        Toast toast = Toast.makeText(getApplicationContext(), "Mal, prueba otra vez", duration);
                        toast.show();
                    } else if (num > randomNumber) {
                        evaluacio.setText("El numero es mes petit que "+Integer.toString(num));
                        Toast toast = Toast.makeText(getApplicationContext(), "Mal, prueba otra vez", duration);
                        toast.show();
                    }
                    numField.setText("");
                    intents += 1;
                }

            }
        });

        //Para ver la solucion
        sol.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view) {
                int duration = Toast.LENGTH_LONG;
                Toast solutionMessage = Toast.makeText(getApplicationContext(), "La solucio es "+Integer.toString(randomNumber), duration);
                solutionMessage.show();
            }
        });

        //Pera cambiar de vista a la laderboard
        laderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent record = new Intent(getApplicationContext(), RecordsActivity.class);
                startActivity(record);
            }
        });
    }

    private void mostrarAlerta() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Buen trabajo");
        builder.setMessage("Has acertado el numero!");
        // Set an EditText view to get user input
        final EditText input = new EditText(this);

        builder.setView(input);
        builder.setPositiveButton("Hecho ^-^", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = String.valueOf(input.getText());
                ranking.add(new Record(name, intents, temps));
                intents = 0;
                temps = 0;
                // Acción a realizar al hacer clic en el botón "Aceptar"
                dialog.dismiss(); // Cierra el AlertDialog
            }
        });

        builder.setNegativeButton("No guardar :(", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                intents = 0;
                temps = 0;
                dialog.dismiss(); // Cierra el AlertDialog
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


}
