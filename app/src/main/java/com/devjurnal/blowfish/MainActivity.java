package com.devjurnal.blowfish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText plainText;
    private Button enkripsi;
    private EditText edtKey;
    private TextView tvHasil;
    private Button dekrip;
    private TextView tvHasildekrip;
    String CesarEnc = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        enkripsi.setOnClickListener(this);
        dekrip.setOnClickListener(this);
    }

    private void initView() {
        plainText = (EditText) findViewById(R.id.edtPlainText);
        enkripsi = (Button) findViewById(R.id.enkripsi);
        edtKey = (EditText) findViewById(R.id.edtKey);
        tvHasil = (TextView) findViewById(R.id.tvHasil);
        dekrip = (Button) findViewById(R.id.dekrip);
        tvHasildekrip = (TextView) findViewById(R.id.tvHasildekrip);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.enkripsi :
                String plaintext = plainText.getText().toString();
                String key = edtKey.getText().toString().trim();

                String cipherBlow = BlowfishCaesar.enkripsi(plaintext, key);

                CesarEnc = BlowfishCaesar.encryptCaesar(cipherBlow,3);

                tvHasil.setText("blowfish:"+cipherBlow+"\ncaesar :"+CesarEnc);
                break;
            case R.id.dekrip:
                String keyDec = edtKey.getText().toString().trim();

                String decripCesar = BlowfishCaesar.decryptCaesar(CesarEnc,3);
                String textBlow = BlowfishCaesar.dekripsiBlowfish(decripCesar, keyDec);

                tvHasildekrip.setText("dekrip Caesar menjadi blowfish cipher : " + decripCesar+"\ndec blowfish menjadi plaintext :"+textBlow);
                break;
        }


    }

}
