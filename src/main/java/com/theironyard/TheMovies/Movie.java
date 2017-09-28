package com.theironyard.TheMovies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
"vote_count": 1202,
            "id": 346364,
            "video": false,
            "vote_average": 7.5,
            "title": "It",
            "popularity": 661.035988,
            "poster_path": "/9E2y5Q7WlCVNEhP5GiVTjhEhx1o.jpg",
            "original_language": "en",
            "original_title": "It",
            "genre_ids": [
                12,
                18,
                27
            ],
            "backdrop_path": "/tcheoA2nPATCm2vvXw2hVQoaEFD.jpg",
            "adult": false,
            "overview": "In a small town in Maine, seven children known as The Losers Club come face to face with life problems, bullies and a monster that takes the shape of a clown called Pennywise.",
            "release_date": "2017-09-05"
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {

    @JsonProperty("vote_count")
    int voteCount;

    int id;
    String title;

    @JsonProperty("poster_path")
    String posterPath;

    String overview;
    double popularity;

    public Movie() {
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public void getposterPath(String posterPath) {this.posterPath = posterPath;}

    public String setposterPath() {return posterPath;}
}



/*
"voteCount":1202,
"id":346364,
"video":false,
"vote_average":7.5,
"title":"It",
"popularity":731.845242,
"posterPath":"\/9E2y5Q7WlCVNEhP5GiVTjhEhx1o.jpg",
"original_language":"en",
"original_title":"It",
"genre_ids":[12,18,27],
"backdrop_path":"\/tcheoA2nPATCm2vvXw2hVQoaEFD.jpg",
"adult":false,
"overview":"In a small town in Maine, seven children known as The Losers Club come face to face with life problems, bullies and a monster that takes the shape of a clown called Pennywise.",
"release_date":"2017-09-05"
 */