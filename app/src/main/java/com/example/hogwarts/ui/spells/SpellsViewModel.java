package com.example.hogwarts.ui.spells;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hogwarts.models.Houses;
import com.example.hogwarts.models.Spells;
import com.example.hogwarts.repository.DataRepository;

import java.util.List;

public class SpellsViewModel extends AndroidViewModel {

    private DataRepository dataRepository;
    private LiveData<List<Spells>> spellsLiveData;

    public SpellsViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(){
        dataRepository = new DataRepository();
        spellsLiveData = dataRepository.getSpellsLiveData();
    }

    public void searchSpells(){
        dataRepository.searchSpells();
    }

    public LiveData<List<Spells>> getSpellsLiveData() {
        return spellsLiveData;
    }
}