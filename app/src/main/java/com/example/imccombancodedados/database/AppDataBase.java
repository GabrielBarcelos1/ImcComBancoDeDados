package com.example.imccombancodedados.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.imccombancodedados.model.HistoricoImc;
import com.example.imccombancodedados.model.HistoricoImcDAO;
import com.example.imccombancodedados.model.Usuario;
import com.example.imccombancodedados.model.UsuarioDAO;


@Database(entities =  {Usuario.class, HistoricoImc.class}, version = 1 )
public abstract class AppDataBase extends RoomDatabase {
    public abstract  UsuarioDAO usuarioDAO();
    public  abstract HistoricoImcDAO historicoImcDAO();
}
