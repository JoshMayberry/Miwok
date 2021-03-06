package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FamilyActivity extends AppCompatActivity {
    int[] defaultIdList = {R.string.word_default_family_1, R.string.word_default_family_2, R.string.word_default_family_3, R.string.word_default_family_4, R.string.word_default_family_5, R.string.word_default_family_6, R.string.word_default_family_7, R.string.word_default_family_8, R.string.word_default_family_9, R.string.word_default_family_10};
    int[] miwokIdList = {R.string.word_miwok_family_1, R.string.word_miwok_family_2, R.string.word_miwok_family_3, R.string.word_miwok_family_4, R.string.word_miwok_family_5, R.string.word_miwok_family_6, R.string.word_miwok_family_7, R.string.word_miwok_family_8, R.string.word_miwok_family_9, R.string.word_miwok_family_10};
    int[] imageIdList = {R.drawable.family_father, R.drawable.family_mother, R.drawable.family_son, R.drawable.family_daughter, R.drawable.family_older_brother, R.drawable.family_younger_brother, R.drawable.family_older_sister, R.drawable.family_younger_sister, R.drawable.family_grandmother, R.drawable.family_grandfather};
    int[] soundIdList = {R.raw.family_father, R.raw.family_mother, R.raw.family_son, R.raw.family_daughter, R.raw.family_older_brother, R.raw.family_younger_brother, R.raw.family_older_sister, R.raw.family_younger_sister, R.raw.family_grandmother, R.raw.family_grandfather};
    int colorId = R.color.category_family;

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
