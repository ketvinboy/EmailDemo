package com.hengtiansoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class PostEmail {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送文本邮件
     * @param to
     * @param subject
     * @param content
     */
    public void sendTextMail(String to,String subject,String content){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }

    /**
     * html邮件发送
     * @param to
     * @param subject
     * @param content
     * @throws MessagingException
     */
    public void sendHtmlMail(String to,String subject,String content) throws MessagingException {
        MimeMessage message=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content,true);
        mailSender.send(message);
    }

    /**
     * 带附件邮件发送
     * @param to
     * @param subject
     * @param content
     * @param filePath
     * @throws MessagingException
     */
    public void sendAttachmentMail(String to,String subject,String content,String filePath) throws MessagingException {
        MimeMessage message=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content,true);
        FileSystemResource file=new FileSystemResource(new File(filePath));
        String fileName=file.getFilename();
        helper.addAttachment(fileName,file);
        mailSender.send(message);
    }

    /**
     * 带图片附件发送
     * @param to
     * @param subject
     * @param content
     * @param filePath
     * @param uid
     * @throws MessagingException
     */
    public void sendAnInHtmlMail(String to,String subject,String content,String filePath,String uid) throws MessagingException {
        MimeMessage message=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setText(content,true);
        helper.setSubject(subject);
        FileSystemResource image=new FileSystemResource(new File(filePath));
        helper.addInline(uid,image);
        mailSender.send(message);
    }

    /**
     * 模板邮件发送
     * @param to
     * @param subject
     * @throws MessagingException
     */
    public void sendTemplateMail(String to,String subject) throws MessagingException {
        Context context=new Context();
        context.setVariable("id","9358d109b3de9c82036507ac6681800a19d84395.jpg");
        String content=templateEngine.process("index",context);
        sendHtmlMail(to,subject,content);
    }
}
