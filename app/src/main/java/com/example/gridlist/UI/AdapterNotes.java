package com.example.gridlist.UI;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gridlist.Model.Note;
import com.example.gridlist.OnItemClickListener;
import com.example.gridlist.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterNotes extends RecyclerView.Adapter<AdapterNotes.ViewHolder> {


    private List<Note> notes = new ArrayList<>();

    private OnItemClickListener listener;



    public AdapterNotes(List<Note> notes, OnItemClickListener listener){
        this.notes = notes;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_note, parent, false);



        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.titleNote.setText(notes.get(position).getTitle());
        holder.descriptionNote.setText(notes.get(position).getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.openNote(notes.get(position));
            }
        });



        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notes.remove(notes.get(position));

                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }



    static class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView titleNote;
        private final TextView descriptionNote;
        private final Button buttonDelete;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleNote = itemView.findViewById(R.id.titleNote);
            descriptionNote = itemView.findViewById(R.id.descriptionNote);

            buttonDelete = itemView.findViewById(R.id.buttonDel);
        }
    }
}
