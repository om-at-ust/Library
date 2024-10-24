package com.demo.book_service.client;

public class Author {
    private String authorId;
    private String authorName;

    public Author(String authorName, String authorId) {
        this.authorName = authorName;
        this.authorId = authorId;
    }

    public Author() {
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
