package com.example.imccombancodedados;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imccombancodedados.database.AppDataBase;
import com.example.imccombancodedados.model.Usuario;

public class CadastroActivity extends AppCompatActivity {
    private AppDataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        db = Room.databaseBuilder(this,AppDataBase.class,"app_imc").allowMainThreadQueries().build();
    }
    public void onClickCadastro (View v){
        EditText editlogin = findViewById(R.id.editLogin);
        EditText editSenha = findViewById(R.id.editSenha);
        EditText editNome = findViewById(R.id.editNome);

        String login = editlogin.getText().toString();
        String senha = editSenha.getText().toString();
        String nome = editNome.getText().toString();
        if(login.equals("")||senha.equals("") || nome.equals("")){
            Toast.makeText(this, "Para fazer o cadastro é nescessario que voce preencha todos os dados", Toast.LENGTH_SHORT).show();
        }else{
            Usuario u = db.usuarioDAO().findByLogin(login);
            if(u !=null ){
                Toast.makeText(this, "Esse nome de login ja esta cadastrado, por favor tente outro", Toast.LENGTH_SHORT).show();
            }else{
                try {
                    Usuario usuario = new Usuario(nome,login,senha);
                    db.usuarioDAO().insertUsuarios(usuario);
                    Toast.makeText(this, usuario.toString(), Toast.LENGTH_SHORT).show();
                    finish();
                }catch (Exception e){
                    Toast.makeText(this, "Ocorreu um erro inesperado, por favor tente novamente", Toast.LENGTH_SHORT).show();
                }

            }

        }
    }
}
