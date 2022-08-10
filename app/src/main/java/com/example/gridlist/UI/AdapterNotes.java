package com.example.gridlist.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gridlist.Model.Note;
import com.example.gridlist.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterNotes extends RecyclerView.Adapter<AdapterNotes.ViewHolder> {


    private List<Note> notes = new ArrayList<>();
    public AdapterNotes(List<Note> notes){
        this.notes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleNote.setText(notes.get(position).getTitle());
        holder.descriptionNote.setText(notes.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }



    static class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView titleNote;
        private final TextView descriptionNote;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleNote = itemView.findViewById(R.id.titleNote);
            descriptionNote = itemView.findViewById(R.id.descriptionNote);

        }
    }
}
