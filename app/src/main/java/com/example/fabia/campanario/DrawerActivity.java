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
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.fabia.campanario.Fragments.DirectoryFragment;
import com.example.fabia.campanario.Fragments.EventsFragment;
import com.example.fabia.campanario.Fragments.OffersFragment;
import com.example.fabia.campanario.Fragments.PQRFragment;
import com.example.fabia.campanario.Fragments.StoreFragment;
import com.example.fabia.campanario.Helpers.DataBase;
import com.orm.SugarContext;

public class DrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    String url2="https://campanariopopayan.com/";


    private FragmentManager fragmentManager;
    private  DrawerLayout drawer;
    private DataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
       // dataBase=DataBase.getInstance(this);

       drawer=(DrawerLayout)findViewById(R.id.drawer);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_);
        final NavigationView navigation=(NavigationView)findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);
        final ActionBarDrawerToggle toogle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.abierto,R.string.cerrado);
        drawer.addDrawerListener(toogle);
        toogle.syncState();
        navigation.setNavigationItemSelectedListener(this);

        fragmentManager=getSupportFragmentManager();

        WebView web = (WebView) findViewById(R.id.webcampanario);
        WebSettings settings= web.getSettings();
        settings.setJavaScriptEnabled(true);
        web.loadUrl(url2);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Toast toast=null;
        Fragment fragment;
        Bundle bundle;
        switch (item.getItemId()){
            case R.id.item_accessories:
                bundle = new Bundle();
                bundle.putInt( "category",R.id.item_accessories);
                fragment=new StoreFragment();
                fragment.setArguments(bundle);
                replaceFragmentContent(fragment);
                break;
            case R.id.item_entertainment:
                bundle = new Bundle();
                bundle.putInt( "category",R.id.item_entertainment);
                fragment=new StoreFragment();
                fragment.setArguments(bundle);
                replaceFragmentContent(fragment);

                break;
            case R.id.item_fashion:
                 bundle = new Bundle();
                bundle.putInt( "category",R.id.item_fashion);
                fragment=new StoreFragment();
                fragment.setArguments(bundle);
                replaceFragmentContent(fragment);

                break;
            case R.id.item_hypermarket:
                bundle = new Bundle();
                bundle.putInt( "category",R.id.item_hypermarket);
                fragment=new StoreFragment();
                fragment.setArguments(bundle);
                replaceFragmentContent(fragment);

                break;
            case R.id.item_home_technology:
                 bundle = new Bundle();
                bundle.putInt( "category",R.id.item_home_technology);
                fragment=new StoreFragment();
                fragment.setArguments(bundle);
                replaceFragmentContent(fragment);

                break;
            case R.id.item_others:
                bundle = new Bundle();
                bundle.putInt( "category",R.id.item_others);
                fragment=new StoreFragment();
                fragment.setArguments(bundle);
                replaceFragmentContent(fragment);
                break;

            case R.id.item_events:
                 fragment=new EventsFragment();
                replaceFragmentContent(fragment);


                break;
            case R.id.item_food_drink:
                 bundle = new Bundle();
                bundle.putInt( "category",R.id.item_food_drink);
                fragment=new StoreFragment();
                fragment.setArguments(bundle);
                replaceFragmentContent(fragment);
                break;
            case R.id.item_offers:
                 fragment=new OffersFragment();
                replaceFragmentContent(fragment);


                break;
            case R.id.item_directory:
                fragment=new DirectoryFragment();
                replaceFragmentContent(fragment);

                break;
            case R.id.item_pqrs:
                fragment=new PQRFragment();
                replaceFragmentContent(fragment);

                break;
            default:
                toast=Toast.makeText(this,"defecto",Toast.LENGTH_SHORT);
                break;

        }
        if(toast!=null){
            toast.show();
        }
        drawer.closeDrawers();

        return true;
    }

    public void replaceFragmentContent(Fragment fragment){
        FragmentTransaction transation=fragmentManager.beginTransaction();
        transation.replace(R.id.layoutContent,fragment);
        transation.commit();
    }
}
