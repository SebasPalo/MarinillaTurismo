package com.sebaspalo.marinillaturismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.sebaspalo.marinillaturismo.R.drawable.avatar;
import static com.sebaspalo.marinillaturismo.R.drawable.avatar2;
import static com.sebaspalo.marinillaturismo.R.drawable.avatar3;
import static com.sebaspalo.marinillaturismo.R.drawable.avatar4;
import static com.sebaspalo.marinillaturismo.R.id.mPerfil;

public class PerfilActivity extends AppCompatActivity {

    TextView tUsername,tEmail;
    Button bAvatar;
    String username, correo;
    int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        tUsername = (TextView) findViewById(R.id.tUsername);
        tEmail=(TextView) findViewById(R.id.tEmail);
        bAvatar=(Button) findViewById(R.id.bAvatar);

        Bundle extras= getIntent().getExtras();
        username = extras.getString("username");
        correo= extras.getString("correo");
        tUsername.setText(username);
        tEmail.setText(extras.getString("correo"));

bAvatar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {flag=flag+1;
        if (flag==1) bAvatar.setBackgroundResource(avatar2);
        else if (flag==2) bAvatar.setBackgroundResource(avatar3);
        else if (flag==3) bAvatar.setBackgroundResource(avatar4);
        else {bAvatar.setBackgroundResource(avatar); flag=0;}
    }
});

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuperfil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        switch (id){
            case R.id.mLogOut:
                Intent intent = new Intent(PerfilActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.mPrincipal:
                /*Intent intent2 = new Intent(PerfilActivity.this, MainActivity.class);
                intent2.putExtra("username", username);
                intent2.putExtra("correo", correo);
                startActivity(intent2);*/
                finish();
                break;


        }
        return true;
    }

    /*   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }*/


 /*   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.mPrincipal:
                Intent intent2 = new Intent(PerfilActivity.this, MainActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.mLogOut:
                Intent intent = new Intent(PerfilActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return true;
    }*/
}
