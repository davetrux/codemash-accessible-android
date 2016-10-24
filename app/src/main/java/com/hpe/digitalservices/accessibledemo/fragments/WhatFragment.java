package com.hpe.digitalservices.accessibledemo.fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hpe.digitalservices.accessibledemo.ClueViewAdapter;
import com.hpe.digitalservices.accessibledemo.DividerItemDecoration;
import com.hpe.digitalservices.accessibledemo.R;
import com.hpe.digitalservices.accessibledemo.Utils;
import com.hpe.digitalservices.accessibledemo.data.ClueItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by trux on 9/12/16.
 *
 * http://game-icons.net/
 *
 */
public class WhatFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.who_fragment, container, false);

        List<ClueItem> persons = getData();

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Drawable border = getContext().getDrawable(R.drawable.border);
        recyclerView.addItemDecoration(new DividerItemDecoration(border));


        /** Accessibility Feature **/
        boolean isDarkTheme = Utils.isDarkTheme(this.getActivity());

        ClueViewAdapter adapter = new ClueViewAdapter(persons, R.layout.clue_list_card, isDarkTheme);
        recyclerView.setAdapter(adapter);

        return v;
    }
    
    private List<ClueItem> getData(){

        List<String> weapons = Arrays.asList(getResources().getStringArray(R.array.weapons));

        List<ClueItem> result = new ArrayList<>(weapons.size());

        for (String weapon : weapons) {
            ClueItem item = new ClueItem();
            item.setName(weapon);
            item.setPhoto(getDrawableByName(weapon));
            result.add(item);
        }

        return result;
    }

    private int getDrawableByName(String rawName) {

        Context context = getContext();

        String name = rawName.toLowerCase().replace(' ', '_');

        return context.getResources().getIdentifier(name, "drawable", context.getPackageName());
    }
}
