package net.ramastudio.anotheracojwt.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.ramastudio.anotheracojwt.R;

public class BiayaperkaraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biayaperkara);

        getSupportActionBar().setTitle("Biaya Perkara");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
