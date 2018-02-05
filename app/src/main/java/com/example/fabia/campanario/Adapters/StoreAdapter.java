package com.example.fabia.campanario.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fabia.campanario.Models.Store;
import com.example.fabia.campanario.R;
import com.example.fabia.campanario.ViewHolders.ViewStoreHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by fabia on 3/11/2017.
 */

public class StoreAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<Store> listStore;

    public StoreAdapter(Activity activity, ArrayList<Store> listStore) {
        this.activity = activity;
        this.listStore = listStore;

    }

    @Override
    public int getCount() {
        return listStore.size();
    }

    @Override
    public Object getItem(int i) {
        return listStore.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewResult=view;
        ViewStoreHolder viewStoreHolder;
        if(viewResult==null){
            LayoutInflater layoutInflater=this.activity.getLayoutInflater();
            viewResult=layoutInflater.inflate(R.layout.item_store,null);
            viewStoreHolder= new ViewStoreHolder();
            viewStoreHolder.img_store=(ImageView)viewResult.findViewById(R.id.img_store);
            viewStoreHolder.txt_store_name=(TextView) viewResult.findViewById(R.id.txt_store_name);
           /* viewStoreHolder.txt_store_ubication=(TextView) viewResult.findViewById(R.id.txt_store_ubication);
            viewStoreHolder.txt_store_numberTelephone=(TextView) viewResult.findViewById(R.id.txt_store_numberTelephone);*/
            viewResult.setTag(viewStoreHolder);
        }else{
            viewStoreHolder=(ViewStoreHolder)viewResult.getTag();
        }
        Store tempStore=listStore.get(i);
        viewStoreHolder.txt_store_name.setText(tempStore.getName());

        if(tempStore.getUrlLogo()!=null){
            Picasso.with(this.activity).load(tempStore.getUrlLogo()).into(viewStoreHolder.img_store);
        }else{
            Picasso.with(this.activity).load(R.drawable.img_store_default).into(viewStoreHolder.img_store);
        }
        viewStoreHolder.txt_store_ubication.setText(tempStore.getUbication());
        viewStoreHolder.txt_store_numberTelephone.setText(tempStore.getNumberTelephone());


        return viewResult;
    }
}
