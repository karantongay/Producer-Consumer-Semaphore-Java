// Consumer class
public class Consumer implements Runnable
{
    ResourceQueue q;
    Consumer(ResourceQueue q){
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run()
    {
        for(int i=0; i < 5; i++)
            q.consume("Consumer");
    }
}
