package com.epam.utils;

import com.epam.entities.AuthorType;
import com.epam.entities.GenreType;

public class RandomEntityGenerator extends TestFields {
    public static GenreType getTestGenreEntity(int randomID) {
        GenreType testEntity = new GenreType();
        testEntity.setGenreId(randomID);
        testEntity.setGenreName(randomGenreName + randomID);
        testEntity.setGenreDescription(randomGenreDescription);
        return testEntity;
    }

    public static AuthorType getTestAuthorEntity(int randomID) {
        AuthorType testEntity = new AuthorType();
        testEntity.setAuthorId(randomID);
        testEntity.setAuthorName(getTestNameEntity());
        testEntity.setNationality(randomAuthorNationality);
        testEntity.setAuthorDescription(randomAuthorDescription);
        testEntity.setBirth(getTestBirthEntity());
        return testEntity;
    }

    private static AuthorType.AuthorName getTestNameEntity() {
        AuthorType.AuthorName nameEntity = new AuthorType.AuthorName();
        nameEntity.setFirst(randomAuthorFirstName + randomID);
        nameEntity.setSecond(randomAuthorSecondName);
        return nameEntity;
    }

    private static AuthorType.Birth getTestBirthEntity() {
        AuthorType.Birth birthEntity = new AuthorType.Birth();
        birthEntity.setDate(randomAuthorDate);
        birthEntity.setCountry(randomAuthorCountry);
        birthEntity.setCity(randomAuthorCity);
        return birthEntity;
    }
}
