public class ThreadTest {
	public static void main(String[] args) {
		Example example = new Example();

		Thread t1 = new Thread1(example);
		Thread t2 = new Thread2(new Example());
		Thread t3 = new Thread3(example);

		t1.start();
		t2.start();
		//t3.start();
	}

}

class Example {
	private Object object = new Object();

	public synchronized void execute() {
		// synchronized (object)
		{
			for (int i = 0; i < 20; ++i) {
				try {
					Thread.sleep((long) Math.random() * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Hello: " + i);
			}

		}

	}

	public synchronized void execute2() {
		// synchronized (object)
		{
			for (int i = 0; i < 20; ++i) {
				try {
					Thread.sleep((long) Math.random() * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("World: " + i);
			}

		}

	}

	public void notSync() {
		for (int i = 0; i < 20; ++i) {
			try {
				Thread.sleep((long) Math.random() * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Not Sync");
		}

	}

}

class Thread1 extends Thread {
	private Example example;

	public Thread1(Example example) {
		this.example = example;
	}

	@Override
	public void run() {
		example.execute();
	}

}

class Thread2 extends Thread {
	private Example example;

	public Thread2(Example example) {
		this.example = example;
	}

	@Override
	public void run() {
		example.execute2();
	}

}

class Thread3 extends Thread {
	private Example example;

	public Thread3(Example example) {
		this.example = example;
	}

	@Override
	public void run() {
		example.notSync();
	}

}
