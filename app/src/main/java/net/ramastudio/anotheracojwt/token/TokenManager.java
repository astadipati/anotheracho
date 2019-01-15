package net.ramastudio.anotheracojwt.token;

import android.content.Context;
import android.content.SharedPreferences;

public class TokenManager {

    private SharedPreferences sharedPreferences;
    private Context context;
    private SharedPreferences.Editor editor;
    private int Mode = 0;
    private static  final String REF_NAME="TokenManager";
    public static final String KEY_NAME = "noHP";
    public static final String KEY_JWT_TOKEN="jwttokenname";

    public TokenManager(Context context)
    {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(REF_NAME,Mode);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(String noHP , String jwttokenname)
    {
        editor.putString(KEY_NAME,noHP);
        editor.putString(KEY_JWT_TOKEN,jwttokenname);
        editor.commit();

    }

//    public String getJwt(){
//        return sharedPreferences.getString("")
//    }

    public String getnoHP(){
        return sharedPreferences.getString("noHP", null);
    }

    public void logOUT()
    {

    }



}
