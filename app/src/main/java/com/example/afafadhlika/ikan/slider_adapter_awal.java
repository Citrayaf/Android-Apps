package com.example.afafadhlika.ikan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class slider_adapter_awal extends PagerAdapter {


    Context context;
    LayoutInflater layoutInflater;

    public slider_adapter_awal (Context context) {

        this.context=context;
    }

    public int[] slide_images={
            R.drawable.get_started,
            R.drawable.beri_pakan,
            R.drawable.grafik,
            R.drawable.manage_tambak,
            R.drawable.panen
    };

    public String[] slide_headings = {
            "Get Started",
            "Beri Pakan",
            "Grafik",
            "Atur Pakan",
            "Panen"
    };

    public String[] slide_desc={
            "Kali pertama menggunakan aplikasi ini? Yuk ikuti pengenalan singkat berikut ini.",
            "Anda dapat merekap pemberian pakan Anda, serta AI dari kita akan membantu Anda untuk pemberian pakan yang tepat",
            "Lihat grafik pengularaan dan pendapatan Anda disini, jangan lupa untuk selalu mengeceknya",
            "Atur pakan dari tambak Anda, sehingga dapat membantu AI kamu dalam menghitung keuntungan maksimal untuk Anda",
            "Simpan data panen Anda disini, sehingga AI kami dapat terus belajar untuk kebutuhan panen  yang maksimal"
    };

    @Override
    public int getCount() {

        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position)
    {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_awal_isi, container, false);

        ImageView slideimageview = (ImageView) view.findViewById(R.id.slide_gambar);
        TextView slideheading = (TextView) view.findViewById(R.id.slide_heading1);
        TextView slidedesc = (TextView) view.findViewById(R.id.slide_content1);


        slideimageview.setImageResource(slide_images[position]);
        slideheading.setText(slide_headings[position]);
        slidedesc.setText(slide_desc[position]);



        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){

        container.removeView((RelativeLayout)object);
    }

}
