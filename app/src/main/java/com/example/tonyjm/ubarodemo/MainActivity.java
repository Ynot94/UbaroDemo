package com.example.tonyjm.ubarodemo;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
    private float currentBalance;
    private Context ctx = this;
    private Bundle b;
    TextView tvBalance;
    private static ListView list_view;
    private  TransactionListAdapter adapter;
    private List<Transaction> mTransactionList = new ArrayList<Transaction>();
    //private static String[] NAMES = new String[]{"Tony", "Alejandro", "Caro", "Mamá", "Alejandro", "Caro", "Mamá", "Alejandro", "Caro", "Mamá", "Alejandro", "Caro", "Mamá"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBalance = (TextView)findViewById(R.id.lblBalance);

        b = getIntent().getExtras();
        UpdateBalanceLabel();
        listView();

        //Botones inferiores
        Button btnEnviar = (Button)findViewById(R.id.btnEnviar);
        Button btnPagar = (Button)findViewById(R.id.btnPagar);
        Button btnRecibir = (Button)findViewById(R.id.btnRecibir);
        Button btnAgregar = (Button)findViewById(R.id.btnAgregarSaldo);
        Button btnAtras = (Button)findViewById(R.id.btnAtras);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*float newBalance = currentBalance + 500;
                DatabaseOperations dbop = new DatabaseOperations(ctx);
                dbop.updateBalanceById(dbop, b.getString("CurrentUser").toString(), String.valueOf(newBalance));
                UpdateBalanceLabel();*/

                Intent objIntent = new Intent(MainActivity.this, AgregarORetirar.class);
                objIntent.putExtra("CurrentUser", b.getString("CurrentUser"));
                objIntent.putExtra("CurrentBalance", String.valueOf(currentBalance));
                startActivity(objIntent);
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent objIntent = new Intent(MainActivity.this, EnviarPrincipal.class);
                objIntent.putExtra("CurrentUser", b.getString("CurrentUser"));
                objIntent.putExtra("CurrentBalance", String.valueOf(currentBalance));
                startActivity(objIntent);
            }
        });

        btnPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent objIntent = new Intent(MainActivity.this, PagarActivity.class);
                objIntent.putExtra("CurrentUser", b.getString("CurrentUser"));
                objIntent.putExtra("CurrentBalance", String.valueOf(currentBalance));
                startActivity(objIntent);
            }
        });

        btnRecibir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: pantalla solicitar
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obIntent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(obIntent);
            }
        });
    }

    public void listView() {
        list_view = (ListView)findViewById(R.id.listView);
        mTransactionList.add(new Transaction(1, "Pizza", "250","22/09/16"));
        mTransactionList.add(new Transaction(2, "Subway", "500","20/09/16"));
        mTransactionList.add(new Transaction(3, "Bagels", "120","17/09/16"));
        mTransactionList.add(new Transaction(4, "Mamá", "43","15/09/16"));
        mTransactionList.add(new Transaction(5, "Hermana", "90","10/09/16"));
        mTransactionList.add(new Transaction(6, "Tacos", "45","09/09/16"));
        mTransactionList.add(new Transaction(7, "Amazon", "900","08/09/16"));
        mTransactionList.add(new Transaction(8, "Boutique", "450","01/09/16"));

        adapter = new TransactionListAdapter(getApplicationContext(), mTransactionList);
        list_view.setAdapter(adapter);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Clicked product id: " + view.getTag(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void UpdateBalanceLabel()
    {
        DatabaseOperations dop = new DatabaseOperations(ctx);
        Cursor cr = dop.getBalanceById(dop, b.getString("CurrentUser"));
        cr.moveToFirst();
        String balance = "";
        do {
            String bal = cr.getString(0);
            currentBalance = Float.parseFloat(bal);
            tvBalance.setText(String.valueOf(currentBalance));
        }while (cr.moveToNext());
    }
}
