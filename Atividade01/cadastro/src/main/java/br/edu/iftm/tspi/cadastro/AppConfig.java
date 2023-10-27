package br.edu.iftm.tspi.cadastro;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.CadastroDao;

@Configuration
public class AppConfig {
    @Bean
    public DataSource dataSource() {
        return dataSource();

    }
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
    @Bean
    public CadastroDao cadastroDao() {
        return new CadastroDao();
    }
}