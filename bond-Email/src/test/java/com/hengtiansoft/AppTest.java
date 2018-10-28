package com.hengtiansoft;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;

/**
 * Unit test for simple WebApplication.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest 
{
    @Autowired
    private PostEmail postEmail;
    @Test
    public void shouldAnswerWithTrue() throws MessagingException {
       String to="1256859782@qq.com";
       String subject="测试";
//       String content="这是我的第一封邮件";
//       postEmail.sendTextMail(to,subject,content);
//       String html="<html>\n"+
//               "<body>\n"+
//               "<h1>你好！</h1>\n"+
//               "</body>\n"+
//               "</html>";
//       postEmail.sendHtmlMail(to,subject,html);
//        String  filepath="Z:\\universityApp.rar";
//       postEmail.sendAttachmentMail(to,subject,html,filepath);
//       filepath="Z:\\xm.jpg";
//       html="<html>\n"+
//               "<body>\n"+
//               "<h1>你好！</h1>\n"+
//               "</body>\n"+
//               "</html>";
//       postEmail.sendAttachmentMail(to,subject,html,filepath);
       postEmail.sendTemplateMail(to,subject);
    }
}
