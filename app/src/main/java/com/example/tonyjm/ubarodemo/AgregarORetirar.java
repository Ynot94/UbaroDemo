package com.example.tonyjm.ubarodemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AgregarORetirar extends AppCompatActivity {
    Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_oretirar);
        Button btnCancelar = (Button)findViewById(R.id.btnCancelar);
        Button btnCargarSaldo = (Button)findViewById(R.id.btnCargarSaldo);
        Button btnRetirarEnEfectivo = (Button)findViewById(R.id.btnRetirarEfectivo);
        b = getIntent().getExtras();
    }

    public void huboClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnCancelar:
                Intent objIntent = new Intent(AgregarORetirar.this, MainActivity.class);
                objIntent.putExtra("CurrentUser", b.getString("CurrentUser"));
                startActivity(objIntent);
                break;
            case  R.id.btnCargarSaldo:
                Intent objIntent2 = new Intent(AgregarORetirar.this, MetodoParaCargarActivity.class);
                objIntent2.putExtra("CurrentUser", b.getString("CurrentUser"));
                startActivity(objIntent2);
                break;
            case R.id.btnRetirarEfectivo:
                Intent objIntent3 = new Intent(AgregarORetirar.this, MainActivity.class);
                objIntent3.putExtra("CurrentUser", b.getString("CurrentUser"));
                startActivity(objIntent3);
                break;
        }
    }
}
