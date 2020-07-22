package com.example.imccombancodedados.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.imccombancodedados.ImcActivity;
import com.example.imccombancodedados.MainActivity;
import com.example.imccombancodedados.R;
import com.example.imccombancodedados.database.AppDataBase;

import java.util.List;

public class HistoricoActivity extends AppCompatActivity {
     private AppDataBase db;
     private long id;
     private List<HistoricoImc> imcs;
     private ArrayAdapter<HistoricoImc> adapter;
     private ListView lvImc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);
        db = Room.databaseBuilder(this, AppDataBase.class,"app_imc").allowMainThreadQueries().build();
        Intent intent = getIntent();
        id = intent.getLongExtra(ImcActivity.EXTRA_TEXT_ID, 1);
        imcs = db.historicoImcDAO().findImc(id);
        adapter = new ArrayAdapter<HistoricoImc>(this,R.layout.support_simple_spinner_dropdown_item, imcs);
        lvImc = findViewById(R.id.listImc);
        lvImc.setAdapter(adapter);



    }

}
