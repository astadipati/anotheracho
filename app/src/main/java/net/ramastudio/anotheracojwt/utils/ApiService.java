package net.ramastudio.anotheracojwt.utils;

import net.ramastudio.anotheracojwt.adapter.JWTToken;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> loginRequest(@Field("email") String email,
                                    @Field("password") String password);

    @FormUrlEncoded
    @POST("register.php")
    Call<ResponseBody> registerRequest(@Field("idperkara") String idperkara,
                                       @Field("nama") String nama,
                                       @Field("email") String email,
                                       @Field("password") String password);

    @FormUrlEncoded
    @POST("login")
    Call<JWTToken> userlogin(@Field("noHP") String noHP, @Field("password")String password);

    @GET("/phptest/jwttest.php")
    Call<String> getUser(@Header("Authorization") String authorization);

//    @GET("index.php/berita")
//    Call<ResponseBerita> request_show_all_berita();
//
//    @GET("index.php/pta")
//    Call<ResponseBeritaPTA> request_show_all_beritapta();
//
//    @GET("index.php/badilag")
//    Call<ResponseBeritaBadilag> request_show_all_beritaBadilag();
//
//    @GET("index.php/ma")
//    Call<ResponseBeritaMA> request_show_all_beritaMA();
//
//    @GET("index.php/panjar")
//    Call<ResponsePanjar> request_show_all_panjar();
//
//    @GET("index.php/syarat")
//    Call<ResponseSyarat> request_show_all_syarat();
//
//    @GET("index.php/hukum")
//    Call<ResponseHukum> request_show_all_hukum();
//
//    @GET("index.php/pojok")
//    Call<ResponsePojok> request_show_all_pojok();
//
//    @GET("index.php/user/{idperkara}")
//    Call<User> getUser(@Path("idperkara") int dataId);
//
//    @GET("index.php/dataumum/{idperkara}")
//    Call<ResponseDataUmum> getDataumum(@Path("idperkara") int dataId);
//
//    @GET("index.php/sidang/{idperkara}")
//    Call<ResponseSidang> getSidang(@Path("idperkara") int dataId);
//
//    @GET("index.php/transaksi/{idperkara}")
//    Call<ResponseTransaksi> getTransaksi(@Path("idperkara") int dataId);
//
//    @GET("index.php/riwayat/{idperkara}")
//    Call<ResponseRiwayat> getRiwayat(@Path("idperkara") int dataId);
//
//    @GET("index.php/ac/{idperkara}")
//    Call<ResponseAkteCerai> getAkte(@Path("idperkara") int dataId);
//
//    @GET("index.php/dirput/{idperkara}")
//    Call<ResponseDirput> getDirput(@Path("idperkara") int dataId);
//
//    @GET("index.php/getdataumumv2/{idperkara}")
//    Call<ResponseBody> getDataUmumV2(@Path("idperkara") int dataId);
}
