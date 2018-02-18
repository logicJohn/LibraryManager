/**
 * @author Johnnie Hernandez
 * @version Assignment 4
 */
package assg4_Hernandez;


/**
 * Book is an object to represent a book in a catalog consisting of
 * <b>book id, book title, book isbn, book author, and book category</b>.
 * The <b>id</b> will be the book id, a positive number 5 integers long. The book
 * <b>title</b> will be as a string of a max of 30 characters.  <b>isbn</b> will be a 10 
 * digit long string. <b>Author</b> will be the name of the author stored at a max of 10
 * characters. The <b>category</b> will be a char F or N representing fiction or non-fiction.
 *
 */
public class Book {

	private int id; // 5-digits
	private String title; // 30 char max
	private String isbn; // 10 digits 
	private String author; // 10 char max
	private char category; // F fiction, N non-fiction
	
	/**
	 * Constructs a book with default values
	 */
	public Book () {
		this.id = 10000;
		this.title = "default";
		this.isbn = "0000000000";
		this.author = "default";
		this.category = 'F';
	}
	
	/**
	 * Constructs a book after vetting inputed id, title, isbn, author, and category.
	 * @param id is the book id as a 5 digit number.
	 * @param title is the book title with 30 max characters.
	 * @param isbn is the book isbn 10 digits.
	 * @param author is the book authors name with 10 max characters.
	 * @param category is the book category as F or N, for fiction and non-fiction.
	 */
	public Book (int id, String title, String isbn, String author, char category) {
		if (id > 10000 && id < 99999) {
			this.id = id;
		} else {
			id = 10000;
		}
		this.title = title.substring(0, Math.min(title.length(),30));
		this.isbn = isbn.substring(0, Math.min(isbn.length(),10));
		this.author = author.substring(0, Math.min(author.length(),10));
		if ( category == 'F' || category == 'N') {
			this.category = category;
		} else { 
			this.category = 'F';
		}
		
	}
	
	/**
	 * Get the Id of book.
	 * @return Book Id.
	 */
	public int getId () {
		return this.id;
	}
	
	/**
	 * Get the title of book.
	 * @return Book title.
	 */
	public String getTitle () {
		return this.title;
	}
	
	/**
	 * Get the isbn of book.
	 * @return Book ISBN. 
	 */
	public String getIsbn () {
		return this.isbn;
	}
	
	/**
	 * Get the Author of the book.
	 * @return Book Author.
	 */
	public String getAuthor () {
		return this.author;
	}
	
	/**
	 * Get the category of book.  Categories are only 'F' for fiction
	 * and 'N' for non fiction
	 * @return Book category in the form of char
	 */
	public String getCategory () {
		if (this.category == 'F') {
			return "Fiction";
		} else {
			return "Non-Fiction";
		}
	}
	
	/**
	 * Get the book's id, title, isbn, author, and category as
	 * a single string.
	 * @return The books descriptions.
	 */
	@Override
	public String toString () {
		return this.id + " " + this.title + " "
				+ this.isbn + " " + this.author + " " 
				+ this.getCategory();
	}
	
	/**
	 * Search the contents of an array for a given book id.
	 * 
	 * @param arr is a Catalog of books.
	 * @param arraySize the size of arr.
	 * @param id is the book id you are searching the catalog for.
	 * @throws BookNotFoundException if book id does not exist in catalog.
	 */
	public static void bookSearch (Book[] arr, int arraySize, int id) throws BookNotFoundException {
		for (int i = 0; i < arraySize; i++) {
			if (arr[i].id == id) {
				System.out.println(arr[i].toString());
				return;
			}
		}
		throw new BookNotFoundException(Integer.toString(id));
	}

}
