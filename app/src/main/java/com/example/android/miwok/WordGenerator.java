package com.example.android.miwok;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class WordGenerator {
    static public void populateView(AppCompatActivity activity, int[] defaultIdList, int[] miwokIdLists) {
        ArrayList<Word> words = new ArrayList<>();
        for (int i=0; i<defaultIdList.length; i++) words.add(new Word(activity, defaultIdList[i], miwokIdLists[i]));
        ListView rootView = (ListView) activity.findViewById(R.id.rootView);
        rootView.setAdapter(new WordAdapter(activity, words));
    }
}

