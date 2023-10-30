package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import domain.Anime;

@Component
public class AnimeDao {
    
    @Autowired
    JdbcTemplate db;

    public List<Anime> getAnime(){
        String sql = "SELECT * FROM tb_anime";

        return db.query(sql, (res, rowNum) -> new Anime(
            res.getString("titulo"),
            res.getString("nota"),
            res.getString("episodios"),
            res.getDate("dataInicio"),
            res.getDate("dataFim")
        ));
    }

    public List<Anime> getAnime(String titulo){
        String sql = "SELECT * FROM tb_anime WHERE lower(titulo) LIKE ?";

        return db.query(sql,
        new BeanPropertyRowMapper<>(Anime.class),
        new Object[] { "%"+titulo+"%" }
        );
    }
}
