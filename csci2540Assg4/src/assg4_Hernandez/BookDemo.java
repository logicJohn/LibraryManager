package assg4_Hernandez;

import java.io.*;
import java.util.Scanner;


public class BookDemo {

	
	
	
	public static void main (String[] args) {
		String file1 = "catalog.txt";
		Book[] x;
		x = copyFile(file1);
		printCatalog(x);
		searchCatalog(x);
		
	}
	
	
	public static Book[] copyFile (String fileName) {
		int lines = countLines(fileName);
		Book[] x = new Book[lines];
		x = readFile(fileName, lines);
		return x;
	}
	
	public static int countLines (String fileName) {
		int lineCount = 0;
		try { 
			FileReader file = new FileReader(fileName);
			BufferedReader buffer = new BufferedReader(file);
			String line = null;
			
			while ((line = buffer.readLine()) != null) {
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
	
	public static void printCatalog (Book[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.println(x[i].toString());
		}
		
		for (int i = 0; i < x.length; i++) {
			System.out.println(x[i].getId());
			System.out.println(x[i].getTitle());
			System.out.println(x[i].getIsbn());
			System.out.println(x[i].getAuthor());
			System.out.println(x[i].getCategory());
		}
	}
	
	public static void searchCatalog (Book[] x) {
		int input=-1;
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
				Book.bookSearch(x, x.length, input);
			} catch (BookNotFoundException e) {
				System.err.println("BookNotFoundException " + e.getMessage());
			}
		}
		
	}


}
