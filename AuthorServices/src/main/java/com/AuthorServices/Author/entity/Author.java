package com.AuthorServices.Author.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Author {
    @Id
    private String _id;
    private String authorName;
    private String authorEmail;
    private String authorBio;
    private String authorAddress;
    private String authorPhoneNumber;


    public Author(String authorId, String authorName, String authorEmail, String authorBio, String authorAddress, String authorPhoneNumber) {
        this._id = authorId;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.authorBio = authorBio;
        this.authorAddress = authorAddress;
        this.authorPhoneNumber = authorPhoneNumber;
    }
    public String getAuthorId() {
        return _id;
    }
    public Author() {
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorPhoneNumber() {
        return authorPhoneNumber;
    }

    public void setAuthorPhoneNumber(String authorPhoneNumber) {
        this.authorPhoneNumber = authorPhoneNumber;
    }

    public String getAuthorAddress() {
        return authorAddress;
    }

    public void setAuthorAddress(String authorAddress) {
        this.authorAddress = authorAddress;
    }

    public String getAuthorBio() {
        return authorBio;
    }

    public void setAuthorBio(String authorBio) {
        this.authorBio = authorBio;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }
}
