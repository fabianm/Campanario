package com.example.fabia.campanario.Utilities;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ListView;

import com.example.fabia.campanario.Adapters.NumberPhoneAdapter;

/**
 * Created by fabia on 4/10/2017.
 */

public class SearchStoreTextWatcher implements TextWatcher {
    private NumberPhoneAdapter numberPhoneAdapter;
    private ListView listView;

    public SearchStoreTextWatcher(NumberPhoneAdapter adapterMovieFilterable, ListView listView) {
        this.numberPhoneAdapter = adapterMovieFilterable;
        this.listView=listView;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        numberPhoneAdapter.getFilter().filter(editable.toString().toLowerCase());
        listView.setAdapter(numberPhoneAdapter);

    }
}
