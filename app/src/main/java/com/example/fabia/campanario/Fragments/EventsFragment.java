package com.example.fabia.campanario.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.fabia.campanario.Adapters.EventAdapter;
import com.example.fabia.campanario.Models.Event;
import com.example.fabia.campanario.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;


public class EventsFragment extends Fragment {

    private EventAdapter eventAdapter;
    private ExpandableListView expandableListView;
    private ArrayList<String> listTitleGroupEvent;


    public EventsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentEvent= inflater.inflate(R.layout.fragment_events, container, false);
        HashMap<String, List<Event>> listGroupsEvents=chargeEvents();
        listTitleGroupEvent=new ArrayList<>(listGroupsEvents.keySet());
        eventAdapter=new EventAdapter(this.getActivity(),listTitleGroupEvent,listGroupsEvents);
        expandableListView=(ExpandableListView)fragmentEvent.findViewById(R.id.events_listView);
        expandableListView.setAdapter(eventAdapter);



        return fragmentEvent;
    }

    public HashMap<String, List<Event>> chargeEvents(){
        HashMap<String, List<Event>> groupEvents=new HashMap<String, List<Event>>();
        ArrayList<Event> eventsHoy=new ArrayList<>();
        eventsHoy.add(new Event(Calendar.getInstance().getTime(), "Hora con dios", "misa dominical con el padre  chichirre", "campanario","https://goo.gl/mP9QQs"));
        eventsHoy.add(new Event(Calendar.getInstance().getTime(), "FITNESS CAMPANARIO", "Todos los domingos 9:30am", "campanario","https://campanariopopayan.com/images/agenda/fitness-campanario-1496093232.jpg"));
        eventsHoy.add(new Event(Calendar.getInstance().getTime(), "CLUB CAMPANERITOS", "Ultimo sabado de cada mes", "campanario","https://campanariopopayan.com/images/agenda/club-campaneritos-1424276981.jpg"));


        groupEvents.put("Eventos Permanentes", eventsHoy);

        ArrayList<Event> eventsHoy2=new ArrayList<>();
        eventsHoy2.add(new Event(Calendar.getInstance().getTime(), "Misa", "misa dominical con el padre  chichirre", "campanario"));
        eventsHoy2.add(new Event(Calendar.getInstance().getTime(), "Misa1", "misa dominical con el padre  chichirre", "campanario"));
        eventsHoy2.add(new Event(Calendar.getInstance().getTime(), "Misa2", "misa dominical con el padre  chichirre", "campanario"));
        eventsHoy2.add(new Event(Calendar.getInstance().getTime(), "Misa3", "misa dominical con el padre  chichirre", "campanario"));
        eventsHoy2.add(new Event(Calendar.getInstance().getTime(), "Misa4", "misa dominical con el padre  chichirre", "campanario"));
        eventsHoy2.add(new Event(Calendar.getInstance().getTime(), "Misa5", "misa dominical con el padre  chichirre", "campanario"));

        groupEvents.put("Eventos", eventsHoy2);
        ArrayList<Event> eventsHoy3=new ArrayList<>();
        groupEvents.put("Eventos Pasados", eventsHoy3);


        return groupEvents;
    }


}
