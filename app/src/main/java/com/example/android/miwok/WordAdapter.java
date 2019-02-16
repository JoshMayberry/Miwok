package com.example.android.miwok;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.TypedValue;
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

        //Populate Text
        TextView view_miwok = (TextView) view.findViewById(R.id.list_item_top);
        TextView view_default = (TextView) view.findViewById(R.id.list_item_bottom);
        view_miwok.setText(word.getMiwokTranslation());
        view_default.setText(word.getDefaultTranslation());

        //Populate Image
        ImageView view_icon = (ImageView) view.findViewById(R.id.list_item_image);
        if (word.hasImage()) {
            view_icon.setImageResource(word.getImageId());
            view_icon.setVisibility(View.VISIBLE);
        } else {
            view_icon.setVisibility(View.GONE);
        }

        //Change Background
        //Use: https://stackoverflow.com/questions/17277618/get-color-value-programmatically-when-its-a-reference-theme/17277714#17277714
        //See: https://developer.android.com/reference/android/content/res/Resources.Theme#resolveAttribute(int,%20android.util.TypedValue,%20boolean)
        View view_background = view.findViewById(R.id.word_section);
        Resources.Theme myTheme = getContext().getTheme();
        TypedValue typedValue = new TypedValue();

        if (!(myTheme.resolveAttribute(R.attr.colorPrimary, typedValue, true))) {
            typedValue.data = R.color.primary_color;
        }
        view_background.setBackgroundColor(typedValue.data);

        return view;
    }
}
