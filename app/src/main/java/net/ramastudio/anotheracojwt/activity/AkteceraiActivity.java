package net.ramastudio.anotheracojwt.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.ramastudio.anotheracojwt.R;

public class AkteceraiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktecerai);

        getSupportActionBar().setTitle("Akte Cerai");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
