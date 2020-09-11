package com.example.hogwarts.ui.houses;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hogwarts.models.Houses;
import com.example.hogwarts.repository.DataRepository;

public class HouseViewModel extends AndroidViewModel {

    private DataRepository dataRepository;
    private LiveData<Houses> housesLiveData;

    public HouseViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(){
        dataRepository = new DataRepository();
        housesLiveData = dataRepository.getHousesLiveData();
    }

    public void searchHouses(){
        dataRepository.searchHouses();
    }

    public LiveData<Houses> getHousesLiveData() {
        return housesLiveData;
    }
}