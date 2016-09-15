package com.example.tonyjm.ubarodemo;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CargarCuantoActivity extends AppCompatActivity {
    private Context ctx = this;
    private String str = "", currentBalance, loggedUser;
    private Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar_cuanto);
        Button btn1 = (Button)findViewById(R.id.btn1);
        Button btn2 = (Button)findViewById(R.id.btn2);
        Button btn3 = (Button)findViewById(R.id.btn3);
        Button btn4 = (Button)findViewById(R.id.btn4);
        Button btn5 = (Button)findViewById(R.id.btn5);
        Button btn6 = (Button)findViewById(R.id.btn6);
        Button btn7 = (Button)findViewById(R.id.btn7);
        Button btn8 = (Button)findViewById(R.id.btn8);
        Button btn9 = (Button)findViewById(R.id.btn9);
        Button btn0 = (Button)findViewById(R.id.btn0);
        Button btnNext = (Button)findViewById(R.id.btnNext);
        final TextView blSelectedNumber = (TextView)findViewById(R.id.lblSelectedNumber);

        b = getIntent().getExtras();
        //currentBalance = b.getString("CurrentBalance");
        loggedUser = b.getString("CurrentUser");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent objIntent = new Intent(CargarCuantoActivity.this, ConfirmarRecargaActivity.class);
                    objIntent.putExtra("Cantidad", str);
                    objIntent.putExtra("CurrentUser", loggedUser);
                    startActivity(objIntent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clicked = (Button)v;
                str += clicked.getText().toString();
                blSelectedNumber.setText("$"+str+".00");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clicked = (Button)v;
                str += clicked.getText().toString();
                blSelectedNumber.setText("$"+str+".00");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clicked = (Button)v;
                str += clicked.getText().toString();
                blSelectedNumber.setText("$"+str+".00");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clicked = (Button)v;
                str += clicked.getText().toString();
                blSelectedNumber.setText("$"+str+".00");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clicked = (Button)v;
                str += clicked.getText().toString();
                blSelectedNumber.setText("$"+str+".00");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clicked = (Button)v;
                str += clicked.getText().toString();
                blSelectedNumber.setText("$"+str+".00");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clicked = (Button)v;
                str += clicked.getText().toString();
                blSelectedNumber.setText("$"+str+".00");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clicked = (Button)v;
                str += clicked.getText().toString();
                blSelectedNumber.setText("$"+str+".00");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clicked = (Button)v;
                str += clicked.getText().toString();
                blSelectedNumber.setText("$" + str + ".00");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clicked = (Button)v;
                str += clicked.getText().toString();
                blSelectedNumber.setText("$"+str+".00");
            }
        });
    }
}
