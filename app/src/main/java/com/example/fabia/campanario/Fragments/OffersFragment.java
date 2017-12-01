package com.example.fabia.campanario.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fabia.campanario.Adapters.OffersAdapter;
import com.example.fabia.campanario.Adapters.StoreOfferAdapter;
import com.example.fabia.campanario.Helpers.DataBase;
import com.example.fabia.campanario.Models.Offer;
import com.example.fabia.campanario.Models.Store;
import com.example.fabia.campanario.Persistence.PersistenceData;
import com.example.fabia.campanario.R;
import com.example.fabia.campanario.Utilities.StringToDate;
import com.orm.SugarContext;
import com.orm.util.Collection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;


public class OffersFragment extends Fragment {
   private FeatureCoverFlow coverFlow;
    private OffersAdapter offerAdapter;
    private StoreOfferAdapter storeOfferAdapter;

    private GridView gridStores;

    private ViewGroup linearLayoutDetails;
    private ImageView imageViewExpand;
    private static final int DURATION = 250;

    private PersistenceData persistenceData;


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
        SugarContext.init(getContext());

        linearLayoutDetails=(ViewGroup)viewOffers.findViewById(R.id.content_description_car);
        imageViewExpand=(ImageView)viewOffers.findViewById(R.id.imageViewExpand);
        coverFlow= (FeatureCoverFlow) viewOffers.findViewById(R.id.coverflow);
        persistenceData=new PersistenceData(this.getContext());
        if(!persistenceData.isSaveOffer()){
            saveOffer();
        }

        offerAdapter= new OffersAdapter(this.getActivity(),(ArrayList<Offer>) chargeOffers());
        coverFlow.setAdapter(offerAdapter);
        gridStores=(GridView)viewOffers.findViewById(R.id.grid_stores);
        storeOfferAdapter=new StoreOfferAdapter(this.getActivity(),loadStoreOffers());
        gridStores.setAdapter(storeOfferAdapter);
        gridStores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Store storeSelect=(Store)adapterView.getItemAtPosition(i);
                offerAdapter= new OffersAdapter(getActivity(),(ArrayList<Offer>) storeSelect.getListOffers());
                coverFlow.setAdapter(offerAdapter);
            }
        });


        return viewOffers;
    }

    public ArrayList<Store> loadStoreOffers(){
        ArrayList<Store> listStore= new ArrayList<>();

        List<Offer> listOffer= Offer.findWithQuery(Offer.class, "SELECT * FROM "+DataBase.TABLE_OFFER+" GROUP BY "+DataBase.OFFER_STORE_ID, null);
        for(Offer offer:listOffer){
            listStore.add(offer.getStore());
            System.out.println(offer.getStore().getName()+"\n*************///*****");
        }
        System.out.println("***********************\n"+listStore.size()+"\n*****************");
        return listStore;
    }

    public List<Offer> chargeOffers(){

        return Offer.listAll(Offer.class);
       // ArrayList<Offer> offerList=new ArrayList<>();


           /* Date date = StringToDate.converToDate("30/11/2017");
            offerList.add(new Offer(date,"https://campanariopopayan.com/images/ofertas/postccdigitaljeans109-1509581041.jpg","Studio F","Amamos los Jeans Studio F, solo por HOY llévatelos a $109.900 en nuestras tiendas y tienda online"));
            offerList.add(new Offer(StringToDate.converToDate("6/11/2017"),"https://campanariopopayan.com/images/ofertas/post-1509724508.jpg","Ela","Pagando con tus tarjetas débito o crédito Davivienda recibe 25% OFF en artículos de última colección.*Aplican condiciones y restricciones."));
            offerList.add(new Offer(StringToDate.converToDate("3/12/2017"),"https://campanariopopayan.com/images/ofertas/postlogomerchannov-1509747502.jpg","Ela","¡Te obsequiamos nuestra plancha #CoolHair perfecta para tus viajes! *Aplican condiciones y restricciones."));
            offerList.add(new Offer(date,"https://campanariopopayan.com/images/ofertas/instructivo30segundopar03nov01-1509725109.jpg","Bubble Gummers","Aprovecha el 30 % de descuento en el segundo artículo de igual o menor valor!!!"));
            offerList.add(new Offer(date,"https://campanariopopayan.com/images/ofertas/image002-1509725335.jpg","Fuera de Serie FDS","Adelanta tus compras de navidad con un 30% DCTO en TODO!!! adicional un -30 % en prendas ya rebajadas."));

            offerList.add(new Offer(date,"https://campanariopopayan.com/images/ofertas/image4-1509580912.jpg","OxFord","Queremos celebrar contigo el mes de tu cumpleaños. *Aplican condiciones y restricciones."));
            offerList.add(new Offer(StringToDate.converToDate("17/11/2017"),StringToDate.converToDate("26/11/2017"),"https://campanariopopayan.com/images/ofertas/blackfridaydoradoelegante01-1509747403.jpg","DIVA'S","Toda la tienda con el 50% de descuento. Es de resaltar que la promoción va del 17 al 26 de noviembre de 2017."));
            offerList.add(new Offer(date,"https://campanariopopayan.com/images/ofertas/32-1509116973.jpg","Arturo Calle Leather","Visítanos en nuestra de campanario Popayán LOCAL 126"));
            offerList.add(new Offer(date,"https://campanariopopayan.com/images/ofertas/32-1509116973.jpg","Arturo Calle Leather","Visítanos en nuestra de campanario Popayán LOCAL 126"));
            offerList.add(new Offer(date,"https://campanariopopayan.com/images/ofertas/4-1509117008.jpg","Arturo Calle Leather","Visítanos en nuestra de campanario Popayán LOCAL 126"));
            offerList.add(new Offer(date,"https://campanariopopayan.com/images/ofertas/52-1509117047.jpg","Arturo Calle Leather","Visítanos en nuestra de campanario Popayán LOCAL 126"));
            offerList.add(new Offer(date,"https://campanariopopayan.com/images/ofertas/13-1509117970.jpg","Arturo Calle Leather","Visítanos en nuestra de campanario Popayán LOCAL 126"));
            offerList.add(new Offer(date,"https://campanariopopayan.com/images/ofertas/22-1509116928.jpg","Arturo Calle Leather","Visítanos en nuestra de campanario Popayán LOCAL 126"));
            offerList.add(new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.29.35-1509410097.jpg","Ibis","Visítanos y conoce nuestro catálogo de la última colección!!"));
            offerList.add(new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.29.35-1509410097.jpg","Ibis","Visítanos y conoce nuestro catálogo de la última colección!!"));
            offerList.add(new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.29.59-1509410170.jpg","Ibis","Visítanos y conoce nuestro catálogo de la última colección!!"));
            offerList.add(new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.30.18-1509410252.jpg","Ibis","Visítanos y conoce nuestro catálogo de la última colección!!"));
            offerList.add(new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.30.36-1509410491.jpg","Ibis","Visítanos y conoce nuestro catálogo de la última colección!!"));
            offerList.add(new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.31.02-1509410576.jpg","Ibis","Visítanos y conoce nuestro catálogo de la última colección!!"));
            offerList.add(new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.31.17-1509410682.jpg","Ibis","Visítanos y conoce nuestro catálogo de la última colección!!"));
*/
        //return offerList;
    }


    private ArrayList<Store> loadStore(){
        ArrayList<Store> listStore=new ArrayList<>();
        Date date = StringToDate.converToDate("30/11/2017");

      /*  Offer offer1=new Offer(date,"https://campanariopopayan.com/images/ofertas/postccdigitaljeans109-1509581041.jpg","Studio F","Amamos los Jeans Studio F, solo por HOY llévatelos a $109.900 en nuestras tiendas y tienda online");
        Store store1=new Store("Studio F", "8323060", "Local: 94","https://campanariopopayan.com/images/tiendas/tiendas/studio-f-1371581505.jpg");
        store1.addOffer(offer1);

        Offer offer3=new Offer(StringToDate.converToDate("6/11/2017"),"https://campanariopopayan.com/images/ofertas/post-1509724508.jpg","Ela","Pagando con tus tarjetas débito o crédito Davivienda recibe 25% OFF en artículos de última colección.*Aplican condiciones y restricciones.");
        Offer offer2=new Offer(StringToDate.converToDate("3/12/2017"),"https://campanariopopayan.com/images/ofertas/postlogomerchannov-1509747502.jpg","Ela","¡Te obsequiamos nuestra plancha #CoolHair perfecta para tus viajes! *Aplican condiciones y restricciones.");
        Store store2=new Store("Ela", "", "Local: 121","");
        store2.addOffer(offer2);
        store2.addOffer(offer3);


        Offer offer0=new Offer(date,"https://campanariopopayan.com/images/ofertas/instructivo30segundopar03nov01-1509725109.jpg","Bubble Gummers","Aprovecha el 30 % de descuento en el segundo artículo de igual o menor valor!!!");
        Store store3=new Store("Bubble Gummers", "----", "Local: 87 y 88","https://campanariopopayan.com/images/tiendas/tiendas/bubble-gummers-1502315512.jpg");
        store3.addOffer(offer0);

        Offer offer19=new Offer(date,"https://campanariopopayan.com/images/ofertas/image002-1509725335.jpg","Fuera de Serie FDS","Adelanta tus compras de navidad con un 30% DCTO en TODO!!! adicional un -30 % en prendas ya rebajadas.");
        Store store4=new Store("Fuera de serie FDS", "8232821", "Local: 19","https://campanariopopayan.com/images/tiendas/tiendas/fuera-de-serie-fds-1395947876.jpg");
        store4.addOffer(offer19);


        Offer offer5=new Offer(StringToDate.converToDate("17/11/2017"),StringToDate.converToDate("26/11/2017"),"https://campanariopopayan.com/images/ofertas/blackfridaydoradoelegante01-1509747403.jpg","DIVA'S","Toda la tienda con el 50% de descuento. Es de resaltar que la promoción va del 17 al 26 de noviembre de 2017.");
        Offer offer6=new Offer(StringToDate.converToDate("30/11/2017"),"https://campanariopopayan.com/images/ofertas/32-1509116973.jpg","Arturo Calle Leather","Visítanos en nuestra de campanario Popayán LOCAL 126");
        Offer offer7=new Offer(StringToDate.converToDate("30/11/2017"),"https://campanariopopayan.com/images/ofertas/32-1509116973.jpg","Arturo Calle Leather","Visítanos en nuestra de campanario Popayán LOCAL 126");
        Offer offer8=new Offer(StringToDate.converToDate("30/11/2017"),"https://campanariopopayan.com/images/ofertas/4-1509117008.jpg","Arturo Calle Leather","Visítanos en nuestra de campanario Popayán LOCAL 126");
        Offer offer9=new Offer(StringToDate.converToDate("30/11/2017"),"https://campanariopopayan.com/images/ofertas/52-1509117047.jpg","Arturo Calle Leather","Visítanos en nuestra de campanario Popayán LOCAL 126");
        Offer offer10=new Offer(StringToDate.converToDate("30/11/2017"),"https://campanariopopayan.com/images/ofertas/13-1509117970.jpg","Arturo Calle Leather","Visítanos en nuestra de campanario Popayán LOCAL 126");
        Offer offer11=new Offer(date,"https://campanariopopayan.com/images/ofertas/22-1509116928.jpg","Arturo Calle Leather","Visítanos en nuestra de campanario Popayán LOCAL 126");
        Store store5=new Store("Arturo Calle", "8323015, 8237029", "Local: 39","https://campanariopopayan.com/images/tiendas/tiendas/arturo-calle-1371579861.jpg");
        store5.addOffer(offer5);
        store5.addOffer(offer6);
        store5.addOffer(offer7);
        store5.addOffer(offer8);
        store5.addOffer(offer9);
        store5.addOffer(offer10);
        store5.addOffer(offer11);

        Offer offer18=new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.29.35-1509410097.jpg","Ibis","Visítanos y conoce nuestro catálogo de la última colección!!");
        Offer offer12=new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.29.35-1509410097.jpg","Ibis","Visítanos y conoce nuestro catálogo de la última colección!!");
        Offer offer13=new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.29.59-1509410170.jpg","Ibis","Visítanos y conoce nuestro catálogo de la última colección!!");
        Offer offer14=new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.30.18-1509410252.jpg","Ibis","Visítanos y conoce nuestro catálogo de la última colección!!");
        Offer offer15=new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.30.36-1509410491.jpg","Ibis","Visítanos y conoce nuestro catálogo de la última colección!!");
        Offer offer16=new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.31.02-1509410576.jpg","Ibis","Visítanos y conoce nuestro catálogo de la última colección!!");
        Offer offer17=new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.31.17-1509410682.jpg","Ibis","Visítanos y conoce nuestro catálogo de la última colección!!");
        Store store6=new Store("Ibis", " 8201457", "Local: 65","https://campanariopopayan.com/images/tiendas/tiendas/ibis-1371580542.jpg");
        store6.addOffer(offer12);
        store6.addOffer(offer13);
        store6.addOffer(offer14);
        store6.addOffer(offer15);
        store6.addOffer(offer16);
        store6.addOffer(offer17);
        store6.addOffer(offer18);


        listStore.add(store1);
        listStore.add(store2);
        listStore.add(store3);
        listStore.add(store4);
        listStore.add(store5);
        listStore.add(store6);*/

        return listStore;
    }
    public void saveOffer(){
        ArrayList<Store> listStore=new ArrayList<>();
        Date date = StringToDate.converToDate("30/11/2017");

        Offer.save(new Offer(date,"https://campanariopopayan.com/images/ofertas/postccdigitaljeans109-1509581041.jpg",Store.find(Store.class, DataBase.STORE_NAME+" = ?","Studio F").get(0),"Amamos los Jeans Studio F, solo por HOY llévatelos a $109.900 en nuestras tiendas y tienda online"));

        Offer.save(new Offer(date,"https://campanariopopayan.com/images/ofertas/instructivo30segundopar03nov01-1509725109.jpg",Store.find(Store.class, DataBase.STORE_NAME+" = ?","Bubble Gummers").get(0),"Aprovecha el 30 % de descuento en el segundo artículo de igual o menor valor!!!"));

        Offer.save(new Offer(date,"https://campanariopopayan.com/images/ofertas/image002-1509725335.jpg",Store.find(Store.class, DataBase.STORE_NAME+" = ?","Fuera de serie FDS").get(0),"Adelanta tus compras de navidad con un 30% DCTO en TODO!!! adicional un -30 % en prendas ya rebajadas."));

       Offer.save(new Offer(StringToDate.converToDate("30/11/2017"),"https://campanariopopayan.com/images/ofertas/32-1509116973.jpg",Store.find(Store.class, DataBase.STORE_NAME+" = ?","Arturo Calle").get(0),"Visítanos en nuestra de campanario Popayán LOCAL 126"));
        Offer.save(new Offer(StringToDate.converToDate("30/11/2017"),"https://campanariopopayan.com/images/ofertas/32-1509116973.jpg",Store.find(Store.class, DataBase.STORE_NAME+" = ?","Arturo Calle").get(0),"Visítanos en nuestra de campanario Popayán LOCAL 126"));
        Offer.save(new Offer(StringToDate.converToDate("30/11/2017"),"https://campanariopopayan.com/images/ofertas/4-1509117008.jpg",Store.find(Store.class, DataBase.STORE_NAME+" = ?","Arturo Calle").get(0),"Visítanos en nuestra de campanario Popayán LOCAL 126"));
        Offer.save(new Offer(StringToDate.converToDate("30/11/2017"),"https://campanariopopayan.com/images/ofertas/52-1509117047.jpg",Store.find(Store.class, DataBase.STORE_NAME+" = ?","Arturo Calle").get(0),"Visítanos en nuestra de campanario Popayán LOCAL 126"));
        Offer.save(new Offer(StringToDate.converToDate("30/11/2017"),"https://campanariopopayan.com/images/ofertas/13-1509117970.jpg",Store.find(Store.class, DataBase.STORE_NAME+" = ?","Arturo Calle").get(0),"Visítanos en nuestra de campanario Popayán LOCAL 126"));
        Offer.save(new Offer(date,"https://campanariopopayan.com/images/ofertas/22-1509116928.jpg",Store.find(Store.class, DataBase.STORE_NAME+" = ?","Arturo Calle").get(0),"Visítanos en nuestra de campanario Popayán LOCAL 126"));


        Offer.save(new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.29.35-1509410097.jpg",Store.find(Store.class, DataBase.STORE_NAME+" = ?","Ibis").get(0),"Visítanos y conoce nuestro catálogo de la última colección!!"));
        Offer.save(new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.29.35-1509410097.jpg",Store.find(Store.class, DataBase.STORE_NAME+" = ?","Ibis").get(0),"Visítanos y conoce nuestro catálogo de la última colección!!"));
        Offer.save(new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.29.59-1509410170.jpg",Store.find(Store.class, DataBase.STORE_NAME+" = ?","Ibis").get(0),"Visítanos y conoce nuestro catálogo de la última colección!!"));
        Offer.save(new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.30.18-1509410252.jpg",Store.find(Store.class, DataBase.STORE_NAME+" = ?","Ibis").get(0),"Visítanos y conoce nuestro catálogo de la última colección!!"));
        Offer.save(new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.30.36-1509410491.jpg",Store.find(Store.class, DataBase.STORE_NAME+" = ?","Ibis").get(0),"Visítanos y conoce nuestro catálogo de la última colección!!"));
        Offer.save(new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.31.02-1509410576.jpg",Store.find(Store.class, DataBase.STORE_NAME+" = ?","Ibis").get(0),"Visítanos y conoce nuestro catálogo de la última colección!!"));
        Offer.save(new Offer(date,"https://campanariopopayan.com/images/ofertas/capturadepantalla20171030alas18.31.17-1509410682.jpg",Store.find(Store.class, DataBase.STORE_NAME+" = ?","Ibis").get(0),"Visítanos y conoce nuestro catálogo de la última colección!!"));


        persistenceData.setSaveOffer(true);
    }






    public void toggleDetails(View view) {
        if (linearLayoutDetails.getVisibility() == View.GONE) {
            ExpandAndCollapseViewUtil.expand(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.drawable.img_down);
            rotate(-180.0f);
        } else {
            ExpandAndCollapseViewUtil.collapse(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.drawable.img_down);
            rotate(180.0f);
        }
    }

    private void rotate(float angle) {
        Animation animation = new RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(DURATION);
        imageViewExpand.startAnimation(animation);
    }
}
