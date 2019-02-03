package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ColorsActivity extends AppCompatActivity {
    int[] defaultIdList = {R.string.word_default_color_1, R.string.word_default_color_2, R.string.word_default_color_3, R.string.word_default_color_4, R.string.word_default_color_5, R.string.word_default_color_6, R.string.word_default_color_7, R.string.word_default_color_8};
    int[] miwokIdList = {R.string.word_miwok_color_1, R.string.word_miwok_color_2, R.string.word_miwok_color_3, R.string.word_miwok_color_4, R.string.word_miwok_color_5, R.string.word_miwok_color_6, R.string.word_miwok_color_7, R.string.word_miwok_color_8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        WordGenerator.populateView(this, R.id.rootColors, defaultIdList, miwokIdList);
    }
}
