package ru.seriousmike.hellomoon;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoMoonFragment extends Fragment {
	
	private VideoView mVideoPlayer;
	private MediaController mMediaController;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_video_moon, parent, false);
		
		mVideoPlayer = (VideoView) v.findViewById(R.id.videoView);
		
		mMediaController = new MediaController( getActivity() );
		mMediaController.setAnchorView( mVideoPlayer );
		mVideoPlayer.setMediaController( mMediaController );
		
		Uri uri = Uri.parse("android.resource://ru.seriousmike.hellomoon/"+R.raw.videoviewdemo);
		mVideoPlayer.setVideoURI(uri);
		
		mVideoPlayer.start();
		
		return v;
	}
	
}
