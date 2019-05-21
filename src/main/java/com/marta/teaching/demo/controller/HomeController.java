package com.marta.teaching.demo.controller;

import com.marta.teaching.demo.domain.Movie;
import com.marta.teaching.demo.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController
{
    @GetMapping("/home")
    public String home(Model model) throws IOException {

        List<Movie> movies = new MovieService().getMovies();
        model.addAttribute("movies", movies);
        return "home";
    }
}