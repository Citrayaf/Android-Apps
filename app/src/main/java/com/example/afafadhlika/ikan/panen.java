package com.example.afafadhlika.ikan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.afafadhlika.ikan.Model.Data;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class panen extends AppCompatActivity implements View.OnClickListener{

    private DatabaseReference mDatabase;
    Data dt = new Data();
    String ber_totikan,jum_ikan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayik_panen);

        Button panen=(Button) findViewById(R.id.btn_panen);
        panen.setOnClickListener(this);
        Button clear=(Button) findViewById(R.id.btn_clear_textfield);
        clear.setOnClickListener(this);

        mDatabase.child("Tambak").child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    Data obj = dataSnapshot.getValue(Data.class);

                    dt.setNoTambak(obj.getNoTambak());
                    dt.setJenisIkan(obj.getJenisIkan());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public void onClick (View view){
        mDatabase = FirebaseDatabase.getInstance().getReference();


        switch (view.getId()){
            case R.id.btn_panen:
                final Intent bawal = new Intent(this, menu_slide.class);
                final EditText bertot= (EditText) findViewById(R.id.berat_ikan_total_textfield);
                final EditText jumik= (EditText) findViewById(R.id.jumlah_ikan_dipanen_textfield);
                AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
                builder.setTitle("Pemberitahuan");
                builder.setMessage("Apakah Data yang Anda Masukkan Telah Sesuai?");
                builder.setCancelable(false);
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ber_totikan=bertot.getText().toString();
                        jum_ikan=jumik.getText().toString();
                        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

                        dt.setTotalPakan(jum_ikan);
                        dt.setHasilBerat(ber_totikan);
                        dt.setTanggalPanen(date);
                        /*DATABASE*/
                        mDatabase.child("Panen").child(dt.getNoTambak()).child("JenisIkan").setValue(dt.getJenisIkan());
                        mDatabase.child("Panen").child(dt.getNoTambak()).child("TanggalPanen").setValue(dt.getTanggalPanen());
                        mDatabase.child("Panen").child(dt.getNoTambak()).child("TotalPakan").setValue(dt.getTotalPakan());
                        mDatabase.child("Panen").child(dt.getNoTambak()).child("HasilBerat").setValue(dt.getHasilBerat());

                        Toast.makeText(getApplicationContext(), "Terima kasih", Toast.LENGTH_LONG).show();
                        startActivity(bawal);
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Mohon diperhatikan kembali", Toast.LENGTH_LONG).show();
                        dialogInterface.cancel();
                    }
                });
                builder.create().show();
                break;
            case R.id.btn_clear_textfield:
                EditText isi=(EditText) findViewById(R.id.berat_ikan_total_textfield);
                isi.setOnClickListener(this);
                isi.setText("");
                break;


        }
    }
}
