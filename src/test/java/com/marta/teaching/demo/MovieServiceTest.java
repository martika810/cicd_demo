package com.marta.teaching.demo;

import com.marta.teaching.demo.domain.Movie;
import com.marta.teaching.demo.service.MovieService;
import org.jsoup.Jsoup;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MovieServiceTest {

    public final static String MOVIE_PAGE_URL = "https://www.themoviedb.org/discover/movie?sort_by=popularity.desc";

    MovieService movieService = new MovieService();

    public MovieServiceTest() throws IOException {
    }

    @Test
    public void testGetMovies() throws IOException {
        File input = new File("src/test/templates/movie_page_test.html");
        Document movieDocument = Jsoup.parse(input,"UTF-8", "");
        movieService.saveMovies(movieDocument);
        List<Movie> movies = movieService.getMovies();
        Assert.assertTrue(movies.size() == 20);

    }
}
