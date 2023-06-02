package io.swagger.dao.movie;

import io.swagger.model.Movie;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
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
        String query = "INSERT INTO " + moviesTableName + " (title, director, duration, age_category, poster_url, description) VALUES (?, ?, ?, ?, ?, ?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getDirector());
            ps.setInt(3, movie.getDuration());
            ps.setInt(4, movie.getAgeCategory());
            ps.setString(5, movie.getPosterUrl());
            ps.setString(6, movie.getDescription());
            return ps;
        }, keyHolder);

        int movieId = Objects.requireNonNull(keyHolder.getKey()).intValue();

        movie.setId(movieId);

        return movieId;
    }

    @Override
    public Movie getMovieById(Integer id) {
        String query = "SELECT * FROM " + moviesTableName + " WHERE id = " + id;

        return jdbcTemplate.queryForObject(query, MovieDaoUtils::mapToMovieWithId);
    }

    @Override
    public boolean deleteMovieById(Integer id) {
        String query = "DELETE * FROM" + moviesTableName + "WHERE id = " + id;
        int rowsAffected;

        try {
            rowsAffected = jdbcTemplate.update(query);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }

        return rowsAffected == 1;
    }

    @Override
    public List<Movie> getAllMovies() {
        String query = "SELECT * FROM " + moviesTableName;

        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Movie.class));
    }

    @Override
    public boolean updateMovieById(Movie movie, Integer id) {
        String query = "UPDATE " + moviesTableName + " SET title = ?, director = ?, duration = ?, age_category = ?, poster_url = ?, description = ? WHERE id = " + id;
        int rowsAffected = jdbcTemplate.update(query, movie.getTitle(), movie.getDirector(), movie.getDuration(), movie.getAgeCategory(), movie.getPosterUrl(), movie.getDescription());
        movie.setId(id);

        return rowsAffected == 1;
    }

    @Override
    public boolean checkIfMovieExist(Integer id) {
        String query = "SELECT 1 FROM " + moviesTableName + " WHERE ID = " + id;

        Integer result;
        try {
            result = jdbcTemplate.queryForObject(query, Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }

        return result != null && result == 1;
    }

}
