package com.shabiruzzaman_shiam.city_guide.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shabiruzzaman_shiam.city_guide.HelperClass.SliderAdepter;
import com.shabiruzzaman_shiam.city_guide.R;


public class Onboard extends AppCompatActivity {

    ViewPager viewPager;
   LinearLayout dot_layout;

   SliderAdepter sliderAdepter;
   TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard);

        viewPager = findViewById(R.id.slider);
        dot_layout = findViewById(R.id.dots);


        sliderAdepter = new SliderAdepter(this);

        viewPager.setAdapter(sliderAdepter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);

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
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}
