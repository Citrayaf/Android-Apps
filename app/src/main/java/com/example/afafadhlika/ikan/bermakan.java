package com.example.afafadhlika.ikan;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.afafadhlika.ikan.Model.Data;
import com.example.afafadhlika.ikan.Model.Dataa;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class bermakan extends Activity implements View.OnClickListener {

    private DatabaseReference mDatabase;
    Data dt = new Data();
    Dataa ds = new Dataa();
    String hit;
    int h;
    String na_tambak,je_ikan,lus_tambak,berpakan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayik_beri_pakan);


        //hit = ds.getHit();
        /* Database*/
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("Tambak").child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    //classmodel obj = dataSnapshot.getValue(classmodel.class);

                    ;
                    hit = dataSnapshot.getKey();
                    ds.setHit(hit);
                    Data obj = dataSnapshot.getValue(Data.class);
//
                    dt.setNoTambak(obj.getNoTambak());
                    dt.setJenisIkan(obj.getJenisIkan());

                    //blabla.setText(obj.getNama());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Button bberi=(Button) findViewById(R.id.barum);
        bberi.setOnClickListener(this);


        /* Tambak1.setText(menu_tambak.na_tambak);*/
    }

    @Override
    public void onClick(View view) {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        switch(view.getId()) {
            case R.id.barum:
                final Intent bMenu= new Intent(this,menu_slide.class);
                EditText ber_pakan= (EditText) findViewById(R.id.isi);
                berpakan=ber_pakan.getText().toString();
                AlertDialog alertDialog = new AlertDialog.Builder(bermakan.this).create();
                alertDialog.setTitle("Perhatian");

                /*String dateStr = "30/04/2019";
                SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
                Date dateObj = null;
                try {
                    dateObj = curFormater.parse(dateStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                SimpleDateFormat postFormater = new SimpleDateFormat("MMMM dd, yyyy");*/

                String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                //String newDateStr = postFormater.format(dateObj);

                Toast.makeText(getBaseContext()," "+date,Toast.LENGTH_LONG).show();

                dt.setTanggal(date);
                dt.setPemberian(berpakan);

                Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+1:00"));
                Date currentLocalTime = cal.getTime();
                DateFormat dats = new SimpleDateFormat("HH:mm a");
// you can get seconds by adding  "...:ss" to it
                dats.setTimeZone(TimeZone.getTimeZone("GMT+7:00"));

                String localTime = dats.format(currentLocalTime);
                dt.setJam(localTime);
                /* Database
                dt.setPemberian(berpakan);
                //mDatabase.child("Perlakuan").child("JenisIkan").setValue(dt.getJenisIkan());//.setValue(true);
                //mDatabase.child("Perlakuan").child("NoTambak").setValue(dt.getNoTambak());//.setValue(true);
                mDatabase.child("Perlakuan").child("Pemberian").setValue(dt.getPemberian());//.setValue(true);
                //mDatabase.child("Perlakuan").child("Tanggal").child(dt.getTanggal()).setValue(true);
                */
                mDatabase.child("Perlakuan").child(dt.getNoTambak()).child(dt.getTanggal()).push().setValue(dt.getPemberian());
                //mDatabase.child("Perlakuan").child(dt.getNoTambak()).child("Pemberian").setValue(dt.getPemberian());
                //mDatabase.child("Perlakuan").child(ds.getHit()).child(dt.getTanggal()).child(dt.getJam()).setValue(dt.getTanggal());
                alertDialog.setMessage("Data pemeberian pakan Anda telah kami terima");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                startActivity(bMenu);
                            }
                        });
                alertDialog.show();
                break;
        }
    }
}
