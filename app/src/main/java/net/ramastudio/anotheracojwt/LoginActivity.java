package net.ramastudio.anotheracojwt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import net.ramastudio.anotheracojwt.activity.DataActivity;
import net.ramastudio.anotheracojwt.adapter.JWTToken;
import net.ramastudio.anotheracojwt.model.Session;
import net.ramastudio.anotheracojwt.token.TokenManager;
import net.ramastudio.anotheracojwt.utils.ApiService;
import net.ramastudio.anotheracojwt.utils.Pref;
import net.ramastudio.anotheracojwt.utils.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout tilnophone, tilpass;
    private Button login, loginpref;
    private TokenManager tokenManager;
    private TextView tvToken, tvkeregister, tvidpref;

    Context mcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tilnophone = (TextInputLayout)findViewById(R.id.tilnophone);
        tilpass = (TextInputLayout)findViewById(R.id.til_password);

        login = (Button)findViewById(R.id.btn_login);
        loginpref = (Button)findViewById(R.id.btn_pref);

        tvToken = (TextView)findViewById(R.id.tvtoken);
        tvkeregister = (TextView)findViewById(R.id.ke_register);
        tvidpref = (TextView)findViewById(R.id.tvidpref);

        tokenManager = new TokenManager(getApplicationContext());

        loginpref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvidpref.setText("");
            }
        });

        tvkeregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String noHP = tilnophone.getEditText().getText().toString();
                final String pass = tilpass.getEditText().getText().toString();
                final ApiService apiService = UtilsApi.getAPIService();
                Call<JWTToken> jwtTokenCall = apiService.userlogin(noHP,pass);
                jwtTokenCall.enqueue(new Callback<JWTToken>() {
                    @Override
                    public void onResponse(Call<JWTToken> call, Response<JWTToken> response) {
                        JWTToken jwtToken = response.body();
                            if (response.isSuccessful()){
                                try{
                                    JSONObject obj = new JSONObject(response.body().toString());
                                    if (obj.getBoolean("error")){
                                        String error_message = obj.getString("error_msg");
                                        showToast("Error shared" + mcontext);
                                    }else {
                                        showToast("Mengarahkan");
//                                        simpan pref
                                        Session session = new Gson().fromJson(obj.getString("noHP"), Session.class);
                                        tvToken.setText(obj.getString(""));
                                        Pref.put(Session.class, session);
//                                        startActivity(new Intent(LoginActivity.this,DataActivity.class));
                                        finish();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }else {
                                showToast("gagal response");
                            }
                        tokenManager.createLoginSession(noHP,jwtToken.getToken().toString());
                        tvToken.setText(""+jwtToken.getToken().toString());
                        startActivity(new Intent(LoginActivity.this, DataActivity.class));

                    }

                    @Override
                    public void onFailure(Call<JWTToken> call, Throwable t) {
                        showToast("inner"+t.getMessage());
                    }
                });
            }
        });

//        tampilpref.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SharedPreferences datalogin = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
//                String no = datalogin.getString("noHP","");
//                String pass = datalogin.getString("password","");
//                tvToken.setText(no + " "+pass);
//            }
//        });
    }
    void showToast(String msg)
    {
        Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show();
    }
}
