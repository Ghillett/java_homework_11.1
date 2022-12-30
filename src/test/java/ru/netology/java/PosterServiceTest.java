package ru.netology.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PosterServiceTest {

    //добавляю 15 фильмов в список

    public void setup(PosterService poster) {
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

    PosterService poster = new PosterService();
    PosterService posterLess = new PosterService(7);
    PosterService posterMore = new PosterService(14);

    //тест создания пустого массива
    @Test
    public void shouldCreateEmptyArray() {
        PosterService emptyPoster = new PosterService();
        int expected = 0;

        Assertions.assertEquals(expected, poster.getFilmsCount());
    }

    //тесты добавления фильмов
    @ParameterizedTest
    @CsvSource({
            "0, Зеленая Миля",
            "1, Список Шиндлера",
            "2, Побег из Шоушенка"
    })
    public void shouldAddFilmsFirst(int number, String expected) {
        setup(poster);
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
        setup(poster);
        Film actual = poster.getFilmByNumber(number);

        Assertions.assertEquals(expected, actual.getFilmTitle());
    }

    //тест findLast() со значением по дефолту

    @Test
    public void shouldFindLast() {
        setup(poster);
        Film[] expected = {poster.getFilmByNumber(14), poster.getFilmByNumber(13),
                poster.getFilmByNumber(12), poster.getFilmByNumber(11),
                poster.getFilmByNumber(10), poster.getFilmByNumber(9),
                poster.getFilmByNumber(8), poster.getFilmByNumber(7),
                poster.getFilmByNumber(6), poster.getFilmByNumber(5)};

        Assertions.assertArrayEquals(expected, poster.findLast());
    }

    //тест findLast() со значением меньше дефолтного (7)

    @Test
    public void shouldFindLastLess() {
        setup(posterLess);
        Film[] expected = {posterLess.getFilmByNumber(14), posterLess.getFilmByNumber(13),
                posterLess.getFilmByNumber(12), posterLess.getFilmByNumber(11),
                posterLess.getFilmByNumber(10), posterLess.getFilmByNumber(9),
                posterLess.getFilmByNumber(8)};

        Assertions.assertArrayEquals(expected, posterLess.findLast());
    }

    // тесты findLast() со значением выше дефолтного (14)

    @Test
    public void shouldFindLastMore() {
        setup(posterMore);
        Film[] expected = {posterMore.getFilmByNumber(14), posterMore.getFilmByNumber(13),
                posterMore.getFilmByNumber(12), posterMore.getFilmByNumber(11),
                posterMore.getFilmByNumber(10), posterMore.getFilmByNumber(9),
                posterMore.getFilmByNumber(8), posterMore.getFilmByNumber(7),
                posterMore.getFilmByNumber(6), posterMore.getFilmByNumber(5),
                posterMore.getFilmByNumber(4), posterMore.getFilmByNumber(3),
                posterMore.getFilmByNumber(2), posterMore.getFilmByNumber(1)};

        Assertions.assertArrayEquals(expected, posterMore.findLast());
    }
}