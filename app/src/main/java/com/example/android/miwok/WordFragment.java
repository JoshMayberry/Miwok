package com.example.android.miwok;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * See: https://developer.android.com/guide/components/fragments.html?utm_source=udacity&utm_medium=course&utm_campaign=android_basics
 * See: https://developer.android.com/guide/components/fragments.html?utm_source=udacity&utm_medium=course&utm_campaign=android_basics#Lifecycle
 * See: https://developer.android.com/guide/components/fragments?utm_campaign=android_basics&utm_medium=course&utm_source=udacity
 * See: https://developer.android.com/guide/topics/resources/providing-resources.html#AlternativeResources
 */
public class WordFragment extends Fragment {
    int[] defaultIdList = {};
    int[] miwokIdList = {};
    int[] imageIdList = {};
    int[] soundIdList = {};
    int colorId = R.color.primary_color;

    private WordGenerator mWordGenerator;
    private AppCompatActivity mActivity;

    public WordFragment() {
    }

    //See: https://github.com/codepath/android_guides/wiki/Creating-and-Using-Fragments#user-content-communicating-with-fragments
    WordFragment setActivity(AppCompatActivity activity) {
        Log.v("WordFragment", "@setActivity");
        this. mActivity = activity;
        this.mWordGenerator = new WordGenerator(this, mActivity);
        return this;
    }

    WordFragment setDefaultIdList(int[] textId) {
        this.defaultIdList = textId;
        return this;
    }

    WordFragment setMiwokIdList(int[] textId) {
        this.miwokIdList = textId;
        return this;
    }

    WordFragment setSoundIdList(int[] soundId) {
        this.soundIdList = soundId;
        return this;
    }

    WordFragment setImageIdList(int[] imageId) {
        this.imageIdList = imageId;
        return this;
    }

    WordFragment setColorId(int colorId) {
        this.colorId = colorId;
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v("WordFragment", "@onCreateView");

        View rootView = inflater.inflate(R.layout.word_list, container, false);
        mWordGenerator = new WordGenerator(this, mActivity)
                .setDefaultIdList(defaultIdList)
                .setMiwokIdList(miwokIdList)
                .setImageIdList(imageIdList)
                .setColorId(colorId)
                .setSoundIdList(soundIdList);
        mWordGenerator.populateView((ListView) rootView);
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        //See: https://developer.android.com/guide/components/activities/activity-lifecycle#alc
        mWordGenerator.releaseMediaPlayer();
    }

}
