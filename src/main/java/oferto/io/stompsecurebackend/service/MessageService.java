package oferto.io.stompsecurebackend.service;

import java.security.Principal;
import java.util.Date;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import oferto.io.stompsecurebackend.model.MessageRequest;
import oferto.io.stompsecurebackend.model.MessageResponse;

@Slf4j
@AllArgsConstructor
@Service
public class MessageService {
	private SimpMessagingTemplate simpMessagingTemplate;
	
	public boolean echo(MessageRequest messageRequest, Principal user) {	
		log.info("Starting Echo service for the text {} and user {}", messageRequest.getText(), user.getName());
						
		try {
			for (int step = 0; step < messageRequest.getSteps(); step++) {
				log.info("Echo message for the step {}", step);
				
				MessageResponse message = new MessageResponse();
				message.setText( messageRequest.getText());
				message.setDate(new Date());
				
				this.simpMessagingTemplate.convertAndSendToUser(user.getName(), "/queue/echo/hit", "Step " + step + ": Echo " +  messageRequest.getText());
				   
				Thread.sleep(1000);				
			}					    
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
			
		return true;
	}
}
