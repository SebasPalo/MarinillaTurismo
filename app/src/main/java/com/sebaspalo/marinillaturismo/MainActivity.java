package com.sebaspalo.marinillaturismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import static com.sebaspalo.marinillaturismo.R.string.username;

public class MainActivity extends AppCompatActivity {

    String username, correo, titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras =getIntent().getExtras();
        username = extras.getString("username");
        correo= extras.getString("correo");


    }


/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//Creo el menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        switch (id){
            case R.id.mPerfil:
                Intent intent =new Intent(MainActivity.this, PerfilActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mBares:titulo="Bares";
                Intent intent2 = new Intent(MainActivity.this, HotelDActivity.class);
                intent2.putExtra("titulo", titulo);
                intent2.putExtra("username", username);
                intent2.putExtra("correo", correo);
                startActivity(intent2);
                finish();
                break;
            case R.id.mRestaurantes:titulo="Restaurantes";
                Intent intent3 = new Intent(MainActivity.this, HotelDActivity.class);
                intent3.putExtra("titulo", titulo);
                intent3.putExtra("username", username);
                intent3.putExtra("correo", correo);
                startActivity(intent3);
                finish();
                break;
            case R.id.mHoteles:titulo="Hoteles";
                Intent intent4 = new Intent(MainActivity.this, HotelDActivity.class);
                intent4.putExtra("titulo", titulo);
                intent4.putExtra("username", username);
                intent4.putExtra("correo", correo);
                startActivity(intent4);
                finish();
                break;
            case R.id.mLogOut:
                Intent intent5 = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent5);
                finish();
                break;






        }
        return true;
        //return super.onOptionsItemSelected(item);
    }
*/

 /*  @Override
    public void onBackPressed() {
        Intent intent =new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }*/
}


