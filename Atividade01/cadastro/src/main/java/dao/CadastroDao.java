package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import br.edu.iftm.tspi.cadastro.dto.CadastroDTO;

public class CadastroDao {

    @Autowired
    JdbcTemplate db;

    public List<CadastroDTO> getCadastro() {
        String sql = "select  id,nome,email,telefone from tb_cadastro";

        return db.query(sql, (res, rowNum) -> {
            return new CadastroDTO(
                    res.getLong("id"),
                    res.getString("inputNome"),
                    res.getString("inputEmail"),
                    res.getString("inputTelefone"));
        });
    }

    public List<CadastroDTO> getCadastro(String inputNome) {
        String sql = "select  id,nome,email,telefone from tb_cadastro where lower(nome) like ?";

        return db.query(sql,
                new BeanPropertyRowMapper<>(CadastroDTO.class),
                new Object[] { "%" + inputNome + "%" });
    }

    public CadastroDTO getCadastro(Long id) {
        String sql = "select  id,nome,email,telefone from tb_cadastro where id = ?";

        return db.queryForObject(sql,
                new BeanPropertyRowMapper<>(CadastroDTO.class),
                new Object[] { id });
    }

    public void addCadastro(CadastroDTO cadastro) {
        String sql = "insert into tb_cadastro (nome,email,telefone) values (?,?,?)";

        db.update(sql,
                cadastro.getInputNome(),
                cadastro.getInputEmail(),
                cadastro.getInputTelefone());
    }

    public void updateCadastro(CadastroDTO cadastro) {
        String sql = "update tb_cadastro set nome = ?, email = ?, telefone = ? where id = ?";

        db.update(sql,
                cadastro.getInputNome(),
                cadastro.getInputEmail(),
                cadastro.getInputTelefone(),
                cadastro.getId());
    }

    public void deleteCadastro(Long id) {
        String sql = "delete from tb_cadastro where id = ?";

        db.update(sql, id);
    }
}
