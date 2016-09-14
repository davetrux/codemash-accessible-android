package com.hpe.digitalservices.accessibledemo;

import android.content.Context;
import android.support.v4.app.Fragment;
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
 */
public class WhoFragment extends Fragment {

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

        List<String> suspects = Arrays.asList(getResources().getStringArray(R.array.suspects));

        List<ClueItem> result = new ArrayList<>(suspects.size());

        for (String suspect : suspects) {
            ClueItem item = new ClueItem();
            item.setNames(suspect);
            item.setPhotos(getDrawableByName(suspect));
            result.add(item);
        }

        return result;
    }

    private int getDrawableByName(String rawName) {

        Context context = getContext();

        String name = rawName.toLowerCase().replace(".", "").replace(' ', '_');

        int id = context.getResources().getIdentifier(name, "drawable", context.getPackageName());

        if(id == 0) {
            id = R.drawable.rope;
        }

        return id;
    }
}
