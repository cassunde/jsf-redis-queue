package br.com.cassunde.email;

import java.io.File;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class SendEmail {

	public static void main(String[] args) throws EmailException {
		
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(System.getProperty("user.home") + File.separator + "thymeleaf.pdf");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Relatório");
		attachment.setName("Relatório.pdf");
		
		HtmlEmail mail = new HtmlEmail();
		mail.setFrom("email@principal.com.br", "Nome");
		mail.setSubject("Assunto");
		mail.setMsg("Conteúdo do Email");
		mail.setAuthentication("usuario", "senha");
		mail.setHostName("email-ssl.com.br");
		mail.setSmtpPort(587);
		
		mail.attach(attachment);
		
		mail.addTo("destinatatio@email.com", "Destinatário");
		
		mail.send();
	}

}
