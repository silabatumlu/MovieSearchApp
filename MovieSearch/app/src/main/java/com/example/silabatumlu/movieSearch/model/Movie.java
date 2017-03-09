package com.example.silabatumlu.movieSearch.model;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by silabatumlu on 02/03/17.
 */

@JsonObject
public class Movie {
    @JsonField(name = "Title")
    public String title;
    @JsonField(name = "Year")
    public String year;
    @JsonField(name = "imdbID")
    public String imdbID;
    @JsonField(name = "Poster")
    public String poster;
}
