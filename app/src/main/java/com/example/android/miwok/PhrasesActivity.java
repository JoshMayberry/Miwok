package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PhrasesActivity extends AppCompatActivity {
    int[] defaultIdList = {R.string.word_default_phrase_1, R.string.word_default_phrase_2, R.string.word_default_phrase_3, R.string.word_default_phrase_4, R.string.word_default_phrase_5, R.string.word_default_phrase_6, R.string.word_default_phrase_7, R.string.word_default_phrase_8, R.string.word_default_phrase_9, R.string.word_default_phrase_10};
    int[] miwokIdList = {R.string.word_miwok_phrase_1, R.string.word_miwok_phrase_2, R.string.word_miwok_phrase_3, R.string.word_miwok_phrase_4, R.string.word_miwok_phrase_5, R.string.word_miwok_phrase_6, R.string.word_miwok_phrase_7, R.string.word_miwok_phrase_8, R.string.word_miwok_phrase_9, R.string.word_miwok_phrase_10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        new WordGenerator(this).populateView(defaultIdList, miwokIdList);
    }
}
