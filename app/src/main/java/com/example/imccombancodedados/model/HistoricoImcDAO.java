package com.example.imccombancodedados.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HistoricoImcDAO {

    @Query("SELECT * FROM HISTORICOIMC WHERE usuarioid = :id")
    public List<HistoricoImc> findImc(long id);
    @Insert
    public void insertHistoricoImc (HistoricoImc... historicoImc);
}
