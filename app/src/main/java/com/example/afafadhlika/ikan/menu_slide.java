package com.example.afafadhlika.ikan;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.afafadhlika.ikan.Model.Data;
import com.example.afafadhlika.ikan.Model.Dataa;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class menu_slide extends AppCompatActivity implements View.OnClickListener{

    private ViewPager mslide;
    private LinearLayout mdots;

    private TextView[] mDOTS;

    private slideradapter sliderAdapter;
/*
    private Button mkanan;
    private Button mkiri;*/

    private int mcurrent;
    public String na;
    Data dt = new Data();

    Dataa ds = new Dataa();
    public int hit=0;String h;
    private DatabaseReference mDatabase;
    public void adddotsindicator(int position){
        mDOTS=new TextView[3];
        mdots.removeAllViews();

        for (int i = 0; i<mDOTS.length; i++){
            mDOTS[i]=new TextView(this);
            mDOTS[i].setText(Html.fromHtml("&#8226;"));
            mDOTS[i].setTextSize(35);
            mDOTS[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            ds.setPos(i);
            mdots.addView(mDOTS[i]);
        }

        mDOTS[position].setTextColor(getResources().getColor(R.color.colorWhite));

    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            adddotsindicator(i);
            mcurrent=i;

            /*if(i == 0){
                mkanan.setEnabled(true);
                mkiri.setEnabled(false);
                mkiri.setVisibility(View.INVISIBLE);

                mkanan.setText("NEXT");
                mkiri.setText("");
            } else if (i == mDOTS.length-1) {
                mkanan.setEnabled(true);
                mkiri.setEnabled(true);
                mkiri.setVisibility(View.VISIBLE);

                mkanan.setText("FINISH");
                mkiri.setText("BACK");
            } else {
                mkanan.setEnabled(true);
                mkiri.setEnabled(true);
                mkiri.setVisibility(View.VISIBLE);

                mkanan.setText("NEXT");
                mkiri.setText("BACK");
            }*/

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_regis_pakan:
                Intent bregis;
                bregis = new Intent(this, regis.class);
                this.startActivity(bregis);
                break;
            case R.id.btn_beri_pakan:
                Intent bpakan= new Intent(this,bermakan.class);
                this.startActivity(bpakan);
                break;
            case R.id.btn_grafik:
                Intent bgraf= new Intent(this,gruff.class);
                this.startActivity(bgraf);
                break;
            case R.id.btn_panen:
                Intent bpan= new Intent(this,panen.class);
                this.startActivity(bpan);
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayik_main_menu);

        mslide = (ViewPager) findViewById(R.id.slideview);
        mdots = (LinearLayout) findViewById(R.id.dots);

       /* mkanan=(Button) findViewById(R.id.buttonkanan);
        mkiri=(Button) findViewById(R.id.buttonkiri);*/




        sliderAdapter = new slideradapter(menu_slide.this,slideradapter.class);

        mslide.setAdapter(sliderAdapter);

        int x=ds.getPos();
        if (x==0){
            mDatabase = FirebaseDatabase.getInstance().getReference().child("Tambak");
            final Button sett = (Button) findViewById(R.id.btn_current_tambak1);
            TextView textme = (TextView) findViewById(R.id.main_menu_heading);
            Button mreg = (Button) findViewById(R.id.btn_regis_pakan);
            Button mber = (Button) findViewById(R.id.btn_beri_pakan);
            Button mgraf = (Button) findViewById(R.id.btn_grafik);
            Button mpa = (Button) findViewById(R.id.btn_panen);
            sett.setOnClickListener(this);
            mreg.setOnClickListener(this);
            mber.setOnClickListener(this);
            mgraf.setOnClickListener(this);
            mpa.setOnClickListener(this);
            mDatabase.child("1").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        dt.setNoTambak(dataSnapshot.getKey());

                        Toast.makeText(getBaseContext()," "+dt.getNoTambak(),Toast.LENGTH_LONG).show();
                        //hit=Integer.parseInt(dt.getNoTambak());
                        hit=1;
                        sett.setVisibility(View.INVISIBLE);
                        sett.setEnabled(false);
                    }
                    else{
                        sett.setVisibility(View.VISIBLE);
                        sett.setEnabled(true);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
        else if (x==1){
            mDatabase = FirebaseDatabase.getInstance().getReference().child("Tambak");
            final Button sett = (Button) findViewById(R.id.btn_current_tambak1);
            TextView textme = (TextView) findViewById(R.id.main_menu_heading);
            Button mreg = (Button) findViewById(R.id.btn_regis_pakan);
            Button mber = (Button) findViewById(R.id.btn_beri_pakan);
            Button mgraf = (Button) findViewById(R.id.btn_grafik);
            Button mpa = (Button) findViewById(R.id.btn_panen);
            sett.setOnClickListener(this);
            mreg.setOnClickListener(this);
            mber.setOnClickListener(this);
            mgraf.setOnClickListener(this);
            mpa.setOnClickListener(this);
            mDatabase.child("3").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        dt.setNoTambak(dataSnapshot.getKey());

                        Toast.makeText(getBaseContext()," "+dt.getNoTambak(),Toast.LENGTH_LONG).show();
                        //hit=Integer.parseInt(dt.getNoTambak());
                        hit=1;
                        sett.setVisibility(View.INVISIBLE);
                        sett.setEnabled(false);
                    }
                    else{
                        sett.setVisibility(View.VISIBLE);
                        sett.setEnabled(true);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
        else if (x==2){
            mDatabase = FirebaseDatabase.getInstance().getReference().child("Tambak");
            final Button sett = (Button) findViewById(R.id.btn_current_tambak1);
            TextView textme = (TextView) findViewById(R.id.main_menu_heading);
            Button mreg = (Button) findViewById(R.id.btn_regis_pakan);
            Button mber = (Button) findViewById(R.id.btn_beri_pakan);
            Button mgraf = (Button) findViewById(R.id.btn_grafik);
            Button mpa = (Button) findViewById(R.id.btn_panen);
            sett.setOnClickListener(this);
            mreg.setOnClickListener(this);
            mber.setOnClickListener(this);
            mgraf.setOnClickListener(this);
            mpa.setOnClickListener(this);
            mDatabase.child("3").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists()){
                        dt.setNoTambak(dataSnapshot.getKey());

                        Toast.makeText(getBaseContext()," "+dt.getNoTambak(),Toast.LENGTH_LONG).show();
                        //hit=Integer.parseInt(dt.getNoTambak());
                        hit=1;
                        sett.setVisibility(View.INVISIBLE);
                        sett.setEnabled(false);
                    }
                    else{
                        sett.setVisibility(View.VISIBLE);
                        sett.setEnabled(true);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }

        adddotsindicator(0);


        mslide.addOnPageChangeListener(viewListener);


      /*  mkanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mslide.setCurrentItem(mcurrent+1);
            }
        });

        mkiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mslide.setCurrentItem(mcurrent-1);
            }
        });*/

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("Tambak").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    /*
                    classmodel obj = dataSnapshot.getValue(classmodel.class);*/
//
//                    Data obj = dataSnapshot.getValue(Data.class);
//
//                    dt.setNama(obj.getNoTambak());
                    //na = dt.getNoTambak();
                    //textme.setText(obj.getNoTambak());

                    //namaa = obj.getNoTambak();
                    /*blabla.setText(obj.getNama());
                     */
                    //dt.setNama(namaa);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
