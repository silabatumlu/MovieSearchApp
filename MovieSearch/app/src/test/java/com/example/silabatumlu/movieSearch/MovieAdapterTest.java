package com.example.silabatumlu.movieSearch;

import com.example.silabatumlu.movieSearch.adapters.MovieAdapter;
import com.example.silabatumlu.movieSearch.model.Movie;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MovieAdapterTest {

    @Test
    public void addMovieTest() throws Exception {
        MovieAdapter adapter = new MovieAdapter(new ArrayList<Movie>());
        ArrayList<Movie> movies = new ArrayList<Movie>();

        Movie movie = new Movie();
        movie.title = "Test1";
        movies.add(movie);

        Movie movie2 = new Movie();
        movie.title = "Test2";
        movies.add(movie2);

        adapter.addMovieList(movies);
        assertEquals(2,adapter.getItemCount());
    }
}