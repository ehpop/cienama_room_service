package io.swagger.dao.movie;

import io.swagger.model.Movie;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MySqlMovieDao implements MovieDao {
    private final String moviesTableName;
    private final JdbcTemplate jdbcTemplate;

    public MySqlMovieDao(JdbcTemplate jdbcTemplate, String moviesTableName) {
        this.jdbcTemplate = jdbcTemplate;
        this.moviesTableName = moviesTableName;
    }

    @Override
    public Integer addMovie(Movie movie) {
        String query = "INSERT INTO " + moviesTableName + " (title, director, duration, age_category) VALUES (?, ?, ?, ?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getDirector());
            ps.setInt(3, movie.getDuration());
            ps.setInt(4, movie.getAgeCategory());
            return ps;
        }, keyHolder);

        int movieId = Objects.requireNonNull(keyHolder.getKey()).intValue();

        movie.setId(movieId);

        return movieId;
    }

    @Override
    public Movie getMovieById(Integer id) {
        String query = "SELECT * FROM " + moviesTableName + " WHERE id = " + id;

        Movie movie;
        try {
            movie = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Movie.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

        return movie;
    }

    @Override
    public boolean deleteMovieById(Integer id) {
           String query = "DELETE * FROM" + moviesTableName + "WHERE id = " + id;
           int rowsAffected = 0;

           try {
               rowsAffected = jdbcTemplate.update(query);
           } catch (EmptyResultDataAccessException e) {
               return false;
           }

           return rowsAffected == 1;
    }

    @Override
    public ArrayList<Movie> getAllMovies() {
        String query = "SELECT * FROM " + moviesTableName;
        List<Movie> movies = jdbcTemplate.query(query, MovieDaoUtils::mapToMovie);

        return new ArrayList<>(movies);
    }

    @Override
    public boolean updateMovieById(Movie movie, Integer id) {
        String query = "UPDATE " + moviesTableName + " SET title = ?, director = ?, duration = ?, age_category = ? WHERE id = " + id;
        int rowsAffected = jdbcTemplate.update(query, movie.getTitle(), movie.getDirector(), movie.getDuration(), movie.getAgeCategory());
        movie.setId(id);

        return rowsAffected == 1;
    }

}
