package com.karthik.lib.app;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class LibraryRecord implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8703331582590569220L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "record_id")
	private Integer recordId;

	@Column(name = "taken_at", nullable = false)
	private Date takenAt;

	@Column(name = "return_at", nullable = false)
	private Date returnAt;

	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "reader_id")
	private Reader reader;

	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "book_copy_id")
	private BookCopy bookCopy;

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Date getReturnAt() {
		return returnAt;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public BookCopy getBookCopy() {
		return bookCopy;
	}

	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}

	public Date getTakenAt() {
		return takenAt;
	}

	public void setTakenAt(Date takenAt) {
		this.takenAt = takenAt;
	}

	public void setReturnAt(Date returnAt) {
		this.returnAt = returnAt;
	}
}
