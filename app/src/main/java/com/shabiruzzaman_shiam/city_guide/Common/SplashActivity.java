package com.shabiruzzaman_shiam.city_guide.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.shabiruzzaman_shiam.city_guide.R;
import com.shabiruzzaman_shiam.city_guide.User.UserDashboard;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;

    Animation topAnim;
    Animation bottomAnim;
    ImageView up,down;
    TextView welcomet;
    SharedPreferences onBoardScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_activity);


        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        up = findViewById(R.id.upsplash);
        down = findViewById(R.id.downsplash);

        welcomet = findViewById(R.id.welcome);

        up.setAnimation(topAnim);
        welcomet.setAnimation(topAnim);
        down.setAnimation(bottomAnim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                onBoardScreen = getSharedPreferences("onBoardScreen",MODE_PRIVATE);
                boolean isFirstTime = onBoardScreen.getBoolean("fisrtTime",true);
                if(isFirstTime) {


                    SharedPreferences.Editor editor = onBoardScreen.edit();
                    editor.putBoolean("fisrtTime",false);
                    editor.commit();

                    Intent intent = new Intent(SplashActivity.this, Onboard.class);

                    startActivity(intent);
                    finish();



                }else {
                    Intent intent = new Intent(SplashActivity.this, UserDashboard.class);

                    startActivity(intent);
                    finish();


                }


            }
        },SPLASH_SCREEN);



    }
}
