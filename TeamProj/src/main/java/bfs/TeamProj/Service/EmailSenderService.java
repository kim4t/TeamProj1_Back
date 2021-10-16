package bfs.TeamProj.Service;

import bfs.TeamProj.domain.RegistrationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private RegistrationTokenService tokenService;

    public void sendSimpleEmail(String toEmail){
        SimpleMailMessage message = new SimpleMailMessage();
        String token = generateString();
        String body = "http://localhost:4200/login/register?email="+toEmail+"&token="+token;
        String subject = "BeaconFire - Link for register ";
        message.setFrom("taetaehokim@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        javaMailSender.send(message);
        System.out.println("Mail send");

        RegistrationToken newToken = new RegistrationToken();
        newToken.setToken(token);
        System.out.println(LocalDateTime.now().plusMinutes(30));
        newToken.setValidDuration( LocalDateTime.now().plusMinutes(30));
        newToken.setEmail(toEmail);
        newToken.setCreatedBy("admin");
        tokenService.addToken(newToken);
        System.out.println("Token is stored");
    }
    public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

}
