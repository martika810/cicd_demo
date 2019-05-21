package com.marta.teaching.demo.domain;

import java.util.Objects;

public class Movie {
    public String title;
    public String imageUrl;
    public int reviewRate;
    public String description;

    public Movie(String title, String imageUrl, int reviewRate, String description) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.reviewRate = reviewRate;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getReviewRate() {
        return reviewRate;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return reviewRate == movie.reviewRate &&
                Objects.equals(title, movie.title) &&
                Objects.equals(imageUrl, movie.imageUrl) &&
                Objects.equals(description, movie.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, imageUrl, reviewRate, description);
    }
}
