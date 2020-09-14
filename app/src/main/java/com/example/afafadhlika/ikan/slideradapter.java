package com.example.afafadhlika.ikan;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.afafadhlika.ikan.Model.Data;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import static android.support.v4.content.ContextCompat.startActivity;

public class slideradapter extends PagerAdapter {

    private DatabaseReference mDatabase;
    Data dt = new Data();
    int hit; String h;

    Context context;
    LayoutInflater layoutInflater;

    menu_slide ms = new menu_slide();

    String nam;

    public slideradapter(Context context, Class<slideradapter> slideradapterClass) {

        this.context=context;
    }

   /* public int[] slide_images={
            R.drawable.nu1,
            R.drawable.nu2,
            R.drawable.nu3
    };*/

    public String[] slide_headings = {
            "TAMBAK 1",
            "TAMBAK 2",
            "TAMBAK 3"
    };

    public String[] slide_Nama={
            "Lele",
            "Patin",
            "Nila"
    };

    @Override
    public int getCount() {

        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position)
    {
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("Tambak").child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    //classmodel obj = dataSnapshot.getValue(classmodel.class);

                    //Data obj = dataSnapshot.getValue(Data.class);

//                    dt.setNamTambak(obj.getNamTambak());
//                    dt.setJenisIkan(obj.getJenisIkan());
                    //h=dt.getNoTambak();
//                    hit = Integer.parseInt(h);
//                    nam = dt.getJenisIkan();

                }
                else{
                    hit = 0;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //slide_Nama[position] = ms.na;
        //slide_Nama[hit-1] = dt.getJenisIkan();
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider, container, false);

        /*ImageView slideimageview = (ImageView) view.findViewById(R.id.imageviewnama);*/
        TextView slideheading = (TextView) view.findViewById(R.id.current_tambak_heading);
        TextView slidedesc = (TextView) view.findViewById(R.id.textheading);


        /*slideimageview.setImageResource(slide_images[position]);*/
        slideheading.setText(slide_headings[position]);
        slidedesc.setText(nam);



        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){

        container.removeView((RelativeLayout)object);
    }







}
