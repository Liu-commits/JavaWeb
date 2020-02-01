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
		 * �õ�session
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
		 * ����MimeMessage
		 */
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("liuyouquan6688@163.com"));//������
		
		msg.setRecipients(RecipientType.TO, "1656389800@qq.com");//�ռ���
		msg.setRecipients(RecipientType.CC, "926471395@qq.com");//����
		msg.setRecipients(RecipientType.BCC, "1656389800@qq.com");//����
		msg.setSubject("����Mr.Liu���ʼ�");
		msg.setContent("�����ʼ���", "text/html;charset=utf-8");
		
		/*
		 * ��
		 */
		Transport.send(msg);
		
	}
	
	@Test
	public void fun1() throws Exception, Exception{
		/*
		 * ���ʹ��и������ʼ�
		 */
		/*
		 * �õ�session
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
		 * ����MimeMessage
		 */
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("liuyouquan6688@163.com"));//������
		
		msg.setRecipients(RecipientType.TO, "1656389800@qq.com");//�ռ���
		
		msg.setSubject("����Mr.Liu���ʼ�-������");
		
		//-------------------------------------------------------------------
		/*
		 * �����ʹ��������ʼ�ʱ���ʼ���Ϊ�ಿ����ʽ
		 */
		//		msg.setContent("�����ʼ���", "text/html;charset=utf-8");
		//�����ಿ������
		MimeMultipart mm = new MimeMultipart();
		
		MimeBodyPart mbp = new MimeBodyPart();
		//�������岿��������
		mbp.setContent("���ǰ����������ʼ�", "text/html;charset=utf-8");
		//�����岿����ӵ�������
		mm.addBodyPart(mbp);
		
		//��Ӹ���
		MimeBodyPart file = new MimeBodyPart();
		file.attachFile("F:/����/windows�۽�/01.jpg");
		//������ʾ���ļ�����mimeutilty��������
		file.setFileName(MimeUtility.encodeText("�Ծ���.jpg"));
		mm.addBodyPart(file);
		
		
		msg.setContent(mm);
		/*
		 * ��
		 */
		Transport.send(msg);
		
	}
	
	
}
