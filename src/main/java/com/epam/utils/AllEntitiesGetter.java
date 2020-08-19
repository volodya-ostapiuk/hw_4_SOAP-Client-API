package com.epam.utils;

import com.epam.entities.*;

import java.math.BigInteger;

public class AllEntitiesGetter extends TestFields {
    public static GetGenresResponse getAllGenres() {
        LibraryPortService servicePres = new LibraryPortService();
        LibraryPort libraryPortPres = servicePres.getLibraryPortSoap11();

        GetGenresRequest requestPres = new GetGenresRequest();
        requestPres.setSearch(setUpSearch());

        return libraryPortPres.getGenres(requestPres);
    }

    public static GetAuthorsResponse getAllAuthors() {
        LibraryPortService servicePres = new LibraryPortService();
        LibraryPort libraryPortPres = servicePres.getLibraryPortSoap11();

        GetAuthorsRequest requestPres = new GetAuthorsRequest();
        requestPres.setSearch(setUpSearch());

        return libraryPortPres.getAuthors(requestPres);
    }

    public static GetBooksResponse getAllBooks() {
        LibraryPortService servicePres = new LibraryPortService();
        LibraryPort libraryPortPres = servicePres.getLibraryPortSoap11();

        GetBooksRequest requestPres = new GetBooksRequest();
        requestPres.setSearch(setUpSearch());

        return libraryPortPres.getBooks(requestPres);
    }

    private static SearchParamsWithPagination setUpSearch() {
        SearchParamsWithPagination searchPres = new SearchParamsWithPagination();
        searchPres.setSize(searchSize);
        searchPres.setOrderType(searchOrder);
        searchPres.setPagination(searchPagination);
        searchPres.setPage(BigInteger.valueOf(searchPage));
        return searchPres;
    }
}
