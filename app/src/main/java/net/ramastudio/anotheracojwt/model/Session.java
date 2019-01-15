package net.ramastudio.anotheracojwt.model;

import com.google.gson.annotations.SerializedName;

public class Session {
    public String nik;
    public String noHP;
    @SerializedName("id")
    public int id;
}
