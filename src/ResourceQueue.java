import java.util.concurrent.Semaphore;

public class ResourceQueue
{
    int item;

    static Semaphore producerSemaphore = new Semaphore(1);
    static Semaphore consumerSemaphore = new Semaphore(0); // Setting to 0 ensures producer executes first

    void consume(String s)
    {
        try {
            // Before consuming an item, it should acquire a permit from consumerSemaphore
            consumerSemaphore.acquire();
        }
        catch(InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

        System.out.println(s + " consumed item : " + item);

        // After consuming it releases producerSemaphore to notify producer
        producerSemaphore.release();
    }

    // to put an item in buffer
    void produce(int item)
    {
        try {
            // Before producing an item, it should acquire a permit from producerSemaphore
            producerSemaphore.acquire();
        } catch(InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

        this.item = item;

        System.out.println("Produced item : " + item);

        // After producing it releases consumerSemaphore to notify consumer
        consumerSemaphore.release();
    }
}
