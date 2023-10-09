package com.example.myapplication;

import static com.example.myapplication.MainActivity.ranking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class RecordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        final Button backB = findViewById(R.id.back);
        Intent changer = new Intent(getApplicationContext(), MainActivity.class);

        //Tabla
        TableRow.LayoutParams params1 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams params2 = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableLayout tbl = (TableLayout) findViewById(R.id.tabla);

        //Campos
        TableRow row1 = new TableRow(this);
        TextView c1 = new TextView(this);
        TextView c2 = new TextView(this);
        TextView c3 = new TextView(this);
        //setting the text
        c1.setText("Nombre");
        c2.setText("Puntuacion");
        c3.setText("Tiempo");
        c1.setLayoutParams(params1);
        c2.setLayoutParams(params1);
        c3.setLayoutParams(params1);
        //the textviews have to be added to the row created
        row1.addView(c1);
        row1.addView(c2);
        row1.addView(c3);
        row1.setLayoutParams(params2);
        tbl.addView(row1);

        //Los records
        for(int ctr=0;ctr<ranking.size();ctr++) {
            TableRow row = new TableRow(this);
            TextView txt1 = new TextView(this);
            TextView txt2 = new TextView(this);
            TextView txt3 = new TextView(this);
            //setting the text
            txt1.setText(ranking.get(ctr).getName());
            txt2.setText(Integer.toString(ranking.get(ctr).getIntents()));
            txt3.setText(Integer.toString(ranking.get(ctr).getTemps()));
            txt1.setLayoutParams(params1);
            txt2.setLayoutParams(params1);
            txt3.setLayoutParams(params1);
            //the textviews have to be added to the row created
            row.addView(txt1);
            row.addView(txt2);
            row.addView(txt3);
            row.setLayoutParams(params2);
            tbl.addView(row);
        }

        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(changer);
            }
        });
    }

    private static void createTable(){

    }
}