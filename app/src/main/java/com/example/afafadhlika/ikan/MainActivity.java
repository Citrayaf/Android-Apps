package com.example.afafadhlika.ikan;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.afafadhlika.ikan.Model.Data;
import com.example.afafadhlika.ikan.Model.Dataa;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    Dataa dat = new Dataa();
    int hit=0; String h;
    private FirebaseAuth firebaseAuth;
    private static int SPLASH_TIME_OUT = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Tambak");

        mDatabase.child("1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    hit=1;
                    h=Integer.toString(hit);
                    dat.setHit(h);
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
                    h=Integer.toString(hit);
                    dat.setHit(h);
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
                    h=Integer.toString(hit);
                    dat.setHit(h);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String email = "pandhawa29@gmail.com";
                String password  = "cyaf9814";
                Toast.makeText(getBaseContext(),"Selamat Datang",Toast.LENGTH_LONG).show();
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    finish();

                                }

                            }
                        });
                if (hit!=0)
                {
                    Intent lele= new Intent(MainActivity.this,menu_slide.class);
                    startActivity(lele);
                }
                else if (hit==0){
                    Intent bawal = new Intent(MainActivity.this, slider_awal.class);
                    startActivity(bawal);
                }

            }
        },SPLASH_TIME_OUT);

    }

}
