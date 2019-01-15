package net.ramastudio.anotheracojwt.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.ramastudio.anotheracojwt.R;


public class JadwalsidangActivity extends AppCompatActivity {

    Button btnsidang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwalsidang);

        getSupportActionBar().setTitle("Jadwal Sidang");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnsidang = (Button)findViewById(R.id.btnsidang);

        btnsidang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Data berhasil dikirim");
            }
        });
    }

    void showToast(String msg)
    {
        Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}