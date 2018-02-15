package assg4_Hernandez;

public class Book {

	private int id; // 5-digits
	private String title; // 30 char max
	private String isbn; // 10 digits 
	private String author; // 10 char max
	private char category; // F fiction N non-fiction
	
	private int catalogLength;
	
	public Book () {
		this.id = 10000;
		this.title = "default";
		this.isbn = "0000000000";
		this.author = "default";
		this.category = 'F';
	}
	
	public Book (int id, String title, String isbn, String author, char category) {
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.category = category;
	}
	
	
}
