package com.example.imccombancodedados;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imccombancodedados.database.AppDataBase;
import com.example.imccombancodedados.model.Usuario;

public class MainActivity extends AppCompatActivity {
    private AppDataBase db;
    public static final String EXTRA_TEXT_ID = "com.example.imccombancodedados.EXTRA_TEXT_ID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(this, AppDataBase.class,"app_imc").allowMainThreadQueries().build();
    }
    public void onClickCadastro(View v){
        Intent iCadastro = new Intent(this, CadastroActivity.class);
        startActivity(iCadastro);
    }

    public void onClickLogar(View v){
        EditText editlogin = findViewById(R.id.editLogin);
        EditText editSenha = findViewById(R.id.editSenha);

        String login = editlogin.getText().toString();
        String senha = editSenha.getText().toString();
        long id;

        if(login.equals("")||senha.equals("")){
            Toast.makeText(this, "Login ou senha precisam estar preenchidos, tente novamente", Toast.LENGTH_SHORT).show();
        }else{
            Usuario u = db.usuarioDAO().findByLoginAndSenha(login, senha);
            if(u == null){
                Toast.makeText(this, "O usuario ou senha estão incorretos", Toast.LENGTH_SHORT).show();
            }else{
                id = db.usuarioDAO().findId(login);
                Intent iImc = new Intent(this, ImcActivity.class);
                iImc.putExtra(EXTRA_TEXT_ID,id);
                startActivity(iImc);
            }
        }
    }
}
