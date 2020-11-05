package com.anwar.simplemvvmjavaexample;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<MainModel>> modelList;

    //we will call this method to get the data
    public LiveData<List<MainModel>> getModelDatas() {
        //if the list is null
        if (modelList == null) {
            modelList = new MutableLiveData<> ();
            //we will load it asynchronously from server in this method
            loadModelData ();
        }

        //finally we will return the list
        return modelList;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadModelData() {
        Retrofit retrofit = new Retrofit.Builder ()
                .baseUrl (Api.BASE_URL)
                .addConverterFactory (GsonConverterFactory.create ())
                .build ();

        Api api = retrofit.create (Api.class);
        Call<List<MainModel>> call = api.getModelDatas ();


        call.enqueue (new Callback<List<MainModel>> () {
            @Override
            public void onResponse(Call<List<MainModel>> call, Response<List<MainModel>> response) {

                //finally we are setting the list to our MutableLiveData
                modelList.setValue (response.body ());
            }

            @Override
            public void onFailure(Call<List<MainModel>> call, Throwable t) {

            }
        });
    }
}
