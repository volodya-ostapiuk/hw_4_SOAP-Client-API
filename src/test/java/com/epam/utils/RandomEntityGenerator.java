package com.epam.utils;

import com.epam.entities.AuthorType;
import com.epam.entities.TestFields;

public class RandomEntityGenerator extends TestFields {
    public static AuthorType getRandomAuthor(int randomId) {
        AuthorType authorType = new AuthorType();
        authorType.setAuthorId(randomId);
        AuthorType.AuthorName authorName = new AuthorType.AuthorName();
        authorName.setFirst(randomFirstName + randomId);
        authorName.setSecond(randomSecondName + randomId);
        authorType.setAuthorName(authorName);
        authorType.setNationality(randomNationality);
        AuthorType.Birth authorBirth = new AuthorType.Birth();
        authorBirth.setDate(randomDate);
        authorBirth.setCountry(randomCountry);
        authorBirth.setCity(randomCity);
        authorType.setBirth(authorBirth);
        authorType.setAuthorDescription(randomDescription);
        return authorType;
    }
}
