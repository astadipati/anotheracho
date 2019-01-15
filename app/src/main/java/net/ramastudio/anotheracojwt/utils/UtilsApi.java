package net.ramastudio.anotheracojwt.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UtilsApi {

//    tuban punya
//    public static final String BASE_URL_API = "http://iix.pa-tuban.go.id/";
    public static final String BASE_URL_API = "http://192.168.0.140/ci-rest-jwt/api/users/";

    // Mendeklarasikan Interface BaseApiService -> return model
    public static ApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(ApiService.class);
    }
    // return string
    public static ApiService getAPIServiceString(){
        return RetrofitClient.getClient(BASE_URL_API).create(ApiService.class);
    }

//    another setup dimati
private static Retrofit getRetrofitInstance()
    {
        Gson gson = new GsonBuilder().setLenient().create();

        return new Retrofit.Builder().baseUrl(BASE_URL_API).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }

//    public static ApiService getAPIService()
//    {
//        return getRetrofitInstance().create(ApiService.class);
//    }
}
