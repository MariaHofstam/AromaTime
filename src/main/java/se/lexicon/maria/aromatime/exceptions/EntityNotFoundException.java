package se.lexicon.maria.aromatime.exceptions;

public class EntityNotFoundException extends RuntimeException{

	/**
	 * Default serial version ID
	 */
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException() {
		super();		
	}

	public EntityNotFoundException(String message) {
		super(message);		
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
