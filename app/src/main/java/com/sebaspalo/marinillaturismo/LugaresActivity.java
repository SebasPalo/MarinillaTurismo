package com.sebaspalo.marinillaturismo;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import android.content.Intent;

import static android.R.attr.data;
import static com.sebaspalo.marinillaturismo.R.id.toolbar;

public class LugaresActivity extends AppCompatActivity {


    String username, correo;
    String NombreTab1, NombreTab2, NombreTab3, titulo;

    Fragment tab1Fragm;
    Fragment tab2Fragm;
    Fragment tab3Fragm;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        Bundle extras =getIntent().getExtras();
        titulo= extras.getString("titulo");
        username = extras.getString("username");
        correo= extras.getString("correo");

        SetVariables(titulo);



        SectionsPagerAdapter mSectionsPagerAdapter;

        /**
         * The {@link ViewPager} that will host the section contents.
         */
        ViewPager mViewPager;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(titulo);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id= item.getItemId();
        switch (id){
            case R.id.mPerfil:
                Intent intent =new Intent(LugaresActivity.this, PerfilActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                finish();
                break;
            case R.id.mBares: titulo="Bares";
                Intent intent1 = new Intent(LugaresActivity.this, LugaresActivity.class);
                intent1.putExtra("titulo", titulo);
                intent1.putExtra("username", username);
                intent1.putExtra("correo", correo);
                startActivity(intent1);
                finish();
                break;
            case R.id.mRestaurantes: titulo="Restaurantes";
                Intent intent2 = new Intent(LugaresActivity.this, LugaresActivity.class);
                intent2.putExtra("titulo", titulo);
                intent2.putExtra("username", username);
                intent2.putExtra("correo", correo);
                startActivity(intent2);
                finish();
                break;
            case R.id.mHoteles: titulo="Hoteles";
                Intent intent3 = new Intent(LugaresActivity.this, LugaresActivity.class);
                intent3.putExtra("titulo", titulo);
                intent3.putExtra("username", username);
                intent3.putExtra("correo", correo);
                startActivity(intent3);
                finish();
                break;
            case R.id.mLogOut:
                Intent intent5 = new Intent(LugaresActivity.this, LoginActivity.class);
                startActivity(intent5);
                finish();
                break;






        }
        return true;}

    public class PagerAdapter extends FragmentPagerAdapter{

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }
    }





    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
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
                    return tab1Fragm;
                case 1:
                    return tab2Fragm;
                        /*HotelUnoFragment tab2 = new HotelUnoFragment();
                        return tab2;*/
                case 2:
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
    }

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

    @Override
    public void onBackPressed() {
        Intent intent =new Intent(LugaresActivity.this, MainActivity.class);
        intent.putExtra("username", username);
        intent.putExtra("correo", correo);
        startActivity(intent);
        finish();
    }
}