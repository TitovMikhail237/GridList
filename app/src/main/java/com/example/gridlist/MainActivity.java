package com.example.gridlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.gridlist.Model.Note;

public class MainActivity extends AppCompatActivity implements Navigation{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceListNotes();
    }

    private void replaceFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    @Override
    public void replaceListNotes() {
        replaceFragment(ListNotes.newInstance());
    }

    @Override
    public void replaceCurrentNote(Note note) {

    }
}