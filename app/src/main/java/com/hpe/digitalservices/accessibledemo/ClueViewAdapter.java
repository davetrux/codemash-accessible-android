package com.hpe.digitalservices.accessibledemo;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hpe.digitalservices.accessibledemo.data.*;

import java.util.List;

/**
 * Adapter for filling list items with names and images
 *
 * Created by trux on 9/13/16.
 */
public class ClueViewAdapter extends RecyclerView.Adapter<ClueViewAdapter.ItemHolder>{

    private List<ClueItem> data;
    private int drawableId;
    private static int themeId;

    public ClueViewAdapter(List<ClueItem> items, int rowDrawable, boolean isDarkTheme) {
        data = items;
        drawableId = rowDrawable;

        /**
         * Accessibility Feature
         */
        if(isDarkTheme) {
            themeId = R.style.DarkTheme;
        } else {
            themeId = R.style.LightTheme;
        }
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

    static class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView mItemImage;
        private TextView mItemName;
        private Context context;
        ItemHolder(View v) {
            super(v);

            mItemImage = (ImageView) v.findViewById(R.id.item_image);
            mItemName = (TextView) v.findViewById(R.id.item_name);
            context = v.getContext();
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.d("RecyclerView", "CLICK!");
        }

        void bindPhoto(ClueItem item) {

            mItemName.setText(item.getName());

            final ContextThemeWrapper wrapper = new ContextThemeWrapper(context, themeId);
            final Drawable icon = VectorDrawableCompat.create(context.getResources(), item.getPhoto(), wrapper.getTheme());

            mItemImage.setImageDrawable(icon);

            if(!TextUtils.isEmpty(item.getDescription())) {
                /**
                 * Accessibility feature
                 */
                mItemImage.setContentDescription(item.getDescription());
            }

        }
    }
}
