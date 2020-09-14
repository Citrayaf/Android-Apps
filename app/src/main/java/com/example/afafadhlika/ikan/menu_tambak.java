package com.example.afafadhlika.ikan;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.afafadhlika.ikan.Model.Data;
import com.example.afafadhlika.ikan.Model.Dataa;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class menu_tambak extends Activity  {

    private DatabaseReference mDatabase;
    Data dt = new Data();
    Dataa dat = new Dataa();
    private EditText usikan;
    private EditText lutambak;
    private EditText natambak;
    private EditText berbenih;
    private EditText baikan;
    int minteger = 0, hit=0;
    String h;
    private Button regisdeh;

    String[] jikan = { "Jenis Ikan..","Lele", "Nila", "Patin", "Bandeng"};
    String je_ikan,lu_tambak,na_tambak,ber_benih,ba_ikan,us_ikan,ju_ik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayik_daftar_tambak);
        final Spinner spin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, jikan);

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Tambak");

        mDatabase.child("1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    hit=1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mDatabase.child("2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    hit=2;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mDatabase.child("3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    hit=3;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        mDatabase.child("1").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()) {
//
//                    //classmodel obj = dataSnapshot.getValue(classmodel.class);
//
//                    Data obj = dataSnapshot.getValue(Data.class);
//
//                    dt.setNoTambak(obj.getNoTambak());
//                    h=dt.getNoTambak();
//                    hit = Integer.parseInt(h);
//
//                }
//                else{
//                    hit = 0;
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        spin.setAdapter(aa);
        spin.setSelection(0);
        je_ikan = spin.getSelectedItem().toString();

        usikan = (EditText) findViewById(R.id.umur_ikan_textfield);
        lutambak = (EditText) findViewById(R.id.luas_tambak_textfield);
        natambak = (EditText) findViewById(R.id.nama_tambak_textfield);
        berbenih = (EditText) findViewById(R.id.berat_benih_textfield);
        baikan = (EditText) findViewById(R.id.jumlah_ikan_textfield);
        Button masuk = findViewById(R.id.btn_daftar_tambak);
        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spin.getSelectedItem().toString().equals("Jenis Ikan..") || spin.getSelectedItem().toString().equals("") || usikan.getText().toString().equals("") || lutambak.getText().toString().equals("") || natambak.getText().toString().equals("") || berbenih.getText().toString().equals("") || baikan.getText().toString().equals("") ) {
                    Toast.makeText(menu_tambak.this, "Tolong isi terlebih dahulu", Toast.LENGTH_LONG).show();

                }
                else if(hit<3){
                    us_ikan = usikan.getText().toString();
                    lu_tambak = lutambak.getText().toString();
                    na_tambak = natambak.getText().toString();
                    ber_benih = berbenih.getText().toString();
                    ba_ikan = baikan.getText().toString();
                    ju_ik = Integer.toString(minteger);
                    h = Integer.toString(hit+1);


                    Data dt = new Data();
                    dt.setNoTambak(h);
                    dt.setNamTambak(na_tambak);
                    dt.setLuasTambak(lu_tambak);
                    dt.setJenisIkan(spin.getSelectedItem().toString());
                    dt.setJumlahIkan(ba_ikan);
                    dt.setBeratBenih(ber_benih);
                    dt.setUsia(us_ikan);
                    mDatabase.child(dt.getNoTambak()).child("NoTambak").setValue(dt.getNoTambak());
                    mDatabase.child(dt.getNoTambak()).child("NamTambak").setValue(dt.getNamTambak());
                    mDatabase.child(dt.getNoTambak()).child("LuasTambak").setValue(dt.getLuasTambak());
                    mDatabase.child(dt.getNoTambak()).child("JenisIkan").setValue(dt.getJenisIkan());
                    mDatabase.child(dt.getNoTambak()).child("JumlahIkan").setValue(dt.getJumlahIkan());
                    mDatabase.child(dt.getNoTambak()).child("BeratBenih").setValue(dt.getBeratBenih());
                    mDatabase.child(dt.getNoTambak()).child("Usia").setValue(dt.getUsia());

                    Toast.makeText(getBaseContext(), "Terimakasih, telah meregistrasi", Toast.LENGTH_LONG).show();
                    Intent bMenu = new Intent(menu_tambak.this, menu_slide.class);
                    startActivity(bMenu);


                }
                else {
                    Toast.makeText(getBaseContext(),"Maks tambak adalah tiga",Toast.LENGTH_LONG).show();
                    Intent bMenu = new Intent(menu_tambak.this, menu_slide.class);
                    startActivity(bMenu);
                }
            }
        });
    }


  /*  public void onClick(View view) {
        switch(view.getId()) {
            case R.id.start:


                us_ikan= usikan.getText().toString();
                lu_tambak=lutambak.getText().toString();
                na_tambak=natambak.getText().toString();
                ber_benih=berbenih.getText().toString();
                ba_ikan=baikan.getText().toString();
                ju_ik= Integer.toString(minteger);


                Toast.makeText(getBaseContext(),"Terimakasih, telah meregistrasi",Toast.LENGTH_LONG).show();
                Intent bMenu= new Intent(this,menut.class);
                int no=pilihtambak.i;
                startActivity(bMenu);

                break;
        }
    }*/






}
