package br.edu.iftm.tspi.contato.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import br.edu.iftm.tspi.contato.domain.Contato;

@Component
public class ContatoDao {

    @Autowired

    JdbcTemplate db;

public List<Contato> getContatos() {
    String sql = "select email,nome from tb_contato";
    return db.query(sql, (rowData, rowNum) -> {
    return new Contato(
    rowData.getString("nome"),
    rowData.getString("email")
    );
});
}

    public List<Contato> getContatos(String nome) {
        String sql = "select email,nome from tb_contato where lower(nome) like ?";
        return db.query(sql,
        new BeanPropertyRowMapper<>(Contato.class),
        new Object[]{"%"+nome+"%"});
    }
}

