package com.example.afafadhlika.ikan;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.TextView;
import android.widget.Toast;

import com.example.afafadhlika.ikan.Model.Data;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

import static com.example.afafadhlika.ikan.R.id.totalmakanan;

public class gruff extends Activity {
    private DatabaseReference mDatabase;
    int hit,jumpakan;String h,nam;
    LineChart churt;
    Data dt = new Data();
    int[] angka = new int[120];
    int j=0,k=0,l=0,pakanperhari=0;
    String[] tanggal=new String[120];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayik_grafik);
        churt=(LineChart) findViewById(R.id.grafik);
        final TextView totalmakanan = (TextView) findViewById(R.id.totalmakanan);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Perlakuan");
        mDatabase.child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    //dt.setTanggal(dataSnapshot.getChildren().toString());
                    for(DataSnapshot ds : dataSnapshot.getChildren()) {
                        String address = ds.getKey();
                        //hit=Integer.parseInt(address);
                        tanggal[k]=address;
                        //jumpakan=jumpakan+hit;
                        k++;
                        //Toast.makeText(getBaseContext()," "+tanggal[0],Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    hit = 0;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Perlakuan");//.child("1");
        //String tanggal=dt.getTanggal();



            //j=0;
            mDatabase.child("1").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    //Toast.makeText(getBaseContext()," "+tanggal[l],Toast.LENGTH_LONG).show();

                    if (dataSnapshot.exists()) {
                        j=0;


                        Data obj = dataSnapshot.getValue(Data.class);

                        dt.setNoTambak(obj.getNoTambak());
                        dt.setJenisIkan(obj.getJenisIkan());
                        //h=dt.getPemberian();
                        //hit = Integer.parseInt(h);
                        for(l=0;l<=k;l++) {
                            pakanperhari=0;

                            for (DataSnapshot ds : dataSnapshot.child("" + tanggal[l]).getChildren()) {
                                String address = ds.getValue(String.class);
                                hit = Integer.parseInt(address);
                                //angka[j] = hit;
                                pakanperhari=pakanperhari+hit;
                                jumpakan = jumpakan + hit;
                                j++;

                                //Toast.makeText(getBaseContext()," "+jumpakan,Toast.LENGTH_LONG).show();
                            }
                            angka[l]=pakanperhari;
                        }

                        //BATASSSSSSSS
                        totalmakanan.setText(Integer.toString(jumpakan)+" Kg");
                        ArrayList<String> xAXES= new ArrayList<>();
                        ArrayList<Entry> yaxessin= new ArrayList<>();
                        double x=0;
                        int numdata=120;
                        for(int i=0;i<numdata;i++){
                            x=x+0.1;
                            yaxessin.add(new Entry(i,angka[i]));
                            xAXES.add(i,String.valueOf(x));
                        }
                        String[] xax=new String[xAXES.size()];
                        for(int i=0;i<xAXES.size();i++){
                            xax[i]=xAXES.get(i).toString();
                        }


                        ArrayList<ILineDataSet> lineDataSets=new ArrayList<>();
                        LineDataSet lineDataSet2= new LineDataSet(yaxessin,"Pakan Perhari");
                        lineDataSet2.setDrawCircles(false);
                        lineDataSet2.setColor(Color.RED);
                        lineDataSets.add(lineDataSet2);
                        churt.setData(new LineData(lineDataSets));
                        churt.setVisibleXRangeMaximum(65f);
                        churt.setTouchEnabled(true);
                        churt.setDragEnabled(true);
                    }
                    else{
                        hit = 0;
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
   // }
}
