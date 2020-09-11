package com.example.hogwarts.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hogwarts.R;
import com.example.hogwarts.models.Houses;

import java.util.ArrayList;
import java.util.List;

public class HousesResultsAdapter extends RecyclerView.Adapter<HousesResultsAdapter.HousesResultsHolder> {

    private List<Houses>mHouses = new ArrayList<>();


    public HousesResultsAdapter() {

    }

    @NonNull
    @Override
    public HousesResultsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_house_list, parent, false);
        return new HousesResultsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HousesResultsHolder holder, int position) {

        Houses houses =mHouses.get(position);

        holder.textHouseName.setText(houses.getName());
        holder.textGhost.setText(houses.getHouseGhost());

    }

    @Override
    public int getItemCount() {
        return mHouses != null ? mHouses.size(): 0;

    }

    public void setResults(List<Houses> houses){
        mHouses = houses;
        notifyDataSetChanged();
    }

    public class HousesResultsHolder extends RecyclerView.ViewHolder {
        private TextView textHouseName ;
        private TextView textGhost;

        public HousesResultsHolder(@NonNull View itemView) {
            super(itemView);

            textHouseName = itemView.findViewById(R.id.textHouseName);
            textGhost = itemView.findViewById(R.id.textGhost);
        }
    }
}
