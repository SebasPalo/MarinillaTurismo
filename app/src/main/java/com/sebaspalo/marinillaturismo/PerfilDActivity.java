package com.sebaspalo.marinillaturismo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.sebaspalo.marinillaturismo.R.drawable.avatar;
import static com.sebaspalo.marinillaturismo.R.drawable.avatar2;
import static com.sebaspalo.marinillaturismo.R.drawable.avatar3;
import static com.sebaspalo.marinillaturismo.R.drawable.avatar4;

public class PerfilDActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView tUsername,tEmail,navUsername,navcorreo;
    Button bAvatar;
    String username, correo,titulo;
    int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_d);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        navUsername = (TextView) headerView.findViewById(R.id.text3Nombre);
        navUsername.setText(username);

        navcorreo= (TextView) headerView.findViewById(R.id.text3Correo);
        navcorreo.setText(correo);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent =new Intent(PerfilDActivity.this, MainDActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.perfil_d, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(),"Sin uso temporalmente",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.md3Principal) {
            Intent intent =new Intent(PerfilDActivity.this, MainDActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();

            // Handle the camera action
        } else if (id == R.id.md3Hoteles) {titulo="Hoteles";
            Intent intent3 = new Intent(PerfilDActivity.this, HotelDActivity.class);
            intent3.putExtra("titulo", titulo);
            intent3.putExtra("username", username);
            intent3.putExtra("correo", correo);
            startActivity(intent3);
            finish();

        } else if (id == R.id.md3Restaurantes) {titulo="Restaurantes";
            Intent intent2 = new Intent(PerfilDActivity.this, HotelDActivity.class);
            intent2.putExtra("titulo", titulo);
            intent2.putExtra("username", username);
            intent2.putExtra("correo", correo);
            startActivity(intent2);
            finish();

        } else if (id == R.id.md3Bares) {titulo="Bares";
            Intent intent1 = new Intent(PerfilDActivity.this, HotelDActivity.class);
            intent1.putExtra("titulo", titulo);
            intent1.putExtra("username", username);
            intent1.putExtra("correo", correo);
            startActivity(intent1);
            finish();

        }  else if (id == R.id.md3Logout) {
            Intent intent5 = new Intent(PerfilDActivity.this, LoginActivity.class);
            startActivity(intent5);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
