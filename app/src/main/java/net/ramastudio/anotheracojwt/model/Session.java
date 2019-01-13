package net.ramastudio.anotheracojwt.model;

import com.google.gson.annotations.SerializedName;

public class Session {
    public String nama;
    public String email;
    @SerializedName("IDPerkara")
    public int idperkara;
    @SerializedName("noPerkara")
    public String noPerkara;
}
