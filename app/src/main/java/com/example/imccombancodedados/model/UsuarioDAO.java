package com.example.imccombancodedados.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UsuarioDAO {
    @Query("Select * FROM usuario")
    public List<Usuario> findByAll();

    @Query("Select * from usuario where id in (:ids)")
    public List<Usuario> findByIds(long[] ids);

    @Query("SELECT * FROM USUARIO WHERE id = :id")
    public Usuario findById(long id);

    @Query("Select * from usuario where nome = :nome")
    public Usuario findByNome(String nome);

    @Query("SELECT * FROM usuario WHERE login = :login LIMIT 1")
    public Usuario findByLogin(String login);

    @Query("Select * from usuario where login = :login and senha = :senha limit 1")
    public Usuario findByLoginAndSenha(String login,String senha);

    @Insert
    public void insertUsuarios(Usuario ... usuarios);
    @Update
    public void updateUsuarios(Usuario ... usuarios);
    @Delete
    public void deleteUsuarios(Usuario ... usuarios);

}
