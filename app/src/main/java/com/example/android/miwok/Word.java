package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;

class Word {
    private AppCompatActivity mActivity;
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mSoundId;
    private int mImageId = NO_IMAGE_PROVIDED;
    public static final int NO_IMAGE_PROVIDED = -1;

    Word(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mActivity=" + mActivity +
                ", mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mSoundId=" + mSoundId +
                ", mImageId=" + mImageId +
                '}';
    }

    //Setters
    Word setDefaultTranslation(String translation) {
        this.mDefaultTranslation = translation;
        return this;
    }

    Word setDefaultTranslation(int textId) {
        return setDefaultTranslation(mActivity.getString(textId));
    }

    Word setMiwokTranslation(String translation) {
        this.mMiwokTranslation = translation;
        return this;
    }

    Word setMiwokTranslation(int textId) {
        return setMiwokTranslation(mActivity.getString(textId));
    }

    Word setImageId(int imageId) {
        this.mImageId = imageId;
        return this;
    }

    Word setSoundId(int soundId) {
        this.mSoundId = soundId;
        return this;
    }

    //Getters
    String getDefaultTranslation() {
        return this.mDefaultTranslation;
    }

    String getMiwokTranslation() {
        return this.mMiwokTranslation;
    }

    int getImageId() {
        return this.mImageId;
    }

    int getSoundId() {
        return this.mSoundId;
    }

    boolean hasImage() {
        return this.mImageId != NO_IMAGE_PROVIDED;
    }
}

