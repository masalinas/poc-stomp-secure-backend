package oferto.io.stompsecurebackend.controller;

import java.security.Principal;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import oferto.io.stompsecurebackend.model.MessageRequest;
import oferto.io.stompsecurebackend.service.MessageService;

@Slf4j
@AllArgsConstructor
@Controller
public class MessageController {
	private MessageService messageService;
	
	@MessageMapping("/echo")
	@SendToUser("/queue/echo")
	public boolean echo(@Payload MessageRequest messageRequest, Principal user) throws Exception {
		log.info("Echo controller for the text {}", messageRequest.getText());
	            
        return messageService.echo(messageRequest, user);
	}
}
