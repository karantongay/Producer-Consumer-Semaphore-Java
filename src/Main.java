// Driver class
class Main
{
    public static void main(String args[])
    {
        // creating buffer queue
        ResourceQueue q = new ResourceQueue();

        // starting consumer thread
        new Consumer(q);
        new Consumer(q);

        // starting producer thread
        new Producer(q);
        new Producer(q);
    }
}
