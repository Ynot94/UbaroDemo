package com.example.tonyjm.ubarodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EnviarPrincipal extends AppCompatActivity {
    private Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_principal);
        b = getIntent().getExtras();
    }

    public void hizoClick(View v) {

        switch (v.getId())
        {
            case R.id.btnMiembro:
                break;
            case R.id.btnCashier:
                break;
            case R.id.btnCuentaBancaria:
                break;
            case R.id.btnBitcoin:
                break;
            case R.id.btnAtras:
                break;
        }
    }
}
