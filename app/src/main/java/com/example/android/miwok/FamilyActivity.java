package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FamilyActivity extends AppCompatActivity {
    int[] defaultIdList = {R.string.word_default_family_1, R.string.word_default_family_2, R.string.word_default_family_3, R.string.word_default_family_4, R.string.word_default_family_5, R.string.word_default_family_6, R.string.word_default_family_7, R.string.word_default_family_8, R.string.word_default_family_9, R.string.word_default_family_10};
    int[] miwokIdList = {R.string.word_miwok_family_1, R.string.word_miwok_family_2, R.string.word_miwok_family_3, R.string.word_miwok_family_4, R.string.word_miwok_family_5, R.string.word_miwok_family_6, R.string.word_miwok_family_7, R.string.word_miwok_family_8, R.string.word_miwok_family_9, R.string.word_miwok_family_10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        WordGenerator.populateView(this, defaultIdList, miwokIdList);
    }
}
