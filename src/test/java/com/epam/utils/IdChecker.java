package com.epam.utils;

import com.epam.entities.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

public class IdChecker extends TestFields {
    public static boolean check;

    public static int getPresentGenreId() {
        LibraryPort service = new LibraryPortService().getLibraryPortSoap11();
        check = false;
        GetGenresRequest request = new GetGenresRequest();
        GetGenresResponse response = service.getGenres(request);
        List<GenreType> genres = response.getGenres().getGenre();
        do {
            randomID = new Random().nextInt(Integer.MAX_VALUE - MINIMUM) + MINIMUM;
            for (GenreType genre : genres) {
                if (randomID == genre.getGenreId()) {
                    check = true;
                    break;
                }
            }
        } while (!check);
        return randomID;
    }

    public static int getAbsentGenreId() {
        LibraryPort service = new LibraryPortService().getLibraryPortSoap11();
        check = false;
        GetGenresRequest request = new GetGenresRequest();
        GetGenresResponse response = service.getGenres(request);
        List<GenreType> genres = response.getGenres().getGenre();
        do {
            randomID = new Random().nextInt(Integer.MAX_VALUE - MINIMUM) + MINIMUM;
            for (GenreType genre : genres) {
                if (randomID == genre.getGenreId()) {
                    check = false;
                    break;
                } else {
                    check = true;
                }
            }
        } while (!check);
        return randomID;
    }

    public static int getPresentAuthorId() {
        LibraryPortService servicePres = new LibraryPortService();
        LibraryPort libraryPortPres = servicePres.getLibraryPortSoap11();

        GetAuthorsRequest requestPres = new GetAuthorsRequest();
        SearchParamsWithPagination searchPres = new SearchParamsWithPagination();
        searchPres.setSize(100);
        searchPres.setOrderType("desc");
        searchPres.setPagination(true);
        searchPres.setPage(BigInteger.valueOf(1));
        requestPres.setSearch(searchPres);

        GetAuthorsResponse responsePres = libraryPortPres.getAuthors(requestPres);
        List<AuthorType> authorsPres = responsePres.getAuthors().getAuthor();
        check = false;
        do {
            randomID = new Random().nextInt(Integer.MAX_VALUE - MINIMUM) + MINIMUM;
            for (AuthorType author : authorsPres) {
                if (randomID == author.getAuthorId()) {
                    check = true;
                    break;
                }
            }
        } while (!check);
        return randomID;
    }

    public static int getAbsentAuthorId() {
        LibraryPortService serviceAbs = new LibraryPortService();
        LibraryPort libraryPortAbs = serviceAbs.getLibraryPortSoap11();

        GetAuthorsRequest requestAbs = new GetAuthorsRequest();
        SearchParamsWithPagination searchAbs = new SearchParamsWithPagination();
        searchAbs.setSize(100);
        searchAbs.setOrderType("desc");
        searchAbs.setPagination(true);
        searchAbs.setPage(BigInteger.valueOf(1));
        requestAbs.setSearch(searchAbs);

        GetAuthorsResponse responseAbs = libraryPortAbs.getAuthors(requestAbs);
        List<AuthorType> authorsAbs = responseAbs.getAuthors().getAuthor();
        check = false;
        do {
            randomID = new Random().nextInt(Integer.MAX_VALUE - MINIMUM) + MINIMUM;
            for (AuthorType author : authorsAbs) {
                if (randomID == author.getAuthorId()) {
                    check = false;
                    break;
                } else {
                    check = true;
                }
            }
        } while (!check);
        return randomID;
    }

    public static int getPresentBookId() {
        LibraryPort service = new LibraryPortService().getLibraryPortSoap11();
        check = false;
        GetBooksRequest request = new GetBooksRequest();
        GetBooksResponse response = service.getBooks(request);
        List<BookType> books = response.getBooks().getBook();
        do {
            randomID = new Random().nextInt(Integer.MAX_VALUE - MINIMUM) + MINIMUM;
            for (BookType book : books) {
                if (randomID == book.getBookId()) {
                    check = true;
                    break;
                }
            }
        } while (!check);
        return randomID;
    }

    public static int getAbsentBookId() {
        LibraryPort service = new LibraryPortService().getLibraryPortSoap11();
        check = false;
        GetBooksRequest request = new GetBooksRequest();
        GetBooksResponse response = service.getBooks(request);
        List<BookType> books = response.getBooks().getBook();
        do {
            randomID = new Random().nextInt(Integer.MAX_VALUE - MINIMUM) + MINIMUM;
            for (BookType book : books) {
                if (randomID == book.getBookId()) {
                    check = false;
                    break;
                } else {
                    check = true;
                }
            }
        } while (!check);
        return randomID;
    }
}
