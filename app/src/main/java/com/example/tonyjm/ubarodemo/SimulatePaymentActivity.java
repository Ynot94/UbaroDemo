package com.example.tonyjm.ubarodemo;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class SimulatePaymentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulate_payment);
        Vibrator v = (Vibrator) this.getSystemService(this.VIBRATOR_SERVICE);
        // Vibrate for 500 milliseconds
        v.vibrate(500);
    }

    private void SimularPago()
    {
        Random rand = new Random();
        //TODO: Generar random shit:
        // 0,1,2
        switch (rand.nextInt(3))
        {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }

    }
}
