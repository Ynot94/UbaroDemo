package com.example.tonyjm.ubarodemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SignInActivity extends AppCompatActivity {
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isFirstRun", true).commit();
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
        if (isFirstRun)
        {
            DatabaseOperations DB = new DatabaseOperations(ctx);
            DB.CreateDummieUsers(DB);
        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isFirstRun", false).commit();

        setContentView(R.layout.activity_sign_in);
        ImageView imgUser1 = (ImageView)findViewById(R.id.ivUser1);
        ImageView imgUser2 = (ImageView)findViewById(R.id.ivUser2);

        imgUser1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent objIntent = new Intent(SignInActivity.this, MainActivity.class);
                objIntent.putExtra("CurrentUser", "1");
                startActivity(objIntent);
            }
        });

        imgUser2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent objIntent = new Intent(SignInActivity.this, MainActivity.class);
                objIntent.putExtra("CurrentUser", "2");
                startActivity(objIntent);
            }
        });
    }
}
