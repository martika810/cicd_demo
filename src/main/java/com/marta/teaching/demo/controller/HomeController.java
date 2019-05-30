package com.marta.teaching.demo.controller;

import com.marta.teaching.demo.domain.Movie;
import com.marta.teaching.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MovieService service;

    @GetMapping("/home")
    public String home(Model model) throws IOException {
        List<Movie> movies = service.getMovies();
        model.addAttribute("movies", movies);
        return "home";
    }

}