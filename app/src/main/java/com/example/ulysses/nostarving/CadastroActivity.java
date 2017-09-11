package com.example.ulysses.nostarving;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class CadastroActivity extends AppCompatActivity {
    EditText login, senha, nome;
    Usuario usuario;
    Context context;
    private DatabaseHelper databasehelper;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        info_login();
    }

    public void onBackPressed(){
        startActivity(new Intent(this, InicialActivity.class));
        finish();
    }
    private void info_login(){
        nome = (EditText) findViewById(R.id.id_nome);
        login = (EditText) findViewById(R.id.id_login);
        senha = (EditText) findViewById(R.id.id_senha);
    }
    public void cadastro (View view){
        Context context = getApplicationContext();
        String Login = login.getText().toString();
        String Senha = senha.getText().toString();
        String Nome = nome.getText().toString();
        Usuario usuario = new Usuario(Nome,Login,Senha);
        UsuarioNegocio usuarioNegocio = new UsuarioNegocio(context,usuario);
        usuarioNegocio.cadastro(usuario);
        startActivity(new Intent(this, LogarActivity.class));
        finish();
    }
}
