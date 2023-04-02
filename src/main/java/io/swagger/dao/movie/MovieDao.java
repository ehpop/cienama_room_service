package io.swagger.dao.movie;

import io.swagger.model.Movie;

import java.util.ArrayList;

public interface MovieDao {
    public Integer addMovie(Movie movie);

    public Movie getMovieById(Integer id);

    public boolean deleteMovieById(Integer id);

    public ArrayList<Movie> getAllMovies();

    public boolean updateMovieById(Movie movie, Integer id);

    boolean checkIfMovieExist(Integer id);
}
