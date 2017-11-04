package com.example.fabia.campanario.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fabia.campanario.Models.Event;
import com.example.fabia.campanario.R;
import com.example.fabia.campanario.ViewHolders.ViewEventHolder;
import com.example.fabia.campanario.ViewHolders.ViewGroupEventHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fabia on 28/10/2017.
 */

public class EventAdapter extends BaseExpandableListAdapter {
    private Activity activity;
    private ArrayList<String> titles;
    private HashMap<String,List<Event>> listDetail;

    public EventAdapter(Activity activity, ArrayList<String> titles, HashMap<String, List<Event>> listDetail) {
        this.activity = activity;
        this.titles = titles;
        this.listDetail = listDetail;
    }

    @Override
    public int getGroupCount() {
        return listDetail.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return this.listDetail.get(this.titles.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return this.titles.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return this.listDetail.get(this.titles.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        View viewReturn=view;
        ViewGroupEventHolder viewGroupEventHolder;

        if(viewReturn==null){
            LayoutInflater layoutInflater=this.activity.getLayoutInflater();
            viewReturn=layoutInflater.inflate(R.layout.group_event,null);

             viewGroupEventHolder=new ViewGroupEventHolder();
            viewGroupEventHolder.txt_countGroup=(TextView) viewReturn.findViewById(R.id.txt_countGroup);
            viewGroupEventHolder.txt_titleGroup=(TextView)viewReturn.findViewById(R.id.txt_titleGroup);
            viewReturn.setTag(viewGroupEventHolder);
        }else{
            viewGroupEventHolder=(ViewGroupEventHolder) viewReturn.getTag();
        }
        viewGroupEventHolder.txt_titleGroup.setText(titles.get(i));
        viewGroupEventHolder.txt_countGroup.setText(listDetail.get(titles.get(i)).size()+"");

        return viewReturn;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        View viewReturn=view;
        ViewEventHolder viewEventHolder;
        if(viewReturn==null){
            LayoutInflater layoutInflater=this.activity.getLayoutInflater();
            viewReturn=layoutInflater.inflate(R.layout.item_event,null);
            viewEventHolder=new ViewEventHolder();
            viewEventHolder.img_itemEvent=(ImageView)viewReturn.findViewById(R.id.img_itemEvent);
            viewEventHolder.txt_dateEvent=(TextView)viewReturn.findViewById(R.id.txt_dateEvent);
            viewEventHolder.txt_placeEvent=(TextView)viewReturn.findViewById(R.id.txt_placeEvent);
            viewEventHolder.txt_titleEvent=(TextView)viewReturn.findViewById(R.id.txt_titleEvent);
            viewReturn.setTag(viewEventHolder);
        }else{
            viewEventHolder=(ViewEventHolder)viewReturn.getTag();
        }
        Event eventTemp=listDetail.get(titles.get(i)).get(i1);
        viewEventHolder.txt_titleEvent.setText(eventTemp.getTitle());
        viewEventHolder.txt_placeEvent.setText(eventTemp.getUbication());
        viewEventHolder.txt_dateEvent.setText(eventTemp.getFormattedDate());

        if(eventTemp.getUrlphoto()!=null){
            Picasso.with(this.activity).load(eventTemp.getUrlphoto()).into(viewEventHolder.img_itemEvent);
        }


        return viewReturn;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
