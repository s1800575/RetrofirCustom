package com.example.retrofitcustom;

import com.example.retrofitcustom.Post;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface JsonPlaceHolderApi {

        // Tällä luokalla otetaan yhteys REST API:n
        // Tässä annotaatio @GET("posts"), jolla kutsu ohjajataan
        // posts. URL:in alkuosa määritetään aktiviteetti-luokassa
        // kun luodaan uusi Retrofit ilmentymä new Retrofit.builder();

        @GET("posts")
        Call<List<Post>> getPosts();

        @GET("photos")
        Call<List<Photo>> getPhotos();

        @GET("users")
        Call<List<User>> getUsers(@QueryMap Map<String, String> parameters);

    }

