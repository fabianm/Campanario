package com.example.fabia.campanario.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fabia.campanario.Models.Store;
import com.example.fabia.campanario.R;
import com.example.fabia.campanario.Utilities.RecyclerViewAnimator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fabian Muñoz on 5/02/2018.
 */

public class StoreCardAdapter extends RecyclerView.Adapter<StoreCardAdapter.ViewHolder> {
    private RecyclerViewAnimator mAnimator;
    private List<Store> storeList;

    public StoreCardAdapter(RecyclerView recyclerView) {
        mAnimator = new RecyclerViewAnimator(recyclerView);
        this.storeList=new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_store, parent, false);
        ViewHolder vh = new ViewHolder(v);

        /**
         * First item's entrance animations.
         */
        mAnimator.onCreateViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(storeList.get(position).getName());

        Glide.with(holder.mBackground.getContext())
                .load(storeList.get(position).getUrlLogo())
                .centerCrop()
                .into(holder.mBackground);

        /**
         * Item's entrance animations during scroll are performed here.
         */
        mAnimator.onBindViewHolder(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return storeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ImageView mBackground;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.txt_store_name);
            mBackground = (ImageView) v.findViewById(R.id.img_store);
        }
    }

    public void setStoreList(List<Store> list){
        storeList.clear();
        storeList.addAll(list);
        notifyDataSetChanged();
    }

}
