package com.example.tonyjm.ubarodemo;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Vibrator;
import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.StringTokenizer;

public class SimulatePaymentActivity extends AppCompatActivity {
    String currentUsr, aPagar = "";
    Context ctx = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle b = new Bundle();
        b = getIntent().getExtras();
        currentUsr = b.getString("CurrentUser");

        super.onCreate(savedInstanceState);
        //SimularPago();
        setContentView(R.layout.activity_simulate_payment);
        Vibrator v = (Vibrator) this.getSystemService(this.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        v.vibrate(500);
        Button btnDenegar = (Button)findViewById(R.id.btnConfirmarPago);
        Button btnAceptar = (Button)findViewById(R.id.btnConfirmarPago);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseOperations dop = new DatabaseOperations(ctx);
                Cursor cr = dop.getBalanceById(dop, currentUsr);
                Float balance;
                cr.moveToFirst();
                do {
                    String bal = cr.getString(0);
                    balance = Float.parseFloat(bal);
                }while (cr.moveToNext());

                balance = balance + Float.parseFloat(aPagar);
                dop.updateBalanceById(dop, currentUsr, String.valueOf(balance));

                Intent objIntent = new Intent(SimulatePaymentActivity.this, MainActivity.class);
                objIntent.putExtra("CurrentUser", currentUsr);
                Toast.makeText(SimulatePaymentActivity.this,"Pago Exitoso!", Toast.LENGTH_LONG);
                startActivity(objIntent);
            }
        });

        btnDenegar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SimulatePaymentActivity.this,"Pago Rechazado", Toast.LENGTH_LONG);
                Intent objIntent = new Intent(SimulatePaymentActivity.this, MainActivity.class);
                startActivity(objIntent);
            }
        });
    }

    private void SimularPago()
    {
        Random rand = new Random();
        //TODO: Generar random shit:
        ImageView imgLugar = (ImageView)findViewById(R.id.ivEstablecimiento);
        // 0,1,2
        switch (rand.nextInt(3))
        {
            case 0:
                imgLugar.setImageResource(R.drawable.rollpizza);
                break;
            case 1:
                imgLugar.setImageResource(R.drawable.tacos);
                break;
            case 2:
                imgLugar.setImageResource(R.drawable.lobsterrolls);
                break;
        }

        TextView lblPregunta = (TextView)findViewById(R.id.lblPreguntaPago);
        GenerarCantidad();
        lblPregunta.setText("¿Confirmar pago por: $"+aPagar+ ".00?");

    }

    private void GenerarCantidad()
    {
        Random rnd = new Random();
        aPagar += String.valueOf(rnd.nextInt(10)) + String.valueOf(rnd.nextInt(10));
    }
}
