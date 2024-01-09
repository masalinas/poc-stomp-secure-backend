package oferto.io.stompsecurebackend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageRequest {
	private String text;
	private int steps;
}
