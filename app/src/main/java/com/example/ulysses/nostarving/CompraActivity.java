package com.example.ulysses.nostarving;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.Vector;

public class CompraActivity extends AppCompatActivity {
    AutoCompleteTextView produto;
    private DatabaseHelper databaseHelper;
    SQLiteDatabase database;
    String PREFERENCE_NAME = "LoginActivityPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);
        databaseHelper = new DatabaseHelper(getApplicationContext());
        produtos_db();
    }

    public void produtos_db(){
        Vector<String> result = new Vector<>();
        Cursor cursor = getDatabase().rawQuery("SELECT NOME FROM Produto", null);
        while (cursor.moveToNext()){
            result.add(cursor.getString(0));
        }
        cursor.close();
        getDatabase().close();
        ArrayAdapter<String> produtos = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, result);
        produto = (AutoCompleteTextView) findViewById(R.id.nome_produto);
        produto.setAdapter(produtos);
    }

    private SQLiteDatabase getDatabase(){
        if (database == null){
            database = databaseHelper.getWritableDatabase();
        }
        return database;
    }

    public void avancar(View view){
        SharedPreferences nome_produto = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = nome_produto.edit();
        editor.putString("Nome_Produto", String.valueOf(produto));
        startActivity(new Intent(this, MapsActivity.class));
    }

}
