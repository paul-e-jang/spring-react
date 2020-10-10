package bashpound.marketplace.services.member.exception;

public class DuplicateMemberException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DuplicateMemberException(String message) {
		super(message);
	}

}
