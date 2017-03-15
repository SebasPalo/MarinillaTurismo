package com.sebaspalo.marinillaturismo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    EditText eRUsuario, eRPassword,eRRepPassword,eCorreo;
    Button bRegistrarse,bCancelar;
    //String usuario, password, correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eRUsuario= (EditText) findViewById(R.id.eRUsuario);
        eRPassword= (EditText) findViewById(R.id.eRPassword);
        eRRepPassword= (EditText) findViewById(R.id.eRRepPassword);
        eCorreo= (EditText) findViewById(R.id.eCorreo);
        bRegistrarse= (Button) findViewById(R.id.bRegistrarse);
        bCancelar= (Button) findViewById(R.id.bCancelar);

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });


        bRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (eRUsuario.getText().toString().equals("")||eRPassword.getText().toString().equals("")||eRRepPassword.getText().toString().equals("")|| eCorreo.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Llene todos los campos",Toast.LENGTH_SHORT).show();
                }
                else if (!eRPassword.getText().toString().equals(eRRepPassword.getText().toString())){
                    //Toast.makeText(getApplicationContext(),"@string/PasswNoEqual",Toast.LENGTH_SHORT).show();
                    AlertDialog alertDialog = new AlertDialog.Builder(RegistroActivity.this).create();
                    alertDialog.setTitle("Error!");
                    alertDialog.setMessage("Las contraseñas no coinciden");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                else {
                    //debo validar q todos los campos esten llenos,q las dos contaseñas sean iguales
                    Intent intent = new Intent();//Aqui le voy a responder a alguien.   Como estoy respondiendo se quien me llamo. creo intent:donde estoy,hacia donde voy
                    intent.putExtra("username", eRUsuario.getText().toString());//informacion q voy a mandar
                    intent.putExtra("password", eRPassword.getText().toString());
                    intent.putExtra("correo", eCorreo.getText().toString());
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.RegistroconExito),Toast.LENGTH_SHORT).show();
                    setResult(RESULT_OK, intent); //Como estoy respondiendo se quien me llamo
                    finish();//mata actividad
                }
                //en caso contrario, se debe mostrar mensajes o notificaciones tipo TOAST
            }
        });

    }

}
