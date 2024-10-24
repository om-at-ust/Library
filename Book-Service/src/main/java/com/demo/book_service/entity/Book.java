package com.demo.book_service.entity;

import java.time.LocalDate;


import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Book {
    private String bookTitle;
	private String bookPrice;
	private LocalDate bookPublished;
	private String bookImageUrl;
	private String bookAuthorId;

	public Book() {
	}

	public Book(String bookTitle, String bookPrice, LocalDate bookPublished, String bookAuthorId, String bookImageUrl) {
		this.bookTitle = bookTitle;
		this.bookPrice = bookPrice;
		this.bookPublished = bookPublished;
		this.bookAuthorId = bookAuthorId;
		this.bookImageUrl = bookImageUrl;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}

	public LocalDate getBookPublished() {
		return bookPublished;
	}

	public void setBookPublished(LocalDate bookPublished) {
		this.bookPublished = bookPublished;
	}

	public String getBookAuthorId() {
		return bookAuthorId;
	}

	public void setBookAuthorId(String bookAuthorId) {
		this.bookAuthorId = bookAuthorId;
	}

	public String getBookImageUrl() {
		return bookImageUrl;
	}

	public void setBookImageUrl(String bookImageUrl) {
		this.bookImageUrl = bookImageUrl;
	}
}
