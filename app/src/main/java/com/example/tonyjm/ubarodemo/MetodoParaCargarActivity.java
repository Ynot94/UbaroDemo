package com.example.tonyjm.ubarodemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MetodoParaCargarActivity extends AppCompatActivity {
Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodo_para_cargar);
        b = getIntent().getExtras();
    }

    public void hizoClick(View v)
    {
        switch (v.getId()){
            case R.id.btnTarjetas:
                Intent i = new Intent(MetodoParaCargarActivity.this, CargarCuantoActivity.class);
                i.putExtra("CurrentUser",b.getString("CurrentUser"));
                startActivity(i);
                break;
            case R.id.btnEfectivo:
                Intent i2 = new Intent(MetodoParaCargarActivity.this, CargarCuantoActivity.class);
                i2.putExtra("CurrentUser",b.getString("CurrentUser"));
                startActivity(i2);
                break;
            case R.id.btnCuentaBancaria:
                Intent i3 = new Intent(MetodoParaCargarActivity.this, CargarCuantoActivity.class);
                i3.putExtra("CurrentUser",b.getString("CurrentUser"));
                startActivity(i3);
                break;
            case R.id.btnBitcoin:
                Intent i4 = new Intent(MetodoParaCargarActivity.this, CargarCuantoActivity.class);
                i4.putExtra("CurrentUser",b.getString("CurrentUser"));
                startActivity(i4);
                break;
            case R.id.btnAtras:
                Intent i5 = new Intent(MetodoParaCargarActivity.this, AgregarORetirar.class);
                i5.putExtra("CurrentUser",b.getString("CurrentUser"));
                startActivity(i5);
                break;
        }
    }
}
