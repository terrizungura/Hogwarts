package com.example.hogwarts.api;

import com.example.hogwarts.models.Houses;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HogwartsDataService {

    @GET("/houses")
    Call<Houses> searchHouses();

    @GET("/spells")
    Call<Houses> searchSpells();

    @GET("/characters")
    Call<Houses> searchStudents();
}
