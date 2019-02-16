package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

class WordGenerator {

    private AppCompatActivity mActivity;
    private MediaPlayer mMediaPlayer;

    WordGenerator(AppCompatActivity activity) {
        mActivity = activity;
    }

    void populateView(int[] defaultIdList, int[] miwokIdLists) {
        populateView(defaultIdList, miwokIdLists, null);
    }
    void populateView(int[] defaultIdList, int[] miwokIdLists, int[] imageIdList) {
        //Populate Words
        ArrayList<Word> words = new ArrayList<>();
        for (int i=0; i<defaultIdList.length; i++) {
            Word newWord = new Word(mActivity)
                    .setDefaultTranslation(defaultIdList[i])
                    .setMiwokTranslation(miwokIdLists[i]);
            if (imageIdList != null) {
                newWord.setImageId(imageIdList[i]);
            }
        }

        //Apply Words
        ListView rootView = (ListView) mActivity.findViewById(R.id.rootView);
        rootView.setAdapter(new WordAdapter(mActivity, words));

        //Apply Audio
        //See: https://developer.android.com/guide/topics/media/mediaplayer#mediaplayer
//        final Class cls = activity.getClass();

//        mActivity.getResources().openRawResource()
        R.raw.

        rootView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                mMediaPlayer = MediaPlayer.create(context, R.raw);
//                mMediaPlayer.start(); // no need to call prepare(); create() does that for you
            }
        });
    }
}

