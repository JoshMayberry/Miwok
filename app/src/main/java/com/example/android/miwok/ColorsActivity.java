package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ColorsActivity extends AppCompatActivity {
    int[] defaultIdList = {R.string.word_default_color_1, R.string.word_default_color_2, R.string.word_default_color_3, R.string.word_default_color_4, R.string.word_default_color_5, R.string.word_default_color_6, R.string.word_default_color_7, R.string.word_default_color_8};
    int[] miwokIdList = {R.string.word_miwok_color_1, R.string.word_miwok_color_2, R.string.word_miwok_color_3, R.string.word_miwok_color_4, R.string.word_miwok_color_5, R.string.word_miwok_color_6, R.string.word_miwok_color_7, R.string.word_miwok_color_8};
    int[] imageIdList = {R.drawable.color_red, R.drawable.color_green, R.drawable.color_brown, R.drawable.color_gray, R.drawable.color_black, R.drawable.color_white, R.drawable.color_dusty_yellow, R.drawable.color_mustard_yellow};
    int[] soundIdList = {R.raw.color_red, R.raw.color_green, R.raw.color_brown, R.raw.color_gray, R.raw.color_black, R.raw.color_white, R.raw.color_dusty_yellow, R.raw.color_mustard_yellow};
    int colorId = R.color.category_colors;

    //See: Tabs and ViewPager (Android Development Patterns Ep 9) - https://www.youtube.com/watch?v=zQekzaAgIlQ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WordFragment wordFragment = new WordFragment()
                .setActivity(this)
                .setDefaultIdList(defaultIdList)
                .setMiwokIdList(miwokIdList)
                .setImageIdList(imageIdList)
                .setColorId(colorId)
                .setSoundIdList(soundIdList);

        //See: https://developer.android.com/guide/components/fragments.html?utm_source=udacity&utm_medium=course&utm_campaign=android_basics#Transactions
        setContentView(R.layout.activity_category);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, wordFragment)
                .commit();
    }
}
