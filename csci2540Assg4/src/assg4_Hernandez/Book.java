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
	
	/**
	 * Get the Id of book.
	 * @return Book Id in integer form
	 */
	public int getId () {
		return this.id;
	}
	
	/**
	 * Get the title of book
	 * @return Book title as String
	 */
	public String getTitle () {
		return this.title;
	}
	
	/**
	 * Get the isbn of book
	 * @return Book ISBN as String
	 */
	public String getIsbn () {
		return this.isbn;
	}
	
	/**
	 * Get the Author of the book
	 * @return Book Author as String
	 */
	public String getAuthor () {
		return this.author;
	}
	
	/**
	 * Get the category of book.  Categories are only 'F' for fiction
	 * and 'N' for non fiction
	 * @return Book category in the form of char
	 */
	public char getCategory () {
		return this.category;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString () {
		return " " + this.id + " " + this.title + " "
				+ this.isbn + " " + this.author + " " 
				+ this.category + "\n";
	}
	
	/**
	 * 
	 * @param array
	 * @param arraySize
	 * @param id
	 */
	public static void bookSearch (Book[] array, int arraySize, int id) {
		for (int i = 0; i < arraySize; i++) {
			if (array[i].id==id) {
				System.out.print(array[i].toString());
				return;
			}
		}
		System.out.println("put exception here");
		return;
	}
	
}
