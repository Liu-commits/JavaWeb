package com.lyq.Demo;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.junit.Test;

public class Demo1 {
	
	@Test
	public void fun() throws Exception, Exception{
		/*
		 * 得到session
		 */
		Properties props = new Properties();
		props.setProperty("mail.host","smtp.163.com");
		props.setProperty("mail.smtp.auth","true");
		
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("liuyouquan6688", "865437liu");
			}
		};
		Session session = Session.getInstance(props, auth);
		/*
		 * 创建MimeMessage
		 */
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("liuyouquan6688@163.com"));//发件人
		
		msg.setRecipients(RecipientType.TO, "1656389800@qq.com");//收件人
		msg.setRecipients(RecipientType.CC, "926471395@qq.com");//抄送
		msg.setRecipients(RecipientType.BCC, "1656389800@qq.com");//暗送
		msg.setSubject("来自Mr.Liu的邮件");
		msg.setContent("测试邮件！", "text/html;charset=utf-8");
		
		/*
		 * 发
		 */
		Transport.send(msg);
		
	}
	
	@Test
	public void fun1() throws Exception, Exception{
		/*
		 * 发送带有附件的邮件
		 */
		/*
		 * 得到session
		 */
		Properties props = new Properties();
		props.setProperty("mail.host","smtp.163.com");
		props.setProperty("mail.smtp.auth","true");
		
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("liuyouquan6688", "865437liu");
			}
		};
		Session session = Session.getInstance(props, auth);
		/*
		 * 创建MimeMessage
		 */
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("liuyouquan6688@163.com"));//发件人
		
		msg.setRecipients(RecipientType.TO, "1656389800@qq.com");//收件人
		
		msg.setSubject("来自Mr.Liu的邮件-带附件");
		
		//-------------------------------------------------------------------
		/*
		 * 当发送带附件的邮件时，邮件体为多部件形式
		 */
		//		msg.setContent("测试邮件！", "text/html;charset=utf-8");
		//创建多部件内容
		MimeMultipart mm = new MimeMultipart();
		
		MimeBodyPart mbp = new MimeBodyPart();
		//设置主体部件的内容
		mbp.setContent("这是包含附件的邮件", "text/html;charset=utf-8");
		//将主体部件添加到集合中
		mm.addBodyPart(mbp);
		
		//添加附件
		MimeBodyPart file = new MimeBodyPart();
		file.attachFile("F:/软六/windows聚焦/01.jpg");
		//设置显示的文件名称mimeutilty处理乱码
		file.setFileName(MimeUtility.encodeText("苍井空.jpg"));
		mm.addBodyPart(file);
		
		
		msg.setContent(mm);
		/*
		 * 发
		 */
		Transport.send(msg);
		
	}
	
	
}
