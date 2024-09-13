package com.cpy.email.email.service;



import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import java.util.Date;

/**
 * 邮件业务类
 * @author qzz
 */
@Service
public class MailService {
    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    /**
     * 注入邮件工具类
     */
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Value("${spring.mail.username}")
    private String sendMailer;

    /**
     * 检测邮件信息类
     * @param to
     * @param subject
     * @param text
     */
    private void checkMail(String to,String subject,String text){
        if(StringUtils.isEmpty(to)){
            throw new RuntimeException("邮件收信人不能为空");
        }
        if(StringUtils.isEmpty(subject)){
            throw new RuntimeException("邮件主题不能为空");
        }
        if(StringUtils.isEmpty(text)){
            throw new RuntimeException("邮件内容不能为空");
        }
    }

    /**
     * 发送纯文本邮件
     * @param to
     * @param subject
     * @param text
     */
    public void sendTextMailMessage(String to,String subject,String text){

        //true 代表支持复杂的类型
        MimeMessageHelper mimeMessageHelper = null;
        try {
            mimeMessageHelper = new MimeMessageHelper(javaMailSender.createMimeMessage(),true);
        } catch (jakarta.mail.MessagingException e) {
            throw new RuntimeException(e);
        }
        //邮件发信人
        try {
            mimeMessageHelper.setFrom(sendMailer);
        } catch (jakarta.mail.MessagingException e) {
            throw new RuntimeException(e);
        }
        //邮件收信人  1或多个
        try {
            mimeMessageHelper.setTo(to.split(","));
        } catch (jakarta.mail.MessagingException e) {
            throw new RuntimeException(e);
        }
        //邮件主题
        try {
            mimeMessageHelper.setSubject(subject);
        } catch (jakarta.mail.MessagingException e) {
            throw new RuntimeException(e);
        }
        //邮件内容
        try {
            mimeMessageHelper.setText(text);
        } catch (jakarta.mail.MessagingException e) {
            throw new RuntimeException(e);
        }
        //邮件发送时间
        try {
            mimeMessageHelper.setSentDate(new Date());
        } catch (jakarta.mail.MessagingException e) {
            throw new RuntimeException(e);
        }

        //发送邮件
        javaMailSender.send(mimeMessageHelper.getMimeMessage());
        System.out.println("发送邮件成功："+sendMailer+"->"+to);

    }
}

