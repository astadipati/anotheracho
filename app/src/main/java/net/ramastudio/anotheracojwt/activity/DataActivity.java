package net.ramastudio.anotheracojwt.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import net.ramastudio.anotheracojwt.R;
import net.ramastudio.anotheracojwt.token.TokenManager;

import butterknife.OnClick;

public class DataActivity extends AppCompatActivity {

    TextView du,sidang,biaya,riwayat,putusan,akte, tvpref, tvToken;

    TokenManager tokensession;
    String nohape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        tokensession = new TokenManager(DataActivity.this.getApplicationContext());
        nohape = tokensession.getnoHP();

        du = (TextView)findViewById(R.id.tvdataumum);
        sidang = (TextView)findViewById(R.id.tvjadwalsidang);
        biaya = (TextView)findViewById(R.id.tvbiayaperkara);
        riwayat = (TextView)findViewById(R.id.tvriwayat);
        putusan = (TextView)findViewById(R.id.tvputusan);
        akte = (TextView)findViewById(R.id.tvaktecerai);
        tvpref = (TextView)findViewById(R.id.tv_prefdimari);
        tvToken = (TextView)findViewById(R.id.tvheader);


        tvpref.setText(nohape);

        du.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DataActivity.this, DataumumActivity.class));
            }
        });
        sidang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DataActivity.this, JadwalsidangActivity.class));
            }
        });
        biaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DataActivity.this, BiayaperkaraActivity.class));
            }
        });
        riwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DataActivity.this, RiwayatActivity.class));
            }
        });
        putusan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DataActivity.this, PutusanActivity.class));
            }
        });
        akte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DataActivity.this, AkteceraiActivity.class));
            }
        });
    }
}
