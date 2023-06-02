package io.swagger.dao.movie;

import io.swagger.model.Movie;

import java.util.List;

public interface MovieDao {
    public Integer addMovie(Movie movie);

    public Movie getMovieById(Integer id);

    public boolean deleteMovieById(Integer id);

    public List<Movie> getAllMovies();

    public boolean updateMovieById(Movie movie, Integer id);

    boolean checkIfMovieExist(Integer id);
}
