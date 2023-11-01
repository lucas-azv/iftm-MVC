package br.edu.iftm.tspi.anime.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Anime {
    private Long id;
    private String titulo, nota, episodios;
    private Date dataInicio, dataFim;

    public Anime(){
}

    public Anime(Long id, String titulo, String nota, String episodios, Date dataInicio, Date dataFim) {
        this.id = id;
        this.titulo = titulo;
        this.nota = nota;
        this.episodios = episodios;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
}