package com.example.imccombancodedados.model;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface HistoricoImcDAO {
    @Insert
    public void insertHistoricoImc (HistoricoImc... historicoImc);
}
