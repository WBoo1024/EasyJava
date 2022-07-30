package service;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.Random;

/**
 * @program: NewJavaWebProject
 * @description:
 * @author: 壹零二四
 * @created: 2022/07/29 09:43
 */
public class SendMail extends Thread {
    //发件人信息
    private String From = "1533690878@qq.com";
    //发件人邮箱
    private String recipient = "1533690878@qq.com";
    //邮箱密码
    private String password = "vjvzzpvpxsceihda";
    //邮件发送的服务器
    private String host = "smtp.qq.com";

    //收件人信息
    private String to;
    private int code;
    public SendMail(String email,int code) {
        to = email;
        this.code = code;}

    @Override
    public void run() {
        try {
            Properties properties = new Properties();

            properties.setProperty("mail.host","smtp.qq.com");

            properties.setProperty("mail.transport.protocol","smtp");

            properties.setProperty("mail.smtp.auth","true");

            //QQ存在一个特性设置SSL加密
            MailSSLSocketFactory sf = null;
            try {
                sf = new MailSSLSocketFactory();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);

            //创建一个session对象
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(recipient,password);
                }
            });

            //开启debug模式
            session.setDebug(true);

            //获取连接对象
            Transport transport = null;
            try {
                transport = session.getTransport();
            } catch (NoSuchProviderException e) {
                e.printStackTrace();
            }

            //连接服务器
            transport.connect(host,From,password);


            //创建一个邮件发送对象
            MimeMessage mimeMessage = new MimeMessage(session);
            //邮件发送人
            mimeMessage.setFrom(new InternetAddress(recipient));

            //邮件接收人
            mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(to));

            //邮件标题
            mimeMessage.setSubject("修改密码验证码");

            //邮件内容
            mimeMessage.setContent("本次验证码为为:"+code+"，请在一分钟内输入","text/html;charset=UTF-8");

            //发送邮件
            transport.sendMessage(mimeMessage,mimeMessage.getAllRecipients());

            transport.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
