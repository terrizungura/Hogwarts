package com.example.hogwarts.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hogwarts.R;
import com.example.hogwarts.models.Houses;
import com.example.hogwarts.models.Students;

import java.util.ArrayList;
import java.util.List;

public class StudentsResultsAdapter extends RecyclerView.Adapter<StudentsResultsAdapter.StudentsResultsHolder> {

    private List<Students> results = new ArrayList<>();

    @NonNull
    @Override
    public StudentsResultsAdapter.StudentsResultsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student_list, parent, false);
        return new StudentsResultsAdapter.StudentsResultsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsResultsAdapter.StudentsResultsHolder holder, int position) {

        Students students =results.get(position);

        holder.textStudentName.setText(students.getName());
        holder.textRole.setText(students.getRole());

    }

    @Override
    public int getItemCount() {
        return results != null ? results.size(): 0;
    }

    public void setResults(List<Students> results){
        this.results = results;
        notifyDataSetChanged();
    }

    public class StudentsResultsHolder extends RecyclerView.ViewHolder {
        private TextView textStudentName ;
        private TextView textRole;

        public StudentsResultsHolder(@NonNull View itemView) {
            super(itemView);

            textStudentName = itemView.findViewById(R.id.textStudentName);
            textRole = itemView.findViewById(R.id.textRole);
        }
    }
}
