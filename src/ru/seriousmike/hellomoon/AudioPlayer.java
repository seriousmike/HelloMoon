package ru.seriousmike.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class AudioPlayer {
	
	private final static String TAG = "ru.seriousmike.com.APlogs";
	private boolean mPaused = false;

	private MediaPlayer mPlayer;
	
	public void onCreate() {
		Log.d(TAG,"mp created");
	}
	
	public void stop() {
		Log.d(TAG, "mp stop initiated");
		if(mPlayer!=null) {
			Log.d(TAG, "mp stop running player");
			mPlayer.release();
			mPlayer = null;
		}
	}
	
	public void play(Context c) {
		if(!mPaused) {
			stop();
			
			mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
		
			mPlayer.setOnCompletionListener( new MediaPlayer.OnCompletionListener() {
				public void onCompletion(MediaPlayer mp) {
					Log.d(TAG, "mp complete playing");
					stop();
				}
			} );
		}
		mPaused = false;
		mPlayer.start();
		Log.d(TAG, "mp playing");
	}
	
	public void pause() {
		Log.d(TAG, "mp paused");
		mPaused = true;
		mPlayer.pause();
	}
		
	
}
