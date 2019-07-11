package designModel;

public class MailSender implements Sender{

	@Override
	public void Send() {
		System.out.println("MailSender");
	}

}
