package com.example.afafadhlika.ikan;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class pilihtambak extends Activity implements View.OnClickListener {
    int pil[]={0};
    public static int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihtambak);
        Button Tambak1=(Button) findViewById(R.id.btambakA);
        Button Tambak2=(Button) findViewById(R.id.btambakB);
        Button Tambak3=(Button) findViewById(R.id.btambakC);
        Button Tambak4=(Button) findViewById(R.id.btambakD);
        Tambak1.setOnClickListener(this);
        Tambak2.setOnClickListener(this);
        Tambak3.setOnClickListener(this);
        Tambak4.setOnClickListener(this);

       /* Tambak1.setText(menu_tambak.na_tambak);*/
    }
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btambakA:
                //Toast.makeText(getBaseContext(),"Selamat Datang",Toast.LENGTH_LONG).show();
                Intent tambakA= new Intent(this,menu_tambak.class);
                startActivity(tambakA);
                break;
            case R.id.btambakB:
                Intent tambakB= new Intent(this,menu_tambak.class);
                startActivity(tambakB);
                break;
            case R.id.btambakC:
                Intent tambakC= new Intent(this,menu_tambak.class);
                startActivity(tambakC);
                break;
            case R.id.btambakD:
                Intent tambakD= new Intent(this,menu_tambak.class);
                startActivity(tambakD);
                break;
        }
    }
}
