package com.example.ulysses.nostarving;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static com.example.ulysses.nostarving.R.layout;

public class InicialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_inicial);
    }

    public void logar(View view){
        startActivity(new Intent(this, LogarActivity.class));
        finish();
    }

    public void cadastro(View view) {
        startActivity(new Intent(this, CadastroActivity.class));
        finish();
    }
}
