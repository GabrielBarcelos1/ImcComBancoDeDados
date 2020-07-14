package com.example.imccombancodedados;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imccombancodedados.database.AppDataBase;
import com.example.imccombancodedados.model.HistoricoImc;

public class ImcActivity extends AppCompatActivity {
    private AppDataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        db = Room.databaseBuilder(this,AppDataBase.class,"app_imc").allowMainThreadQueries().build();
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
             try {
                 db.historicoImcDAO().findByLogin();
                 db.historicoImcDAO().insertHistoricoImc(historicoImc);
             }catch (Exception e){
                 Toast.makeText(this, "Erro inesperado, tente novamente", Toast.LENGTH_SHORT).show();
             }
            Toast.makeText(this, historicoImc.toString(), Toast.LENGTH_SHORT).show();
        }

    }
}
