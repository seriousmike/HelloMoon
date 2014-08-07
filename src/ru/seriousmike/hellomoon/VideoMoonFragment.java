package ru.seriousmike.hellomoon;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

public class VideoMoonFragment extends Fragment {
	
	private Button mPlayMovie;
	private VideoView mVideoPlayer;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_video_moon, parent, false);
		
		mVideoPlayer = new VideoView( getActivity() );
		
		mPlayMovie = (Button) v.findViewById(R.id.btnVideoPlay);
		mPlayMovie.setOnClickListener( new View.OnClickListener() {
			@Override 
			public void onClick(View v) {
				Uri uri = Uri.parse("android:resource://ru.seriousmike.hellomoon/raw/apollo_17_stroll");
				mVideoPlayer.setVideoURI(uri);
				mVideoPlayer.start();
			}
		} );
		
		
		
		return v;
	}
	
}
