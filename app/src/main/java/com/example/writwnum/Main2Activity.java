package com.example.writwnum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    static boolean isPlay=true;
    MediaPlayer mediaPlayer;
    Button music_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        music_btn=(Button)findViewById(R.id.btn_music);
        PlayMusic();
    }
    public void onAbout(View view){
        startActivity(new Intent(Main2Activity.this,AboutActivity.class));
    }
    public void onPlay(View view){ startActivity(new Intent(Main2Activity.this,SelectActivity.class));
    }
    public void onMusic(View view){
        if(isPlay){
            mediaPlayer.stop();
            music_btn.setBackgroundResource(R.mipmap.btn_music2);
            isPlay=false;
        }
        else{
            PlayMusic();
            music_btn.setBackgroundResource(R.mipmap.btn_music1);
            isPlay=true;
        }
    }
    public void PlayMusic(){
        mediaPlayer = MediaPlayer.create(Main2Activity.this, R.raw.main_music);
        mediaPlayer.setLooping(true);
        try{
            mediaPlayer.prepare();
        }catch (Exception e){
            e.printStackTrace();
        }
        mediaPlayer.start();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
    @Override
    protected void onStop(){
        super.onStop();
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        if(isPlay==true){
            PlayMusic();
        }
    }
}
