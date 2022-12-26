package ru.netology.java;

public class Film {

    static int filmsCount = 0;
    private String filmTitle;
    private String filmGenre;
    private String releaseYear;

    public Film() {
        filmsCount++;
    }

    public Film(String filmTitle, String filmGenre, String releaseYear) {
        this.filmTitle = filmTitle;
        this.filmGenre = filmGenre;
        this.releaseYear = releaseYear;
        filmsCount++;
    }

    public String getFilmTitle() {
        if (!(this.filmTitle == null)) {
            return this.filmTitle;
        } else {
            return "error";
        }
    }

    public String getFilmGenre() {
        if (!(this.filmGenre == null)) {
            return this.filmGenre;
        } else {
            return "error";
        }
    }

    public String getReleaseYear() {
        if (!(this.releaseYear == null)) {
            return this.releaseYear;
        } else {
            return "error";
        }
    }

    public int getCount() {
        return filmsCount;
    }
}