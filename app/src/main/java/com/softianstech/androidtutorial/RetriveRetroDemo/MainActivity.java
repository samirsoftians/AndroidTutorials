package com.softianstech.androidtutorial.RetriveRetroDemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.softianstech.androidtutorial.R;
import com.softianstech.androidtutorial.RetriveRetroDemo.adapters.FoodAdapter;
import com.softianstech.androidtutorial.RetriveRetroDemo.apiservices.ApiService;
import com.softianstech.androidtutorial.RetriveRetroDemo.clients.ApiClient;
import com.softianstech.androidtutorial.RetriveRetroDemo.models.FoodModel;
import com.softianstech.androidtutorial.RetriveRetroDemo.models.ListFoodModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private Button btnDisplayDatafood;
    private RecyclerView recyclerViewFood;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retriveretro);

        btnDisplayDatafood = (Button) findViewById(R.id.button_display_data_food);
        recyclerViewFood = (RecyclerView) findViewById(R.id.recyclerview_food);

        progressDialog = new ProgressDialog(this);

        btnDisplayDatafood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAllDataFood();
            }
        });

    }

    private void getAllDataFood(){
        progressDialog.setTitle("Displaying data");
        progressDialog.setMessage("Loading ...");
        progressDialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<ListFoodModel> call = apiService.getAllDataFood();
        call.enqueue(new Callback<ListFoodModel>() {
            @Override
            public void onResponse(Call<ListFoodModel> call, Response<ListFoodModel> response) {
                ListFoodModel listFoodModel = response.body();
                if(listFoodModel.getStatus()==1){
                    List<FoodModel> listFood = listFoodModel.getListFoodM();
                    FoodAdapter foodAdapter = new FoodAdapter(listFood, MainActivity.this);
                    recyclerViewFood.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerViewFood.setItemAnimator(new DefaultItemAnimator());
                    recyclerViewFood.setAdapter(foodAdapter);
                    progressDialog.dismiss();
                }else{
                    Toast.makeText(MainActivity.this, listFoodModel.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<ListFoodModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

    }
}
