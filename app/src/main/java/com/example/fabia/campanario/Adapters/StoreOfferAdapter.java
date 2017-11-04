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
import com.example.fabia.campanario.ViewHolders.ViewStoreOfferHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by fabia on 4/11/2017.
 */

public class StoreOfferAdapter extends BaseAdapter {
private Activity activity;
private ArrayList<Store> listStore;

public StoreOfferAdapter(Activity activity, ArrayList<Store> listStore) {
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
        ViewStoreOfferHolder viewStoreHolder;
        if(viewResult==null){
                LayoutInflater layoutInflater=this.activity.getLayoutInflater();
                viewResult=layoutInflater.inflate(R.layout.item_store_offer,null);
                viewStoreHolder= new ViewStoreOfferHolder();
                viewStoreHolder.img_store_offer=(ImageView)viewResult.findViewById(R.id.img_store_offer);
                viewStoreHolder.txt_nameStore_offer=(TextView) viewResult.findViewById(R.id.txt_nameStore_offer);
                viewResult.setTag(viewStoreHolder);
        }else{
        viewStoreHolder=(ViewStoreOfferHolder)viewResult.getTag();
        }
        Store tempStore=listStore.get(i);
        viewStoreHolder.txt_nameStore_offer.setText(tempStore.getName());

        if(tempStore.getUrlLogo()!=null && !tempStore.getUrlLogo().isEmpty()){
            Picasso.with(this.activity).load(tempStore.getUrlLogo()).into(viewStoreHolder.img_store_offer);
        }else{
            Picasso.with(this.activity).load(R.drawable.img_store_default).into(viewStoreHolder.img_store_offer);
        }



        return viewResult;
  }
}

