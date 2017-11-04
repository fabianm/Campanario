package com.example.fabia.campanario.Adapters;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fabia.campanario.Models.Store;
import com.example.fabia.campanario.R;
import com.example.fabia.campanario.ViewHolders.ViewContactHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabia on 3/11/2017.
 */

public class NumberPhoneAdapter extends BaseAdapter implements Filterable {
    private Activity activity;
    private ArrayList<Store> listStore;

    private List<Store> filteredStore;
    private ItemContactFilter mFilter;

    public NumberPhoneAdapter(Activity activity, ArrayList<Store> listStore) {
        this.activity = activity;
        this.listStore = listStore;
        this.filteredStore=listStore;
        mFilter= new ItemContactFilter();
    }

    @Override
    public int getCount() {
        return filteredStore.size();
    }

    @Override
    public Object getItem(int i) {
        return filteredStore.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewResult=view;
        ViewContactHolder viewContactHolder;
        if(view==null){
            LayoutInflater layoutInflater=this.activity.getLayoutInflater();
            viewResult=layoutInflater.inflate(R.layout.item_contact_store,null);
            viewContactHolder=new ViewContactHolder();
            viewContactHolder.btn_call_store=(ImageButton) viewResult.findViewById(R.id.btn_call_store);
            viewContactHolder.txt_nameStore_directory=(TextView) viewResult.findViewById(R.id.txt_nameStore_directory);
            viewContactHolder.txt_numberTelephoneStore_directory=(TextView) viewResult.findViewById(R.id.txt_numberTelephoneStore_directory);
            viewContactHolder.img_logo_contact=(ImageView)viewResult.findViewById(R.id.img_logo_contact);
            viewResult.setTag(viewContactHolder);
        }else{
            viewContactHolder=(ViewContactHolder)viewResult.getTag();
        }
        final Store  tempStore=filteredStore.get(i);
        viewContactHolder.txt_numberTelephoneStore_directory.setText(tempStore.getNumberTelephone());

        if(tempStore.getUrlLogo()!=null){
            Picasso.with(this.activity).load(tempStore.getUrlLogo()).into(viewContactHolder.img_logo_contact);
        }else{
            Picasso.with(this.activity).load(R.drawable.img_store_default).into(viewContactHolder.img_logo_contact);
        }
        if(tempStore.getNumberTelephone()==null && tempStore.getNumberTelephone()!=null){
            viewContactHolder.btn_call_store.setEnabled(true);
        }else{
            viewContactHolder.btn_call_store.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int permissionCheck = ContextCompat.checkSelfPermission(
                            v.getContext(), Manifest.permission.CALL_PHONE);
                    if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                        Log.i("Mensaje", "No se tiene permiso para realizar llamadas telefónicas.");
                        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, 225);
                    } else {
                        Log.i("Mensaje", "Se tiene permiso!");
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:" + tempStore.getNumberTelephone()));
                        activity.startActivity(callIntent);
                    }
                }
            });
        }
        viewContactHolder.txt_nameStore_directory.setText(tempStore.getName());


        return viewResult;
    }


    @Override
    public Filter getFilter() {
        return mFilter;
    }

    public class ItemContactFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String filterString = constraint.toString().toLowerCase();
            Log.i("Filter",filterString);
            FilterResults results = new FilterResults();

            int count = listStore.size();
            final List<Store> tempItems = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                if (listStore.get(i).getName().toLowerCase().contains(filterString)) {
                    tempItems.add(listStore.get(i));
                }
            }

            results.values = tempItems;
            results.count = tempItems.size();
            Log.i("Tamaño array filter",tempItems.size()+"");

            return results;

        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            filteredStore = (ArrayList<Store>) filterResults.values;
            notifyDataSetChanged();
        }
    }
}
