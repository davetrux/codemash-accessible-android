package com.hpe.digitalservices.accessibledemo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by trux on 9/12/16.
 *
 * http://game-icons.net/
 *
 */
public class WhatFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.who_fragment, container, false);

        List<ClueItem> persons = getData();

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ClueViewAdapter adapter = new ClueViewAdapter(persons);
        recyclerView.setAdapter(adapter);

        return v;
    }
    
    private List<ClueItem> getData(){

        List<String> weapons = Arrays.asList(getResources().getStringArray(R.array.weapons));

        List<ClueItem> result = new ArrayList<>(weapons.size());

        for (String weapon : weapons) {
            ClueItem item = new ClueItem();
            item.setNames(weapon);
            item.setPhotos(R.drawable.rope_coil);
            result.add(item);
        }

        return result;
    }
}
