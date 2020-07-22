package com.example.imccombancodedados;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imccombancodedados.database.AppDataBase;
import com.example.imccombancodedados.model.HistoricoActivity;
import com.example.imccombancodedados.model.HistoricoImc;

public class ImcActivity extends AppCompatActivity {
    private AppDataBase db;
    private long id;
    public static final String EXTRA_TEXT_ID = "com.example.imccombancodedados.EXTRA_TEXT_ID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        db = Room.databaseBuilder(this,AppDataBase.class,"app_imc").allowMainThreadQueries().build();
        Intent intent = getIntent();
        id = intent.getLongExtra(MainActivity.EXTRA_TEXT_ID, 1);
    }
    public void onClickCalcularImc(View v){
        EditText editPeso = findViewById(R.id.editPeso);
        EditText editAltura = findViewById(R.id.editAltura);
        TextView viewImc = findViewById(R.id.textImc);
        TextView viewSituacao = findViewById(R.id.textSituacao);

        double peso = 0;
        double altura = 0;

        if(editPeso.getText().toString().equals("")|| editAltura.getText().toString().equals("")){
            Toast.makeText(this, "Voce precisa preencher todos os campos para calcaularmos o seu imc", Toast.LENGTH_SHORT).show();
        }else{

             peso = Double.parseDouble(editPeso.getText().toString());
             altura = Double.parseDouble(editAltura.getText().toString());
             HistoricoImc historicoImc = new HistoricoImc(altura,peso);

             historicoImc.setUsuarioId(id);
             viewImc.setText("O seu imc é de: "+String.format("%.2f", historicoImc.getImc()) );
             viewSituacao.setText("Voce esta em : " + historicoImc.getSituacao());
             try {
                 db.historicoImcDAO().insertHistoricoImc(historicoImc);
             }catch (Exception e){
                 Toast.makeText(this, "Erro inesperado, tente novamente", Toast.LENGTH_SHORT).show();
             }
        }

    }
    public void onClickHistoricoImc(View v){
        Intent iHistorico = new Intent(this, HistoricoActivity.class);
        iHistorico.putExtra(EXTRA_TEXT_ID,id);
        startActivity(iHistorico);

    }
}
