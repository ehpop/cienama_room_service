package io.swagger.configuration;

import io.swagger.dao.movie.MySqlMovieDao;
import io.swagger.dao.reservation.MySqlReservationDao;
import io.swagger.dao.room.MySqlRoomDao;
import io.swagger.dao.screening.MySqlScreeningDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DaoConfig {
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.movies_table_name}")
    private String moviesTableName;

    @Value("${spring.datasource.rooms_table_name}")
    private String roomsTableName;

    @Value("${spring.datasource.room_movies_table_name}")
    private String roomMoviesTableName;

    @Value("${spring.datasource.screenings_table_name}")
    private String screeningsTableName;

    @Value("${spring.datasource.reservations_table_name}")
    private String reservationsTableName;

    @Bean
    public JdbcTemplate jdbcTemplate(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

        driverManagerDataSource.setDriverClassName(driverClassName);
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(username);
        driverManagerDataSource.setPassword(password);

        return new JdbcTemplate(driverManagerDataSource);
    }

    @Autowired
    @Bean
    public MySqlMovieDao movieDao(JdbcTemplate jdbcTemplate) {
        return new MySqlMovieDao(jdbcTemplate, moviesTableName);
    }

    @Autowired
    @Bean
    public MySqlRoomDao roomDao(JdbcTemplate jdbcTemplate){
        return new MySqlRoomDao(jdbcTemplate, roomsTableName, roomMoviesTableName);
    }

    @Autowired
    @Bean
    public MySqlReservationDao reservationDao(JdbcTemplate jdbcTemplate){
        return new MySqlReservationDao(jdbcTemplate, reservationsTableName);
    }

    @Autowired
    @Bean
    public MySqlScreeningDao screeningDao(JdbcTemplate jdbcTemplate){
        return new MySqlScreeningDao(jdbcTemplate, screeningsTableName);
    }


}

