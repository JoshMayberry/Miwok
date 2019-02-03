package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

//Modified code from: https://github.com/udacity/ud839_CustomAdapter_Example/blob/master/app/src/main/java/com/example/android/flavor/AndroidFlavorAdapter.java
public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(@NonNull Context context, @NonNull List<Word> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View scrapView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View view = scrapView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word word = getItem(position);

        TextView view_miwok = (TextView) view.findViewById(R.id.list_item_top);
        view_miwok.setText(word.getMiwokTranslation());

        TextView view_default = (TextView) view.findViewById(R.id.list_item_bottom);
        view_default.setText(word.getDefaultTranslation());

//        ImageView view_icon = (ImageView) listItemView.findViewById(R.id.list_item_icon);
//        view_icon.setImageResource(word.getImageResourceId());

        return view;
    }
}
