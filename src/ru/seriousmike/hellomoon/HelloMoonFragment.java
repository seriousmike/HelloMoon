package ru.seriousmike.hellomoon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HelloMoonFragment extends Fragment {
	
	private AudioPlayer mPlayer = new AudioPlayer();
	private Button mPlayButton;
	private Button mStopButton;
	private Button mPauseButton;
	private Button mMovieButton;

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_hello_moon,  parent, false);
		
		mPlayButton = (Button) v.findViewById(R.id.hellomoon_playButton);
		
		mPlayButton.setOnClickListener( new View.OnClickListener() {
			public void onClick(View v) {
				mPlayer.play(getActivity());
			}
		});
		
		mStopButton = (Button) v.findViewById(R.id.hellomon_stopButton);
		
		mStopButton.setOnClickListener( new View.OnClickListener() {
			public void onClick(View v) {
				mPlayer.stop();
			}
		});
		
		mPauseButton = (Button) v.findViewById(R.id.hellomoon_pauseButton);
		
		mPauseButton.setOnClickListener( new View.OnClickListener() {
			public void onClick(View v) {
				mPlayer.pause();
			}
		} );
		
		
		mMovieButton = (Button) v.findViewById(R.id.hellomoon_movie);
		mMovieButton.setOnClickListener( new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), VideoMoonActivity.class);
				startActivity(intent);
			}
		} );
		
		return v;
	}
	
	@Override 
	public void onDestroy() {
		super.onDestroy();
		mPlayer.stop();
	}

}