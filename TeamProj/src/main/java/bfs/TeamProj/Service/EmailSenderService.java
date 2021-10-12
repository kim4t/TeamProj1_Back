package bfs.TeamProj.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendSimpleEmail(String toEmail){
        SimpleMailMessage message = new SimpleMailMessage();
        String body = "http://localhost:4200/login/register?email="+toEmail+"&token="+generateString();
        String subject = "BeaconFire - Link for register ";
        message.setFrom("taetaehokim@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        javaMailSender.send(message);
        System.out.println("Mail send");
    }
    public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

}
