package com.example.afafadhlika.ikan;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class first extends Activity implements View.OnClickListener {
    int minteger = 0;
    String[] jikan = { "Lele", "Nila", "Patin", "Udang Vanamee"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button bmenu=(Button) findViewById(R.id.start);
        bmenu.setOnClickListener(this);
        Spinner spin = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, jikan);

        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(aa);

    }
    //public void onItemSelected(AdapterView<?> parent, View v, int position,   long id) {

      //  Toast.makeText(this, "Anda Memilih: " + jikan[position],Toast.LENGTH_LONG).show();

    //}

   // public void onNothingSelected(AdapterView<?> parent) {

    //    Toast.makeText(this, "Silahkan Jenis Ikan", Toast.LENGTH_LONG).show();

   // }
    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.integer_number);
        displayInteger.setText("" + number);
    }

    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }public void decreaseInteger(View view) {
        minteger = minteger - 1;
        display(minteger);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.start:
                Toast.makeText(getBaseContext(),"Terimakasih, telah meregistrasi",Toast.LENGTH_LONG).show();
                Intent bMenu= new Intent(this,menut.class);
                startActivity(bMenu);
                break;
        }
    }














}

