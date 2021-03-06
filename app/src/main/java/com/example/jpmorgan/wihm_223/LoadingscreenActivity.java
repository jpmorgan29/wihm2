package com.example.jpmorgan.wihm_223;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class LoadingscreenActivity extends AppCompatActivity {
    private GifImageView gifImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_loadingscreen);


        gifImageView = (GifImageView) findViewById(R.id.gifImageView);

        //Set GIFImageView Resource

        try{

            InputStream inputStream = getAssets().open("hb.gif");
            byte bytes[] = IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }
        catch(IOException ex){

        }

        //Wacht 4 seconden
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                LoadingscreenActivity.this.startActivity(new Intent(LoadingscreenActivity.this, MainActivity.class));
                LoadingscreenActivity.this.finish();
            }
        },4000);

    }
}
