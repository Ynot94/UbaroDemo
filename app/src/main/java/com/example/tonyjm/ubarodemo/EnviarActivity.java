package com.example.tonyjm.ubarodemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EnviarActivity extends AppCompatActivity {
    private Context ctx = this;
    private Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar);
        final TextView lblConfirmed = (TextView)findViewById(R.id.lblConfirmedUser);
        lblConfirmed.setVisibility(View.GONE);

        final Button btnSlectedUser = (Button)findViewById(R.id.btnEjemplo);
        Button btnContinuar = (Button)findViewById(R.id.btnContinuar);
        Button btnAtras = (Button)findViewById(R.id.btnAtras);

        btnSlectedUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b = getIntent().getExtras();
                String user = b.getString("CurrentUser");
                if (user.equals("1"))
                    lblConfirmed.setText("Has seleccionado enviar a Alejandro");
                else
                    lblConfirmed.setText("Has seleccionado enviar a Tony");

                btnSlectedUser.setVisibility(View.GONE);
                lblConfirmed.setVisibility(View.VISIBLE);
            }
        });
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent objIntent = new Intent(EnviarActivity.this, MainSendQuantityActivity.class);
                objIntent.putExtra("CurrentUser", b.getString("CurrentUser"));
                objIntent.putExtra("CurrentBalance", b.getString("CurrentBalance"));
                startActivity(objIntent);
            }
        });
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(EnviarActivity.this, MainActivity.class);
                obj.putExtra("CurrentUser", b.getString("CurrentUser"));
                startActivity(obj);
            }
        });
    }
}
