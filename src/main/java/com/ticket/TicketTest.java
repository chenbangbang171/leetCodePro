package main.java.ticket;

class SoldTest extends Thread {

	private static int ticket = 100;

	@Override
	public void run() {
		while (true) {
			synchronized ("") {

				if (ticket > 0) {
					System.out.println(this.currentThread().getName() + "售出了第" + ticket + "票");
					ticket--;
				} else {
					System.out.println("票已售罄");
					break;
				}
			}

		}

	}
}

public class TicketTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thd1 = new Thread(new SoldTest(), "猫眼电影");
		Thread thd2 = new Thread(new SoldTest(), "淘票票");
		Thread thd3 = new Thread(new SoldTest(), "美团");
		
		Thread thread3 = new Thread(() -> System.out.println("22222票已售罄"));
		thd1.start();
		thd2.start();
		thread3.start();
		thd3.start();
	}

}
