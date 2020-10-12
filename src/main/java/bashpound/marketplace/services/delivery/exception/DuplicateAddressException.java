package bashpound.marketplace.services.delivery.exception;

public class DuplicateAddressException extends RuntimeException {
	private static final long serialVersionUID = 3357970673031502190L;

	public DuplicateAddressException(String msg) {
		super(msg);
	}

}
