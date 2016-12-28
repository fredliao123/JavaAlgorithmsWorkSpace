
public class StaticTest
{
    public static void main(String[] args)
    {
        Example2 example = new Example2();

        Thread t1 = new Thread12(example);

        // 此处即便传入不同的对象，静态方法同步仍然不允许多个线程同时执行
        example = new Example2();

        Thread t2 = new Thread22(example);

        t1.start();
        t2.start();
    }

}

class Example2
{
    public synchronized static void execute()
    {
        for (int i = 0; i < 20; ++i)
        {
            try
            {
                Thread.sleep((long) Math.random() * 1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("Hello: " + i);
        }
    }

    public synchronized  void execute2()
    {
        for (int i = 0; i < 20; ++i)
        {
            try
            {
                Thread.sleep((long) Math.random() * 1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("World: " + i);
        }
    }

}

class Thread12 extends Thread
{
    private Example2 example;

    public Thread12(Example2 example)

    {
        this.example = example;
    }

    @Override
    public void run()
    {
        Example2.execute();
    }

}

class Thread22 extends Thread
{
    private Example2 example;

    public Thread22(Example2 example)
    {
        this.example = example;
    }

    @Override
    public void run()
    {
    	example.execute2();
    }

}