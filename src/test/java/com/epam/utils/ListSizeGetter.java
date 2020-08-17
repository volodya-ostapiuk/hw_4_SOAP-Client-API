package com.epam.utils;

import com.epam.entities.*;

import java.math.BigInteger;
import java.util.List;

public class ListSizeGetter {
    public static int getAuthorListSize() {
        LibraryPortService serviceAut = new LibraryPortService();
        LibraryPort libraryPortAut = serviceAut.getLibraryPortSoap11();

        GetAuthorsRequest requestAut = new GetAuthorsRequest();
        SearchParamsWithPagination searchAut = new SearchParamsWithPagination();
        searchAut.setSize(100);
        searchAut.setOrderType("desc");
        searchAut.setPagination(true);
        searchAut.setPage(BigInteger.valueOf(1));
        requestAut.setSearch(searchAut);

        GetAuthorsResponse responseAut = libraryPortAut.getAuthors(requestAut);
        List<AuthorType> authorsAut = responseAut.getAuthors().getAuthor();
        return authorsAut.size();
    }
}
