/**
 * @author Johnnie Hernandez
 * @version Assignment 4
 */
package assg4_Hernandez;

/**
 * Is an exception for handling book search method in the Book class.  
 */
@SuppressWarnings("serial")
public class BookNotFoundException extends Exception {
	
	public BookNotFoundException () {}
	
	public BookNotFoundException (String id) {
		super ("Book ID " + id + " not found.");
	}
	
}
