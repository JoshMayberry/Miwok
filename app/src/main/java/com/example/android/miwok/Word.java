package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String defaultTranslation, String miwokTranslation) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageId) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.mImageId = imageId;
    }

    public Word(AppCompatActivity activity, int defaultTranslationId, int miwokTranslationId) {
        this.mDefaultTranslation = activity.getResources().getString(defaultTranslationId);
        this.mMiwokTranslation = activity.getResources().getString(miwokTranslationId);
    }

    public Word(AppCompatActivity activity, int defaultTranslationId, int miwokTranslationId, int imageId) {
        this.mDefaultTranslation = activity.getResources().getString(defaultTranslationId);
        this.mMiwokTranslation = activity.getResources().getString(miwokTranslationId);
        this.mImageId = imageId;
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

    public void setImageId(int imageId) {
        this.mImageId = imageId;
    }

    public int getImageId() {
        return this.mImageId;
    }

    public boolean hasImage() {
        return this.mImageId != NO_IMAGE_PROVIDED;
    }
}

