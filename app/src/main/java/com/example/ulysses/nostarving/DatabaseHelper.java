package com.example.ulysses.nostarving;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "tasks";
    private static final int VERSAO = 1;

    public DatabaseHelper(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    public String getNome(){
        return BANCO_DADOS;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Tabela de usuarios
        db.execSQL("CREATE TABLE Usuarios ( _id INTEGER PRIMARY KEY, "
                + "nome TEXT, login TEXT, senha TEXT)");
        // Tabela de compras
        db.execSQL("CREATE TABLE Compra ( _id INTEGER PRIMARY KEY, "
                + "tipo TEXT, valor TEXT, id_comprador TEXT, data TEXT)");
        // Tabela de produtos
        db.execSQL("CREATE TABLE Produto ( _id INTEGER PRIMARY KEY, "
                + "vendedor TEXT, nome TEXT, qnt TEXT, validade TEXT, preco TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public static class Usuarios {
        public static final String TABELA = "usuarios";
        public static final String _ID = "_id";
        public static final String NOME = "nome";
        public static final String LOGIN = "login";
        public static final String SENHA = "senha";
        public static final String[] COLUNAS = new String[]{
                _ID, NOME, LOGIN, SENHA
        };
    }

    public static class Compra {
        public static final String TABELA_COMPRA = "compra";
        public static final String ID = "_id";
        public static final String TIPO = "tipo";
        public static final String VALOR = "valor";
        public static final String ID_COMPRADOR = "id_comprador";
        public static final String DATA = "data";
        public static final String[] COLUNAS_COMPRA = new String[]{
                ID, TIPO, VALOR, ID_COMPRADOR, DATA
        };
    }

    public static class Produto {
        public static final String TABELA_PRODUTO = "produto";
        public static final String ID = "_id";
        public static final String VENDEDOR = "vendedor";
        public static final String NOME = "nome";
        public static final String QNT = "qnt";
        public static final String VALIDADE = "validade";
        public static final String PRECO = "preco";
        public static final String[] COLUNAS_PRODUTO = new String[]{
                ID, VENDEDOR, NOME, QNT, VALIDADE, PRECO
        };
    }

}