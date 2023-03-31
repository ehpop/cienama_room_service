package io.swagger.dao.Movie;

import io.swagger.model.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDaoUtils {

    public static Movie mapToMovie(ResultSet rs, Integer id) throws SQLException {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(rs.getString("title"));
        movie.setDirector(rs.getString("director"));
        movie.setDuration(rs.getInt("duration"));
        movie.setAgeCategory(rs.getInt("age_category"));

        return movie;
    }
}
