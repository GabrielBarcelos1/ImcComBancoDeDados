package com.example.imccombancodedados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imccombancodedados.model.HistoricoImc;

public class ImcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
    }
    public void onClickCalcularImc(View v){
        EditText editPeso = findViewById(R.id.editPeso);
        EditText editAltura = findViewById(R.id.editAltura);
        TextView viewImc = findViewById(R.id.textImc);

        double peso = 0;
        double altura = 0;

        if(editPeso.getText().toString().equals("")|| editAltura.getText().toString().equals("")){
            Toast.makeText(this, "Voce precisa preencher todos os campos para calcaularmos o seu imc", Toast.LENGTH_SHORT).show();
        }else{
             peso = Double.parseDouble(editPeso.getText().toString());
             altura = Double.parseDouble(editAltura.getText().toString());
             HistoricoImc historicoImc = new HistoricoImc(altura,peso);
             viewImc.setText("O seu imc é de:"+ historicoImc.getImc());

            Toast.makeText(this, historicoImc.toString(), Toast.LENGTH_SHORT).show();
        }

    }
}