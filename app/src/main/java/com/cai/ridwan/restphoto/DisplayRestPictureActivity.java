package com.cai.ridwan.restphoto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.cai.ridwan.restphoto.adapter.DataAdapter;
import com.cai.ridwan.restphoto.api.RequestInterface;
import com.cai.ridwan.restphoto.models.photoModels;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DisplayRestPictureActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<photoModels> data;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_rest_picture);
        initViews();
    }

    private void initViews() {
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }

    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);

        Call<List<photoModels>> call = request.getJSON();
        call.enqueue(new Callback<List<photoModels>>() {

            @Override
            public void onResponse(Call<List<photoModels>> call, Response<List<photoModels>> response) {
                List<photoModels> respon = response.body();

                data = new ArrayList<>(respon);
                adapter = new DataAdapter(DisplayRestPictureActivity.this, data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<photoModels>> call, Throwable t) {
                Toast.makeText(DisplayRestPictureActivity.this, "No Connection...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
