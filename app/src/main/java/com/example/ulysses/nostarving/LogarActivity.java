package com.example.ulysses.nostarving;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LogarActivity extends AppCompatActivity {
    EditText login, senha;
    String PREFERENCE_NAME = "LoginActivityPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logar);
        info_login();
    }
    public void onBackPressed(){
        startActivity(new Intent(this, InicialActivity.class));
        finish();
    }
    private void info_login(){
        login = (EditText) findViewById(R.id.login);
        senha = (EditText) findViewById(R.id.senha);
    }
    public void usuario_logar(View view){
        Context context = getApplicationContext();
        String Login = login.getText().toString();
        String Senha = senha.getText().toString();
        Usuario user = new Usuario(Login,Senha);
        UsuarioNegocio usuarioNegocio = new UsuarioNegocio(context,user);
        if(usuarioNegocio.retornarUsuario(Login,Senha)){
            SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
            SharedPreferences.Editor editor     = sharedPreferences.edit();
            editor.putString("LOGIN", String.valueOf(login));
            editor.putString("SENHA", String.valueOf(senha));
            startActivity(new Intent(this, TelaPrincipalActivity.class));
            finish();
        }

    }

}
