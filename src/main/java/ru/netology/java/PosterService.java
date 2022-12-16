package ru.netology.java;

public class PosterService {

    int defaultLastAdded = 10;
    int lastAdded = defaultLastAdded;

    private Film[] filmsList = new Film[0];

    public PosterService() {
    }

    public PosterService(int lastAdded) {
        if (lastAdded > 0) {
            this.lastAdded = lastAdded;
        }
    }

    private void addFilmToList(Film newFilm) {

        Film[] tmp = new Film[filmsList.length + 1];

        for (int i = 0; i < filmsList.length; i++) {
            tmp[i] = filmsList[i];
        }

        tmp[tmp.length - 1] = newFilm;
        filmsList = tmp;
    }

    public void addFilm(String filmTitle, String filmGenre, String releaseYear) {

        Film newFilm = new Film(filmTitle, filmGenre, releaseYear);

        addFilmToList(newFilm);
    }

    public int getFilmsCount() {
        return filmsList.length;
    }

    public Film getFilmByNumber(int number) {
        return filmsList[number];
    }

    public Film[] findAll() {
        return filmsList;
    }

    public Film[] findLast() {
        Film[] filmsList = this.filmsList;

        Film[] reversed = new Film[lastAdded];

        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = filmsList[filmsList.length - 1 - i];
        }

        return reversed;
    }
}