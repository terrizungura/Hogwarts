package com.example.hogwarts.api;

import com.example.hogwarts.models.Houses;
import com.example.hogwarts.models.Spells;
import com.example.hogwarts.models.Students;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HogwartsDataService {

    @GET("/houses")
    Call<Houses> searchHouses();

    @GET("/spells")
    Call<Spells> searchSpells();

    @GET("/characters")
    Call<Students> searchStudents();
}
