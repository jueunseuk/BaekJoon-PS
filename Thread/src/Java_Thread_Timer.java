import java.lang.Thread;

// Thread 클래스로 스레드 이용
class TimerThread extends Thread{
	int n = 0;
	@Override
	public void run() {
		while(true) {
			System.out.println(n++);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// Thread 인터페이스로 스레드 이용
class TimerRunnable implements Runnable{
	int n = 0;
	@Override
	public void run() {
		while(true) {
			System.out.println(n++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Java_Thread_Timer {
	public static void main(String[] args) {
		TimerThread th1 = new TimerThread();
		TimerRunnable tr = new TimerRunnable();
		Thread th2 = new Thread(tr);
		th1.start();
		th2.start();
	}
}
