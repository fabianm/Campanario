package com.example.fabia.campanario.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fabia.campanario.Adapters.OffersAdapter;
import com.example.fabia.campanario.Models.Offer;
import com.example.fabia.campanario.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;


public class OffersFragment extends Fragment {
   private FeatureCoverFlow coverFlow;
    private OffersAdapter offerAdapter;



    public OffersFragment() {
        // Required empty public constructor
    }


 /*   @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewOffers=inflater.inflate(R.layout.fragment_offers, container, false);
        coverFlow= (FeatureCoverFlow) viewOffers.findViewById(R.id.coverflow);
        offerAdapter= new OffersAdapter(this.getActivity(),chargeOffers());
        coverFlow.setAdapter(offerAdapter);



        return viewOffers;
    }

    public ArrayList<Offer> chargeOffers(){
        ArrayList<Offer> offerList=new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = "2/11/2017";

        try {

            Date date = formatter.parse(dateInString);
            Offer offer1=new Offer(date,"https://campanariopopayan.com/images/ofertas/postccdigitaljeans109-1509581041.jpg","Studio F","Amamos los Jeans Studio F, solo por HOY llévatelos a $109.900 en nuestras tiendas y tienda online");
            Offer offer2=new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.29.35-1509410097.jpg","Ibis","Visítanos y conoce nuestro catálogo de la última colección!!");
            Offer offer3=new Offer(date,"https://campanariopopayan.com/images/ofertas/22-1509116928.jpg","Arturo Calle Leather","Visítanos en nuestra de campanario Popayán LOCAL 126");
            Offer offer4=new Offer(date,"https://campanariopopayan.com/images/ofertas/image4-1509580912.jpg","OxFord","Queremos celebrar contigo el mes de tu cumpleaños. *Aplican condiciones y restricciones.");
            offerList.add(offer1);
            offerList.add(offer2);
            offerList.add(offer3);
            offerList.add(offer4);






        } catch (ParseException e) {
            e.printStackTrace();
        }

        return offerList;
    }


}
