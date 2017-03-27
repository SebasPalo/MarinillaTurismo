package com.sebaspalo.marinillaturismo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainDActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String username, correo, titulo;
    TextView navUsername,navcorreo;

    private Lista_Entrada[] datos = new Lista_Entrada[] {
            new Lista_Entrada(R.drawable.hoteluno2, "Hotel Kasakir", "Mejores precios", "Carrera 30 # 28 58"),
            new Lista_Entrada(R.drawable.hoteldos2, "Hotel Megacielo", "Gran Comfort", "Cl 22 Carrera 44-174"),
            new Lista_Entrada(R.drawable.hoteltres2, "Hotel Villacolonia", "Atencion Especial", "Autopista Medellín-Bogotá, Km 39"),
            new Lista_Entrada(R.drawable.hotel1, "Grandes ofertas", "50% off", "Hoteles")};

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_d);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras =getIntent().getExtras();
        username = extras.getString("username");
        correo= extras.getString("correo");

        /*TextView textNombre=(TextView)findViewById(R.id.text2Nombre);
        textNombre.setText(username);
        TextView textCorreo=(TextView)findViewById(R.id.text2Correo);
        textCorreo.setText(correo);*/

        list = (ListView) findViewById(R.id.list);
        Adapter adapter = new Adapter(this, datos);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = ( (Lista_Entrada)parent.getItemAtPosition(position)).getNombre();
                Toast.makeText(getApplicationContext(), data,Toast.LENGTH_SHORT).show();


                if (data=="Grandes ofertas"){
                    Intent intent1 = new Intent(MainDActivity.this, MainActivity.class);
                    intent1.putExtra("username", username);
                    intent1.putExtra("correo", correo);
                    startActivity(intent1);
                }
                else {titulo="Hoteles";
                    Intent intent3 = new Intent(MainDActivity.this, HotelDActivity.class);
                    intent3.putExtra("titulo", titulo);
                    intent3.putExtra("username", username);
                    intent3.putExtra("correo", correo);
                    startActivity(intent3);
                    finish();

                }

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
        navUsername = (TextView) headerView.findViewById(R.id.text2Nombre);
        navUsername.setText(username);

        navcorreo= (TextView) headerView.findViewById(R.id.text2Correo);
        navcorreo.setText(correo);
    }


    class Adapter extends ArrayAdapter<Lista_Entrada> {

        public Adapter(@NonNull Context context, Lista_Entrada[] datos) {
            super(context, R.layout.list_item, datos);
        }

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_item, null);

            TextView nombre = (TextView) item.findViewById(R.id.tNombre);
            nombre.setText(datos[position].getNombre());

            TextView descrip = (TextView) item.findViewById(R.id.tDescrip);
            descrip.setText(datos[position].getDescrip());

            TextView direc = (TextView) item.findViewById(R.id.tDirec);
            direc.setText(datos[position].getDirec());

            ImageView imagen = (ImageView) item.findViewById(R.id.iFoto);
            imagen.setImageResource(datos[position].getIdImagen());
            return item;
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent =new Intent(MainDActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_d, menu);
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

         if (id == R.id.md2Hoteles) {titulo="Hoteles";
            Intent intent3 = new Intent(MainDActivity.this, HotelDActivity.class);
            intent3.putExtra("titulo", titulo);
            intent3.putExtra("username", username);
            intent3.putExtra("correo", correo);
            startActivity(intent3);
            finish();

        } else if (id == R.id.md2Restaurantes) {titulo="Restaurantes";
            Intent intent2 = new Intent(MainDActivity.this, HotelDActivity.class);
            intent2.putExtra("titulo", titulo);
            intent2.putExtra("username", username);
            intent2.putExtra("correo", correo);
            startActivity(intent2);
            finish();

        } else if (id == R.id.md2Bares) {titulo="Bares";
            Intent intent1 = new Intent(MainDActivity.this, HotelDActivity.class);
            intent1.putExtra("titulo", titulo);
            intent1.putExtra("username", username);
            intent1.putExtra("correo", correo);
            startActivity(intent1);
            finish();

        } else if (id == R.id.md2Perfil) {
            Intent intent =new Intent(MainDActivity.this, PerfilDActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.md2Logout) {
            Intent intent5 = new Intent(MainDActivity.this, LoginActivity.class);
            startActivity(intent5);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
