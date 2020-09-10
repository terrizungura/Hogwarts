package com.example.hogwarts.ui.spells;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hogwarts.models.Houses;
import com.example.hogwarts.models.Spells;
import com.example.hogwarts.repository.DataRepository;

public class SpellsViewModel extends ViewModel {

    private DataRepository dataRepository;
    private LiveData<Spells> spellsLiveData;

    public SpellsViewModel(@NonNull Application application) {
        super();
    }

    public void init(){
        dataRepository = new DataRepository();
        spellsLiveData = dataRepository.getSpellsLiveData();
    }

    public void searchSpells(){
        dataRepository.searchSpells();
    }

    public LiveData<Spells> getSpellsLiveData() {
        return spellsLiveData;
    }
}