package com.anwar.simplemvvmjavaexample;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MainModelAdapter adapter;
    List<MainModel> mainModelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        recyclerView = findViewById (R.id.recyclerview);
        recyclerView.setHasFixedSize (true);
        recyclerView.setLayoutManager (new LinearLayoutManager (this));

        MainViewModel model = new ViewModelProvider (this).get (MainViewModel.class);

        model.getModelDatas ().observe (this, new Observer<List<MainModel>> () {
            @Override
            public void onChanged(@Nullable List<MainModel> mainModelDataList) {
                adapter = new MainModelAdapter (MainActivity.this, mainModelDataList);
                recyclerView.setAdapter (adapter);
            }
        });
        
    }
}
