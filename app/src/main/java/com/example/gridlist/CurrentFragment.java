package com.example.gridlist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gridlist.Model.Note;


public class CurrentFragment extends Fragment {


   private static final String CURRENT_NOTE = "current_note";


    public static CurrentFragment newInstance(Note note) {
        CurrentFragment fragment = new CurrentFragment();
        Bundle args = new Bundle();
        args.putSerializable(CURRENT_NOTE, note);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_current_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView id = view.findViewById(R.id.idCardView);
        TextView title = view.findViewById(R.id.titleCardView);
        TextView description = view.findViewById(R.id.descriptionCardView);

        if(getArguments()!=null) {
            Note note = (Note) getArguments().getSerializable(CURRENT_NOTE);

            id.setText(String.valueOf(note.getId()));
            title.setText(note.getTitle());
            description.setText(note.getDescription());
        }
    }
}