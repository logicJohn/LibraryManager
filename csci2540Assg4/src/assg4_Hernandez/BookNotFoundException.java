package assg4_Hernandez;

@SuppressWarnings("serial")
public class BookNotFoundException extends Exception {
	

	public BookNotFoundException (int id) {
		super ("Book ID " + id + " could not be found.");
	}
	
}
