package com.example.hogwarts.ui.students;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hogwarts.R;
import com.example.hogwarts.adapters.HousesResultsAdapter;
import com.example.hogwarts.adapters.StudentsResultsAdapter;
import com.example.hogwarts.models.Students;
import com.example.hogwarts.ui.houses.HouseViewModel;

import java.util.List;

public class StudentsFragment extends Fragment {

    private StudentsViewModel studentsViewModel;
    private StudentsResultsAdapter adapter;

    public StudentsFragment (){}

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_students, container, false);

        adapter = new StudentsResultsAdapter();
        RecyclerView recyclerView = root.findViewById(R.id.listItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);


        studentsViewModel = new ViewModelProvider(this).get(StudentsViewModel.class);
        studentsViewModel.init();
        studentsViewModel.getStudentsLiveData().observe(getActivity(), students -> {
            if (students != null) {
                adapter.setResults(List.of(students));
            }
        });

        studentsViewModel.searchStudents();
        return root;
    }
}