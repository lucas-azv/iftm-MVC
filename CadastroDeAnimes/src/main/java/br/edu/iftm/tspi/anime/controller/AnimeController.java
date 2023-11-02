package br.edu.iftm.tspi.anime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iftm.tspi.anime.dao.AnimeDao;
import br.edu.iftm.tspi.anime.domain.Anime;

@Controller

public class AnimeController {

        @Autowired
        private AnimeDao dao;
        
        @RequestMapping("animes")
        public String getAnime(Model model){
            model.addAttribute("anime", new Anime());
            model.addAttribute("animes", dao.getAnime());
            model.addAttribute("edit", false);
            return "animeList";
        }

        @PostMapping("animes")
        public String inserirAnime(Anime anime, Model model){
            if(anime.getId() == null){
                dao.inserirAnime(anime);
            } else{
                dao.updateAnime(anime);
            }
            return getAnime(model);
        }

        @RequestMapping("animesParametro")
        public String getAnime(@RequestParam(value="titulo", required = true) String titulo, Model model){
            model.addAttribute("animes",dao.getAnime(titulo));
            model.addAttribute("anime", new Anime());
            model.addAttribute("edit", false);
            return "animeList";
        }

        @RequestMapping("editarAnime")
        public String updateAnime(@RequestParam(value="id", required = true) Long id, Model model){
            Anime anime = dao.getAnime(id);
            model.addAttribute("anime", anime);
            model.addAttribute("animes", dao.getAnime());
            model.addAttribute("edit", true);
            return "animeList";
        }

        @RequestMapping("excluirAnime")
        public String deleteAnime(@RequestParam(value="id", required = true) Long id, Model model){
            dao.deleteAnime(id);
            return getAnime(model);
        }
    }

