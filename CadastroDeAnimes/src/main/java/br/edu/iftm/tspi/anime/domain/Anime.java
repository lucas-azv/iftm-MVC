package br.edu.iftm.tspi.anime.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Anime {
    private Long id;
    private String titulo, nota, episodios;
    private LocalDate dataInicio, dataFim;

    public Anime(){
}

    public Anime(Long id, String titulo, String nota, String episodios, LocalDate dataInicio, LocalDate dataFim) {
        this.id = id;
        this.titulo = titulo;
        this.nota = nota;
        this.episodios = episodios;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
}