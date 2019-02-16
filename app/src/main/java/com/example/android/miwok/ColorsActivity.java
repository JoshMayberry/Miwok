package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ColorsActivity extends AppCompatActivity {
    int[] defaultIdList = {R.string.word_default_color_1, R.string.word_default_color_2, R.string.word_default_color_3, R.string.word_default_color_4, R.string.word_default_color_5, R.string.word_default_color_6, R.string.word_default_color_7, R.string.word_default_color_8};
    int[] miwokIdList = {R.string.word_miwok_color_1, R.string.word_miwok_color_2, R.string.word_miwok_color_3, R.string.word_miwok_color_4, R.string.word_miwok_color_5, R.string.word_miwok_color_6, R.string.word_miwok_color_7, R.string.word_miwok_color_8};
    int[] imageIdList = {R.drawable.color_red, R.drawable.color_green, R.drawable.color_brown, R.drawable.color_gray, R.drawable.color_black, R.drawable.color_white, R.drawable.color_dusty_yellow, R.drawable.color_mustard_yellow};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        WordGenerator.populateView(this, defaultIdList, miwokIdList, imageIdList);
    }
}
