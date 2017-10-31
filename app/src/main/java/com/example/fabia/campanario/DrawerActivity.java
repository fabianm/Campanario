package com.example.fabia.campanario;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.fabia.campanario.Fragments.EventsFragment;

public class DrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        final DrawerLayout drawer=(DrawerLayout)findViewById(R.id.drawer);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_);
        final NavigationView navigation=(NavigationView)findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);
        final ActionBarDrawerToggle toogle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.abierto,R.string.cerrado);
        drawer.addDrawerListener(toogle);
        toogle.syncState();
        navigation.setNavigationItemSelectedListener(this);

        fragmentManager=getSupportFragmentManager();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Toast toast=null;
        switch (item.getItemId()){
            case R.id.item_accessories:
                toast=Toast.makeText(this,"accesorios",Toast.LENGTH_SHORT);
                break;
            case R.id.item_entertainment:
                toast=Toast.makeText(this,"entretenimiento",Toast.LENGTH_SHORT);

                break;
            case R.id.item_fashion:
                toast=Toast.makeText(this,"fashion",Toast.LENGTH_SHORT);

                break;
            case R.id.item_hypermarket:
                toast=Toast.makeText(this,"hipermercado",Toast.LENGTH_SHORT);

                break;
            case R.id.item_home_technology:
                toast=Toast.makeText(this,"home- tecnologia",Toast.LENGTH_SHORT);

                break;
            case R.id.item_events:
                toast=Toast.makeText(this,"home- tecnologia",Toast.LENGTH_SHORT);
                Fragment fragmentEvent=new EventsFragment();
                replaceFragmentContent(fragmentEvent);


                break;
            default:
                toast=Toast.makeText(this,"defecto",Toast.LENGTH_SHORT);
                break;

        }
        if(toast!=null){
            toast.show();
        }

        return true;
    }

    public void replaceFragmentContent(Fragment fragment){
        FragmentTransaction transation=fragmentManager.beginTransaction();
        transation.replace(R.id.layoutContent,fragment);
        transation.commit();
    }
}
