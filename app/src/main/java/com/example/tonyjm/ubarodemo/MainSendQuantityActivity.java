package com.example.tonyjm.ubarodemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainSendQuantityActivity extends AppCompatActivity {

    private String str = "", currentBalance, loggedUser;
    private Bundle b;
    private Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_send_quantity);
        b = getIntent().getExtras();

        currentBalance = b.getString("CurrentBalance");
        loggedUser = b.getString("CurrentUser");

        final Button btn1 = (Button)findViewById(R.id.btn1);
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

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float currBalance = Float.parseFloat(currentBalance);
                float desiredAmount = Float.parseFloat(str);
                if ((currBalance - desiredAmount) < 0)
                {
                    Toast.makeText(MainSendQuantityActivity.this, "Error, balance insuficiente", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Intent objIntent = new Intent(MainSendQuantityActivity.this, ConfirmarEnvioActivity.class);
                    objIntent.putExtra("Cantidad", str);
                    objIntent.putExtra("CurrentBalance", currentBalance);
                    objIntent.putExtra("CurrentUser", loggedUser);
                    if (loggedUser.equals("1"))
                        objIntent.putExtra("Destinatario", "4777294500");
                    else
                        objIntent.putExtra("Destinatario", "4777294577");
                    startActivity(objIntent);
                }
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
