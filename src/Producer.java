// Producer class 
public class Producer implements Runnable
{
    ResourceQueue q;
    Producer(ResourceQueue q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        for(int i=0; i < 5; i++)
            q.produce(i);
    }
}
