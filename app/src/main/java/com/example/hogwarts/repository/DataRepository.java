package com.example.hogwarts.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.hogwarts.adapters.SpellsResultsAdapter;
import com.example.hogwarts.api.APIClient;
import com.example.hogwarts.api.HogwartsDataService;
import com.example.hogwarts.models.Houses;
import com.example.hogwarts.models.Spells;
import com.example.hogwarts.models.Students;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepository {

    private static final String TAG = "DataRepository";
    private HogwartsDataService hogwartsDataService;
    private MutableLiveData<Houses> housesLiveData;
    private MutableLiveData<List<Spells>> spellsLiveData;
    private MutableLiveData<Students> studentsLiveData;

    private SpellsResultsAdapter adapter = new SpellsResultsAdapter();

    public DataRepository(){
        housesLiveData = new MutableLiveData<>();
        spellsLiveData = new MutableLiveData<>();
        studentsLiveData = new MutableLiveData<>();
        hogwartsDataService = APIClient.getClient().create(HogwartsDataService.class);
    }

    public void searchHouses(){
        hogwartsDataService.searchHouses()
                .enqueue(new Callback<Houses>() {
                    @Override
                    public void onResponse(Call<Houses> call, Response<Houses> response) {
                        if(response.body()!= null){
                            housesLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<Houses> call, Throwable t) {

                        housesLiveData.postValue(null);
                    }
                });
    }
    public void searchSpells(){
        hogwartsDataService.searchSpells()
                .enqueue(new Callback<List<Spells>>() {
                    @Override
                    public void onResponse(Call<List<Spells>> call, Response<List<Spells>> response) {
                        if(response.body()!= null){
                            spellsLiveData.postValue(response.body());

                            /*List<Spells> spells = List.of(response.body());
                            Log.d(TAG, "onResponse: Response " + response.body());

                            adapter.setResults(spells);*/
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Spells>> call, Throwable t) {

                        spellsLiveData.postValue(null);
                    }
                });
    }
    public void searchStudents(){
        hogwartsDataService.searchStudents()
                .enqueue(new Callback<Students>() {
                    @Override
                    public void onResponse(Call<Students> call, Response<Students> response) {
                        if(response.body()!= null){
                            studentsLiveData.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<Students> call, Throwable t) {

                        studentsLiveData.postValue(null);
                    }
                });
    }

    public LiveData<Houses> getHousesLiveData(){
        return housesLiveData;
    }

    public LiveData<List<Spells>> getSpellsLiveData(){
        return spellsLiveData;
    }

    public LiveData<Students> getStudentsLiveData(){
        return studentsLiveData;
    }



}
