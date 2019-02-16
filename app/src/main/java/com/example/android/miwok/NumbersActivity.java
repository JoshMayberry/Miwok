package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NumbersActivity extends AppCompatActivity {
    int[] defaultIdList = {R.string.word_default_number_1, R.string.word_default_number_2, R.string.word_default_number_3, R.string.word_default_number_4, R.string.word_default_number_5, R.string.word_default_number_6, R.string.word_default_number_7, R.string.word_default_number_8, R.string.word_default_number_9, R.string.word_default_number_10};
    int[] miwokIdList = {R.string.word_miwok_number_1, R.string.word_miwok_number_2, R.string.word_miwok_number_3, R.string.word_miwok_number_4, R.string.word_miwok_number_5, R.string.word_miwok_number_6, R.string.word_miwok_number_7, R.string.word_miwok_number_8, R.string.word_miwok_number_9, R.string.word_miwok_number_10};
    int[] imageIdList = {R.drawable.number_one, R.drawable.number_two, R.drawable.number_three, R.drawable.number_four, R.drawable.number_five, R.drawable.number_six, R.drawable.number_seven, R.drawable.number_eight, R.drawable.number_nine, R.drawable.number_ten};
    int[] soundIdList = {R.raw.number_one, R.raw.number_two, R.raw.number_three, R.raw.number_four, R.raw.number_five, R.raw.number_six, R.raw.number_seven, R.raw.number_eight, R.raw.number_nine, R.raw.number_ten};

    private WordGenerator mWordGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        mWordGenerator = new WordGenerator(this)
                .setDefaultIdList(defaultIdList)
                .setMiwokIdList(miwokIdList)
                .setImageIdList(imageIdList)
                .setColorId(R.color.category_numbers)
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
