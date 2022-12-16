package ru.netology.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PosterServiceTest {

    //тест создания пустого массива

    //добавляю 15 фильмов в список
    PosterService poster = new PosterService();

    @Test
    public void shouldCreateEmptyArray() {
        PosterService poster = new PosterService();

        int expected = 0;

        Assertions.assertEquals(expected, poster.getFilmsCount());
    }

    public void setup() {
        poster.addFilm("Зеленая Миля", "Драма", "1999");
        poster.addFilm("Список Шиндлера", "Драма", "1993");
        poster.addFilm("Побег из Шоушенка", "Драма", "1994");
        poster.addFilm("Форрест Гамп", "Драма", "1994");
        poster.addFilm("Властелин колец: Возвращение короля", "Фэнтези", "2003");
        poster.addFilm("Тайна Коко", "Мультфильм", "2017");
        poster.addFilm("Назад в будущее", "Фантастика", "1985");
        poster.addFilm("Интерстеллар", "Фантастика", "2014");
        poster.addFilm("Властелин колец: Братство Кольца", "Фэнтези", "2001");
        poster.addFilm("Властелин колец: Две крепости", "Фэнтези", "2002");
        poster.addFilm("Криминальное чтиво", "Фэнтези", "1994");
        poster.addFilm("Иван Васильевич меняет профессию", "Фэнтези", "1973");
        poster.addFilm("1+1", "Драма", "2011");
        poster.addFilm("Король Лев", "Мультфильм", "1994");
        poster.addFilm("Темный рыцарь", "Фантастика", "2008");
    }

    public void secondSetup(PosterService list) {
        Film[] tmp = poster.findAll();
        for (int i = 0; i < poster.getFilmsCount(); i++) {
            list.addFilm(tmp[i].getFilmTitle(), tmp[i].getFilmGenre(), tmp[i].getReleaseYear());
        }
    }

    //тесты добавления фильмов
    @ParameterizedTest
    @CsvSource({
            "0, Зеленая Миля",
            "1, Список Шиндлера",
            "2, Побег из Шоушенка"
    })
    public void shouldAddFilmsFirst(int number, String expected) {
        setup();
        Film actual = poster.getFilmByNumber(number);

        Assertions.assertEquals(expected, actual.getFilmTitle());
    }

    @ParameterizedTest
    @CsvSource({
            "12, 1+1",
            "13, Король Лев",
            "14, Темный рыцарь"
    })
    public void shouldAddFilmsLast(int number, String expected) {
        setup();
        Film actual = poster.getFilmByNumber(number);

        Assertions.assertEquals(expected, actual.getFilmTitle());
    }

    //тесты findLast() со значением по дефолту
    @ParameterizedTest
    @CsvSource({
            "5,9",
            "6,8",
            "7,7"
    })
    public void shouldFindLast(int initialId, int changedId) {
        setup();
        Film[] initialArray = poster.findAll();
        String expected = initialArray[initialId].getFilmTitle();
        Film[] findLastArray = poster.findLast();
        String actual = findLastArray[changedId].getFilmTitle();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "14,0",
            "13,1",
            "12,2"
    })
    public void shouldFindFirst(int initialId, int changedId) {
        setup();
        Film[] initialArray = poster.findAll();
        String expected = initialArray[initialId].getFilmTitle();
        Film[] findLastArray = poster.findLast();
        String actual = findLastArray[changedId].getFilmTitle();

        Assertions.assertEquals(expected, actual);
    }

    //тесты findLast() со значением меньше дефолтного

    @ParameterizedTest
    @CsvSource({
            "14,0",
            "13,1",
            "12,2"
    })
    public void shouldFindLastMinCustom(int initialId, int changedId) {
        setup();
        PosterService posterLess = new PosterService(7);
        secondSetup(posterLess);
        Film[] initialArray = posterLess.findAll();
        String expected = initialArray[initialId].getFilmTitle();
        Film[] findLastArray = posterLess.findLast();
        String actual = findLastArray[changedId].getFilmTitle();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "8,6",
            "9,5",
            "10,4"
    })
    public void shouldFindFirstMinCustom(int initialId, int changedId) {
        setup();
        PosterService posterLess = new PosterService(7);
        secondSetup(posterLess);
        Film[] initialArray = posterLess.findAll();
        String expected = initialArray[initialId].getFilmTitle();
        Film[] findLastArray = posterLess.findLast();
        String actual = findLastArray[changedId].getFilmTitle();

        Assertions.assertEquals(expected, actual);
    }

    // тесты findLast() со значением выше дефолтного

    @ParameterizedTest
    @CsvSource({
            "14,0",
            "13,1",
            "12,2"
    })
    public void shouldFindLastMaxCustom(int initialId, int changedId) {
        setup();
        PosterService posterMore = new PosterService(14);
        secondSetup(posterMore);
        Film[] initialArray = posterMore.findAll();
        String expected = initialArray[initialId].getFilmTitle();
        Film[] findLastArray = posterMore.findLast();
        String actual = findLastArray[changedId].getFilmTitle();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1,13",
            "2,12",
            "3,11"
    })
    public void shouldFindFirstMaxCustom(int initialId, int changedId) {
        setup();
        PosterService posterMore = new PosterService(14);
        secondSetup(posterMore);
        Film[] initialArray = posterMore.findAll();
        String expected = initialArray[initialId].getFilmTitle();
        Film[] findLastArray = posterMore.findLast();
        String actual = findLastArray[changedId].getFilmTitle();

        Assertions.assertEquals(expected, actual);
    }
}