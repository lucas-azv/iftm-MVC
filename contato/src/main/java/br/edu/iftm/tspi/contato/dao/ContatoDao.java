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
		String sql = "select  email,nome from tb_contato";

		return db.query(sql, (res, rowNum) -> {
			return new Contato(
					res.getString("nome"),
					res.getString("email")
			);
		});
	}

	public List<Contato> getContatos(String nome) {
		String sql = "select  email,nome from tb_contato where lower(nome) like ?";

		return db.query(sql,
		                new BeanPropertyRowMapper<>(Contato.class),
						new Object[]{"%"+nome+"%"});
	}

	public void inserirContato(Contato contato) {
		String sql = "insert into tb_contato(email,nome) values(?,?)";

		db.update(sql,new Object[]{contato.getEmail(),contato.getNome()});
	}

	public void updateContato(Contato contato) {
		String sql = "update tb_contato set nome = ? where email = ?";

		db.update(sql,new Object[]{contato.getNome(),contato.getEmail()});
	}

	public void deleteContato(String email) {
		String sql = "delete from tb_contato where email = ?";

		db.update(sql,new Object[]{email});
	}

    public Contato getContato(String email){
        String sql = "select email, nome from tb_contato where email = ?";

        return  db.queryForObject(sql, new BeanPropertyRowMapper<>(Contato.class),
        new Object[]{email});

    }
}