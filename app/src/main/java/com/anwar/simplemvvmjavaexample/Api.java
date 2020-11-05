package com.anwar.simplemvvmjavaexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "http://anwar.freetzi.com/";

    @GET("animal.php")
    Call<List<MainModel>> getModelDatas();
}
