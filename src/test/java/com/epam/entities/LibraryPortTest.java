package com.epam.entities;

import com.epam.utils.IdChecker;
import com.epam.utils.ListSizeGetter;
import com.epam.utils.RandomEntityGenerator;
import com.sun.xml.internal.ws.fault.ServerSOAPFaultException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.List;

public class LibraryPortTest extends TestFields {
    private static LibraryPort service;
    private static SearchParamsWithPagination search;

    @BeforeClass
    public void setUpService() {
        service = new LibraryPortService().getLibraryPortSoap11();
        search = new SearchParamsWithPagination();
        search.setSize(searchSize);
        search.setOrderType(searchOrder);
        search.setPagination(searchPagination);
        search.setPage(BigInteger.valueOf(searchPage));

    }

    @Test(groups = "positive", description = "get list of authors with selected size")
    public void getAuthorsWithSize() {
        GetAuthorsRequest request = new GetAuthorsRequest();
        request.setSearch(search);
        GetAuthorsResponse response = service.getAuthors(request);
        List<AuthorType> authors = response.getAuthors().getAuthor();
        Assert.assertNotNull(authors, "List is empty");
        Assert.assertEquals(authors.size(), searchSize, "Different list size");
    }

    @Test(groups = "negative", description = "create author with id that exists")
    public void createNewAuthorWithExistingId() {
        AuthorType author;
        AuthorType authorType;
        try {
            randomID = IdChecker.getPresentAuthorId();
            authorType = RandomEntityGenerator.getRandomAuthor(randomID);

            CreateAuthorRequest request = new CreateAuthorRequest();
            request.setAuthor(authorType);
            CreateAuthorResponse response = service.createAuthor(request);
            author = response.getAuthor();
            Assert.assertNotEquals(author.getAuthorId(), randomID, "Posted Id is equal");
            Assert.assertNotEquals(author.getAuthorName().getFirst(), authorType.getAuthorName().getFirst(),
                    "Posted FirstName is equal");
        } catch (ServerSOAPFaultException exp) {
            System.out.println(exp.getMessage());
        }
    }

    @Test(groups = "positive", description = "delete author with id that exists")
    public void deleteAuthor() {
        randomID = IdChecker.getPresentAuthorId();
        int sizeBeforeDelete = ListSizeGetter.getAuthorListSize();
        DeleteAuthorRequest request = new DeleteAuthorRequest();
        request.setAuthorId(randomID);
        int sizeAfterDelete = ListSizeGetter.getAuthorListSize();

        Assert.assertEquals(sizeBeforeDelete, sizeAfterDelete, "You're deleting not existed genreId");
    }

    @Test(groups = "negative", description = "update author with id that does not exist")
    public void updateExistingGenre() {
        try {
            randomID = IdChecker.getAbsentAuthorId();
            GetAuthorRequest beforeUpdateRequest = new GetAuthorRequest();
            beforeUpdateRequest.setAuthorId(randomID);
            GetAuthorResponse beforeUpdateResponse = service.getAuthor(beforeUpdateRequest);
            AuthorType beforeUpdate = beforeUpdateResponse.getAuthor();

            AuthorType randomAuthor = RandomEntityGenerator.getRandomAuthor(randomID);
            UpdateAuthorRequest afterUpdateRequest = new UpdateAuthorRequest();
            afterUpdateRequest.setAuthor(randomAuthor);
            LibraryPort serviceUpdate = new LibraryPortService().getLibraryPortSoap11();
            UpdateAuthorResponse afterUpdateResponse = serviceUpdate.updateAuthor(afterUpdateRequest);
            AuthorType afterUpdate = afterUpdateResponse.getAuthor();

            Assert.assertNull(beforeUpdate);
            Assert.assertNull(afterUpdate);
            Assert.assertNotEquals(beforeUpdate.getAuthorId(), afterUpdate.getAuthorId(), "Updated IDs are equal");
            Assert.assertNotEquals(beforeUpdate.getBirth().getCity(), afterUpdate.getBirth().getCity(),
                    "Updated Cities are equal");
        } catch (ServerSOAPFaultException exp) {
            System.out.println(exp.getMessage());
        }
    }

    @Test(groups = "positive")
    public void getGenresWithSize() {
        GetGenresRequest request = new GetGenresRequest();
        request.setSearch(search);
        GetGenresResponse response = service.getGenres(request);
        List<GenreType> genres = response.getGenres().getGenre();
        Assert.assertNotNull(genres, "List is empty");
        Assert.assertEquals(genres.size(), searchSize, "Different list size");
    }
}
