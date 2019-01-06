package com.example.dmv.media_player;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends AppCompatActivity  {
    private SeekBar seekBar;
    double starttime =0;
    double endtime = 0;
    int fortime = 20000;
    int backtime= 20000;
    int filed;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(MainActivity.this, R.raw.song); }

    public void play(View view)
    {
        starttime = mp.getDuration();
        endtime = mp.getCurrentPosition();
        mp.start();
        Toast.makeText(getApplication(), "play", Toast.LENGTH_LONG).show();
    }

    public void pause(View view)
    {
        mp.pause();
    }

    public void next( View view)
    {
        int temp =(int)starttime;
        if(temp + fortime <= endtime )
        {
          starttime = starttime + fortime;
        }
            mp.seekTo((int)starttime);
            Toast.makeText(getApplication(), "forward by 20 sec", Toast.LENGTH_LONG).show();


    }

    public void previous(View view)
    {
        int temp = (int)starttime;
        if(temp - backtime >0)
        {
            starttime = starttime - backtime;}
            mp.seekTo((int)starttime);
            Toast.makeText(getApplication(), "backward by 20 sec", Toast.LENGTH_LONG).show();


    }

}

