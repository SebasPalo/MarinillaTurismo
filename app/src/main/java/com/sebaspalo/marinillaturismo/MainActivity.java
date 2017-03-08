package com.sebaspalo.marinillaturismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import static com.sebaspalo.marinillaturismo.R.string.username;

public class MainActivity extends AppCompatActivity {

    String username, correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras =getIntent().getExtras();
        username = extras.getString("username");
        correo= extras.getString("correo");

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//Creo el menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        switch (id){
            case R.id.mPerfil:
                Intent intent =new Intent(MainActivity.this, PerfilActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                break;
            case R.id.mLogOut:
                Intent intent2 = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent2);
                finish();
                break;

        }
        return true;
        //return super.onOptionsItemSelected(item);
    }
}
