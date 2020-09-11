package com.example.hogwarts.ui.houses;

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
import com.example.hogwarts.adapters.SpellsResultsAdapter;
import com.example.hogwarts.ui.spells.SpellsViewModel;

import java.util.List;

public class HouseFragment extends Fragment {

    private HouseViewModel houseViewModel;
    private HousesResultsAdapter adapter;

    public HouseFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_house, container, false);

        adapter = new HousesResultsAdapter();
        RecyclerView recyclerView = root.findViewById(R.id.listItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);


        houseViewModel = new ViewModelProvider(this).get(HouseViewModel.class);
        houseViewModel.init();
        houseViewModel.getHousesLiveData().observe(getActivity(), houses -> {
            if (houses != null) {
                adapter.setResults(List.of(houses));
//                    //recyclerView.setAdapter(adapter);
            }
        });

        houseViewModel.searchHouses();
        return root;
    }
}