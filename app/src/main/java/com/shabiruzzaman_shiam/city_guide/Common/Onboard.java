package com.shabiruzzaman_shiam.city_guide.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shabiruzzaman_shiam.city_guide.HelperClass.SliderAdepter;
import com.shabiruzzaman_shiam.city_guide.R;
import com.shabiruzzaman_shiam.city_guide.User.UserDashboard;


public class Onboard extends AppCompatActivity {

    ViewPager viewPager;
   LinearLayout dot_layout;

   SliderAdepter sliderAdepter;
   TextView[] dots;
   Button letsGetStarted;
   Animation animation;
   int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_onboard);

        viewPager = findViewById(R.id.slider);
        dot_layout = findViewById(R.id.dots);
        letsGetStarted = findViewById(R.id.get_started_btn);



        sliderAdepter = new SliderAdepter(this);

        viewPager.setAdapter(sliderAdepter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);

    }
    public void skip(View view){
        startActivity(new Intent(this, UserDashboard.class));
        finish();

    }
    public void next(View view){

        viewPager.setCurrentItem(currentPos + 1);
    }

    private void addDots(int position){

        dots = new TextView[4];
        dot_layout.removeAllViews();

        for (int i=0; i<dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);

            dot_layout.addView(dots[i]);

        }

        if(dots.length > 0){
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);

            currentPos = position;

            if(position == 0){
                letsGetStarted.setVisibility(View.INVISIBLE);

            }else if(position == 1)
            {
                letsGetStarted.setVisibility(View.INVISIBLE);

            }else if(position == 2)
            {
                letsGetStarted.setVisibility(View.INVISIBLE);

            }else{
                animation = AnimationUtils.loadAnimation(Onboard.this,R.anim.bottom_animation);
                letsGetStarted.setAnimation(animation);
                letsGetStarted.setVisibility(View.VISIBLE);

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}
