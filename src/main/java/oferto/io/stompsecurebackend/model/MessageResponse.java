package oferto.io.stompsecurebackend.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponse {
	private String text;
	private Date date;
}
