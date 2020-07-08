package com.example.imccombancodedados.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "historicoImc")
public class HistoricoImc {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private long idHistoricoImc;

    @NonNull
    @ColumnInfo(name = "altura")
    private double altura;

    @NonNull
    @ColumnInfo(name = "peso")
    private double peso;

    @NonNull
    @ColumnInfo(name = "imc")
    private double imc;

    public HistoricoImc(double altura, double peso) {
        this.altura = altura;
        this.peso = peso;
        double imc = peso/(altura*altura);
        this.setImc(imc);
    }

    public long getIdHistoricoImc() {
        return idHistoricoImc;
    }

    public void setIdHistoricoImc(long idHistoricoImc) {
        this.idHistoricoImc = idHistoricoImc;
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


    @Override
    public String toString() {
        return "HistoricoImc{" +
                "idHistoricoImc=" + idHistoricoImc +
                ", altura=" + altura +
                ", peso=" + peso +
                ", imc=" + imc +
                '}';
    }
}
