package com.example.imccombancodedados.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface HistoricoImcDAO {
    @Query("SELECT ID FROM USUARIO WHERE login =:login")
    public HistoricoImc findByLogin(String login);
    @Insert
    public void insertHistoricoImc (HistoricoImc... historicoImc);
}
