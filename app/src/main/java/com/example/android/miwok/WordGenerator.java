package com.example.android.miwok;

import android.app.Fragment;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

class WordGenerator {
    private int[] mDefaultIdList;
    private int[] mMiwokIdList;
    private int[] mSoundIdList;
    private int[] mImageIdList;
    private int mColorId;

    private WordFragment mFragment;
    private AppCompatActivity mActivity;
    private AudioManager mAudioManager;
    private MediaPlayer mMediaPlayer;

    WordGenerator(WordFragment fragment, AppCompatActivity activity) {
        //Use: https://developer.android.com/guide/topics/media-apps/audio-focus#audio_focus_pre-android_80
        mAudioManager = (AudioManager) activity.getSystemService(Context.AUDIO_SERVICE);
        mActivity = activity;
        mFragment = fragment;
    }

    WordGenerator setDefaultIdList(int[] textId) {
        this.mDefaultIdList = textId;
        return this;
    }

    WordGenerator setMiwokIdList(int[] textId) {
        this.mMiwokIdList = textId;
        return this;
    }

    WordGenerator setSoundIdList(int[] soundId) {
        this.mSoundIdList = soundId;
        return this;
    }

    WordGenerator setImageIdList(int[] imageId) {
        this.mImageIdList = imageId;
        return this;
    }

    WordGenerator setColorId(int colorId) {
        this.mColorId = colorId;
        return this;
    }

    void populateView(ListView rootView) {
        //Populate Words
        final ArrayList<Word> words = new ArrayList<>();
        for (int i = 0; i < mDefaultIdList.length; i++) {
            Word newWord = new Word(mActivity)
                    .setDefaultTranslation(mDefaultIdList[i])
                    .setMiwokTranslation(mMiwokIdList[i])
                    .setSoundId(mSoundIdList[i]);
            if (mImageIdList.length != 0) {
                newWord.setImageId(mImageIdList[i]);
            }
            words.add(newWord);
        }

        //Apply Words
        ListView listView = (ListView) rootView.findViewById(R.id.rootView);
        listView.setAdapter(new WordAdapter(mActivity, words, mColorId));

        //Apply Audio
        releaseMediaPlayer();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long index) {
                if (requestAudioService()) {
                    //See: https://developer.android.com/guide/topics/media/mediaplayer#mediaplayer
                    //See: https://www.101apps.co.za/index.php/articles/all-about-using-android-s-context-class.html
                    mMediaPlayer = MediaPlayer.create(mActivity.getApplication(), words.get(position).getSoundId());
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mMediaCompletionListener);
                }
            }
        });
    }

    private MediaPlayer.OnCompletionListener mMediaCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    //Use: https://developer.android.com/guide/topics/media-apps/audio-focus#audio-focus-change
    //See: https://developer.android.com/reference/android/media/AudioManager.OnAudioFocusChangeListener
    //See: https://medium.com/google-developers/how-to-properly-handle-audio-interruptions-3a13540d18fa
    private AudioManager.OnAudioFocusChangeListener mAudioManagerChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    switch (focusChange) {
                        //See: https://stackoverflow.com/questions/5086322/java-switch-statement-multiple-cases/5277741#5277741
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                            mMediaPlayer.pause();
                            mMediaPlayer.seekTo(0);
                            break;
                        case AudioManager.AUDIOFOCUS_GAIN:
                            mMediaPlayer.start();
                            break;
                        case AudioManager.AUDIOFOCUS_LOSS:
                            releaseMediaPlayer();
                            break;
                    }
                }
            };

    void releaseMediaPlayer() {
        if (mMediaPlayer == null) {
            return;
        }
        mMediaPlayer.release();
        mMediaPlayer = null;

        //Use: https://developer.android.com/guide/topics/media-apps/audio-focus#audio_focus_pre-android_80
        mAudioManager.abandonAudioFocus(mAudioManagerChangeListener);
    }

    boolean requestAudioService() {
        //Use: https://developer.android.com/guide/topics/media-apps/audio-focus#audio_focus_pre-android_80
        return mAudioManager.requestAudioFocus(mAudioManagerChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT) == AudioManager.AUDIOFOCUS_REQUEST_GRANTED;
    }
}

