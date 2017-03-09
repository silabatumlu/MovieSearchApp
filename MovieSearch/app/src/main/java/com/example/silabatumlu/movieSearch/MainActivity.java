package com.example.silabatumlu.movieSearch;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.silabatumlu.movieSearch.fragments.MovieListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //To stop edittext opening the keyboard immediately.
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        Fragment movieListFragment = new MovieListFragment();
        getFragmentManager().beginTransaction().add(R.id.activity_main, movieListFragment).commit();
    }
}