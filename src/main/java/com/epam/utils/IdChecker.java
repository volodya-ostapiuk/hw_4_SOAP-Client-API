package com.epam.utils;

import com.epam.entities.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

public class IdChecker extends TestFields {
    public static boolean check;

    public static int getPresentGenreId() {
        check = false;
        GetGenresResponse response = AllEntitiesGetter.getAllGenres();
        List<GenreType> genres = response.getGenres().getGenre();
        do {
            TestFields.randomID = new Random().nextInt(Integer.MAX_VALUE - TestFields.MINIMUM) + TestFields.MINIMUM;
            for (GenreType genre : genres) {
                if (TestFields.randomID == genre.getGenreId()) {
                    check = true;
                    break;
                }
            }
        } while (!check);
        return TestFields.randomID;
    }

    public static int getAbsentGenreId() {
        check = false;
        GetGenresResponse response = AllEntitiesGetter.getAllGenres();
        List<GenreType> genres = response.getGenres().getGenre();
        do {
            TestFields.randomID = new Random().nextInt(Integer.MAX_VALUE - TestFields.MINIMUM) + TestFields.MINIMUM;
            for (GenreType genre : genres) {
                if (TestFields.randomID == genre.getGenreId()) {
                    check = false;
                    break;
                } else {
                    check = true;
                }
            }
        } while (!check);
        return TestFields.randomID;
    }

    public static int getPresentAuthorId() {
        GetAuthorsResponse responsePres = AllEntitiesGetter.getAllAuthors();
        List<AuthorType> authorsPres = responsePres.getAuthors().getAuthor();
        check = false;
        do {
            TestFields.randomID = new Random().nextInt(Integer.MAX_VALUE - TestFields.MINIMUM) + TestFields.MINIMUM;
            for (AuthorType author : authorsPres) {
                if (TestFields.randomID == author.getAuthorId()) {
                    check = true;
                    break;
                }
            }
        } while (!check);
        return TestFields.randomID;
    }

    public static int getAbsentAuthorId() {
        GetAuthorsResponse responseAbs = AllEntitiesGetter.getAllAuthors();
        List<AuthorType> authorsAbs = responseAbs.getAuthors().getAuthor();
        check = false;
        do {
            TestFields.randomID = new Random().nextInt(Integer.MAX_VALUE - TestFields.MINIMUM) + TestFields.MINIMUM;
            for (AuthorType author : authorsAbs) {
                if (TestFields.randomID == author.getAuthorId()) {
                    check = false;
                    break;
                } else {
                    check = true;
                }
            }
        } while (!check);
        return TestFields.randomID;
    }

    public static int getPresentBookId() {
        check = false;
        GetBooksResponse response = AllEntitiesGetter.getAllBooks();
        List<BookType> books = response.getBooks().getBook();
        do {
            TestFields.randomID = new Random().nextInt(Integer.MAX_VALUE - TestFields.MINIMUM) + TestFields.MINIMUM;
            for (BookType book : books) {
                if (TestFields.randomID == book.getBookId()) {
                    check = true;
                    break;
                }
            }
        } while (!check);
        return TestFields.randomID;
    }

    public static int getAbsentBookId() {
        check = false;
        GetBooksResponse response = AllEntitiesGetter.getAllBooks();
        List<BookType> books = response.getBooks().getBook();
        do {
            TestFields.randomID = new Random().nextInt(Integer.MAX_VALUE - TestFields.MINIMUM) + TestFields.MINIMUM;
            for (BookType book : books) {
                if (TestFields.randomID == book.getBookId()) {
                    check = false;
                    break;
                } else {
                    check = true;
                }
            }
        } while (!check);
        return TestFields.randomID;
    }
}
