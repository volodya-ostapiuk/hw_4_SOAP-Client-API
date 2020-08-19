package com.epam.utils;

import com.epam.entities.*;

import java.util.List;

public class ListSizeGetter {
    public static int getAuthorListSize() {
        GetAuthorsResponse responseAut = AllEntitiesGetter.getAllAuthors();
        List<AuthorType> authorsAut = responseAut.getAuthors().getAuthor();
        return authorsAut.size();
    }

    public static int getGenreListSize() {
        GetGenresResponse responseAut = AllEntitiesGetter.getAllGenres();
        List<GenreType> genresAut = responseAut.getGenres().getGenre();
        return genresAut.size();
    }

    public static int getBookListSize() {
        GetBooksResponse responseAut = AllEntitiesGetter.getAllBooks();
        List<BookType> booksAut = responseAut.getBooks().getBook();
        return booksAut.size();
    }
}
