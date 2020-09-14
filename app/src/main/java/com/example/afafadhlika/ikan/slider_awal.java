package com.example.afafadhlika.ikan;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class slider_awal extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mslide;
    private LinearLayout mdots;

    private TextView[] mDOTS;

    private slider_adapter_awal slider_Adapter_awal;

    private Button mskip;
    private Button mgets;

    Animation bttn;

    private int mcurrent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_awal);
        mslide = (ViewPager) findViewById(R.id.slideview);
        mdots = (LinearLayout) findViewById(R.id.dots);

        mskip=(Button) findViewById(R.id.button_skippu);
        mskip.setOnClickListener(this);
        mgets=(Button) findViewById(R.id.buttonGetStarted);
        mgets.setOnClickListener(this);

        slider_Adapter_awal = new slider_adapter_awal(this);

        mslide.setAdapter(slider_Adapter_awal);

        adddotsindicator(0);

        mslide.addOnPageChangeListener(viewlistener);

        bttn= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.get_anim);



    }

    public void adddotsindicator(int position){
        mDOTS=new TextView[5];
        mdots.removeAllViews();

        for (int i = 0; i<mDOTS.length; i++){
            mDOTS[i]=new TextView(this);
            mDOTS[i].setText(Html.fromHtml("&#8226;"));
            mDOTS[i].setTextSize(35);
            mDOTS[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mdots.addView(mDOTS[i]);
        }

        if(mDOTS.length>0){
            mDOTS[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }

    }
    ViewPager.OnPageChangeListener viewlistener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            adddotsindicator(i);
            mcurrent=i;

            if (i==4){
                mgets.setEnabled(true);
                mskip.setEnabled(false);
                mskip.setVisibility(View.INVISIBLE);
                mgets.setVisibility(View.VISIBLE);
                mgets.setAnimation(bttn);
            }
            else{
                mskip.setEnabled(true);
                mgets.setEnabled(false);
                mgets.setVisibility(View.INVISIBLE);
                mskip.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonGetStarted:
                Intent mskippo=new Intent(this,menu_tambak.class);
                startActivity(mskippo);
            case R.id.button_skippu:
                mslide.setCurrentItem(4);

        }
    }
}
