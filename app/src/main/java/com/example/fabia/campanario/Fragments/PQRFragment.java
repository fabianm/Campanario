package com.example.fabia.campanario.Fragments;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.fabia.campanario.Adapters.CustomAdapter;
import com.example.fabia.campanario.Helpers.HttDataHandler;
import com.example.fabia.campanario.Models.ChatMo;
import com.example.fabia.campanario.Models.SimsimiMo;
import com.example.fabia.campanario.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class PQRFragment extends Fragment {


    public ListView list;
    public EditText editText;
    public List<ChatMo> list_chat = new ArrayList<>();
    public ImageButton btn_send_message;
    public String tempMsg;
    public Activity activity;


    CustomAdapter adapter;
    public PQRFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        activity=this.getActivity();
        View viewPQR=inflater.inflate(R.layout.fragment_pqr, container, false);
        list = (ListView) viewPQR.findViewById(R.id.list_message);
        editText = (EditText) viewPQR.findViewById(R.id.message);
        btn_send_message = (ImageButton) viewPQR.findViewById(R.id.btn_send);
        adapter = new CustomAdapter(list_chat,this.getActivity());

        btn_send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                ChatMo model = new ChatMo(text,true);  // user send msg
                list_chat.add(model);
                tempMsg=editText.getText().toString();
                new SimsimiAPI().execute(list_chat);
                //remove
                editText.setText("");
            }
        });


        return viewPQR;
    }

    private class SimsimiAPI extends AsyncTask<List<ChatMo>,Void,String> {

        String stream= null;
        List<ChatMo> models;
        String txt = editText.getText().toString();
        @Override
        protected String doInBackground(List<ChatMo>... lists) {
            String url = String.format("http://sandbox.api.simsimi.com/request.p?key=%s&lc=es&ft=1.0&text=%s",
                    getString(R.string.simsimi_api),tempMsg);
            Log.i("msg",tempMsg);
            models = lists[0];
            HttDataHandler httDataHandler = new HttDataHandler();
            stream = httDataHandler.GetHTTPData(url);
            return stream;
        }

        @Override
        protected void onPostExecute(String s) {
            Gson gson = new Gson();
            Log.i("responsoe",s);
            SimsimiMo respon = gson.fromJson(s,SimsimiMo.class);

            ChatMo chatMo = new ChatMo(respon.getReponse(),false); // tenemos respuesta de simsimi
            models.add(chatMo);
            // list_chat.add(chatMo);
            adapter = new CustomAdapter(models,activity);
            list.setAdapter(adapter);
        }
    }


}
