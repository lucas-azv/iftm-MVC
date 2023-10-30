package domain;

import java.util.Date;

import lombok.Data;

@Data
public class Anime {
    private String titulo, nota, episodios;
    private Date dataInicio, dataFim;

    public Anime(){
}

    public Anime(String titulo, String nota, String episodios, Date dataInicio, Date dataFim) {
        this.titulo = titulo;
        this.nota = nota;
        this.episodios = episodios;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
}