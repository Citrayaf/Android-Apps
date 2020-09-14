package com.example.afafadhlika.ikan;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class menut extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button rpakan=(Button) findViewById(R.id.buttonregis);
        Button ppakan=(Button) findViewById(R.id.buttonprogrampakan);
        Button graf=(Button) findViewById(R.id.buttongrafik);
        Button panen=(Button) findViewById(R.id.buttonpanen);
        rpakan.setOnClickListener(this);
        ppakan.setOnClickListener(this);
        graf.setOnClickListener(this);
        panen.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.buttonregis:
                //Toast.makeText(getBaseContext(),"Selamat Datang",Toast.LENGTH_LONG).show();
                Intent bregis= new Intent(this,regis.class);
                startActivity(bregis);
                break;
            case R.id.buttonprogrampakan:
                Intent bpakan= new Intent(this,bermakan.class);
                startActivity(bpakan);
                break;
            case R.id.buttongrafik:
                Intent bgraf= new Intent(this,gruff.class);
                startActivity(bgraf);
                break;
            case R.id.buttonpanen:
                Intent bpan= new Intent(this,panen.class);
                startActivity(bpan);
                break;
        }
    }

}
