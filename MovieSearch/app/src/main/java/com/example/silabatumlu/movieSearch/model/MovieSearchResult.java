package com.example.silabatumlu.movieSearch.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.ArrayList;

/**
 * Created by silabatumlu on 02/03/17.
 */

@JsonObject
public class MovieSearchResult {
    @JsonField(name = "Search")
    public ArrayList<Movie> movieSearchList;
}
