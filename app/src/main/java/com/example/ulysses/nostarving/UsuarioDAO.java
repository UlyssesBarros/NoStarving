package com.example.ulysses.nostarving;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioDAO {

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    Context context_;
    long id_usuario;
    Usuario usuario_;

    public UsuarioDAO(Context context){
        databaseHelper = new DatabaseHelper(context);
        context_ = context;
    }
    public UsuarioDAO(Context context, Usuario usuario) {
        databaseHelper = new DatabaseHelper(context);
        context_ = context;
    }

    private SQLiteDatabase getDatabase() {
        if (database == null) {
            database = databaseHelper.getWritableDatabase();
        }
        return database;
    }

    public void salvarUsuario(Usuario usuario) {
        usuario_ = usuario;
        ContentValues valores = new ContentValues();
        ContentValues id = new ContentValues();
        valores.put(DatabaseHelper.Usuarios.NOME, usuario.getNome());
        valores.put(DatabaseHelper.Usuarios.LOGIN, usuario.getLogin());
        valores.put(DatabaseHelper.Usuarios.SENHA, usuario.getSenha());
        getDatabase().insert(DatabaseHelper.Usuarios.TABELA, null, valores);
        getDatabase().close();
        }

    public boolean buscarUsuarioPorLogin(String login) {
        Cursor cursor = getDatabase().query(DatabaseHelper.Usuarios.TABELA,
                DatabaseHelper.Usuarios.COLUNAS, "login = ?", new String[]{login}, null, null, null);
        if (!(cursor.moveToFirst())) {
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }

    public Usuario existeUsuario(String login, String senha) {  //antes se chamava "logar"
        Usuario usuario = new Usuario(login, senha);
        Cursor cursor = getDatabase().query(DatabaseHelper.Usuarios.TABELA,
                null, "LOGIN = ? AND SENHA = ?", new String[]{login, senha}, null, null, null);
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            int id = cursor.getInt(cursor.getColumnIndex("_id"));
            String nome = cursor.getString(1);
            usuario.set_id(id);
            usuario.setNome(nome);
            return usuario;
        }
        return null;
    }

    public  int retornarId(String login_) {
        Cursor cursor = getDatabase().query(DatabaseHelper.Usuarios.TABELA, DatabaseHelper.Usuarios.COLUNAS, DatabaseHelper.Usuarios.LOGIN + "=?", new String[]{ login_ }, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        int id = Integer.parseInt(cursor.getString(0));
        return id;
    }
}
