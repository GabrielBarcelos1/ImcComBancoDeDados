package com.example.imccombancodedados.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "historicoImc"
        ,foreignKeys = @ForeignKey(entity = Usuario.class,
        parentColumns = "id",
        childColumns = "usuarioid",
     onDelete = ForeignKey.CASCADE))
public class HistoricoImc {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private long id;

    @NonNull
    @ColumnInfo(name = "altura")
    private double altura;

    @NonNull
    @ColumnInfo(name = "peso")
    private double peso;

    @NonNull
    @ColumnInfo(name = "imc")
    private double imc;

    @NonNull
    @ColumnInfo(name = "usuarioid")
    private  long usuarioId;

    public HistoricoImc(double altura, double peso) {
        this.altura = altura;
        this.peso = peso;
        double imc = peso/(altura*altura);
        this.setImc(imc);
    }

    public long getId() {
        return id;
    }

    public void setId(long idHistoricoImc) {
        this.id= idHistoricoImc;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "HistoricoImc{" +
                "idHistoricoImc=" + id +
                ", altura=" + altura +
                ", peso=" + peso +
                ", imc=" + imc +
                '}';
    }
}
