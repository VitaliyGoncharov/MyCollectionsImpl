package myCollectionsImpl;

public class NoSuchElementException extends RuntimeException {
	
	private static final long serialVersionUID = -7296478055855569250L;

	NoSuchElementException() {
		super();
	}
	
	NoSuchElementException(String s) {
		super(s);
	}
}
