package com.example.android.miwok;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;

    public Word(String defaultTranslation, String miwokTranslation) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
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
