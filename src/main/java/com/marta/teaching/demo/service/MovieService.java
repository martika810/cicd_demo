package com.marta.teaching.demo.service;

import com.marta.teaching.demo.domain.Movie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MovieService {

    public final static String MOVIE_PAGE_URL = "https://www.themoviedb.org/discover/movie?sort_by=popularity.desc";
    private List<Movie> movies = null;

    public MovieService() throws IOException {
        scrapeMoviesInformation();
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void scrapeMoviesInformation() throws IOException {
        Document moviePage =loadPage(MOVIE_PAGE_URL);
        saveMovies(moviePage);
    }
    public Document loadPage(String url) throws IOException {
        return Jsoup.connect("https://www.themoviedb.org/discover/movie?sort_by=popularity.desc").get();
    }


    public void saveMovies(Document doc) throws IOException {
        List<Movie> results = new ArrayList<>();
        Elements movieCards = doc.select(".item.poster.card");
        for(int index =0;index<movieCards.size();index++) {
            Element movieCard = movieCards.get(index);
            Movie movie = extractMovieInformation(movieCard);
            results.add(movie);
        }

        movies=results;
    }

    private Movie extractMovieInformation(Element movieCardHtmlElement) {
        // title, image, reviewRate and description
        String title = movieCardHtmlElement.select("a.title.result").attr("title");
        String imageUrl = movieCardHtmlElement.select(".image_content a img").attr("data-src");
        int reviewRate = 0;
        try {
            reviewRate = Integer.parseInt(movieCardHtmlElement.select(".user_score_chart").attr("data-percent"));
        }catch(Exception ex) {

        }
        String description = movieCardHtmlElement.select("p.overview").text();
        Movie movie = new Movie(title, imageUrl, reviewRate, description);
        return movie;
    }
}
