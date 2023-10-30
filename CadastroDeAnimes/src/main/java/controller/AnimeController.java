package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.AnimeDao;

@Controller
public class AnimeController {

        @Autowired
        private AnimeDao dao;
        
        @RequestMapping("animes")
        public String getAnime(Model model){
            model.addAttribute("animes",dao.getAnime());
            return "animeList";
        }

        @RequestMapping("animesParametro")
        public String getAnime(@RequestParam(value="titulo", required = true) String titulo, Model model){
            model.addAttribute("animes",dao.getAnime(titulo));
            return "animeList";
        }
    }

