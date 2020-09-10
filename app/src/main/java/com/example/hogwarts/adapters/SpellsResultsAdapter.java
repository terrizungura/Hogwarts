package com.example.hogwarts.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hogwarts.R;
import com.example.hogwarts.models.Spells;
import com.example.hogwarts.models.Students;

import java.util.ArrayList;
import java.util.List;

public class SpellsResultsAdapter extends RecyclerView.Adapter<SpellsResultsAdapter.SpellsResultsHolder> {

    private List<Spells> results = new ArrayList<>();

    @NonNull
    @Override
    public SpellsResultsAdapter.SpellsResultsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student_list, parent, false);
        return new SpellsResultsAdapter.SpellsResultsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SpellsResultsAdapter.SpellsResultsHolder holder, int position) {

        Spells spells =results.get(position);

        holder.textSpellName.setText(spells.getSpell());
        holder.textEffect.setText(spells.getEffect());

    }

    @Override
    public int getItemCount() {
        return results != null ? results.size(): 0;
    }

    public void setResults(List<Spells> results){
        this.results = results;
        notifyDataSetChanged();
    }

    public class SpellsResultsHolder extends RecyclerView.ViewHolder {
        private TextView textSpellName ;
        private TextView textEffect;

        public SpellsResultsHolder(@NonNull View itemView) {
            super(itemView);

            textSpellName = itemView.findViewById(R.id.textSpellName);
            textEffect = itemView.findViewById(R.id.textEffect);
        }
    }
}
