package com.example.ulysses.nostarving;

import android.content.Context;

public class UsuarioNegocio {

    public UsuarioDAO usuarioDAO;
    public Usuario usuario;

    public UsuarioNegocio(Context context, Usuario usuario_){
        usuarioDAO = new UsuarioDAO(context,usuario_);
        usuario = usuario_;
    }

    public UsuarioNegocio(Context context){
        usuarioDAO = new UsuarioDAO(context);
    }

    public boolean retornarUsuario(String login, String senha){
        if(usuarioDAO.existeUsuario(login,senha) == null){
            return false;
        }
        else{
            return true;
        }
    }

    public void cadastro(Usuario usuario){
        usuarioDAO.salvarUsuario(usuario);
    }

}

