package com.example.silabatumlu.movieSearch.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bluelinelabs.logansquare.LoganSquare;
import com.example.silabatumlu.movieSearch.R;
import com.example.silabatumlu.movieSearch.adapters.MovieAdapter;
import com.example.silabatumlu.movieSearch.model.Movie;
import com.example.silabatumlu.movieSearch.model.MovieSearchResult;
import com.example.silabatumlu.movieSearch.network.AsyncResponse;
import com.example.silabatumlu.movieSearch.network.ConnectionHelper;
import com.example.silabatumlu.movieSearch.network.FetchDataTask;

import java.io.IOException;
import java.util.ArrayList;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class MovieListFragment extends Fragment {

    private static RecyclerView recyclerView;
    private static MovieAdapter adapter;

    public MovieListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new MovieAdapter(new ArrayList<Movie>());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mainView = inflater.inflate(R.layout.fragment_movie_list, container, false);
        Button searchButton = (Button) mainView.findViewById(R.id.button_search);
        final EditText txtMovieTitle = (EditText) mainView.findViewById(R.id.txtMovieTitle);

        recyclerView = (RecyclerView) mainView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setAdapter(adapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyBoard();
                SearchMovieByTitle(txtMovieTitle.getText().toString());
                txtMovieTitle.getText().clear();
            }
        });
        return mainView;
    }

    public void SearchMovieByTitle(String searchKey) {
        FetchDataTask fetchMovieTask = new FetchDataTask(new AsyncResponse() {

            @Override
            public void processFinish(String output) {
                try {
                    MovieSearchResult movieSearchResult = LoganSquare.parse(output, MovieSearchResult.class);
                    if (movieSearchResult.movieSearchList != null && movieSearchResult.movieSearchList.size() > 0) {
                        adapter.addMovieList(movieSearchResult.movieSearchList);
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(getActivity(), getString(R.string.alert_movie_not_found), Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        fetchMovieTask.execute(ConnectionHelper.getMovieSearchApiUrl(searchKey).toString());
    }

    public void hideKeyBoard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
        View focusedView = getActivity().getCurrentFocus();

        if (focusedView != null) {
            imm.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
        }
    }
}