package com.example.fabia.campanario.Adapters;

import android.app.Activity;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fabia.campanario.Models.Offer;
import com.example.fabia.campanario.R;
import com.example.fabia.campanario.ViewOfferHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by fabia on 2/11/2017.
 */

public class OffersAdapter extends BaseAdapter {
    private Activity activity;
    private ArrayList<Offer> listOffer;
    public OffersAdapter(Activity activity, ArrayList<Offer> listOffer){
        this.listOffer=listOffer;
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return listOffer.size();
    }

    @Override
    public Object getItem(int i) {
        return listOffer.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewResult=view;
        ViewOfferHolder viewOfferHolder ;
        if(viewResult==null){
            LayoutInflater layoutInflater=this.activity.getLayoutInflater();
            viewResult=layoutInflater.inflate(R.layout.item_offer,null);
            viewOfferHolder=new ViewOfferHolder();
            viewOfferHolder.img_offer=(ImageView)viewResult.findViewById(R.id.img_offer);
            viewOfferHolder.txt_date_offer=(TextView)viewResult.findViewById(R.id.txt_date_offer);
            viewOfferHolder.txt_description_offer=(TextView)viewResult.findViewById(R.id.txt_description_offer);
            viewOfferHolder.txt_store_offer=(TextView)viewResult.findViewById(R.id.txt_store_offer);
            viewResult.setTag(viewOfferHolder);
        }else{
            viewOfferHolder=(ViewOfferHolder)viewResult.getTag();
        }
        Offer offerTemp=listOffer.get(i);
        viewOfferHolder.txt_store_offer.setText(offerTemp.getStore());
        if(offerTemp.getUrlPhoto()!=null){
            Picasso.with(activity).load(offerTemp.getUrlPhoto()).into(viewOfferHolder.img_offer);
        }
        viewOfferHolder.txt_description_offer.setText(offerTemp.getDescription());



        return viewResult;
    }
}
