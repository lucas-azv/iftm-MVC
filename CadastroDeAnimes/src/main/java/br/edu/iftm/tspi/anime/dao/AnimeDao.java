package br.edu.iftm.tspi.anime.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.edu.iftm.tspi.anime.domain.Anime;

@Component
public class AnimeDao {

    @Autowired
    JdbcTemplate db;

    public List<Anime> getAnime(){
        String sql = "SELECT * FROM tb_anime";

        return db.query(sql, (res, rowNum) -> new Anime(
            res.getLong("id"),
            res.getString("titulo"),
            res.getString("nota"),
            res.getString("episodios"),
            res.getDate("dataInicio").toLocalDate(),
            res.getDate("dataFim").toLocalDate()
        ));
    }

    public List<Anime> getAnime(String titulo){
        String sql = "SELECT * FROM tb_anime WHERE lower(titulo) LIKE ?";

        return db.query(sql,
        new BeanPropertyRowMapper<>(Anime.class),
        new Object[] { "%"+titulo+"%" }
        );
    }

    public Anime getAnime(long id){
        String sql = "SELECT * FROM tb_anime WHERE id = ?";
        List<Anime> animes = db.query(sql,
            new BeanPropertyRowMapper<>(Anime.class),
                new Object[] {id}
        );
        if(animes != null && animes.size() > 0){
            return animes.get(0);
        } else{
            return null;
        }
    }

    public void inserirAnime(Anime anime){
        String sql = "INSERT INTO tb_anime (id, titulo, nota, episodios, dataInicio, dataFim) VALUES (?, ?, ?, ?, ?, ?)";
        db.update(sql, new Object[] {
        anime.getId(),
        anime.getTitulo(),
        anime.getNota(),
        anime.getEpisodios(),
        anime.getDataInicio(),
        anime.getDataFim()
        });
    }

    public void updateAnime(Anime anime){
        String sql = "UPDATE tb_anime SET titulo = ?, nota = ?, episodios = ?, dataInicio = ?, dataFim = ? WHERE id = ?";
        db.update(sql, new Object[] {
        anime.getTitulo(),
        anime.getNota(),
        anime.getEpisodios(),
        anime.getDataInicio(),
        anime.getDataFim(),
        anime.getId()
        });
    }

    public void deleteAnime(long id){
        String sql = "DELETE FROM tb_anime WHERE id = ?";
        db.update(sql, new Object[] {id});
    }
}
