package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;

    public Word(String defaultTranslation, String miwokTranslation) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
    }

    public Word(AppCompatActivity activity, int defaultTranslationId, int miwokTranslationId) {
        this.mDefaultTranslation = activity.getResources().getString(defaultTranslationId);
        this.mMiwokTranslation = activity.getResources().getString(miwokTranslationId);
    }

    public String getDefaultTranslation() {
        return this.mDefaultTranslation;
    }
    public String getMiwokTranslation() {
        return this.mMiwokTranslation;
    }

    public void setDefaultTranslation(String translation) {
        this.mDefaultTranslation = translation;
    }
    public void setMiwokTranslation(String translation) {
        this.mMiwokTranslation = translation;
    }
}
