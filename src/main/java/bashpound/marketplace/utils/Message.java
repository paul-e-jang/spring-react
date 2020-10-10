package bashpound.marketplace.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Message implements Serializable {

	private static final long serialVersionUID = -3815945032655796055L;

	private Message(Builder builder) {
		this.message = builder.messages;
	}

	private List<String> message;

	public static class Builder {
		private List<String> messages;

		public Builder() {
			this.messages = new ArrayList<>();
		}

		public Builder(String... msgs) {
			this.messages = new ArrayList<>();
			for (String msg : msgs) {
				messages.add(msg);
			}
		}

		public Builder message(String... msgs) {
			for (String msg : msgs) {
				this.messages.add(msg);
			}
			return this;
		}

		public Message build() {
			return new Message(this);
		}
	}

	@Override
	public String toString() {
		return "Message [message=" + message + "]";
	}

	public List<String> getMessage() {
		return message;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

}
