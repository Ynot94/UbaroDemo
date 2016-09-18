package com.example.tonyjm.ubarodemo;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class PagarActivity extends AppCompatActivity {
    private Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar);
        b = getIntent().getExtras();
    }

    public void camaraClicked(View v)
    {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, 1);
        }
    }

    public void atrasClicked(View v){
        Intent objIntent = new Intent(PagarActivity.this, MainActivity.class);
        startActivity(objIntent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        String i = "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&";
        Log.d("Media: ", "Camera Terminated"+i);
        Intent objIntent = new Intent(PagarActivity.this, MainActivity.class);
        objIntent.putExtra("CurrentUser", b.getString("CurrentUser"));
        startActivity(objIntent);
    }
}
