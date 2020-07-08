package com.example.imccombancodedados.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "usuario")
//        ,foreignKeys = @ForeignKey(entity = HistoricoImc.class,
//        parentColumns = "idHistorico",
//        childColumns = "id",
//        onDelete = ForeignKey.NO_ACTION))
public class Usuario {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private long id;

    @NonNull
    @ColumnInfo(name = "nome")
    private String nome;

    @NonNull
    @ColumnInfo(name = "login")
    private String login;

    @NonNull
    @ColumnInfo(name = "senha")
    private String senha;

    public long getId() {
        return id;
    }

    public Usuario(@NonNull String nome, @NonNull String login, @NonNull String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    @NonNull
    public String getLogin() {
        return login;
    }

    public void setLogin(@NonNull String login) {
        this.login = login;
    }

    @NonNull
    public String getSenha() {
        return senha;
    }

    public void setSenha(@NonNull String senha) {
        this.senha = senha;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
