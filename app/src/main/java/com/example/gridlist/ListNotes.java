package com.example.gridlist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gridlist.Model.Note;
import com.example.gridlist.UI.AdapterNotes;

import java.util.ArrayList;
import java.util.List;


public class ListNotes extends Fragment {

    private RecyclerView recyclerView;
    private AdapterNotes adapterNotes;

    public static ListNotes newInstance() {
        return new ListNotes();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.list_notes);

        List<Note> notes = getListNotes();
        AdapterNotes adapterNotes = new AdapterNotes(notes);
        recyclerView.setAdapter(adapterNotes);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(),2));

    }

    private List<Note> getListNotes(){

        List<Note> notes = new ArrayList<>();

        notes.add(new Note(1, "Jon Jones", "Wrestling"));
        notes.add(new Note(2, "George St Pierre", "Karate"));
        notes.add(new Note(3, "BJ Penn","Brazilian jiu jitsu"));
        notes.add(new Note(4, "Anderson Silva", "Muay Thai"));
        notes.add(new Note(5, "Kain Velasques", "Wrestling"));
        notes.add(new Note(6,"Stipe Miotich", "Boxing"));
        notes.add(new Note(7, "Fedor Emelanenko", "Sambo"));
        notes.add(new Note(8, "Brian Ortega", "Brazilian jiu jitsu"));
        notes.add(new Note(9, "Diego Sanchez", "Wrestling"));
        notes.add(new Note(10, "Carlos Condit", "Kickboxing"));
        notes.add(new Note(11, "Alexander Gustafson", "Boxing"));
        notes.add(new Note(12, "Daniel Cormie", "Wrestling"));
        notes.add(new Note(13, "Jose Aldo", "Brazilian jiu jitsu"));
        notes.add(new Note(14, "Uraia Faber", "Wrestling"));
        notes.add(new Note(15, "Antonio Rodrigo Nogueira", "Brazilian jiu jitsu"));
        notes.add(new Note(16, "Donald Cerrone", "Kickboxing"));

        return notes;
    }
}