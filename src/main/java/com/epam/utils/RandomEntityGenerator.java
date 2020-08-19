package com.epam.utils;

import com.epam.entities.AuthorType;

public class RandomEntityGenerator extends TestFields {
    public static AuthorType getRandomAuthor(int randomId) {
        AuthorType authorType = new AuthorType();
        authorType.setAuthorId(randomId);
        AuthorType.AuthorName authorName = new AuthorType.AuthorName();
        authorName.setFirst(TestFields.randomFirstName + randomId);
        authorName.setSecond(TestFields.randomSecondName + randomId);
        authorType.setAuthorName(authorName);
        authorType.setNationality(TestFields.randomNationality);
        AuthorType.Birth authorBirth = new AuthorType.Birth();
        authorBirth.setDate(TestFields.randomDate);
        authorBirth.setCountry(TestFields.randomCountry);
        authorBirth.setCity(TestFields.randomCity);
        authorType.setBirth(authorBirth);
        authorType.setAuthorDescription(TestFields.randomDescription);
        return authorType;
    }
}
