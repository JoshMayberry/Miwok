package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    int[] defaultIdList = {R.string.word_default_number_1, R.string.word_default_number_2, R.string.word_default_number_3, R.string.word_default_number_4, R.string.word_default_number_5, R.string.word_default_number_6, R.string.word_default_number_7, R.string.word_default_number_8, R.string.word_default_number_9, R.string.word_default_number_10};
    int[] miwokIdList = {R.string.word_miwok_number_1, R.string.word_miwok_number_2, R.string.word_miwok_number_3, R.string.word_miwok_number_4, R.string.word_miwok_number_5, R.string.word_miwok_number_6, R.string.word_miwok_number_7, R.string.word_miwok_number_8, R.string.word_miwok_number_9, R.string.word_miwok_number_10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        WordGenerator.populateView(this, R.id.rootNumbers, defaultIdList, miwokIdList);
    }
}
