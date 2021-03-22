package kr.co.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class BookVO {
	private int book_id ,book_price ;
	private String fileName, book_title ,book_writer,book_publisher, 
			book_kategorie,book_intro;
	private String credate;
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getBook_writer() {
		return book_writer;
	}
	public void setBook_writer(String book_writer) {
		this.book_writer = book_writer;
	}
	public String getBook_publisher() {
		return book_publisher;
	}
	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}
	public String getBook_kategorie() {
		return book_kategorie;
	}
	public void setBook_kategorie(String book_kategorie) {
		this.book_kategorie = book_kategorie;
	}
	public String getBook_intro() {
		return book_intro;
	}
	public void setBook_intro(String book_intro) {
		this.book_intro = book_intro;
	}
	public String getCredate() {
		return credate;
	}
	public void setCredate(String credate) {
		this.credate = credate;
	}

	
}
