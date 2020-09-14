package com.example.afafadhlika.ikan;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class regis extends Activity implements View.OnClickListener {
    String berpatot,harpatot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayik_daftar_pakan);
        Button breg=(Button) findViewById(R.id.btn_daftar_pakan);
        breg.setOnClickListener(this);
        Button clear=(Button) findViewById(R.id.btn_clear_textfield);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_daftar_pakan:
                final Intent bgo= new Intent(this,menu_slide.class);
                EditText ber_patot= (EditText) findViewById(R.id.berat_pakan_total_textfield);
                EditText har_patot= (EditText) findViewById(R.id.harga_pakan_textfield);
                berpatot=ber_patot.getText().toString();
                harpatot=har_patot.getText().toString();
                AlertDialog alertDialog = new AlertDialog.Builder(regis.this).create();
                alertDialog.setTitle("Perhatian");
                alertDialog.setMessage("Data pakan Anda telah kami terima");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                startActivity(bgo);
                            }
                        });
                alertDialog.show();
                break;
            case R.id.btn_clear_textfield:
                EditText isi=(EditText) findViewById(R.id.berat_pakan_total_textfield);
                isi.setOnClickListener(this);
                isi.setText("");
                break;
        }
    }
}
