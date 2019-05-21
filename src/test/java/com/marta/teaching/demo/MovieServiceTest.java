package com.marta.teaching.demo;

import com.marta.teaching.demo.domain.Movie;
import com.marta.teaching.demo.service.MovieService;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class MovieServiceTest {

    @Test
    public void testGetMovies() throws IOException {
        List<Movie> movies = new MovieService().getMovies();

        System.out.println(movies.size());
    }
}
