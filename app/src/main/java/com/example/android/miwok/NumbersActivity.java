package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class NumbersActivity extends AppCompatActivity {
    int[] defaultIdList = {R.string.word_default_number_1, R.string.word_default_number_2, R.string.word_default_number_3, R.string.word_default_number_4, R.string.word_default_number_5, R.string.word_default_number_6, R.string.word_default_number_7, R.string.word_default_number_8, R.string.word_default_number_9, R.string.word_default_number_10};
    int[] miwokIdList = {R.string.word_miwok_number_1, R.string.word_miwok_number_2, R.string.word_miwok_number_3, R.string.word_miwok_number_4, R.string.word_miwok_number_5, R.string.word_miwok_number_6, R.string.word_miwok_number_7, R.string.word_miwok_number_8, R.string.word_miwok_number_9, R.string.word_miwok_number_10};
    int[] imageIdList = {R.drawable.number_one, R.drawable.number_two, R.drawable.number_three, R.drawable.number_four, R.drawable.number_five, R.drawable.number_six, R.drawable.number_seven, R.drawable.number_eight, R.drawable.number_nine, R.drawable.number_ten};
    int[] soundIdList = {R.raw.number_one, R.raw.number_two, R.raw.number_three, R.raw.number_four, R.raw.number_five, R.raw.number_six, R.raw.number_seven, R.raw.number_eight, R.raw.number_nine, R.raw.number_ten};
    int colorId = R.color.category_numbers;

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
        Log.v("NumbersActivity", "@onCreate");
    }
}
