package com.AuthorServices.Author.dto;

public class Authordto {
    private String _id;
    private String authorName;

    public Authordto() {
    }
    public Authordto(String _id, String authorName) {
        this._id = _id;
        this.authorName = authorName;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
