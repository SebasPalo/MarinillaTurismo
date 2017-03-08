package com.sebaspalo.marinillaturismo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DemodosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demodos);

        FragmentManager fm =getFragmentManager();//si presenta error revisar las librerias de compatibilidad
        FragmentTransaction ft =fm.beginTransaction();

        HotelUnoFragment fragment= new HotelUnoFragment();
        ft.add(android.R.id.content, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu2) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        FragmentManager fm =getFragmentManager();
        FragmentTransaction ft =fm.beginTransaction();

        switch (id){
            case R.id.mHotel1:HotelUnoFragment fragment1= new HotelUnoFragment();
                ft.replace(android.R.id.content,fragment1);
                break;
            case R.id.mHotel2:HotelDosFragment fragment2= new HotelDosFragment();
                ft.replace(android.R.id.content,fragment2);
                break;
        }
        return true;
    }
}
