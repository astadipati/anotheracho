package net.ramastudio.anotheracojwt.utils;

public class UtilsApi {

//    tuban punya
    public static final String BASE_URL_API = "http://iix.pa-tuban.go.id/";

    // Mendeklarasikan Interface BaseApiService -> return model
    public static ApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(ApiService.class);
    }
    // return string
    public static ApiService getAPIServiceString(){
        return RetrofitClient.getClient(BASE_URL_API).create(ApiService.class);
    }
}
