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

public class ConfirmarRecargaActivity extends AppCompatActivity {
    String number, user;
    float balance, newBalance, amountToAdd;
    private Context ctx = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_recarga);

        TextView lblConfirmacion = (TextView)findViewById(R.id.lblConfirmarEnvio);
        Button btnConfirmar = (Button)findViewById(R.id.btnConfirmar);
        Button btnCancelar = (Button)findViewById(R.id.btnCancelar);

        Bundle b = getIntent().getExtras();
        number = b.getString("Cantidad");
        user = b.getString("CurrentUser");
        amountToAdd = Float.parseFloat(number);

        lblConfirmacion.setText("¿Confirmas digitalizar la cantidad de: $" + number + ".00");


        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseOperations dop = new DatabaseOperations(ctx);
                Cursor cr = dop.getBalanceById(dop, user);

                cr.moveToFirst();
                do {
                    String bal = cr.getString(0);
                    balance = Float.parseFloat(bal);
                }while (cr.moveToNext());

                newBalance = balance + amountToAdd;
                dop.updateBalanceById(dop, user, String.valueOf(newBalance));

                Intent objIntent = new Intent(ConfirmarRecargaActivity.this, MainActivity.class);
                objIntent.putExtra("CurrentUser", user);
                Toast.makeText(ConfirmarRecargaActivity.this,"Abono exitoso", Toast.LENGTH_LONG);
                startActivity(objIntent);
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(ConfirmarRecargaActivity.this, MainActivity.class);
                inte.putExtra("CurrentUser", user);
                startActivity(inte);
            }
        });
    }
}