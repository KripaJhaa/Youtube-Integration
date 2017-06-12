package com.example.kripashankarjha.yout;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Config;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import static android.provider.MediaStore.Video.Thumbnails.VIDEO_ID;

public class you extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;
    public  String YOUTUBE_API_KEY = "AIzaSyAydKjPqb2sKwfCTY7Trf-dz0gF9i3NcCs";
    public static  String VIDEO_ID = "bzSTpdcs-EI";
    public  static  YouTubePlayer yplayer;
    private ListView lv;
    public String videourl[]={"bzSTpdcs-EI","lpdRqn6xwiM"};
    public String videoDetail[]={"Channa Mereya...","Aye dil hai muskil..."};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you);

        lv= (ListView) findViewById(R.id.list);
        lv.setAdapter(new customAdapter(this,videourl,videoDetail));
        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(),"posi "+position+" url -> "+videourl[position],Toast.LENGTH_LONG).show();
                VIDEO_ID = videourl[position];
                yplayer.cueVideo(VIDEO_ID);

            }
        });
        youTubeView.initialize(YOUTUBE_API_KEY, you.this);



    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if (!wasRestored) {
            yplayer=youTubePlayer;
            youTubePlayer.cueVideo(VIDEO_ID); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(YOUTUBE_API_KEY, this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return youTubeView;
    }





}


