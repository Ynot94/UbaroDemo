package com.example.tonyjm.ubarodemo;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarEnvioActivity extends AppCompatActivity {
    String number, user, phone, balance, receiverId;
    private Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_envio);

        TextView lblConfirmacion = (TextView)findViewById(R.id.lblConfirmarEnvio);
        Button btnConfirmar = (Button)findViewById(R.id.btnConfirmar);

        Bundle b = getIntent().getExtras();
        number = b.getString("Cantidad");
        phone = b.getString("Destinatario");
        balance = b.getString("CurrentBalance");
        user = b.getString("CurrentUser");
        if (user.equals("1")) {
            lblConfirmacion.setText("¿Confirmar envio a " + "Alejandro" + ", la cantidad de: $" + number + ".00");
            receiverId = "2";
        }
        else {
            lblConfirmacion.setText("¿Confirmar envio a " + "Tony" + ", la cantidad de: $" + number + ".00");
            receiverId = "1";
        }
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseOperations dop = new DatabaseOperations(ctx);
                Cursor cr = dop.getBalanceById(dop, receiverId);
                cr.moveToFirst();
                float balreceiver;
                do {
                    String bal = cr.getString(0);
                    balreceiver = Float.parseFloat(bal);
                }while (cr.moveToNext());

                float usr1newBalance =  Float.parseFloat(balance) - Float.parseFloat(number);
                float usr2newBalance = balreceiver + Float.parseFloat(number);

                dop.updateBalanceById(dop,receiverId, String.valueOf(usr2newBalance));
                dop.updateBalanceById(dop, user, String.valueOf(usr1newBalance));

                Intent objIntent = new Intent(ConfirmarEnvioActivity.this, MainActivity.class);
                objIntent.putExtra("CurrentUser", user);
                startActivity(objIntent);
            }
        });
    }
}
