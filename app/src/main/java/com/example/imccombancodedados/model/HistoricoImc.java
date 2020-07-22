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
    @ColumnInfo(name = "situacao")
    private String situacao;

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
        if(imc< 18.5){
            setSituacao("A baixo do peso");
        }else if(imc>=18.5 && imc<25){
            setSituacao("Peso normal");
        }else if(imc>=25 && imc<30){
            setSituacao("SobrePeso");
        }else if(imc>=30 && imc<35){
            setSituacao("Obesidade de grau 1");
        }else if(imc>=35 && imc < 40){
            setSituacao("Obesidade de grau 2");
        }else{
            setSituacao("Obesidade de grau 3");
        }
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


    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "altura: " + altura +
                " peso: " + peso +
                " imc:" + String.format("%.2f", imc);
    }
}
