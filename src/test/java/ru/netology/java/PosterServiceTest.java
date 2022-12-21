package ru.netology.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PosterServiceTest {

    //тест создания пустого массива
    @Test
    public void shouldCreateEmptyArray() {
        PosterService poster = new PosterService();

        int expected = 0;

        Assertions.assertEquals(expected, poster.getFilmsCount());
    }

    //добавляю 15 фильмов в список

    PosterService poster = new PosterService();

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
            "9, Тайна Коко",
            "8, Назад в будущее",
            "7, Интерстеллар"
    })
    public void shouldFindLast(int changedId, String expected) {
        setup();
        Film[] findLastArray = poster.findLast();
        String actual = findLastArray[changedId].getFilmTitle();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0, Темный рыцарь",
            "1, Король Лев",
            "2, 1+1"
    })
    public void shouldFindFirst(int changedId, String expected) {
        setup();
        Film[] findLastArray = poster.findLast();
        String actual = findLastArray[changedId].getFilmTitle();

        Assertions.assertEquals(expected, actual);
    }

    //тесты findLast() со значением меньше дефолтного

    @ParameterizedTest
    @CsvSource({
            "0, Темный рыцарь",
            "1, Король Лев",
            "2, 1+1"
    })
    public void shouldFindLastMinCustom(int changedId, String expected) {
        setup();
        PosterService posterLess = new PosterService(7);
        secondSetup(posterLess);
        Film[] findLastArray = posterLess.findLast();
        String actual = findLastArray[changedId].getFilmTitle();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "6, Властелин колец: Братство Кольца",
            "5, Властелин колец: Две крепости",
            "4, Криминальное чтиво"
    })
    public void shouldFindFirstMinCustom(int changedId, String expected) {
        setup();
        PosterService posterLess = new PosterService(7);
        secondSetup(posterLess);
        Film[] findLastArray = posterLess.findLast();
        String actual = findLastArray[changedId].getFilmTitle();

        Assertions.assertEquals(expected, actual);
    }

    // тесты findLast() со значением выше дефолтного

    @ParameterizedTest
    @CsvSource({
            "0, Темный рыцарь",
            "1, Король Лев",
            "2, 1+1"
    })
    public void shouldFindLastMaxCustom(int changedId, String expected) {
        setup();
        PosterService posterMore = new PosterService(14);
        secondSetup(posterMore);
        Film[] findLastArray = posterMore.findLast();
        String actual = findLastArray[changedId].getFilmTitle();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "13, Список Шиндлера",
            "12, Побег из Шоушенка",
            "11, Форрест Гамп"
    })
    public void shouldFindFirstMaxCustom(int changedId, String expected) {
        setup();
        PosterService posterMore = new PosterService(14);
        secondSetup(posterMore);
        Film[] findLastArray = posterMore.findLast();
        String actual = findLastArray[changedId].getFilmTitle();

        Assertions.assertEquals(expected, actual);
    }
}