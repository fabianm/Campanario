package com.example.fabia.campanario.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.fabia.campanario.ChatMo;
import com.example.fabia.campanario.R;
import com.github.library.bubbleview.BubbleTextView;

import java.util.List;



/**
 * Created by DIEGO on 01/11/2017.
 */

public class CustomAdapter extends BaseAdapter{

    private List<ChatMo> list_chat_Mo;
    private Context context;
    private Activity activity;
    private LayoutInflater layoutInflater;

    public CustomAdapter(List<ChatMo> list_chat_Mo, /*Activity activity){*/ Context context) {
        this.list_chat_Mo = list_chat_Mo;
        //this.activity = activity;
        this.context=context;
        layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    @Override
    public int getCount() {
        return list_chat_Mo.size();
    }

    @Override
    public Object getItem(int i) {
        return list_chat_Mo.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        View  view= convertview ;

        if (view == null){
            ChatMo tempChatMo=list_chat_Mo.get(i);
            //layoutInflater =this.activity.getLayoutInflater();
            if (tempChatMo.isSend()) {
                view = layoutInflater.inflate(R.layout.item_message_send, null);
                BubbleTextView text_messa =(BubbleTextView) view.findViewById(R.id.text_message);
                text_messa.setText(tempChatMo.getMessage());
            }else {
                view = layoutInflater.inflate(R.layout.item_message_received, null);
                BubbleTextView text_messa = (BubbleTextView)view.findViewById(R.id.text_message1);
                text_messa.setText(tempChatMo.getMessage());
            }


        }else{

        }
        return  view;
    }
}
