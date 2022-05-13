package messageapp.domain;

/**
 * Enum for types of Fields in a Message.
 */
public enum MessageField {
	TO("To:"), FROM("From:"), SUBJECT("Subject:"), BODY("Body:");

	private final String prefix;

	MessageField(String prefix) {
		this.prefix = prefix;
	}

	public String getPrefix() {
		return prefix;
	}
}
