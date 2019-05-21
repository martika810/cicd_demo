package com.marta.teaching.demo.service;

import com.marta.teaching.demo.domain.Movie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieService {

    public List<Movie> getMovies() throws IOException {
        List<Movie> results = new ArrayList<>();
        Document doc = Jsoup.connect("https://www.themoviedb.org/discover/movie?sort_by=popularity.desc").get();
        Elements movieCards = doc.select(".item.poster.card");
        for(int index =0;index<movieCards.size();index++) {
            Element movieCard = movieCards.get(index);
            // title, image, reviewRate and description
            String title = movieCard.select("a.title.result").attr("title");
            String imageUrl = movieCard.select(".image_content a img").attr("data-src");
            int reviewRate = 0;
            try {
                reviewRate = Integer.parseInt(movieCard.select(".user_score_chart").attr("data-percent"));
            }catch(Exception ex) {

            }
            String description = movieCard.select("p.overview").text();
            Movie movie = new Movie(title, imageUrl, reviewRate, description);
            results.add(movie);
        }

        return results;
    }
}
