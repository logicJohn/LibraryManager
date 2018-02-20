/**
 * @author Johnnie Hernandez
 * @version Assignment 4
 */
package assg4_Hernandez;

import java.io.*;
import java.util.Scanner;

/**
 * Creates a catalog of books from a given file.  Records the book
 * id, title, author, isbn, and category of each book.  Then allows the 
 * user to search the category for books by their book id.  
 * 
 */
public class BookDemo {

	public static void main (String[] args) {
		String file1 = "catalog.txt";
		Book[] x;
		x = copyFile(file1);
		printCatalog(x);
		testConstructor();
		searchCatalog(x);
		
		
	}
	
	/**
	 * Reads the fileName and copies each of the books descriptions.
	 * into an array of Books.
	 * @param fileName is the file name holding the list of books.
	 * @return The catalog of all records in fileName.
	 */
	public static Book[] copyFile (String fileName) {
		int lines = countLines(fileName);
		Book[] x = new Book[lines];
		x = readFile(fileName, lines);
		return x;
	}
	
	/**
	 * Count the number of records in the category file.
	 * @param fileName is the file holding the list of books.
	 * @return the number of records in fileName.
	 */
	public static int countLines (String fileName) {
		int lineCount = 0;
		try { 
			FileReader file = new FileReader(fileName);
			BufferedReader buffer = new BufferedReader(file);

			
			while ((buffer.readLine()) != null) {
				lineCount++;
			}
			buffer.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException\n" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOEXception\n" + e.getMessage());
		}
		return lineCount;
	}
	
	/**
	 * Read the records from fileName and store them in an array of Books
	 * @param fileName is the file name holding the list of books.
	 * @param size is the number of records in the books catalog.
	 * @return The catalog of all records in fileName.
	 */
	public static Book[] readFile (String fileName, int size) {
		Book[] x = new Book[size];
		try { 
			FileReader file = new FileReader(fileName);
			BufferedReader buffer = new BufferedReader(file);
			String line = null;
			int counter = 0;
			String[] arr;
			while (((line = buffer.readLine()) != null) && (counter < size)) {
				line = line.replaceAll("\\s+", " ");
				arr = line.split(" ");
				x[counter] = new Book(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4].charAt(0));
				counter++;
			}
			buffer.close();
			

		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException\n -" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOEXception\n -" + e.getMessage());
		}
		return x;
	}
	
	/**
	 * Prints all the records of books to console.
	 * @param books is the catalog of books.
	 */
	public static void printCatalog (Book[] books) {
		for (int i = 0; i < books.length; i++) {
			System.out.println(books[i].toString());
		}
		
		for (int i = 0; i < books.length; i++) {
			System.out.print(books[i].getId() + " ");
			System.out.print(books[i].getTitle() + " ");
			System.out.print(books[i].getIsbn() + " ");
			System.out.print(books[i].getAuthor() + " ");
			System.out.println(books[i].getCategory());
		}
		
		System.out.println("\n");
	}
	
	public static void testConstructor () {
		Book x = new Book();
		System.out.println(x.toString());
		System.out.println("\n\n\n");
	}
	
	/**
	 * Search the books for an id matching a user input.
	 * Then print the book and its information to the console.
	 * @param books is the catalog of books.
	 */
	public static void searchCatalog (Book[] books) {
		int input = -1;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Begin search (enter 0 to exit)");
		
		while( input != 0) {
			System.out.print("Enter book id:");
			input = keyboard.nextInt();
			if( input == 0) {
				keyboard.close();
				return;
			}
			try {
				int temp = Book.bookSearch(books, books.length, input);
				System.out.println(books[temp].toString());
			} catch (BookNotFoundException e) {
				System.err.println("BookNotFoundException " + e.getMessage());
			}
		}
		keyboard.close();
		
	}


}
