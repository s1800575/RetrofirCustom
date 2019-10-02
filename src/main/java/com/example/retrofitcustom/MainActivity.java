package com.example.retrofitcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()

                // pelkkä http:// ei s
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        getUsers();

    }

    private void getUsers() {

        Map<String, String> parameters = new HashMap<>();
        // tässä annetaan parametrit
        parameters.put("_sort", "name");
        parameters.put("_order", "desc");

        Call<List<User>> call = jsonPlaceHolderApi.getUsers(parameters);
        // lisätään -parameters

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<User> users = response.body();

                for (User user : users) {

                    if (user.getName().startsWith("C")) {

                        String content = "";
                        content += "ID: " + user.getId() + "\n";
                        content += "Name: " + user.getName() + "\n";
                        content += "Username: " + user.getUsername() + "\n\n";
                        textViewResult.append(content);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }


        });
    }
}