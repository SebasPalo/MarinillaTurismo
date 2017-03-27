package com.sebaspalo.marinillaturismo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class HotelDActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String username, correo;
    String NombreTab1, NombreTab2, NombreTab3, titulo;
    TextView navUsername,navcorreo;

    Fragment tab1Fragm;
    Fragment tab2Fragm;
    Fragment tab3Fragm;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_d);

        Bundle extras =getIntent().getExtras();
        titulo= extras.getString("titulo");
        username = extras.getString("username");
        correo= extras.getString("correo");


        SetVariables(titulo);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());  //le doy la autoridad de q maneje los fragmentos
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);  //viewpage conectado al adaptador

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);  //viewpag conectado al tap


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        navUsername = (TextView) headerView.findViewById(R.id.textNombre);
        navUsername.setText(username);

        navcorreo= (TextView) headerView.findViewById(R.id.textCorreo);
        navcorreo.setText(correo);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent =new Intent(HotelDActivity.this, MainDActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hotel_d, menu);
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

        if (id == R.id.mdPrincipal) {
            Intent intent =new Intent(HotelDActivity.this, MainDActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();

            // Handle the camera action
        } else if (id == R.id.mdHoteles) {titulo="Hoteles";
            Intent intent3 = new Intent(HotelDActivity.this, HotelDActivity.class);
            intent3.putExtra("titulo", titulo);
            intent3.putExtra("username", username);
            intent3.putExtra("correo", correo);
            startActivity(intent3);
            finish();

        } else if (id == R.id.mdRestaurantes) {titulo="Restaurantes";
            Intent intent2 = new Intent(HotelDActivity.this, HotelDActivity.class);
            intent2.putExtra("titulo", titulo);
            intent2.putExtra("username", username);
            intent2.putExtra("correo", correo);
            startActivity(intent2);
            finish();

        } else if (id == R.id.mdBares) {titulo="Bares";
            Intent intent1 = new Intent(HotelDActivity.this, HotelDActivity.class);
            intent1.putExtra("titulo", titulo);
            intent1.putExtra("username", username);
            intent1.putExtra("correo", correo);
            startActivity(intent1);
            finish();

        } else if (id == R.id.mdPerfil) {
            Intent intent =new Intent(HotelDActivity.this, PerfilDActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();

        } else if (id == R.id.mdLogout) {
            Intent intent5 = new Intent(HotelDActivity.this, LoginActivity.class);
            startActivity(intent5);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
                switch (position) {
                    case 0:
                        //HotelUnoFragment tab1 = new HotelUnoFragment();

                        //return tab1;
                        return tab1Fragm;
                    case 1:
                        return tab2Fragm;
                        //HotelDosFragment tab2 = new HotelDosFragment();
                        //return tab2;
                    case 2:
                        //HotelTresFragment tab3 = new HotelTresFragment();
                        //return tab3;
                        return tab3Fragm;
                    default:
                        return null;
                }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return NombreTab1;
                case 1:
                    return NombreTab2;
                case 2:
                    return NombreTab3;
            }
            return null;
        }
    }  //esto tiene el adaptador

    void SetVariables (String titulo){
        if (titulo.equals("Hoteles")){
            NombreTab1=getResources().getString(R.string.Hotel1);
            NombreTab2=getResources().getString(R.string.Hotel2);
            NombreTab3=getResources().getString(R.string.Hotel3);
            titulo= getResources().getString(R.string.TituloHoteles);

            tab1Fragm = new HotelUnoFragment();
            tab2Fragm = new HotelDosFragment();
            tab3Fragm = new HotelTresFragment();
        }
        else if (titulo.equals("Bares")){
            NombreTab1=getResources().getString(R.string.Bar1);
            NombreTab2=getResources().getString(R.string.Bar2);
            NombreTab3=getResources().getString(R.string.Bar3);
            titulo= getResources().getString(R.string.Titulobares);
            tab1Fragm = new BarUnoFragment();
            tab2Fragm = new BarDosFragment();
            tab3Fragm = new BarTresFragment();
        }
        else if (titulo.equals("Restaurantes")){
            NombreTab1=getResources().getString(R.string.Restaurante1);
            NombreTab2=getResources().getString(R.string.Restaurante2);
            NombreTab3=getResources().getString(R.string.Restaurante3);
            titulo= getResources().getString(R.string.TituloRestaurante);
            tab1Fragm = new RestauranteUnoFragment();
            tab2Fragm = new RestauranteDosFragment();
            tab3Fragm = new RestauranteTresFragment();
        }

    }
}
