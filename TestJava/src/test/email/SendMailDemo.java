package test.email;

public class SendMailDemo {
	public static void main(String[] args) {
		// �����ʼ���������Ϣ
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.163.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);

		// �����û���
		mailInfo.setUserName("imsuimeng@163.com");
		// ��������
		mailInfo.setPassword("xxs123");
		// ����������
		mailInfo.setFromAddress("imsuimeng@163.com");
		// �ռ�������
		mailInfo.setToAddress("1060344404@qq.com");
		// �ʼ�����
		mailInfo.setSubject("����Java�������ʼ�");
		// �ʼ�����
		StringBuffer buffer = new StringBuffer();
		buffer.append("JavaMail 1.4.5 jar�����ص�ַ��http://www.oracle.com/technetwork/java/index-138643.html\n");
		buffer.append("JAF 1.1.1 jar�����ص�ַ��http://www.oracle.com/technetwork/java/javase/downloads/index-135046.html");
		mailInfo.setContent(buffer.toString());

		// �����ʼ�
		SimpleMailSender sms = new SimpleMailSender();
		// ���������ʽ
		sms.sendTextMail(mailInfo);
		// ����html��ʽ
		SimpleMailSender.sendHtmlMail(mailInfo);
		System.out.println("�ʼ��������");
	}
}
