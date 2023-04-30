package io.swagger.dao.movie;

import io.swagger.model.Movie;
import io.swagger.model.Reservation;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

        return jdbcTemplate.queryForObject(query, MovieDaoUtils::mapToMovieWithId);
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

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        System.out.println(rows);

        List<Movie> movies = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            Movie movie = new Movie();
            movie.setId(Integer.parseInt(String.valueOf(row.get("id"))));
            movie.setDuration(Integer.parseInt(String.valueOf(row.get("duration"))));
            movie.setAgeCategory(Integer.parseInt(String.valueOf(row.get("age_category"))));
            movie.setTitle(String.valueOf(row.get("title")));
            movie.setDirector(String.valueOf(row.get("director")));
            movies.add(movie);
        }

        return new ArrayList<>(movies);
    }

    @Override
    public boolean updateMovieById(Movie movie, Integer id) {
        String query = "UPDATE " + moviesTableName + " SET title = ?, director = ?, duration = ?, age_category = ? WHERE id = " + id;
        int rowsAffected = jdbcTemplate.update(query, movie.getTitle(), movie.getDirector(), movie.getDuration(), movie.getAgeCategory());
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
