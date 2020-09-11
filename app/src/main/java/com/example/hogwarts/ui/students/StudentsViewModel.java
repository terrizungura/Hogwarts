package com.example.hogwarts.ui.students;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hogwarts.models.Houses;
import com.example.hogwarts.models.Students;
import com.example.hogwarts.repository.DataRepository;

public class StudentsViewModel extends AndroidViewModel {

    private DataRepository dataRepository;
    private LiveData<Students> studentsLiveData;

    public StudentsViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(){
        dataRepository = new DataRepository();
        studentsLiveData = dataRepository.getStudentsLiveData();
    }

    public void searchStudents(){
        dataRepository.searchStudents();
    }

    public LiveData<Students> getStudentsLiveData() {
        return studentsLiveData;
    }
}