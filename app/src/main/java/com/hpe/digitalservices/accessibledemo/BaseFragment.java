package com.hpe.digitalservices.accessibledemo;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Common functionality among fragments
 *
 * Created by trux on 9/13/16.
 */
public class BaseFragment extends Fragment {

    protected View InflateFragment(LayoutInflater inflater, ViewGroup container, List<ClueItem> data) {
        RecyclerView recyclerView = (RecyclerView) container.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        ClueViewAdapter adapter = new ClueViewAdapter(data);
        recyclerView.setAdapter(adapter);

        return inflater.inflate(R.layout.who_fragment, container, false);
    }

}
