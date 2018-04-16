package com.jifenbao.service.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

/**
 * 简单邮件（不带附件的邮件）发送器
 */
public class SimpleMailSender {

    private final static Logger LOG = Logger.getLogger(SimpleMailSender.class);
    // 发送邮件的服务器的IP和端口
    private String mailServerHost;
    private String mailServerPort = "25";
    // 登陆邮件发送服务器的用户名和密码
    private String userName;
    private String password;
    // 邮件发送者的地址
    private String fromAddress;
    // 是否需要身份验证
    private boolean validate = false;

    /**
     * 获得邮件会话属性
     */
    public Properties getProperties() {
        Properties p = new Properties();
        p.put("mail.smtp.host", this.mailServerHost);
        p.put("mail.smtp.port", this.mailServerPort);
        p.put("mail.smtp.auth", validate ? "true" : "false");
        return p;
    }

    /**
     * 以文本格式发送邮件
     * 
     * @param subject
     *            标题
     * @param content
     *            正文
     * @return
     */
    public boolean sendTextMail(String reciever, String subject, String content) {
        LOG.info("begin to send email" + subject + " to " + reciever);
        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        if (isValidate()) {
            authenticator = new MyAuthenticator(getUserName(), getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(getProperties(), authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(getFromAddress());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(reciever);
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            // 设置邮件消息的主题
            mailMessage.setSubject(subject);
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // 设置邮件消息的主要内容
            mailMessage.setText(content);
            // 发送邮件
            Transport.send(mailMessage);
            LOG.info("successfully send email" + subject + " to " + reciever);
            return true;
        } catch (MessagingException e) {
            LOG.error(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 以HTML格式发送邮件
     * 
     * @param mailInfo
     *            待发送的邮件信息
     */
    public boolean sendHtmlMail(String reciever, String subject, String content) {
        LOG.info("begin to send email" + subject + " to " + reciever);
        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        if (isValidate()) {
            authenticator = new MyAuthenticator(getUserName(), getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(getProperties(), authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(getFromAddress());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(reciever);
            // Message.RecipientType.TO属性表示接收者的类型为TO
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            // 设置邮件消息的主题
            mailMessage.setSubject(subject);
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            // 设置HTML内容
            html.setContent(content, "text/html; charset=utf-8");
            mainPart.addBodyPart(html);
            // 将MiniMultipart对象设置为邮件内容
            mailMessage.setContent(mainPart);
            // 发送邮件
            Transport.send(mailMessage);
            LOG.info("successfully send email" + subject + " to " + reciever);
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        SimpleMailSender sender = new SimpleMailSender();
        sender.setMailServerHost("smtp.thinkmug.com");
        sender.setUserName("test01@thinkmug.com");
        sender.setPassword("1q2w#E$R");
        sender.setValidate(true);
        sender.setFromAddress("test01@thinkmug.com");

        sender.sendTextMail("459932249@qq.com", "testText", "<span style=\"color:red;\">red</span>");
        sender.sendHtmlMail("459932249@qq.com", "testHtml", "<span style=\"color:red;\">red</span>");
    }

    public String getMailServerHost() {
        return mailServerHost;
    }

    public void setMailServerHost(String mailServerHost) {
        this.mailServerHost = mailServerHost;
    }

    public String getMailServerPort() {
        return mailServerPort;
    }

    public void setMailServerPort(String mailServerPort) {
        this.mailServerPort = mailServerPort;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }
}