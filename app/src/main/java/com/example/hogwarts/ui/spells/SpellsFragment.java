package com.example.hogwarts.ui.spells;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hogwarts.R;
import com.example.hogwarts.adapters.SpellsResultsAdapter;
import com.example.hogwarts.models.Houses;
import com.example.hogwarts.models.Spells;

import java.util.List;

public class SpellsFragment extends Fragment {

    private SpellsViewModel spellsViewModel;
    private SpellsResultsAdapter adapter;

public SpellsFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

        @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.fragment_spell, container, false);

            adapter =new SpellsResultsAdapter();
            RecyclerView recyclerView = root.findViewById(R.id.listItems);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(adapter);



            spellsViewModel = new ViewModelProvider(this).get(SpellsViewModel.class);
            spellsViewModel.init();
            spellsViewModel.getSpellsLiveData().observe(getActivity(), spells -> {
                if (spells != null) {
                    adapter.setResults(spells);
//                    //recyclerView.setAdapter(adapter);
                }
            });

            spellsViewModel.searchSpells();
            return root;
        }


    }
