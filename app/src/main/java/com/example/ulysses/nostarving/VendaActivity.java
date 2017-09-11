package com.example.ulysses.nostarving;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class VendaActivity extends AppCompatActivity {
    EditText nome, quantidade, validade, preco;
    private DatabaseHelper databaseHelper;
    public SQLiteDatabase database;
    private static final String PREFERENCE_NAME = "LoginActivityPreferences";
    Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venda);
        SharedPreferences preferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        usuario.setLogin(preferences.getString("LOGIN", null));
        usuario.setSenha(preferences.getString("SENHA", null));
        encontrar_itens();
    }

    public SQLiteDatabase getDatabase() {
        if (database == null) {
            database = databaseHelper.getWritableDatabase();
        }
        return database;
    }

    public void encontrar_itens(){
        nome = (EditText) findViewById(R.id.nome_produto);
        quantidade = (EditText) findViewById(R.id.quantidade);
        validade = (EditText) findViewById(R.id.validade);
        preco = (EditText) findViewById(R.id.preco);
    }

    public void salvar_produto(View view){
        Context context = getApplicationContext();
        databaseHelper = new DatabaseHelper(context);
        String Nome = nome.getText().toString();
        String Quantidade = quantidade.getText().toString();
        String Validade = validade.getText().toString();
        String Preco = preco.getText().toString();
        Produto produto = new Produto();
        produto.setNome(Nome);
        produto.setPreco(Preco);
        produto.setQnt(Quantidade);
        produto.setValidade(Validade);
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.Produto.NOME, produto.getNome());
        cv.put(DatabaseHelper.Produto.QNT, produto.getQnt());
        cv.put(DatabaseHelper.Produto.VALIDADE, produto.getValidade());
        cv.put(DatabaseHelper.Produto.PRECO, produto.getPreco());
        cv.put(DatabaseHelper.Produto.VENDEDOR, usuario.getNome());
        getDatabase().insert(DatabaseHelper.Produto.TABELA_PRODUTO, null, cv);
        getDatabase().close();
        Toast.makeText(context,"Cadastrado com Sucesso", Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, TelaPrincipalActivity.class));
        finish();
    }

}
