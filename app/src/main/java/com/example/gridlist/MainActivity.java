package com.example.gridlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                .add(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void replaceListNotes() {
        replaceFragment(ListNotes.newInstance());
    }

    @Override
    public void replaceCurrentNote(Note note) {
replaceFragment(CurrentFragment.newInstance(note));
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(getSupportFragmentManager().getBackStackEntryCount()==0){
            finish();
        }
    }
}