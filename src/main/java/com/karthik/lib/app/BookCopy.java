package com.karthik.lib.app;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_copies")
public class BookCopy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6755057022504878982L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_copy_id")
	private Integer bookCopyId;

	@Column
	private boolean taken;

	@ManyToOne
	@JoinColumn(name = "book_fk")
	private Book book;

	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	public Integer getBookCopyId() {
		return bookCopyId;
	}

	public void setBookCopyId(Integer bookCopyId) {
		this.bookCopyId = bookCopyId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
