package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PhrasesActivity extends AppCompatActivity {
    int[] defaultIdList = {R.string.word_default_phrase_1, R.string.word_default_phrase_2, R.string.word_default_phrase_3, R.string.word_default_phrase_4, R.string.word_default_phrase_5, R.string.word_default_phrase_6, R.string.word_default_phrase_7, R.string.word_default_phrase_8, R.string.word_default_phrase_9, R.string.word_default_phrase_10};
    int[] miwokIdList = {R.string.word_miwok_phrase_1, R.string.word_miwok_phrase_2, R.string.word_miwok_phrase_3, R.string.word_miwok_phrase_4, R.string.word_miwok_phrase_5, R.string.word_miwok_phrase_6, R.string.word_miwok_phrase_7, R.string.word_miwok_phrase_8, R.string.word_miwok_phrase_9, R.string.word_miwok_phrase_10};
    int[] soundIdList = {R.raw.phrase_where_are_you_going, R.raw.phrase_what_is_your_name, R.raw.phrase_my_name_is, R.raw.phrase_how_are_you_feeling, R.raw.phrase_im_feeling_good, R.raw.phrase_are_you_coming, R.raw.phrase_yes_im_coming, R.raw.phrase_im_coming, R.raw.phrase_lets_go, R.raw.phrase_come_here};

    private WordGenerator mWordGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //See: https://developer.android.com/training/design-navigation/ancestral-temporal.html
        //See: https://developer.android.com/training/design-navigation/screen-planning.html?utm_source=udacity&utm_medium=course&utm_campaign=android_basics#diagram-relationships
        //Use: https://developer.android.com/training/implementing-navigation/ancestral.html?utm_source=udacity&utm_medium=course&utm_campaign=android_basics#up
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.word_list);
        mWordGenerator = new WordGenerator(this)
                .setDefaultIdList(defaultIdList)
                .setMiwokIdList(miwokIdList)
                .setColorId(R.color.category_phrases)
                .setSoundIdList(soundIdList);
        mWordGenerator.populateView();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //See: https://developer.android.com/guide/components/activities/activity-lifecycle#alc
        mWordGenerator.releaseMediaPlayer();
    }
}
