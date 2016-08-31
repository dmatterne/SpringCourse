package be.david.spring.jdbc.repositories;

import be.david.spring.jdbc.domain.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by stannisbaratheon on 31/08/16.
 */
@Repository
public class FilmRepositoryImpl {

    @Autowired
    private JdbcTemplate jdbc;

    public List<Film> findAllFilms() {


        return jdbc.query("SELECT * FROM FILM", (rs, rowNum) -> {
           return new Film(
                   rs.getString("title"),
                   rs.getInt("release_year"),
                   rs.getString("description")
           ) ;
        } );


//        return jdbc.query("SELECT * FROM FILM", new RowMapper<Film>() {
//            @Override
//            public Film mapRow(ResultSet rs, int i) throws SQLException {
//                return new Film(
//                        rs.getString("title"),
//                        rs.getInt("release_year"),
//                        rs.getString("description")
//                ) ;
//            }
//        });


    }

}
