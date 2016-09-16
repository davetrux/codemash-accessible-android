package com.hpe.digitalservices.accessibledemo;


import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Adapter for filling list items with names and images
 *
 * Created by trux on 9/13/16.
 */
public class ClueViewAdapter extends RecyclerView.Adapter<ClueViewAdapter.ItemHolder>{

    private List<ClueItem> data;
    private int drawableId;

    public ClueViewAdapter(List<ClueItem> items, int rowDrawable) {
        data = items;
        drawableId = rowDrawable;
    }

    @Override
    public ClueViewAdapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(drawableId, parent, false);
        return new ItemHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(ClueViewAdapter.ItemHolder holder, int position) {
        ClueItem item = data.get(position);
        holder.bindPhoto(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mItemImage;
        private TextView mItemName;

        public ItemHolder(View v) {
            super(v);

            mItemImage = (ImageView) v.findViewById(R.id.item_image);
            mItemName = (TextView) v.findViewById(R.id.item_name);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d("RecyclerView", "CLICK!");
        }

        public void bindPhoto(ClueItem item) {

            mItemName.setText(item.getName());
            mItemImage.setImageResource(item.getPhoto());

            if(!TextUtils.isEmpty(item.getDescription())) {
                mItemImage.setContentDescription(item.getDescription());
            }

        }
    }
}
