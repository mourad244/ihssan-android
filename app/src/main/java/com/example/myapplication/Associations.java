package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Associations extends Activity {
    Retrofit retrofit = RetrofitFactory.getRetrofit();
    RetrofitServices retrofitServices = retrofit
            .create(RetrofitServices.class);

    AssociationAdapter associationAdapter;
    List<Association> associationList;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_associations);

    }
    @Override
    public void onResume(){
        super.onResume();
        gridView = findViewById(R.id.gvAssociation);

        Call<List<Association>> call = retrofitServices.getAssociations();
        call.enqueue(new Callback<List<Association>>() {
            @Override
            public void onResponse(Call<List<Association>> call, Response<List<Association>> response) {
                associationList = response.body();
                associationAdapter = new AssociationAdapter(associationList, Associations.this);
                gridView.setAdapter(associationAdapter);
            }

            @Override
            public void onFailure(Call<List<Association>> call, Throwable t) {

            }
        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Associations.this, AssociationDestails.class);
                String association_id = associationList.get(position).getId();
                intent.putExtra("association_id", association_id);
                startActivity(intent);
            }
        });
    }
}
