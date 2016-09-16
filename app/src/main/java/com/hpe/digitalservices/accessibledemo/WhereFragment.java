package com.hpe.digitalservices.accessibledemo;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
public class WhereFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.who_fragment, container, false);

        List<ClueItem> persons = getData();

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Drawable border = getContext().getDrawable(R.drawable.border);
        recyclerView.addItemDecoration(new DividerItemDecoration(border));
        ClueViewAdapter adapter = new ClueViewAdapter(persons, R.layout.clue_list_card);
        recyclerView.setAdapter(adapter);

        return v;
    }

    private List<ClueItem> getData(){

        List<String> locations = Arrays.asList(getResources().getStringArray(R.array.locations));
        List<String> descriptions = Arrays.asList(getResources().getStringArray(R.array.location_descriptions));

        List<ClueItem> result = new ArrayList<>(locations.size());

        for (String place : locations) {
            ClueItem item = new ClueItem();
            item.setName(place);
            item.setDescription(descriptions.get(locations.indexOf(place)));
            item.setPhoto(getDrawableByName(place));
            result.add(item);
        }

        return result;
    }

    private int getDrawableByName(String rawName) {

        Context context = getContext();

        String name = rawName.toLowerCase().replace(' ', '_');

        int id = context.getResources().getIdentifier(name, "drawable", context.getPackageName());

        if(id == 0) {
            id = R.drawable.rope;
        }

        return id;
    }
}
