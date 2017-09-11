package com.example.ulysses.nostarving;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TelaPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
    }
    public void onBackPressed(){
        startActivity(new Intent(this, LogarActivity.class));
        finish();
    }

    public void compra_activity(View view){
        startActivity(new Intent(this, CompraActivity.class));
    }

    public void venda_activity(View view){
        startActivity(new Intent(this, VendaActivity.class));
    }

    public void visu_mapa(View view){
        startActivity(new Intent(this, MapsActivity.class));
    }

    public void sair(View view){
        Intent intent = new Intent();
        intent.setClass(this, LogarActivity.class);
        startActivity(intent);
        finish();
    }
}
