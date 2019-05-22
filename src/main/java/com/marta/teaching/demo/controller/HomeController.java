package com.marta.teaching.demo.controller;

import com.marta.teaching.demo.domain.Movie;
import com.marta.teaching.demo.service.MovieService;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MovieService service;

    public final static String MOVIE_PAGE_URL = "https://www.themoviedb.org/discover/movie?sort_by=popularity.desc";
    private List<Movie> movies = null;

    @GetMapping("/home")
    public String home(Model model) throws IOException {
        model.addAttribute("movies", movies);
        return "home";
    }

    @GetMapping("/scrape")
    public String scraping(Model model) throws IOException {
        Document document = service.loadPage(MOVIE_PAGE_URL);
        movies = service.getMovies(document);
        return "inprogress";
    }

}