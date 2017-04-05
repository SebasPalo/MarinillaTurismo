package com.sebaspalo.marinillaturismo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText eUsuario, ePassword;
    Button bIniciar;
    TextView tRegistrarse;
    String username, password, correo;


    SharedPreferences prefs;//creopreferenciascompartidas
    SharedPreferences.Editor editor;//el editor para lo anterior

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        prefs =getSharedPreferences("MisPreferencias",MODE_PRIVATE);
        editor = prefs.edit();

        eUsuario= (EditText) findViewById(R.id.eUsuario);
        ePassword= (EditText) findViewById(R.id.ePassword);
        bIniciar= (Button) findViewById(R.id.bIniciar);
        tRegistrarse= (TextView) findViewById(R.id.tRegistrarse);

        username = prefs.getString("username","noname");//cargo si habia algo en preferencias, le mando username si hay algo
        password = prefs.getString("password","nopass");
        correo = prefs.getString("correo","nocorreo");

       // Log.d("login",String.valueOf(prefs.getInt("login",-1)));//ver en consola
       // Log.d("nombre",prefs.getString("username","noname"));//ver variable username

        if (prefs.getInt("login",-1) == 1){//cargueme la pref login, si no hay nada, mandeme -1
            Intent intent = new Intent(LoginActivity.this, MainDActivity.class);//voy hacia el main activity
            intent.putExtra("username", username);//envio esto
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();//EmpiezoActividad
        }

        //username="p";
        //password="p";
        //correo="palosebas@gmail.com";


        /*Bundle extras =getIntent().getExtras();//bundle es como un objeto-cajon para meter informacion

        extras.getString("username");*/

        tRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                        startActivityForResult(intent,1234);//mando un codigo
            }
        });
        bIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validar que la contraseña y el usuario sean igual al recibido
                if (eUsuario.getText().toString().equals("")|| ePassword.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Llene los Campos",Toast.LENGTH_SHORT).show();
                }
                else if(eUsuario.getText().toString().equals(username) && ePassword.getText().toString().equals(password)){

                    editor.putInt("login",1);//1 para loggin  0 sin loguear
                    editor.commit();//las subo

                    Intent intent = new Intent(LoginActivity.this, MainDActivity.class);//voy hacia el main activity
                    intent.putExtra("username", username);//envio esto
                    intent.putExtra("correo", correo);
                    startActivity(intent);
                    finish();//EmpiezoActividad
                }
                else Toast.makeText(getApplicationContext(),"Usuario o Contraseña Incorrecta",Toast.LENGTH_SHORT).show();
            }
        });
    }

    //con ctrl+o "onActivityResult abro ese "metodo"
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {//aqui vuelvo despues de darle cancelar o registrarse
        if (requestCode==1234 && resultCode==RESULT_OK){ //
            username = data.getExtras().getString("username");
            password = data.getExtras().getString("password");
            correo =data.getExtras().getString("correo");

            editor.putString("username", username);//guardo en las preferencias
            editor.putString("password", password);
            editor.putString("correo", correo);
            //editor.commit();//las subo

            //Log.d("nombre",data.getExtras().getString("username") );//para hacer el seguimiento en consola de las variables
            // Toast.makeText(this, data.getExtras().getString("username"),Toast.LENGTH_SHORT).show();
        }
        if (requestCode == 1234 && resultCode==RESULT_CANCELED){
            Toast.makeText(this, "Registro Cancelado",Toast.LENGTH_SHORT).show();

        }

    }
/*
    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
        super.onBackPressed();
    }*/
}
